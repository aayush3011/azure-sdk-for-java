// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.extendedlocation.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.extendedlocation.CustomLocationsManager;
import com.azure.resourcemanager.extendedlocation.models.CustomLocation;
import com.azure.resourcemanager.extendedlocation.models.HostType;
import com.azure.resourcemanager.extendedlocation.models.ResourceIdentityType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class CustomLocationsGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"identity\":{\"principalId\":\"fkbey\",\"tenantId\":\"wrmjmwvvjektc\",\"type\":\"SystemAssigned\"},\"properties\":{\"authentication\":{\"type\":\"lrsf\",\"value\":\"zpwv\"},\"clusterExtensionIds\":[\"q\",\"biqylihkaet\",\"kt\",\"fcivfsnkym\"],\"displayName\":\"tqhjfbebrjcx\",\"hostResourceId\":\"fuwutttxf\",\"hostType\":\"Kubernetes\",\"namespace\":\"i\",\"provisioningState\":\"hxepcyvahfnlj\"},\"location\":\"qxj\",\"tags\":{\"gidokgjljyoxgvcl\":\"j\",\"jhtxfvgxbfsmxne\":\"bgsncghkjeszzhb\"},\"id\":\"mpvecxgodebfqk\",\"name\":\"rbmpukgri\",\"type\":\"flz\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        CustomLocationsManager manager = CustomLocationsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        CustomLocation response = manager.customLocations()
            .getByResourceGroupWithResponse("mqhgyxzkonocuk", "klyaxuconu", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("qxj", response.location());
        Assertions.assertEquals("j", response.tags().get("gidokgjljyoxgvcl"));
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.identity().type());
        Assertions.assertEquals("lrsf", response.authentication().type());
        Assertions.assertEquals("zpwv", response.authentication().value());
        Assertions.assertEquals("q", response.clusterExtensionIds().get(0));
        Assertions.assertEquals("tqhjfbebrjcx", response.displayName());
        Assertions.assertEquals("fuwutttxf", response.hostResourceId());
        Assertions.assertEquals(HostType.KUBERNETES, response.hostType());
        Assertions.assertEquals("i", response.namespace());
        Assertions.assertEquals("hxepcyvahfnlj", response.provisioningState());
    }
}
