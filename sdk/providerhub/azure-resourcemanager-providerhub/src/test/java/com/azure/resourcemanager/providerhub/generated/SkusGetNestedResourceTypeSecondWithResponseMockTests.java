// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.providerhub.ProviderHubManager;
import com.azure.resourcemanager.providerhub.models.ProvisioningState;
import com.azure.resourcemanager.providerhub.models.SkuResource;
import com.azure.resourcemanager.providerhub.models.SkuScaleType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SkusGetNestedResourceTypeSecondWithResponseMockTests {
    @Test
    public void testGetNestedResourceTypeSecondWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"skuSettings\":[{\"name\":\"ogjwpindedvabbxb\",\"tier\":\"edeilb\",\"size\":\"wfcfxzirzz\",\"family\":\"vwypusuvjsl\",\"kind\":\"wci\",\"locations\":[\"sllfryvdmvxad\",\"acfrgna\",\"bab\"],\"locationInfo\":[{\"location\":\"ktyjmf\"},{\"location\":\"zlfsyqkfrbzgowo\"}],\"requiredQuotaIds\":[\"je\"],\"requiredFeatures\":[\"xnyqgxhlusr\"],\"capacity\":{\"minimum\":219417114,\"maximum\":135967661,\"default\":1468483041,\"scaleType\":\"Automatic\"},\"costs\":[{\"meterId\":\"bjqvls\"},{\"meterId\":\"mywzashxgonoy\"},{\"meterId\":\"fq\"},{\"meterId\":\"puby\"}],\"capabilities\":[{\"name\":\"lkfk\",\"value\":\"ebgvo\"},{\"name\":\"e\",\"value\":\"tuoqujlyegqavni\"}]}],\"provisioningState\":\"Deleting\"},\"id\":\"qqbtny\",\"name\":\"pylx\",\"type\":\"bf\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ProviderHubManager manager = ProviderHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SkuResource response = manager.skus()
            .getNestedResourceTypeSecondWithResponse("lijjjrtvam", "a", "zknxkv", "cxetyvkunmignoh", "k",
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("ogjwpindedvabbxb", response.properties().skuSettings().get(0).name());
        Assertions.assertEquals("edeilb", response.properties().skuSettings().get(0).tier());
        Assertions.assertEquals("wfcfxzirzz", response.properties().skuSettings().get(0).size());
        Assertions.assertEquals("vwypusuvjsl", response.properties().skuSettings().get(0).family());
        Assertions.assertEquals("wci", response.properties().skuSettings().get(0).kind());
        Assertions.assertEquals("sllfryvdmvxad", response.properties().skuSettings().get(0).locations().get(0));
        Assertions.assertEquals("ktyjmf", response.properties().skuSettings().get(0).locationInfo().get(0).location());
        Assertions.assertEquals("je", response.properties().skuSettings().get(0).requiredQuotaIds().get(0));
        Assertions.assertEquals("xnyqgxhlusr", response.properties().skuSettings().get(0).requiredFeatures().get(0));
        Assertions.assertEquals(219417114, response.properties().skuSettings().get(0).capacity().minimum());
        Assertions.assertEquals(135967661, response.properties().skuSettings().get(0).capacity().maximum());
        Assertions.assertEquals(1468483041, response.properties().skuSettings().get(0).capacity().defaultProperty());
        Assertions.assertEquals(SkuScaleType.AUTOMATIC,
            response.properties().skuSettings().get(0).capacity().scaleType());
        Assertions.assertEquals("bjqvls", response.properties().skuSettings().get(0).costs().get(0).meterId());
        Assertions.assertEquals("lkfk", response.properties().skuSettings().get(0).capabilities().get(0).name());
        Assertions.assertEquals("ebgvo", response.properties().skuSettings().get(0).capabilities().get(0).value());
        Assertions.assertEquals(ProvisioningState.DELETING, response.properties().provisioningState());
    }
}
