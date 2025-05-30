// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dependencymap.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dependencymap.models.DiscoverySourceResourceProperties;
import org.junit.jupiter.api.Assertions;

public final class DiscoverySourceResourcePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DiscoverySourceResourceProperties model = BinaryData.fromString(
            "{\"sourceType\":\"DiscoverySourceResourceProperties\",\"provisioningState\":\"Failed\",\"sourceId\":\"nh\"}")
            .toObject(DiscoverySourceResourceProperties.class);
        Assertions.assertEquals("nh", model.sourceId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DiscoverySourceResourceProperties model = new DiscoverySourceResourceProperties().withSourceId("nh");
        model = BinaryData.fromObject(model).toObject(DiscoverySourceResourceProperties.class);
        Assertions.assertEquals("nh", model.sourceId());
    }
}
