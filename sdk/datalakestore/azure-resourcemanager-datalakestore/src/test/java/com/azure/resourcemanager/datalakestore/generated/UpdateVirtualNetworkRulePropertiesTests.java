// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakestore.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datalakestore.fluent.models.UpdateVirtualNetworkRuleProperties;
import org.junit.jupiter.api.Assertions;

public final class UpdateVirtualNetworkRulePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UpdateVirtualNetworkRuleProperties model = BinaryData.fromString("{\"subnetId\":\"zjaoyfhrtxil\"}")
            .toObject(UpdateVirtualNetworkRuleProperties.class);
        Assertions.assertEquals("zjaoyfhrtxil", model.subnetId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UpdateVirtualNetworkRuleProperties model
            = new UpdateVirtualNetworkRuleProperties().withSubnetId("zjaoyfhrtxil");
        model = BinaryData.fromObject(model).toObject(UpdateVirtualNetworkRuleProperties.class);
        Assertions.assertEquals("zjaoyfhrtxil", model.subnetId());
    }
}
