// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.models.Sku;
import org.junit.jupiter.api.Assertions;

public final class SkuTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Sku model = BinaryData.fromString("{\"name\":\"dxkqpx\"}").toObject(Sku.class);
        Assertions.assertEquals("dxkqpx", model.name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Sku model = new Sku().withName("dxkqpx");
        model = BinaryData.fromObject(model).toObject(Sku.class);
        Assertions.assertEquals("dxkqpx", model.name());
    }
}