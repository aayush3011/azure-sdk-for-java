// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.batch.BatchManager;
import com.azure.resourcemanager.batch.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.batch.models.PrivateEndpointConnection;
import com.azure.resourcemanager.batch.models.PrivateLinkServiceConnectionState;
import com.azure.resourcemanager.batch.models.PrivateLinkServiceConnectionStatus;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PrivateEndpointConnectionsUpdateMockTests {
    @Test
    public void testUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\",\"privateEndpoint\":{\"id\":\"vumwmxqh\"},\"groupIds\":[\"noamldsehaohdj\",\"hflzokxco\",\"pelnjetag\"],\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"oatftgzpnpbswvef\",\"actionsRequired\":\"ccsrmozihmipgaw\"}},\"etag\":\"xp\",\"tags\":{\"fmpcycilrmca\":\"cxcjxgry\",\"t\":\"kggnoxu\",\"cpfnznthjtwkja\":\"ksxwpnd\",\"tcqiosmg\":\"srxuzvoam\"},\"id\":\"zah\",\"name\":\"xqdlyrtltlapr\",\"type\":\"tz\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        BatchManager manager = BatchManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PrivateEndpointConnection response
            = manager.privateEndpointConnections()
                .update("wemxswvruunzz", "gehkfkimrtixokff", "yinljqe",
                    new PrivateEndpointConnectionInner().withTags(mapOf("rsbycucrwn", "lxqzvn", "qbsms", "mikzeb"))
                        .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                            .withStatus(PrivateLinkServiceConnectionStatus.PENDING)
                            .withDescription("o")),
                    "ycjsx", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("cxcjxgry", response.tags().get("fmpcycilrmca"));
        Assertions.assertEquals(PrivateLinkServiceConnectionStatus.APPROVED,
            response.privateLinkServiceConnectionState().status());
        Assertions.assertEquals("oatftgzpnpbswvef", response.privateLinkServiceConnectionState().description());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
