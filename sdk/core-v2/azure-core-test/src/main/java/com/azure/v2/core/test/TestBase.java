// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.v2.core.test;

import com.azure.v2.core.test.implementation.TestingHelpers;
import com.azure.v2.core.test.junitextensions.TestContextManagerParameterResolver;
import com.azure.v2.core.test.utils.HttpUrlConnectionHttpClient;
import com.azure.v2.core.test.utils.TestProxyManager;
import com.azure.v2.core.test.utils.TestResourceNamer;
import io.clientcore.core.http.client.HttpClient;
import io.clientcore.core.http.client.HttpClientProvider;
import io.clientcore.core.instrumentation.logging.ClientLogger;
import io.clientcore.core.utils.CoreUtils;
import io.clientcore.core.utils.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Base class for running live and playback tests using {@link InterceptorManager}.
 */
@ExtendWith(TestContextManagerParameterResolver.class)
public abstract class TestBase {
    /**
     * Before tests are executed, determines the test mode by reading the {@code AZURE_TEST_MODE} environment variable.
     * If it is not set, {@link TestMode#PLAYBACK}
     */
    @BeforeAll
    public static void setupTestProxy() {
        testMode = initializeTestMode();
        if (testMode == TestMode.PLAYBACK || testMode == TestMode.RECORD) {
            TestProxyManager.startProxy();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(TestBase.class);

    private static final String AZURE_TEST_DEBUG = "AZURE_TEST_DEBUG";

    // Environment variable name used to determine the TestMode.
    private static final String AZURE_TEST_HTTP_CLIENTS = "AZURE_TEST_HTTP_CLIENTS";

    /**
     * Specifies to use all HttpClient implementations in testing.
     */
    public static final String AZURE_TEST_HTTP_CLIENTS_VALUE_ALL = "ALL";

    private static final Duration PLAYBACK_POLL_INTERVAL = Duration.ofMillis(1);
    private static final String CONFIGURED_HTTP_CLIENTS_TO_TEST
        = Configuration.getGlobalConfiguration().get(AZURE_TEST_HTTP_CLIENTS);
    private static final boolean DEFAULT_TO_NETTY = CoreUtils.isNullOrEmpty(CONFIGURED_HTTP_CLIENTS_TO_TEST);
    private static final List<String> CONFIGURED_HTTP_CLIENTS;

    private static final AtomicReference<HttpClient> TEST_PROXY_HTTP_CLIENT = new AtomicReference<>();

    static {
        CONFIGURED_HTTP_CLIENTS = new ArrayList<>();

        if (DEFAULT_TO_NETTY) {
            CONFIGURED_HTTP_CLIENTS.add("netty");
        } else {
            for (String configuredHttpClient : CONFIGURED_HTTP_CLIENTS_TO_TEST.split(",")) {
                if (CoreUtils.isNullOrEmpty(configuredHttpClient)) {
                    continue;
                }

                CONFIGURED_HTTP_CLIENTS.add(configuredHttpClient.trim().toLowerCase(Locale.ROOT));
            }
        }
    }

    /**
     * The {@link TestMode} used for this execution.
     */
    static TestMode testMode;

    private final ClientLogger logger = new ClientLogger(TestBase.class);

    /**
     * {@link InterceptorManager} used for this test run.
     */
    protected InterceptorManager interceptorManager;

    /**
     * {@link TestResourceNamer} used for this test run.
     */
    protected TestResourceNamer testResourceNamer;

    /**
     * {@link TestContextManager} used for this test run.
     */
    protected TestContextManager testContextManager;

    private long testStartTimeMillis;

    /**
     * Creates a new instance of {@link TestBase}.
     */
    public TestBase() {
    }

    /**
     * Before tests are executed, determines the test mode by reading the {@code AZURE_TEST_MODE} environment variable.
     * If it is not set, {@link TestMode#PLAYBACK}
     */
    @BeforeAll
    public static void setupClass() {
        testMode = initializeTestMode();
    }

    /**
     * Sets-up the {@link TestBase#testResourceNamer} and {@link TestBase#interceptorManager} before each test case is
     * run. Then calls its implementing class to perform any other set-up commands.
     *
     * @param testContextManager The {@link TestContextManager} managing information about this test.
     */
    @BeforeEach
    public void setupTest(TestContextManager testContextManager) {
        this.testContextManager = testContextManager;
        // This check used to happen in the constructor for TestContextManager, but due to how JUnit performs parameter
        // resolution for @BeforeEach methods, we need to check here. If it was left in the constructor, the test would
        // fail instead of being skipped.
        assumeTrue(testContextManager.didTestRun(), "Test does not allow playback and was ran in 'TestMode.PLAYBACK'");

        ThreadDumper.addRunningTest(testContextManager.getTrackerTestName());
        logger.atInfo()
            .addKeyValue("testMode", testContextManager.getTestMode())
            .addKeyValue("testName", testContextManager.getTrackerTestName())
            .log();

        if (shouldLogExecutionStatus()) {
            System.out.println("Starting test " + testContextManager.getTrackerTestName() + ".");
            testStartTimeMillis = System.currentTimeMillis();
        }

        try {
            interceptorManager = new InterceptorManager(testContextManager);
        } catch (UncheckedIOException e) {
            logger.atError()
                .addKeyValue("testName", testContextManager.getTestName())
                .setThrowable(e)
                .log("Could not create interceptor.");
            fail(e);
        }

        interceptorManager.setHttpClient(getTestProxyHttpClient());
        // The supplier/consumer are used to retrieve/store variables over the wire.
        testResourceNamer = new TestResourceNamer(testContextManager, interceptorManager.getProxyVariableConsumer(),
            interceptorManager.getProxyVariableSupplier());
        if (testContextManager.getTestMode() == TestMode.PLAYBACK && !testContextManager.doNotRecordTest()) {
            // We create the playback client here, so that it is available for returning recorded variables
            // in a shared @BeforeEach in a test class.
            interceptorManager.getPlaybackClient();
        } else if (testContextManager.getTestMode() == TestMode.RECORD && !testContextManager.doNotRecordTest()) {
            // Similarly we create the record policy early so matchers/sanitizers can be added.
            interceptorManager.getRecordPolicy();
        }
        beforeTest();
    }

    /**
     * Disposes of {@link InterceptorManager} and its inheriting class' resources.
     *
     * @throws IOException If an error occurs while shutting down test resources.
     */
    @AfterEach
    public void teardownTest() throws IOException {
        if (shouldLogExecutionStatus()) {
            if (testStartTimeMillis > 0) {
                long duration = System.currentTimeMillis() - testStartTimeMillis;
                System.out
                    .println("Finished test " + testContextManager.getTrackerTestName() + " in " + duration + " ms.");
            } else {
                System.out.println("Finished test " + testContextManager.getTrackerTestName() + ", duration unknown.");
            }
        }

        if (testContextManager != null) {
            ThreadDumper.removeRunningTest(testContextManager.getTrackerTestName());

            if (testContextManager.didTestRun()) {
                afterTest();
                interceptorManager.close();
            }
        }
    }

    /**
     * Gets the TestMode that has been initialized.
     *
     * @return The TestMode that has been initialized.
     */
    public TestMode getTestMode() {
        return testMode;
    }

    /**
     * Gets the name of the current test being run.
     *
     * @return The name of the current test.
     * @deprecated This method is deprecated as JUnit 5 provides a simpler mechanism to get the test method name through
     * {@link TestInfo}. Keeping this for backward compatability of other client libraries that still override this
     * method. This method can be deleted when all client libraries remove this method. See {@link
     * #setupTest(TestContextManager)}.
     */
    @Deprecated
    protected String getTestName() {
        if (testContextManager != null) {
            return testContextManager.getTestName();
        }
        return null;
    }

    /**
     * Performs any set-up before each test case. Any initialization that occurs in TestBase occurs first before this.
     * Can be overridden in an inheriting class to add additional functionality during test set-up.
     */
    protected void beforeTest() {
    }

    /**
     * Dispose of any resources and clean-up after a test case runs. Can be overridden in an inheriting class to add
     * additional functionality during test teardown.
     */
    protected void afterTest() {
    }

    /**
     * Returns a list of {@link HttpClient HttpClients} that should be tested.
     *
     * @return A list of {@link HttpClient HttpClients} to be tested.
     */
    public static Stream<HttpClient> getHttpClients() {
        List<HttpClient> httpClientsToTest = new ArrayList<>();
        Iterator<HttpClientProvider> iterator = ServiceLoader.load(HttpClientProvider.class).iterator();
        while (iterator.hasNext()) {
            try {
                HttpClientProvider httpClientProvider = iterator.next();
                if (includeHttpClientOrHttpClientProvider(
                    httpClientProvider.getClass().getSimpleName().toLowerCase(Locale.ROOT))) {
                    httpClientsToTest.add(httpClientProvider.getSharedInstance());
                }
            } catch (ServiceConfigurationError | LinkageError error) {
                LOGGER.atWarning().setThrowable(error).log("Skipping HttpClientProvider due to LinkageError.");
            }
        }

        return httpClientsToTest.stream();
    }

    /**
     * Returns whether the given http clients match the rules of test framework.
     *
     * <ul>
     * <li>Using Netty http client as default if no environment variable is set.</li>
     * <li>If it's set to ALL, all HttpClients in the classpath will be tested.</li>
     * <li>Otherwise, the name of the HttpClient class should match env variable.</li>
     * </ul>
     *
     * Environment values currently supported are: "ALL", "netty", "okhttp" which is case insensitive.
     * Use comma to separate http clients want to test.
     * e.g. {@code set AZURE_TEST_HTTP_CLIENTS = NettyAsyncHttpClient, OkHttpAsyncHttpClient}
     *
     * @param client Http client needs to check
     * @return Boolean indicates whether filters out the client or not.
     */
    public static boolean shouldClientBeTested(HttpClient client) {
        return includeHttpClientOrHttpClientProvider(client.getClass().getSimpleName().toLowerCase(Locale.ROOT));
    }

    private static boolean includeHttpClientOrHttpClientProvider(String name) {
        if (AZURE_TEST_HTTP_CLIENTS_VALUE_ALL.equalsIgnoreCase(CONFIGURED_HTTP_CLIENTS_TO_TEST)) {
            return true;
        }

        return CONFIGURED_HTTP_CLIENTS.stream().anyMatch(name::contains);
    }

    /**
     * Initializes the {@link TestMode} from the environment configuration {@code AZURE_TEST_MODE}.
     * <p>
     * If {@code AZURE_TEST_MODE} isn't configured or is invalid then {@link TestMode#PLAYBACK} is returned.
     *
     * @return The {@link TestMode} being used for testing.
     */
    static TestMode initializeTestMode() {
        return TestingHelpers.getTestMode();
    }

    /**
     * Returns the path of the class to which the test belongs.
     *
     * @return The file path of the test class.
     */
    protected Path getTestClassPath() {
        return testContextManager.getTestClassPath();
    }

    /**
     * Sleeps the test for the given amount of milliseconds if {@link TestMode} isn't {@link TestMode#PLAYBACK}.
     *
     * @param millis Number of milliseconds to sleep the test.
     * @throws IllegalStateException If the sleep is interrupted.
     */
    protected void sleepIfRunningAgainstService(long millis) {
        if (testMode == TestMode.PLAYBACK) {
            return;
        }

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            throw logger.throwableAtWarning().log(ex, IllegalStateException::new);
        }
    }

    //    /**
    //     * Sets the polling interval for the passed {@link SyncPoller}.
    //     * <p>
    //     * This configures the {@link SyncPoller} to use a poll interval of one millisecond if the test mode is playback. In
    //     * live or record test mode the polling interval is left as-is.
    //     *
    //     * @param syncPoller The {@link SyncPoller}.
    //     * @param <T> The type of poll response value.
    //     * @param <U> The type of the final result of long-running operation.
    //     * @return The updated {@link SyncPoller}.
    //     */
    //    protected <T, U> SyncPoller<T, U> setPlaybackSyncPollerPollInterval(SyncPoller<T, U> syncPoller) {
    //        return (testMode == TestMode.PLAYBACK) ? syncPoller.setPollInterval(PLAYBACK_POLL_INTERVAL) : syncPoller;
    //    }

    /**
     * Convenience method which either returned the passed {@link HttpClient} or returns a {@link InterceptorManager#getPlaybackClient()}
     * depending on whether the test mode is playback.
     * <p>
     * When the test mode is playback the {@link InterceptorManager#getPlaybackClient()} corresponding to the test will be returned, otherwise
     * the passed {@link HttpClient} will be returned.
     *
     * @param httpClient The initial {@link HttpClient} that will be used.
     * @return Either the passed {@link HttpClient} or {@link InterceptorManager#getPlaybackClient()} based on the test mode.
     */
    protected HttpClient getHttpClientOrUsePlayback(HttpClient httpClient) {
        return (testMode == TestMode.PLAYBACK) ? interceptorManager.getPlaybackClient() : httpClient;
    }

    private static HttpClient getTestProxyHttpClient() {
        return TEST_PROXY_HTTP_CLIENT.updateAndGet(httpClient -> httpClient == null
            ? getHttpClients().findFirst().orElse(new HttpUrlConnectionHttpClient())
            : httpClient);
    }

    static boolean shouldLogExecutionStatus() {
        String testMode = Configuration.getGlobalConfiguration().get(AZURE_TEST_DEBUG);
        if (testMode == null) {
            return false;
        }

        return Boolean.parseBoolean(testMode);
    }
}
