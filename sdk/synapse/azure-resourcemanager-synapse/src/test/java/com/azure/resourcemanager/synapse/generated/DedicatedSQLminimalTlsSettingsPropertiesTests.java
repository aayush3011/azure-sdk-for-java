// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.DedicatedSQLminimalTlsSettingsProperties;
import org.junit.jupiter.api.Assertions;

public final class DedicatedSQLminimalTlsSettingsPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DedicatedSQLminimalTlsSettingsProperties model =
            BinaryData
                .fromString("{\"minimalTlsVersion\":\"snfepgfewetwlyx\"}")
                .toObject(DedicatedSQLminimalTlsSettingsProperties.class);
        Assertions.assertEquals("snfepgfewetwlyx", model.minimalTlsVersion());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DedicatedSQLminimalTlsSettingsProperties model =
            new DedicatedSQLminimalTlsSettingsProperties().withMinimalTlsVersion("snfepgfewetwlyx");
        model = BinaryData.fromObject(model).toObject(DedicatedSQLminimalTlsSettingsProperties.class);
        Assertions.assertEquals("snfepgfewetwlyx", model.minimalTlsVersion());
    }
}