// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.openai;

import com.azure.ai.openai.models.AudioResponseData;
import com.azure.ai.openai.models.AudioTaskLabel;
import com.azure.ai.openai.models.AudioTranscriptionFormat;
import com.azure.ai.openai.models.AudioTranscriptionTimestampGranularity;
import com.azure.ai.openai.models.AudioTranslationFormat;
import com.azure.ai.openai.models.AzureChatExtensionsMessageContext;
import com.azure.ai.openai.models.AzureSearchChatExtensionConfiguration;
import com.azure.ai.openai.models.AzureSearchChatExtensionParameters;
import com.azure.ai.openai.models.Batch;
import com.azure.ai.openai.models.BatchCreateRequest;
import com.azure.ai.openai.models.BatchStatus;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsFunctionToolCall;
import com.azure.ai.openai.models.ChatCompletionsFunctionToolSelection;
import com.azure.ai.openai.models.ChatCompletionsNamedFunctionToolSelection;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatCompletionsToolCall;
import com.azure.ai.openai.models.ChatCompletionsToolSelection;
import com.azure.ai.openai.models.ChatCompletionsToolSelectionPreset;
import com.azure.ai.openai.models.ChatResponseMessage;
import com.azure.ai.openai.models.ChatRole;
import com.azure.ai.openai.models.Choice;
import com.azure.ai.openai.models.CompleteUploadRequest;
import com.azure.ai.openai.models.Completions;
import com.azure.ai.openai.models.CompletionsFinishReason;
import com.azure.ai.openai.models.CompletionsOptions;
import com.azure.ai.openai.models.CompletionsUsage;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.FileDeletionStatus;
import com.azure.ai.openai.models.FileDetails;
import com.azure.ai.openai.models.FilePurpose;
import com.azure.ai.openai.models.FileState;
import com.azure.ai.openai.models.FunctionCall;
import com.azure.ai.openai.models.FunctionCallConfig;
import com.azure.ai.openai.models.OnYourDataApiKeyAuthenticationOptions;
import com.azure.ai.openai.models.OnYourDataContextProperty;
import com.azure.ai.openai.models.OpenAIFile;
import com.azure.ai.openai.models.SpeechGenerationResponseFormat;
import com.azure.ai.openai.models.UploadPart;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.test.annotation.RecordWithoutRequestBody;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.azure.ai.openai.TestUtils.DISPLAY_NAME_WITH_ARGUMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenAIAsyncClientTest extends OpenAIClientTestBase {
    private OpenAIAsyncClient client;

    private OpenAIAsyncClient getOpenAIAsyncClient(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        return getOpenAIClientBuilder(
            interceptorManager.isPlaybackMode() ? interceptorManager.getPlaybackClient() : httpClient, serviceVersion)
                .buildAsyncClient();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletions(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((deploymentId, prompt) -> {
            StepVerifier.create(client.getCompletions(deploymentId, new CompletionsOptions(prompt)))
                .assertNext(resultCompletions -> {
                    assertCompletions(1, resultCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsStream(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((deploymentId, prompt) -> {
            StepVerifier.create(client.getCompletionsStream(deploymentId, new CompletionsOptions(prompt)))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(completions -> true)
                .consumeRecordedWith(messageList -> {
                    assertTrue(messageList.size() > 1);

                    Object[] result = messageList.stream().toArray();
                    Completions[] completionsArray = Arrays.copyOf(result, result.length, Completions[].class);

                    assertTrue(completionsArray.length > 1);
                    // First element returns the prompt filter results (no output tokens are present)
                    assertFalse(CoreUtils.isNullOrEmpty(completionsArray[0].getPromptFilterResults()));
                    // Choices (output tokens) are present in all the elements in between
                    for (int i = 1; i < completionsArray.length - 2; i++) {
                        assertCompletionsStream(completionsArray[i]);
                    }

                    // Last element returns the completion tokens (no output tokens are present)
                    assertNotNull(completionsArray[completionsArray.length - 1].getUsage());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsStreamUsage(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsStreamUsageRunner((deploymentId, completionsOptions) -> {
            StepVerifier.create(client.getCompletionsStream(deploymentId, completionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(completions -> true)
                .consumeRecordedWith(
                    resultCompletions -> assertCompletionStreamUsage(new ArrayList<>(resultCompletions)))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsStreamTokenCutoff(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsStreamTokenCutoffRunner((deploymentId, completionsOptions) -> {
            StepVerifier.create(client.getCompletionsStream(deploymentId, completionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(completions -> true)
                .consumeRecordedWith(
                    resultCompletions -> assertCompletionStreamTokenCutoff(new ArrayList<>(resultCompletions)))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsFromPrompt(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsFromSinglePromptRunner((deploymentId, prompt) -> {
            StepVerifier.create(client.getCompletions(deploymentId, prompt)).assertNext(resultCompletions -> {
                assertCompletions(1, resultCompletions);
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((deploymentId, prompt) -> {
            StepVerifier
                .create(client.getCompletionsWithResponse(deploymentId,
                    BinaryData.fromObject(new CompletionsOptions(prompt)), new RequestOptions()))
                .assertNext(response -> {
                    Completions resultCompletions = assertAndGetValueFromResponse(response, Completions.class, 200);
                    assertCompletions(1, resultCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsWithResponseBadDeployment(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((deploymentId, prompt) -> {
            deploymentId = "BAD_DEPLOYMENT_ID";
            StepVerifier
                .create(client.getCompletionsWithResponse(deploymentId,
                    BinaryData.fromObject(new CompletionsOptions(prompt)), new RequestOptions()))
                .verifyErrorSatisfies(throwable -> {
                    assertInstanceOf(ResourceNotFoundException.class, throwable);
                    assertEquals(404, ((ResourceNotFoundException) throwable).getResponse().getStatusCode());
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsUsageField(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((modelId, prompt) -> {
            CompletionsOptions completionsOptions = new CompletionsOptions(prompt);
            completionsOptions.setMaxTokens(1024);
            completionsOptions.setN(3);
            completionsOptions.setLogprobs(1);
            StepVerifier.create(client.getCompletions(modelId, completionsOptions)).assertNext(resultCompletions -> {
                CompletionsUsage usage = resultCompletions.getUsage();
                assertCompletions(completionsOptions.getN() * completionsOptions.getPrompt().size(), resultCompletions);
                assertNotNull(usage);
                assertTrue(usage.getTotalTokens() > 0);
                assertEquals(usage.getCompletionTokens() + usage.getPromptTokens(), usage.getTotalTokens());
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetCompletionsTokenCutoff(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsRunner((modelId, prompt) -> {
            CompletionsOptions completionsOptions = new CompletionsOptions(prompt).setMaxTokens(3);
            StepVerifier.create(client.getCompletions(modelId, completionsOptions)).assertNext(resultCompletions -> {
                assertCompletions(1, resultCompletions);
                CompletionsUsage usage = resultCompletions.getUsage();
                assertNotNull(usage);
                assertTrue(usage.getCompletionTokens() <= 3);
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletions(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsRunner((deploymentId, chatMessages) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, new ChatCompletionsOptions(chatMessages)))
                .assertNext(resultChatCompletions -> {
                    assertNotNull(resultChatCompletions.getUsage());
                    assertChatCompletions(1, resultChatCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsTextPromptAudioResponse(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsWithTextPromptAudioResponse((deploymentId, options) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, options)).assertNext(chatCompletions -> {
                ChatChoice choice = chatCompletions.getChoices().get(0);
                ChatResponseMessage message = choice.getMessage();

                // Assert that the message has content
                assertEquals(ChatRole.ASSISTANT, message.getRole());
                AudioResponseData audioResponse = message.getAudio();
                assertNotNull(audioResponse);
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getId()));
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getData()));
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getTranscript()));
                assertNotNull(audioResponse.getExpiresAt());

                // Assert finish reason
                assertEquals(CompletionsFinishReason.STOPPED, choice.getFinishReason());
                CompletionsUsage usage = chatCompletions.getUsage();

                // assert that we only used audio tokens for the response
                assertNotNull(usage);
                assertNotNull(usage.getPromptTokensDetails());
                assertNotNull(usage.getCompletionTokensDetails());

                assertEquals(0, usage.getPromptTokensDetails().getAudioTokens());
                assertTrue(usage.getCompletionTokensDetails().getAudioTokens() > 0);
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsAudioPromptAudioResponse(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsWithAudioPromptAudioResponse((deploymentId, options) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, options)).assertNext(chatCompletions -> {
                ChatChoice choice = chatCompletions.getChoices().get(0);
                ChatResponseMessage message = choice.getMessage();

                // Assert that the message has content
                assertEquals(ChatRole.ASSISTANT, message.getRole());
                AudioResponseData audioResponse = message.getAudio();
                assertNotNull(audioResponse);
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getId()));
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getData()));
                assertFalse(CoreUtils.isNullOrEmpty(audioResponse.getTranscript()));
                assertNotNull(audioResponse.getExpiresAt());

                // Assert finish reason
                assertEquals(CompletionsFinishReason.STOPPED, choice.getFinishReason());
                CompletionsUsage usage = chatCompletions.getUsage();

                // assert that we only used audio tokens for the response
                assertNotNull(usage);
                assertNotNull(usage.getPromptTokensDetails());
                assertNotNull(usage.getCompletionTokensDetails());

                assertTrue(usage.getPromptTokensDetails().getAudioTokens() > 0);
                assertTrue(usage.getCompletionTokensDetails().getAudioTokens() > 0);
            }).verifyComplete();
        });
    }

    @Disabled("There is no instance supporting this feature yet")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsReasoningEffortLow(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsWithReasoningEffortForAzure((deploymentId, options) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, options)).assertNext(chatCompletions -> {
                ChatChoice choice = chatCompletions.getChoices().get(0);
                ChatResponseMessage message = choice.getMessage();

                // Assert that the message has content
                assertEquals(ChatRole.ASSISTANT, message.getRole());
                assertFalse(CoreUtils.isNullOrEmpty(message.getContent()));

                // Assert finish reason
                assertEquals(CompletionsFinishReason.STOPPED, choice.getFinishReason());
                CompletionsUsage usage = chatCompletions.getUsage();

                // assert that we only used audio tokens for the response
                assertNotNull(usage);
                assertNotNull(usage.getPromptTokensDetails());
                assertNotNull(usage.getCompletionTokensDetails());

                assertTrue(usage.getCompletionTokensDetails().getReasoningTokens() > 0);
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsPrediction(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsWithPredictionForAzure((deploymentId, options) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, options)).assertNext(chatCompletions -> {
                ChatChoice choice = chatCompletions.getChoices().get(0);
                ChatResponseMessage message = choice.getMessage();

                // Assert that the message has content
                assertEquals(ChatRole.ASSISTANT, message.getRole());
                assertFalse(CoreUtils.isNullOrEmpty(message.getContent()));

                // Assert finish reason
                assertEquals(CompletionsFinishReason.STOPPED, choice.getFinishReason());
                CompletionsUsage usage = chatCompletions.getUsage();

                // assert that we only used audio tokens for the response
                assertNotNull(usage);
                assertNotNull(usage.getPromptTokensDetails());
                assertNotNull(usage.getCompletionTokensDetails());

                assertTrue(usage.getCompletionTokensDetails().getAcceptedPredictionTokens() > 0);
                assertTrue(usage.getCompletionTokensDetails().getRejectedPredictionTokens() > 0);
            }).verifyComplete();
        });
    }

    @Disabled("Unrecognized request argument supplied: max_completion_tokens")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsTokenCutoff(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsRunner((modelId, chatMessages) -> {
            StepVerifier
                .create(client.getChatCompletions(modelId,
                    new ChatCompletionsOptions(chatMessages).setMaxCompletionTokens(10)))
                .assertNext(
                    resultChatCompletions -> assertTrue(resultChatCompletions.getUsage().getCompletionTokens() <= 10))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsStream(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsRunner((deploymentId, chatMessages) -> {
            StepVerifier.create(client.getChatCompletionsStream(deploymentId, new ChatCompletionsOptions(chatMessages)))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> {
                    assertChatCompletionsStream(chatCompletions);
                    return true;
                })
                .consumeRecordedWith(messageList -> assertTrue(messageList.size() > 1))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsStreamUsage(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsStreamUsageRunner((deploymentId, chatCompletionsOptions) -> {
            StepVerifier.create(client.getChatCompletionsStream(deploymentId, chatCompletionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> true)
                .consumeRecordedWith(
                    resultChatCompletions -> assertChatCompletionStreamUsage(new ArrayList<>(resultChatCompletions)))
                .verifyComplete();
        });
    }

    @Disabled("promps and completion tokens are null in Azure")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsStreamUsageTokenDetails(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsStreamUsageRunner((deploymentId, chatCompletionsOptions) -> {
            StepVerifier.create(client.getChatCompletionsStream(deploymentId, chatCompletionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> true)
                .consumeRecordedWith(resultChatCompletions -> assertChatCompletionStreamUsageTokenDetails(
                    new ArrayList<>(resultChatCompletions)))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsStreamTokenCutoff(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsStreamTokenCutoffRunner((deploymentId, chatCompletionsOptions) -> {
            StepVerifier.create(client.getChatCompletionsStream(deploymentId, chatCompletionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> true)
                .consumeRecordedWith(resultChatCompletions -> assertChatCompletionStreamTokenCutoff(
                    new ArrayList<>(resultChatCompletions)))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsStreamWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsWithResponseRunner(deploymentId -> chatMessages -> requestOptions -> {
            StepVerifier
                .create(client.getChatCompletionsStreamWithResponse(deploymentId,
                    new ChatCompletionsOptions(chatMessages), requestOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(response -> {
                    assertResponseRequestHeader(response.getRequest());
                    assertChatCompletionsStream(response.getValue());
                    return true;
                })
                .consumeRecordedWith(messageList -> assertTrue(messageList.size() > 1))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsRunner((deploymentId, chatMessages) -> {
            StepVerifier
                .create(client.getChatCompletionsWithResponse(deploymentId,
                    BinaryData.fromObject(new ChatCompletionsOptions(chatMessages)), new RequestOptions()))
                .assertNext(response -> {
                    ChatCompletions resultChatCompletions
                        = assertAndGetValueFromResponse(response, ChatCompletions.class, 200);
                    assertChatCompletions(1, resultChatCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testStructuredOutputInResponseFormat(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsStructuredOutputInResponseFormatRunner((deploymentId, chatCompletionsOptions) -> {
            StepVerifier.create(client.getChatCompletions(deploymentId, chatCompletionsOptions))
                .assertNext(resultChatCompletions -> {
                    assertNotNull(resultChatCompletions.getUsage());
                    assertChatCompletions(1, resultChatCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetEmbeddings(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getEmbeddingRunner((deploymentId, embeddingsOptions) -> {
            StepVerifier.create(client.getEmbeddings(deploymentId, embeddingsOptions))
                .assertNext(resultEmbeddings -> assertEmbeddings(resultEmbeddings))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void getEmbeddingsWithSmallerDimensions(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getEmbeddingWithSmallerDimensionsRunner((deploymentId, embeddingsOptions) -> {
            StepVerifier.create(client.getEmbeddings(deploymentId, embeddingsOptions)).assertNext(resultEmbeddings -> {
                assertEmbeddings(resultEmbeddings);
                assertEquals(embeddingsOptions.getDimensions(),
                    resultEmbeddings.getData().get(0).getEmbedding().size());
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetEmbeddingsWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getEmbeddingRunner((deploymentId, embeddingsOptions) -> {
            StepVerifier.create(client.getEmbeddingsWithResponse(deploymentId, BinaryData.fromObject(embeddingsOptions),
                new RequestOptions())).assertNext(response -> {
                    Embeddings resultEmbeddings = assertAndGetValueFromResponse(response, Embeddings.class, 200);
                    assertEmbeddings(resultEmbeddings);
                }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGenerateImage(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getImageGenerationRunner(
            (deploymentId, options) -> StepVerifier.create(client.getImageGenerations(deploymentId, options))
                .assertNext(OpenAIClientTestBase::assertImageGenerationsForAzure)
                .verifyComplete());
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGenerateImageWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getImageGenerationWithResponseRunner(deploymentId -> options -> requestOptions -> {
            StepVerifier.create(client.getImageGenerationsWithResponse(deploymentId, options, requestOptions))
                .assertNext(response -> {
                    assertResponseRequestHeader(response.getRequest());
                    assertImageGenerationsForAzure(response.getValue());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testContentFilterInputExceptionInImageGeneration(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        contentFilterInputExceptionRunner((deploymentId, options) -> {
            StepVerifier.create(client.getImageGenerations(deploymentId, options))
                .expectErrorSatisfies(
                    ex -> validateImageGenerationContentFilteringException((HttpResponseException) ex))
                .verify();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatFunctionAutoPreset(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatFunctionForRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions.setFunctionCall(FunctionCallConfig.AUTO);
            StepVerifier.create(client.getChatCompletions(modelId, chatCompletionsOptions))
                .assertNext(chatCompletions -> {
                    assertEquals(1, chatCompletions.getChoices().size());
                    ChatChoice chatChoice = chatCompletions.getChoices().get(0);
                    MyFunctionCallArguments arguments = assertFunctionCall(chatChoice, MyFunctionCallArguments.class);
                    assertTrue(arguments.getLocation().contains("San Francisco"));
                    assertEquals(arguments.getUnit(), "CELSIUS");
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatFunctionNonePreset(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatFunctionForRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions.setFunctionCall(FunctionCallConfig.NONE);
            StepVerifier.create(client.getChatCompletions(modelId, chatCompletionsOptions))
                .assertNext(chatCompletions -> {
                    assertChatCompletions(1, "stop", ChatRole.ASSISTANT, chatCompletions);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatFunctionNotSuppliedByNamePreset(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatFunctionForRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions.setFunctionCall(new FunctionCallConfig("NotMyFunction"));
            StepVerifier.create(client.getChatCompletions(modelId, chatCompletionsOptions))
                .verifyErrorSatisfies(throwable -> {
                    assertInstanceOf(HttpResponseException.class, throwable);
                    HttpResponseException httpResponseException = (HttpResponseException) throwable;
                    assertEquals(400, httpResponseException.getResponse().getStatusCode());
                    assertTrue(httpResponseException.getMessage().contains("Invalid value for 'function_call'"));
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatCompletionContentFiltering(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsContentFilterRunner((modelId, chatMessages) -> {
            StepVerifier.create(client.getChatCompletions(modelId, new ChatCompletionsOptions(chatMessages)))
                .assertNext(chatCompletions -> {
                    assertSafePromptContentFilterResults(chatCompletions.getPromptFilterResults().get(0));
                    assertEquals(1, chatCompletions.getChoices().size());
                    assertSafeChoiceContentFilterResults(chatCompletions.getChoices().get(0).getContentFilterResults());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatCompletionStreamContentFiltering(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatCompletionsContentFilterRunner((modelId, chatMessages) -> {
            StepVerifier.create(client.getChatCompletionsStream(modelId, new ChatCompletionsOptions(chatMessages)))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> {
                    assertChatCompletionsStream(chatCompletions);
                    return true;
                })
                .consumeRecordedWith(messageList -> {
                    assertTrue(messageList.size() > 1);

                    int i = 0;
                    for (Iterator<ChatCompletions> it = messageList.iterator(); it.hasNext();) {
                        ChatCompletions chatCompletions = it.next();
                        if (i == 0) {
                            // The first stream message has the prompt filter result
                            assertEquals(1, chatCompletions.getPromptFilterResults().size());
                            assertSafePromptContentFilterResults(chatCompletions.getPromptFilterResults().get(0));
                        } else if (i == 1) {
                            // The second message no longer has the prompt filter result, but contains a ChatChoice
                            // filter result with all the filter set to null. The roll is also ASSISTANT
                            assertEquals(ChatRole.ASSISTANT, chatCompletions.getChoices().get(0).getDelta().getRole());
                            assertNull(chatCompletions.getPromptFilterResults());
                            // TODO (team): change in behaviour, this used to be uncommented
                            //                            assertSafeChoiceContentFilterResults(chatCompletions.getChoices().get(0).getContentFilterResults());
                        } else if (i == messageList.size() - 1) {
                            // The last stream message is empty with all the filters set to null
                            assertEquals(1, chatCompletions.getChoices().size());
                            ChatChoice chatChoice = chatCompletions.getChoices().get(0);

                            assertEquals(CompletionsFinishReason.fromString("stop"), chatChoice.getFinishReason());
                            assertNotNull(chatChoice.getDelta());
                            assertNull(chatChoice.getDelta().getContent());
                            // TODO (team): change in behaviour, this used to be uncommented
                            //                            assertSafeChoiceContentFilterResults(chatChoice.getContentFilterResults());
                        } else {
                            // The rest of the intermediary messages have the text generation content filter set
                            assertNull(chatCompletions.getPromptFilterResults());
                            assertNotNull(chatCompletions.getChoices().get(0).getDelta());
                            assertSafeChoiceContentFilterResults(
                                chatCompletions.getChoices().get(0).getContentFilterResults());
                        }
                        i++;
                    }
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testCompletionContentFiltering(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsContentFilterRunner((modelId, prompt) -> {
            CompletionsOptions completionsOptions = new CompletionsOptions(Arrays.asList(prompt));
            // work around for this model, there seem to be some issues with Completions in gpt-turbo models
            completionsOptions.setMaxTokens(2000);
            StepVerifier.create(client.getCompletions(modelId, completionsOptions)).assertNext(completions -> {
                assertCompletions(1, completions);
                assertSafePromptContentFilterResults(completions.getPromptFilterResults().get(0));
                assertSafeChoiceContentFilterResults(completions.getChoices().get(0).getContentFilterResults());
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testCompletionStreamContentFiltering(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getCompletionsContentFilterRunner((modelId, prompt) -> {
            CompletionsOptions completionsOptions = new CompletionsOptions(Arrays.asList(prompt));
            StepVerifier.create(client.getCompletionsStream(modelId, completionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(chatCompletions -> true)
                .consumeRecordedWith(messageList -> {
                    assertTrue(messageList.size() > 1);
                    int i = 0;
                    for (Iterator<Completions> it = messageList.iterator(); it.hasNext();) {
                        Completions completions = it.next();
                        if (i == 0) {
                            assertEquals(1, completions.getPromptFilterResults().size());
                            assertSafePromptContentFilterResults(completions.getPromptFilterResults().get(0));
                        } else if (i == messageList.size() - 1) {
                            // The last contains only the token usage
                            assertEquals(0, completions.getChoices().size());
                            assertEquals(
                                completions.getUsage().getCompletionTokens() + completions.getUsage().getPromptTokens(),
                                completions.getUsage().getTotalTokens());
                        } else {
                            // The rest of the intermediary messages have the text generation content filter set
                            assertNull(completions.getPromptFilterResults());
                            Choice choice = completions.getChoices().get(0);
                            assertNotNull(choice);
                            if (choice.getFinishReason() == null) {
                                assertSafeChoiceContentFilterResults(choice.getContentFilterResults());
                            }
                        }
                        i++;
                    }
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatCompletionsBasicSearchExtension(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getChatCompletionsAzureChatSearchRunner((deploymentName, chatCompletionsOptions) -> {
            AzureSearchChatExtensionParameters searchParameters
                = new AzureSearchChatExtensionParameters(azureSearchEndpoint, azureSearchIndexName);
            searchParameters.setAuthentication(new OnYourDataApiKeyAuthenticationOptions(getAzureCognitiveSearchKey()));
            AzureSearchChatExtensionConfiguration cognitiveSearchConfiguration
                = new AzureSearchChatExtensionConfiguration(searchParameters);

            chatCompletionsOptions.setDataSources(Arrays.asList(cognitiveSearchConfiguration));

            StepVerifier.create(client.getChatCompletions(deploymentName, chatCompletionsOptions))
                .assertNext(OpenAIClientTestBase::assertChatCompletionsCognitiveSearch)
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatCompletionSearchExtensionContextPropertyFilter(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getChatCompletionsAzureChatSearchRunner((deploymentName, chatCompletionsOptions) -> {
            AzureSearchChatExtensionParameters searchParameters
                = new AzureSearchChatExtensionParameters(azureSearchEndpoint, azureSearchIndexName);

            // Only have citations in the search results, default are 'citations' and 'intent'.
            List<OnYourDataContextProperty> contextProperties = new ArrayList<>();
            contextProperties.add(OnYourDataContextProperty.CITATIONS);

            searchParameters.setAuthentication(new OnYourDataApiKeyAuthenticationOptions(getAzureCognitiveSearchKey()))
                .setIncludeContexts(contextProperties);

            AzureSearchChatExtensionConfiguration cognitiveSearchConfiguration
                = new AzureSearchChatExtensionConfiguration(searchParameters);

            chatCompletionsOptions.setDataSources(Arrays.asList(cognitiveSearchConfiguration));

            StepVerifier.create(client.getChatCompletions(deploymentName, chatCompletionsOptions))
                .assertNext(chatCompletions -> {
                    AzureChatExtensionsMessageContext context
                        = chatCompletions.getChoices().get(0).getMessage().getContext();
                    assertNotNull(context);
                    assertNull(context.getIntent());
                    assertFalse(CoreUtils.isNullOrEmpty(context.getCitations()));
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testChatCompletionsStreamingBasicSearchExtension(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getChatCompletionsAzureChatSearchRunner((deploymentName, chatCompletionsOptions) -> {
            AzureSearchChatExtensionParameters searchParameters
                = new AzureSearchChatExtensionParameters(azureSearchEndpoint, azureSearchIndexName);
            searchParameters.setAuthentication(new OnYourDataApiKeyAuthenticationOptions(getAzureCognitiveSearchKey()));
            AzureSearchChatExtensionConfiguration cognitiveSearchConfiguration
                = new AzureSearchChatExtensionConfiguration(searchParameters);

            chatCompletionsOptions.setDataSources(Arrays.asList(cognitiveSearchConfiguration));

            StepVerifier.create(client.getChatCompletionsStream(deploymentName, chatCompletionsOptions))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(_chatCompletion -> true)
                .consumeRecordedWith(
                    chatCompletions -> assertChatCompletionsStreamingCognitiveSearch(chatCompletions.stream()))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionJson(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.JSON);

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> assertAudioTranscriptionSimpleJson(transcription, BATMAN_TRANSCRIPTION))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionVerboseJson(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VERBOSE_JSON);

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> assertAudioTranscriptionVerboseJson(transcription, BATMAN_TRANSCRIPTION,
                    AudioTaskLabel.TRANSCRIBE))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testAudioTranscriptionTimestampGranularityInWord(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VERBOSE_JSON)
                .setTimestampGranularities(Arrays.asList(AudioTranscriptionTimestampGranularity.WORD));

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> {
                    assertNull(transcription.getSegments());
                    assertAudioTranscriptionWords(transcription.getWords());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testAudioTranscriptionTimestampGranularityInSegment(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VERBOSE_JSON)
                .setTimestampGranularities(Arrays.asList(AudioTranscriptionTimestampGranularity.SEGMENT));

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> {
                    assertAudioTranscriptionSegments(transcription.getSegments());
                    assertNull(transcription.getWords());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testAudioTranscriptionTimestampGranularityInBothSegmentAndWord(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VERBOSE_JSON)
                .setTimestampGranularities(Arrays.asList(AudioTranscriptionTimestampGranularity.SEGMENT,
                    AudioTranscriptionTimestampGranularity.WORD));

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> {
                    assertAudioTranscriptionSegments(transcription.getSegments());
                    assertAudioTranscriptionWords(transcription.getWords());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testAudioTranscriptionDuplicateTimestampGranularity(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VERBOSE_JSON)
                .setTimestampGranularities(Arrays.asList(AudioTranscriptionTimestampGranularity.WORD,
                    AudioTranscriptionTimestampGranularity.WORD));

            StepVerifier
                .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions))
                .assertNext(transcription -> {
                    assertNull(transcription.getSegments());
                    assertAudioTranscriptionWords(transcription.getWords());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testAudioTranscriptionTimestampGranularityInWrongResponseFormat(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getAudioTranscriptionRunner((modelId, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.JSON)
                .setTimestampGranularities(Arrays.asList(AudioTranscriptionTimestampGranularity.WORD));

            StepVerifier
                .create(client.getAudioTranscription(modelId, transcriptionOptions.getFilename(), transcriptionOptions))
                .verifyErrorSatisfies(error -> assertTrue(error instanceof HttpResponseException));
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionTextPlain(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.TEXT);

            StepVerifier.create(client.getAudioTranscriptionText(deploymentName, transcriptionOptions.getFilename(),
                transcriptionOptions)).assertNext(transcription ->
            // A plain/text request adds a line break as an artifact. Also observed for translations
            assertEquals(BATMAN_TRANSCRIPTION + "\n", transcription)).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionSrt(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.SRT);

            StepVerifier.create(client.getAudioTranscriptionText(deploymentName, transcriptionOptions.getFilename(),
                transcriptionOptions)).assertNext(translation -> {
                    // 1st Sequence number
                    assertTrue(translation.contains("1\n"));
                    // First sequence starts at timestamp 0
                    assertTrue(translation.contains("00:00:00,000 --> "));
                    // Transcription contains at least one expected word
                    assertTrue(translation.contains("Batman"));
                }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionVtt(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.VTT);

            StepVerifier.create(client.getAudioTranscriptionText(deploymentName, transcriptionOptions.getFilename(),
                transcriptionOptions)).assertNext(translation -> {
                    // Start value according to spec
                    assertTrue(translation.startsWith("WEBVTT\n"));
                    // First sequence starts at timestamp 0. Note: unlike SRT, the millisecond separator is a "."
                    assertTrue(translation.contains("00:00:00.000 --> "));
                    // Transcription contains at least one expected word
                    assertTrue(translation.contains("Batman"));
                }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetAudioTranscriptionTextWrongFormats(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        List<AudioTranscriptionFormat> wrongFormats
            = Arrays.asList(AudioTranscriptionFormat.JSON, AudioTranscriptionFormat.VERBOSE_JSON);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            for (AudioTranscriptionFormat format : wrongFormats) {
                transcriptionOptions.setResponseFormat(format);
                StepVerifier
                    .create(client.getAudioTranscriptionText(deploymentName, transcriptionOptions.getFilename(),
                        transcriptionOptions))
                    .verifyErrorSatisfies(error -> assertTrue(error instanceof IllegalArgumentException));
            }
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetAudioTranscriptionJsonWrongFormats(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        List<AudioTranscriptionFormat> wrongFormats
            = Arrays.asList(AudioTranscriptionFormat.TEXT, AudioTranscriptionFormat.SRT, AudioTranscriptionFormat.VTT);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            for (AudioTranscriptionFormat format : wrongFormats) {
                transcriptionOptions.setResponseFormat(format);
                StepVerifier
                    .create(client.getAudioTranscription(deploymentName, transcriptionOptions.getFilename(),
                        transcriptionOptions))
                    .verifyErrorSatisfies(error -> assertTrue(error instanceof IllegalArgumentException));
            }
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationJson(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.JSON);

            StepVerifier
                .create(
                    client.getAudioTranslation(deploymentName, translationOptions.getFilename(), translationOptions))
                .assertNext(translation -> assertAudioTranslationSimpleJson(translation, "It's raining today."))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationVerboseJson(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.VERBOSE_JSON);

            StepVerifier
                .create(
                    client.getAudioTranslation(deploymentName, translationOptions.getFilename(), translationOptions))
                .assertNext(translation -> assertAudioTranslationVerboseJson(translation, "It's raining today.",
                    AudioTaskLabel.TRANSLATE))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationTextPlain(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.TEXT);

            StepVerifier
                .create(client.getAudioTranslationText(deploymentName, translationOptions.getFilename(),
                    translationOptions))
                .assertNext(translation -> {
                    assertEquals("It's raining today.\n", translation);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationSrt(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.SRT);

            StepVerifier
                .create(client.getAudioTranslationText(deploymentName, translationOptions.getFilename(),
                    translationOptions))
                .assertNext(translation -> {
                    // Sequence number
                    assertTrue(translation.contains("1\n"));
                    // First sequence starts at timestamp 0
                    assertTrue(translation.contains("00:00:00,000 --> "));
                    // Actual translation value
                    assertTrue(translation.contains("It's raining today."));
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationVtt(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.VTT);

            StepVerifier
                .create(client.getAudioTranslationText(deploymentName, translationOptions.getFilename(),
                    translationOptions))
                .assertNext(translation -> {
                    // Start value according to spec
                    assertTrue(translation.startsWith("WEBVTT\n"));
                    // First sequence starts at timestamp 0. Note: unlike SRT, the millisecond separator is a "."
                    assertTrue(translation.contains("00:00:00.000 --> "));
                    // Actual translation value
                    assertTrue(translation.contains("It's raining today."));
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetAudioTranslationTextWrongFormats(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        List<AudioTranslationFormat> wrongFormats
            = Arrays.asList(AudioTranslationFormat.JSON, AudioTranslationFormat.VERBOSE_JSON);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            for (AudioTranslationFormat format : wrongFormats) {
                translationOptions.setResponseFormat(format);
                StepVerifier
                    .create(client.getAudioTranslationText(deploymentName, translationOptions.getFilename(),
                        translationOptions))
                    .verifyErrorSatisfies(error -> assertTrue(error instanceof IllegalArgumentException));
            }
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetAudioTranslationJsonWrongFormats(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        List<AudioTranslationFormat> wrongFormats
            = Arrays.asList(AudioTranslationFormat.TEXT, AudioTranslationFormat.SRT, AudioTranslationFormat.VTT);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            for (AudioTranslationFormat format : wrongFormats) {
                translationOptions.setResponseFormat(format);
                StepVerifier
                    .create(client.getAudioTranslation(deploymentName, translationOptions.getFilename(),
                        translationOptions))
                    .verifyErrorSatisfies(error -> assertTrue(error instanceof IllegalArgumentException));
            }
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsToolCall(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions
                .setToolChoice(new ChatCompletionsToolSelection(ChatCompletionsToolSelectionPreset.AUTO));
            StepVerifier
                .create(client.getChatCompletionsWithResponse(modelId, chatCompletionsOptions, new RequestOptions())
                    .flatMap(response -> {
                        assertNotNull(response);
                        assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300);
                        ChatCompletions chatCompletions = response.getValue();
                        assertNotNull(chatCompletions);

                        assertTrue(chatCompletions.getChoices() != null && !chatCompletions.getChoices().isEmpty());
                        ChatChoice chatChoice = chatCompletions.getChoices().get(0);
                        assertEquals(chatChoice.getFinishReason(), CompletionsFinishReason.TOOL_CALLS);

                        ChatResponseMessage responseMessage = chatChoice.getMessage();
                        assertNotNull(responseMessage);
                        assertTrue(responseMessage.getContent() == null || responseMessage.getContent().isEmpty());
                        assertFalse(responseMessage.getToolCalls() == null || responseMessage.getToolCalls().isEmpty());

                        ChatCompletionsFunctionToolCall functionToolCall
                            = (ChatCompletionsFunctionToolCall) responseMessage.getToolCalls().get(0);
                        assertNotNull(functionToolCall);
                        assertFalse(functionToolCall.getFunction().getArguments() == null
                            || functionToolCall.getFunction().getArguments().isEmpty());

                        // we should be passing responseMessage.getContent()) instead of ""; but it's null and Azure does not accept that
                        return client.getChatCompletions(modelId,
                            getChatCompletionsOptionWithToolCallFollowUp(functionToolCall, ""));
                    }))
                .assertNext(followUpChatCompletions -> {
                    assertNotNull(followUpChatCompletions);
                    assertNotNull(followUpChatCompletions.getChoices());
                    ChatChoice followUpChatChoice = followUpChatCompletions.getChoices().get(0);
                    assertNotNull(followUpChatChoice);
                    assertNotNull(followUpChatChoice.getMessage());
                    String content = followUpChatChoice.getMessage().getContent();
                    assertFalse(content == null || content.isEmpty());
                    assertEquals(followUpChatChoice.getMessage().getRole(), ChatRole.ASSISTANT);
                    assertEquals(followUpChatChoice.getFinishReason(), CompletionsFinishReason.STOPPED);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsToolCallForStrictStructuredOutput(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallStructuredOutputRunner(((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions
                .setToolChoice(new ChatCompletionsToolSelection(ChatCompletionsToolSelectionPreset.AUTO));
            StepVerifier
                .create(client.getChatCompletionsWithResponse(modelId, chatCompletionsOptions, new RequestOptions())
                    .flatMap(response -> {
                        assertNotNull(response);
                        assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300);
                        ChatCompletions chatCompletions = response.getValue();
                        assertNotNull(chatCompletions);

                        assertTrue(chatCompletions.getChoices() != null && !chatCompletions.getChoices().isEmpty());
                        ChatChoice chatChoice = chatCompletions.getChoices().get(0);
                        assertEquals(chatChoice.getFinishReason(), CompletionsFinishReason.TOOL_CALLS);

                        ChatResponseMessage responseMessage = chatChoice.getMessage();
                        assertNotNull(responseMessage);
                        assertTrue(responseMessage.getContent() == null || responseMessage.getContent().isEmpty());
                        assertFalse(responseMessage.getToolCalls() == null || responseMessage.getToolCalls().isEmpty());

                        ChatCompletionsFunctionToolCall functionToolCall
                            = (ChatCompletionsFunctionToolCall) responseMessage.getToolCalls().get(0);
                        assertNotNull(functionToolCall);
                        assertFalse(functionToolCall.getFunction().getArguments() == null
                            || functionToolCall.getFunction().getArguments().isEmpty());

                        // we should be passing responseMessage.getContent()) instead of ""; but it's null and Azure does not accept that
                        return client.getChatCompletions(modelId,
                            getChatCompletionsOptionWithToolCallFollowUp(functionToolCall, ""));
                    }))
                .assertNext(followUpChatCompletions -> {
                    assertNotNull(followUpChatCompletions);
                    assertNotNull(followUpChatCompletions.getChoices());
                    ChatChoice followUpChatChoice = followUpChatCompletions.getChoices().get(0);
                    assertNotNull(followUpChatChoice);
                    assertNotNull(followUpChatChoice.getMessage());
                    String content = followUpChatChoice.getMessage().getContent();
                    assertFalse(content == null || content.isEmpty());
                    assertEquals(followUpChatChoice.getMessage().getRole(), ChatRole.ASSISTANT);
                    assertEquals(followUpChatChoice.getFinishReason(), CompletionsFinishReason.STOPPED);
                })
                .verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionToolCallChoiceExplicitToolName(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions
                .setToolChoice(new ChatCompletionsToolSelection(new ChatCompletionsNamedFunctionToolSelection(
                    new ChatCompletionsFunctionToolSelection("FutureTemperature"))));
            StepVerifier
                .create(client.getChatCompletionsWithResponse(modelId, chatCompletionsOptions, new RequestOptions()))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300);
                    ChatCompletions chatCompletions = response.getValue();
                    assertNotNull(chatCompletions);

                    assertTrue(chatCompletions.getChoices() != null && !chatCompletions.getChoices().isEmpty());
                    ChatChoice chatChoice = chatCompletions.getChoices().get(0);

                    assertNotNull(chatCompletions);
                    assertNotNull(chatCompletions.getChoices());
                    assertNotNull(chatChoice);
                    assertNotNull(chatChoice.getMessage());
                    ChatResponseMessage message = chatChoice.getMessage();
                    assertNull(message.getContent());
                    assertNotNull(message.getToolCalls().get(0));
                    assertInstanceOf(ChatCompletionsFunctionToolCall.class, message.getToolCalls().get(0));
                    ChatCompletionsFunctionToolCall functionToolCall
                        = (ChatCompletionsFunctionToolCall) chatChoice.getMessage().getToolCalls().get(0);
                    assertEquals(functionToolCall.getFunction().getName(), "FutureTemperature");
                    assertTrue(functionToolCall.getFunction().getArguments().contains("Honolulu"));
                    assertEquals(chatChoice.getMessage().getRole(), ChatRole.ASSISTANT);
                    assertEquals(chatChoice.getFinishReason(), CompletionsFinishReason.STOPPED);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionToolCallChoiceNone(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions
                .setToolChoice(new ChatCompletionsToolSelection(ChatCompletionsToolSelectionPreset.NONE));
            StepVerifier
                .create(client.getChatCompletionsWithResponse(modelId, chatCompletionsOptions, new RequestOptions()))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300);
                    ChatCompletions chatCompletions = response.getValue();
                    assertNotNull(chatCompletions);

                    assertTrue(chatCompletions.getChoices() != null && !chatCompletions.getChoices().isEmpty());
                    ChatChoice chatChoice = chatCompletions.getChoices().get(0);

                    assertNotNull(chatCompletions);
                    assertNotNull(chatCompletions.getChoices());
                    assertNotNull(chatChoice);
                    assertNotNull(chatChoice.getMessage());
                    ChatResponseMessage message = chatChoice.getMessage();
                    assertNotNull(message.getContent());
                    assertFalse(message.getContent().isEmpty());
                    assertNull(message.getToolCalls());
                    assertEquals(chatChoice.getMessage().getRole(), ChatRole.ASSISTANT);
                    assertEquals(chatChoice.getFinishReason(), CompletionsFinishReason.STOPPED);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionToolCallChoiceRequired(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallRunner((modelId, chatCompletionsOptions) -> {
            chatCompletionsOptions
                .setToolChoice(new ChatCompletionsToolSelection(ChatCompletionsToolSelectionPreset.REQUIRED));
            StepVerifier
                .create(client.getChatCompletionsWithResponse(modelId, chatCompletionsOptions, new RequestOptions()))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300);
                    ChatCompletions chatCompletions = response.getValue();
                    assertNotNull(chatCompletions);

                    assertTrue(chatCompletions.getChoices() != null && !chatCompletions.getChoices().isEmpty());
                    ChatChoice chatChoice = chatCompletions.getChoices().get(0);

                    assertNotNull(chatCompletions);
                    assertNotNull(chatCompletions.getChoices());
                    assertNotNull(chatChoice);
                    assertNotNull(chatChoice.getMessage());
                    ChatResponseMessage message = chatChoice.getMessage();
                    assertNull(message.getContent());
                    assertNotNull(message.getToolCalls().get(0));
                    assertInstanceOf(ChatCompletionsFunctionToolCall.class, message.getToolCalls().get(0));
                    ChatCompletionsFunctionToolCall functionToolCall
                        = (ChatCompletionsFunctionToolCall) chatChoice.getMessage().getToolCalls().get(0);
                    assertEquals(functionToolCall.getFunction().getName(), "FutureTemperature");
                    assertTrue(functionToolCall.getFunction().getArguments().contains("Honolulu"));
                    assertEquals(chatChoice.getMessage().getRole(), ChatRole.ASSISTANT);
                    assertEquals(chatChoice.getFinishReason(), CompletionsFinishReason.STOPPED);
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testGetChatCompletionsToolCallStreaming(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        getChatWithToolCallRunner((modelId, chatCompletionsOptions) -> {
            StepVerifier.create(client.getChatCompletionsStream(modelId, chatCompletionsOptions)
                .collectList()
                .flatMapMany(chatCompletionsStream -> {
                    StringBuilder argumentsBuilder = new StringBuilder();
                    long totalStreamMessages = chatCompletionsStream.size();
                    String functionName = null;
                    String toolCallId = null;
                    String content = null;
                    assertTrue(totalStreamMessages > 0);

                    int i = 0;
                    for (ChatCompletions chatCompletions : chatCompletionsStream) {
                        List<ChatChoice> chatChoices = chatCompletions.getChoices();
                        if (!chatChoices.isEmpty() && chatChoices.get(0) != null) {
                            assertEquals(1, chatChoices.size());
                            ChatChoice chatChoice = chatChoices.get(0);
                            List<ChatCompletionsToolCall> toolCalls = chatChoice.getDelta().getToolCalls();
                            if (!CoreUtils.isNullOrEmpty(toolCalls)) {
                                assertEquals(1, toolCalls.size());
                                // TODO: can't not cast to ChatCompletionsFunctionToolCall but has to be ChatCompletionsToolCall
                                ChatCompletionsFunctionToolCall toolCall
                                    = (ChatCompletionsFunctionToolCall) toolCalls.get(0);
                                FunctionCall functionCall = toolCall.getFunction();

                                // TODO: It used to be second stream event but now third event.
                                // this data is only available in the on second stream message, if at all
                                // The first contains filter results mostly
                                if (i == 2) {
                                    content = chatChoice.getDelta().getContent();
                                    functionName = functionCall.getName();
                                    toolCallId = toolCall.getId();
                                }
                                argumentsBuilder.append(functionCall.getArguments());
                            }
                            if (i < totalStreamMessages - 1) {
                                assertNull(chatChoice.getFinishReason());
                            } else {
                                assertEquals(CompletionsFinishReason.TOOL_CALLS, chatChoice.getFinishReason());
                            }
                        }
                        i++;
                    }

                    assertFunctionToolCallArgs(argumentsBuilder.toString());
                    FunctionCall functionCall = new FunctionCall(functionName, argumentsBuilder.toString());
                    ChatCompletionsFunctionToolCall functionToolCall
                        = new ChatCompletionsFunctionToolCall(toolCallId, functionCall);

                    // we should be passing responseMessage.getContent()) instead of ""; but it's null and Azure does not accept that
                    ChatCompletionsOptions followUpChatCompletionsOptions
                        = getChatCompletionsOptionWithToolCallFollowUp(functionToolCall, "");

                    return client.getChatCompletionsStream(modelId, followUpChatCompletionsOptions);
                })
                .collectList()).assertNext(followupChatCompletionsStream -> {
                    StringBuilder contentBuilder = new StringBuilder();
                    long totalStreamFollowUpMessages = followupChatCompletionsStream.size();
                    int j = 0;

                    for (ChatCompletions chatCompletions : followupChatCompletionsStream) {
                        List<ChatChoice> chatChoices = chatCompletions.getChoices();
                        if (!chatChoices.isEmpty() && chatChoices.get(0) != null) {
                            assertEquals(1, chatChoices.size());
                            ChatChoice chatChoice = chatChoices.get(0);
                            contentBuilder.append(chatChoice.getDelta().getContent());
                            if (j < totalStreamFollowUpMessages - 1) {
                                assertNull(chatChoice.getFinishReason());
                            } else {
                                assertEquals(CompletionsFinishReason.STOPPED, chatChoice.getFinishReason());
                            }
                        }
                        j++;
                    }
                    assertFalse(CoreUtils.isNullOrEmpty(contentBuilder.toString()));
                }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testTextToSpeech(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        textToSpeechRunner(((modelId, speechGenerationOptions) -> {
            StepVerifier.create(client.generateSpeechFromText(modelId, speechGenerationOptions)).assertNext(speech -> {
                assertNotNull(speech);
                byte[] bytes = speech.toBytes();
                assertNotNull(bytes);
                assertTrue(bytes.length > 0);
            }).verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testTextToSpeechWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        textToSpeechRunner(((modelId, speechGenerationOptions) -> {
            StepVerifier
                .create(client.generateSpeechFromTextWithResponse(modelId,
                    BinaryData.fromObject(speechGenerationOptions), new RequestOptions()))
                .assertNext(response -> {
                    assertTrue(response.getStatusCode() > 0);
                    assertNotNull(response.getHeaders());
                    BinaryData speech = response.getValue();
                    assertNotNull(speech);
                    byte[] bytes = speech.toBytes();
                    assertNotNull(bytes);
                    assertTrue(bytes.length > 0);
                })
                .verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void generateSpeechInMp3(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        textToSpeechRunner(((modelId, speechGenerationOptions) -> {
            speechGenerationOptions.setResponseFormat(SpeechGenerationResponseFormat.MP3);
            StepVerifier.create(client.generateSpeechFromText(modelId, speechGenerationOptions)).assertNext(speech -> {
                assertNotNull(speech);
                byte[] bytes = speech.toBytes();
                assertNotNull(bytes);
                assertTrue(bytes.length > 0);
            }).verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void generateSpeechInWav(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        textToSpeechRunner(((modelId, speechGenerationOptions) -> {
            speechGenerationOptions.setResponseFormat(SpeechGenerationResponseFormat.WAV);
            StepVerifier.create(client.generateSpeechFromText(modelId, speechGenerationOptions)).assertNext(speech -> {
                assertNotNull(speech);
                byte[] bytes = speech.toBytes();
                assertNotNull(bytes);
                assertTrue(bytes.length > 0);
            }).verifyComplete();
        }));
    }

    // Files
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testTextFileOperations(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadTextFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(fileFromBackend);
                    assertFileEquals(uploadedFile, fileFromBackend);
                    return client.listFiles(FilePurpose.ASSISTANTS).zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of file when fetched by purpose
                .flatMap(tuple -> {
                    List<OpenAIFile> files = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    FileDeletionStatus deletionStatus = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testImageFileOperations(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadImageFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(fileFromBackend);
                    assertFileEquals(uploadedFile, fileFromBackend);
                    return client.listFiles().zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of files
                .flatMap(tuple -> {
                    List<OpenAIFile> files = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    FileDeletionStatus deletionStatus = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    @Disabled("Support in Azure OpenAI for FINE_TUNE files is not yet available")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testFineTuningJsonFileOperations(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadFineTuningJsonFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(fileFromBackend);
                    assertFileEquals(uploadedFile, fileFromBackend);
                    return client.listFiles(FilePurpose.FINE_TUNE).zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of file when fetched by purpose
                .flatMap(tuple -> {
                    List<OpenAIFile> files = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    FileDeletionStatus deletionStatus = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testTextFileOperationsWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadTextFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    Response<OpenAIFile> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(response);
                    assertEquals(200, response.getStatusCode());
                    OpenAIFile fileFromBackend = response.getValue();
                    assertFileEquals(uploadedFile, fileFromBackend);

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.addQueryParam("purpose", FilePurpose.ASSISTANTS.toString());
                    return client.listFilesWithResponse(requestOptions).zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of file when fetched by purpose
                .flatMap(tuple -> {
                    Response<List<OpenAIFile>> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    List<OpenAIFile> files = response.getValue();
                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    Response<FileDeletionStatus> response = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    FileDeletionStatus deletionStatus = response.getValue();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testImageFileOperationsWithResponse(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadImageFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    Response<OpenAIFile> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(response);
                    assertEquals(200, response.getStatusCode());
                    OpenAIFile fileFromBackend = response.getValue();
                    assertFileEquals(uploadedFile, fileFromBackend);

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.addQueryParam("purpose", FilePurpose.ASSISTANTS.toString());
                    return client.listFilesWithResponse(requestOptions).zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of file when fetched by purpose
                .flatMap(tuple -> {
                    Response<List<OpenAIFile>> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    List<OpenAIFile> files = response.getValue();
                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    Response<FileDeletionStatus> response = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    FileDeletionStatus deletionStatus = response.getValue();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    @Disabled("Support in Azure OpenAI for FINE_TUNE files is not yet available")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testFineTuningJsonFileOperationsWithResponse(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadFineTuningJsonFileRunner((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    Response<OpenAIFile> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertNotNull(uploadedFile);
                    assertNotNull(response);
                    assertEquals(200, response.getStatusCode());
                    OpenAIFile fileFromBackend = response.getValue();
                    assertFileEquals(uploadedFile, fileFromBackend);

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.addQueryParam("purpose", FilePurpose.FINE_TUNE.toString());
                    return client.listFilesWithResponse(requestOptions).zipWith(Mono.just(uploadedFile));
                })
                // Check for existence of file when fetched by purpose
                .flatMap(tuple -> {
                    Response<List<OpenAIFile>> response = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    List<OpenAIFile> files = response.getValue();
                    assertTrue(files.stream().anyMatch(f -> f.getId().equals(uploadedFile.getId())));
                    return client.deleteFileWithResponse(uploadedFile.getId(), new RequestOptions())
                        .zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    Response<FileDeletionStatus> response = tuple.getT1();
                    OpenAIFile file = tuple.getT2();

                    assertEquals(200, response.getStatusCode());
                    FileDeletionStatus deletionStatus = response.getValue();

                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        });
    }

    // Batch
    @Disabled("Invalid deployment SKU 'Standard'. The deployment SKU needs to be 'globalbatch' for batch API requests.")
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testBatchOperations(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadBatchFileRunner(((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(uploadedFile);
                    assertNotNull(fileFromBackend);
                    assertFileEquals(uploadedFile, fileFromBackend);
                    return Mono.defer(() -> {
                        if (fileFromBackend.getStatus() == FileState.PENDING) {
                            return Mono.delay(Duration.ofSeconds(5))
                                .then(client.getFile(fileFromBackend.getId()))
                                .zipWith(Mono.just(uploadedFile));
                        } else {
                            return Mono.just(fileFromBackend).zipWith(Mono.just(uploadedFile));
                        }
                    });
                })
                // Create batch with file
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    return client
                        .createBatch(new BatchCreateRequest("/v1/chat/completions", fileFromBackend.getId(), "24h"))
                        .zipWith(Mono.just(uploadedFile));
                })
                // Looping getBatch until it's completed
                .flatMap(tuple -> {
                    Batch batch = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(batch);
                    assertNotNull(batch.getId());
                    return Mono.defer(() -> {
                        if (batch.getStatus() == BatchStatus.VALIDATING
                            || batch.getStatus() == BatchStatus.IN_PROGRESS
                            || batch.getStatus() == BatchStatus.FINALIZING) {
                            return Mono.delay(Duration.ofSeconds(5))
                                .then(client.getBatch(batch.getId()))
                                .zipWith(Mono.just(uploadedFile));
                        } else {
                            return Mono.just(batch).zipWith(Mono.just(uploadedFile));
                        }
                    });
                })
                // Get output file content
                .flatMap(tuple -> {
                    Batch batch = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(batch);
                    assertEquals(BatchStatus.COMPLETED, batch.getStatus());
                    return client.getFileContent(batch.getOutputFileId()).zipWith(Mono.just(uploadedFile));
                })
                // Delete uploaded file
                .flatMap(tuple -> {
                    byte[] outputFile = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(outputFile);
                    return client.deleteFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    FileDeletionStatus deletionStatus = tuple.getT1();
                    OpenAIFile file = tuple.getT2();
                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testCancelBatch(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadBatchFileRunner(((fileDetails, filePurpose) -> {
            StepVerifier.create(client.uploadFile(fileDetails, filePurpose)
                // Upload file
                .flatMap(uploadedFile -> {
                    assertNotNull(uploadedFile);
                    assertNotNull(uploadedFile.getId());
                    return client.getFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Compare uploaded file with file from backend
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(uploadedFile);
                    assertNotNull(fileFromBackend);
                    assertFileEquals(uploadedFile, fileFromBackend);
                    return Mono.defer(() -> {
                        if (fileFromBackend.getStatus() == FileState.PENDING) {
                            return Mono.delay(Duration.ofSeconds(5))
                                .then(client.getFile(fileFromBackend.getId()))
                                .zipWith(Mono.just(uploadedFile));
                        } else {
                            return Mono.just(fileFromBackend).zipWith(Mono.just(uploadedFile));
                        }
                    });
                })
                // Create batch with file
                .flatMap(tuple -> {
                    OpenAIFile fileFromBackend = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    return client
                        .createBatch(new BatchCreateRequest("/v1/chat/completions", fileFromBackend.getId(), "24h"))
                        .zipWith(Mono.just(uploadedFile));
                })
                // Cancel batch
                .flatMap(tuple -> {
                    Batch batch = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(batch);
                    assertNotNull(batch.getId());
                    return client.cancelBatch(batch.getId()).zipWith(Mono.just(uploadedFile));
                })
                // Delete uploaded file
                .flatMap(tuple -> {
                    Batch cancelledBatch = tuple.getT1();
                    OpenAIFile uploadedFile = tuple.getT2();
                    assertNotNull(cancelledBatch);
                    BatchStatus status = cancelledBatch.getStatus();
                    assertTrue(status == BatchStatus.CANCELLED || status == BatchStatus.CANCELLING);
                    return client.deleteFile(uploadedFile.getId()).zipWith(Mono.just(uploadedFile));
                }))
                // File deletion
                .assertNext(tuple -> {
                    FileDeletionStatus deletionStatus = tuple.getT1();
                    OpenAIFile file = tuple.getT2();
                    assertNotNull(deletionStatus);
                    assertNotNull(deletionStatus.getId());
                    assertTrue(deletionStatus.isDeleted());
                    assertEquals(file.getId(), deletionStatus.getId());
                })
                .verifyComplete();
        }));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testUploadLargesFilesInPartsOperations(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        AtomicReference<String> uploadId = new AtomicReference<>();
        uploadCreationRunner(createUploadRequest -> {
            StepVerifier.create(client.createUpload(createUploadRequest)).assertNext(upload -> {
                assertNotNull(upload);
                assertNotNull(upload.getId());
                uploadId.set(upload.getId());
            }).verifyComplete();
        });

        addUploadPartRequestRunner((part1, part2) -> {
            String uploadedId = uploadId.get();
            assertNotNull(uploadedId);
            StepVerifier.create(client.addUploadPart(uploadedId, part1).flatMap(uploadPartAdded -> {
                String uploadPartAddedId = uploadPartAdded.getId();
                assertNotNull(uploadPartAddedId);
                return client.addUploadPart(uploadedId, part2).zipWith(Mono.just(uploadPartAddedId));
            }).flatMap(tuple -> {
                UploadPart secondPart = tuple.getT1();
                assertNotNull(secondPart);
                String firstPartId = tuple.getT2();
                String secondPartId = secondPart.getId();
                assertNotEquals(firstPartId, secondPartId);
                CompleteUploadRequest completeUploadRequest
                    = new CompleteUploadRequest(Arrays.asList(firstPartId, secondPartId));
                return client.completeUpload(uploadedId, completeUploadRequest);
            })).assertNext(completeUpload -> {
                assertNotNull(completeUpload);
                assertEquals(uploadedId, completeUpload.getId());
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testCancelUploadLargesFilesInParts(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        uploadCreationRunner(createUploadRequest -> {
            StepVerifier.create(client.createUpload(createUploadRequest).flatMap(upload -> {
                assertNotNull(upload);
                assertNotNull(upload.getId());
                return client.cancelUpload(upload.getId());
            })).assertNext(cancelledId -> {
                assertNotNull(cancelledId);
            }).verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testUploadFileSuccess(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);
        FileDetails fileDetails = new FileDetails(BinaryData.fromBytes("sample-content".getBytes()), "test-file.txt");
        FilePurpose purpose = FilePurpose.ASSISTANTS;

        StepVerifier.create(client.uploadFile(fileDetails, purpose).flatMap(openAIFile -> {
            assertNotNull(openAIFile.getId());
            assertEquals("test-file.txt", openAIFile.getFilename());
            return client.deleteFile(openAIFile.getId()).then();
        })).verifyComplete();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    public void testUploadFileFailure(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        FileDetails fileDetails = new FileDetails(BinaryData.fromBytes("sample-content".getBytes()), "test-file.txt");

        StepVerifier.create(client.uploadFile(fileDetails, null)).verifyErrorSatisfies(error -> {
            assertInstanceOf(HttpResponseException.class, error);
            HttpResponseException httpResponseException = (HttpResponseException) error;
            assertEquals(400, httpResponseException.getResponse().getStatusCode());
            assertFalse(CoreUtils.isNullOrEmpty(httpResponseException.getMessage()));
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationAsResponseObjectSuccess(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.JSON);

            StepVerifier.create(client.getAudioTranslationAsResponseObject(deploymentName, translationOptions))
                .assertNext(translation -> {
                    assertNotNull(translation);
                    assertEquals("It's raining today.", translation.getText());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationAsResponseObjectFailure(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.JSON);
            translationOptions.setFilename(null);

            StepVerifier.create(client.getAudioTranslationAsResponseObject(deploymentName, translationOptions))
                .verifyErrorSatisfies(error -> {
                    assertInstanceOf(HttpResponseException.class, error);
                    HttpResponseException httpResponseException = (HttpResponseException) error;
                    assertEquals(400, httpResponseException.getResponse().getStatusCode());
                    assertFalse(CoreUtils.isNullOrEmpty(httpResponseException.getMessage()));
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionAsResponseObjectSuccess(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.JSON);

            StepVerifier.create(client.getAudioTranscriptionAsResponseObject(deploymentName, transcriptionOptions))
                .assertNext(transcription -> {
                    assertNotNull(transcription);
                    assertEquals(BATMAN_TRANSCRIPTION, transcription.getText());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionAsResponseObjectFailure(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.JSON);
            transcriptionOptions.setFilename(null);

            StepVerifier.create(client.getAudioTranscriptionAsResponseObject(deploymentName, transcriptionOptions))
                .verifyErrorSatisfies(error -> {
                    assertInstanceOf(HttpResponseException.class, error);
                    HttpResponseException httpResponseException = (HttpResponseException) error;
                    assertEquals(400, httpResponseException.getResponse().getStatusCode());
                    assertFalse(CoreUtils.isNullOrEmpty(httpResponseException.getMessage()));
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationTextWithResponseSuccess(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, audioTranslationOptions) -> {
            audioTranslationOptions.setResponseFormat(AudioTranslationFormat.TEXT);

            StepVerifier
                .create(client.getAudioTranslationTextWithResponse(deploymentName,
                    audioTranslationOptions.getFilename(), audioTranslationOptions, new RequestOptions()))
                .assertNext(translation -> {
                    assertNotNull(translation);
                    assertEquals("It's raining today.\n", translation.getValue());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationTextWithResponseFailure(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, audioTranslationOptions) -> {
            audioTranslationOptions.setResponseFormat(AudioTranslationFormat.TEXT);
            audioTranslationOptions.setFilename(null);

            StepVerifier
                .create(client.getAudioTranslationTextWithResponse(deploymentName, "test-file.txt",
                    audioTranslationOptions, new RequestOptions()))
                .verifyErrorSatisfies(error -> {
                    assertInstanceOf(HttpResponseException.class, error);
                    HttpResponseException httpResponseException = (HttpResponseException) error;
                    assertEquals(400, httpResponseException.getResponse().getStatusCode());
                    assertFalse(CoreUtils.isNullOrEmpty(httpResponseException.getMessage()));
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationTextWithResponseWithTemperature(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, audioTranslationOptions) -> {
            audioTranslationOptions.setResponseFormat(AudioTranslationFormat.TEXT);
            audioTranslationOptions.setTemperature(0.0);

            StepVerifier
                .create(client.getAudioTranslationTextWithResponse(deploymentName,
                    audioTranslationOptions.getFilename(), audioTranslationOptions, new RequestOptions()))
                .assertNext(translation -> {
                    assertNotNull(translation);
                    assertEquals("It's raining today.\n", translation.getValue());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionTextWithResponseFailure(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.TEXT);
            transcriptionOptions.setFilename(null);
            transcriptionOptions.setTemperature(0.0);

            StepVerifier
                .create(client.getAudioTranscriptionTextWithResponse(deploymentName, "test-file.txt",
                    transcriptionOptions, new RequestOptions()))
                .verifyErrorSatisfies(error -> {
                    assertInstanceOf(HttpResponseException.class, error);
                    HttpResponseException httpResponseException = (HttpResponseException) error;
                    assertEquals(400, httpResponseException.getResponse().getStatusCode());
                    assertFalse(CoreUtils.isNullOrEmpty(httpResponseException.getMessage()));
                });
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranscriptionWithResponseSuccess(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranscriptionRunner((deploymentName, transcriptionOptions) -> {
            transcriptionOptions.setResponseFormat(AudioTranscriptionFormat.JSON);
            transcriptionOptions.setTemperature(0.0);

            StepVerifier
                .create(client.getAudioTranscriptionWithResponse(deploymentName, transcriptionOptions.getFilename(),
                    transcriptionOptions, new RequestOptions()))
                .assertNext(
                    transcription -> assertAudioTranscriptionSimpleJson(transcription.getValue(), BATMAN_TRANSCRIPTION))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationWithResponseSuccess(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, translationOptions) -> {
            translationOptions.setResponseFormat(AudioTranslationFormat.JSON);
            translationOptions.setTemperature(0.0);

            StepVerifier
                .create(client.getAudioTranslationWithResponse(deploymentName, translationOptions.getFilename(),
                    translationOptions, new RequestOptions()))
                .assertNext(
                    translation -> assertAudioTranslationSimpleJson(translation.getValue(), "It's raining today."))
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testGetAudioTranslationWithResponseWithTemperature(HttpClient httpClient,
        OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        getAudioTranslationRunner((deploymentName, audioTranslationOptions) -> {
            audioTranslationOptions.setResponseFormat(AudioTranslationFormat.JSON);
            audioTranslationOptions.setTemperature(1.0);

            StepVerifier.create(client.getAudioTranslationWithResponse(deploymentName,
                audioTranslationOptions.getFilename(), audioTranslationOptions, new RequestOptions()))
                .assertNext(translation -> {
                    assertNotNull(translation);
                    assertEquals("It's raining today.", translation.getValue().getText());
                })
                .verifyComplete();
        });
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.openai.TestUtils#getTestParameters")
    @RecordWithoutRequestBody
    public void testListBatchesFailure(HttpClient httpClient, OpenAIServiceVersion serviceVersion) {
        client = getOpenAIAsyncClient(httpClient, serviceVersion);

        StepVerifier.create(client.listBatches("40", 20)).verifyErrorSatisfies(error -> {
            assertInstanceOf(HttpResponseException.class, error);
            HttpResponseException httpResponseException = (HttpResponseException) error;
            assertEquals(400, httpResponseException.getResponse().getStatusCode());
            assertNotNull(httpResponseException.getMessage());
        });
    }
}
