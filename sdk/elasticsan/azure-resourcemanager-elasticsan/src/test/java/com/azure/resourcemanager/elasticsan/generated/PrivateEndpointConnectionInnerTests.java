// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elasticsan.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.elasticsan.models.PrivateEndpoint;
import com.azure.resourcemanager.elasticsan.models.PrivateEndpointServiceConnectionStatus;
import com.azure.resourcemanager.elasticsan.models.PrivateLinkServiceConnectionState;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionInner model = BinaryData.fromString(
            "{\"properties\":{\"provisioningState\":\"Pending\",\"privateEndpoint\":{\"id\":\"gujjugwdkcglh\"},\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"jdyggdtji\",\"actionsRequired\":\"b\"},\"groupIds\":[\"fqweykhmene\",\"fyexfwhy\",\"cibvyvdcsitynn\",\"amdecte\"]},\"id\":\"iqscjeypv\",\"name\":\"ezrkgqhcjrefo\",\"type\":\"gm\"}")
            .toObject(PrivateEndpointConnectionInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.privateLinkServiceConnectionState().status());
        Assertions.assertEquals("jdyggdtji", model.privateLinkServiceConnectionState().description());
        Assertions.assertEquals("b", model.privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("fqweykhmene", model.groupIds().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointConnectionInner model
            = new PrivateEndpointConnectionInner().withPrivateEndpoint(new PrivateEndpoint())
                .withPrivateLinkServiceConnectionState(
                    new PrivateLinkServiceConnectionState().withStatus(PrivateEndpointServiceConnectionStatus.APPROVED)
                        .withDescription("jdyggdtji")
                        .withActionsRequired("b"))
                .withGroupIds(Arrays.asList("fqweykhmene", "fyexfwhy", "cibvyvdcsitynn", "amdecte"));
        model = BinaryData.fromObject(model).toObject(PrivateEndpointConnectionInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.privateLinkServiceConnectionState().status());
        Assertions.assertEquals("jdyggdtji", model.privateLinkServiceConnectionState().description());
        Assertions.assertEquals("b", model.privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("fqweykhmene", model.groupIds().get(0));
    }
}
