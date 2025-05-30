// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.DaprSecretsCollection;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DaprComponentsListSecretsWithResponseMockTests {
    @Test
    public void testListSecretsWithResponse() throws Exception {
        String responseStr
            = "{\"value\":[{\"name\":\"t\",\"value\":\"rxkhlob\"},{\"name\":\"jbhvhdiqayflu\",\"value\":\"uosnuud\"},{\"name\":\"lvhyibdrqrswhbu\",\"value\":\"pyrowtj\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerAppsApiManager manager = ContainerAppsApiManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        DaprSecretsCollection response = manager.daprComponents()
            .listSecretsWithResponse("ekaj", "lyzgsnor", "jgmn", com.azure.core.util.Context.NONE)
            .getValue();

    }
}
