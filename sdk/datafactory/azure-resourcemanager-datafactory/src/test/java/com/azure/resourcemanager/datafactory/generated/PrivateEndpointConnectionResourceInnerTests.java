// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.PrivateEndpointConnectionResourceInner;
import com.azure.resourcemanager.datafactory.models.ArmIdWrapper;
import com.azure.resourcemanager.datafactory.models.PrivateLinkConnectionState;
import com.azure.resourcemanager.datafactory.models.RemotePrivateEndpointConnection;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionResourceInner model = BinaryData.fromString(
            "{\"properties\":{\"provisioningState\":\"xihspnxwq\",\"privateEndpoint\":{\"id\":\"epzwaklsbsbqq\"},\"privateLinkServiceConnectionState\":{\"status\":\"wwrxaomzisgl\",\"description\":\"czezkhhlt\",\"actionsRequired\":\"adhqoa\"}},\"name\":\"qoyueayfbpcmsplb\",\"type\":\"rueqthwm\",\"etag\":\"mbscbbx\",\"id\":\"dhxiidlopedbwd\"}")
            .toObject(PrivateEndpointConnectionResourceInner.class);
        Assertions.assertEquals("dhxiidlopedbwd", model.id());
        Assertions.assertEquals("wwrxaomzisgl", model.properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("czezkhhlt", model.properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("adhqoa", model.properties().privateLinkServiceConnectionState().actionsRequired());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointConnectionResourceInner model
            = new PrivateEndpointConnectionResourceInner().withId("dhxiidlopedbwd")
                .withProperties(new RemotePrivateEndpointConnection().withPrivateEndpoint(new ArmIdWrapper())
                    .withPrivateLinkServiceConnectionState(new PrivateLinkConnectionState().withStatus("wwrxaomzisgl")
                        .withDescription("czezkhhlt")
                        .withActionsRequired("adhqoa")));
        model = BinaryData.fromObject(model).toObject(PrivateEndpointConnectionResourceInner.class);
        Assertions.assertEquals("dhxiidlopedbwd", model.id());
        Assertions.assertEquals("wwrxaomzisgl", model.properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("czezkhhlt", model.properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("adhqoa", model.properties().privateLinkServiceConnectionState().actionsRequired());
    }
}
