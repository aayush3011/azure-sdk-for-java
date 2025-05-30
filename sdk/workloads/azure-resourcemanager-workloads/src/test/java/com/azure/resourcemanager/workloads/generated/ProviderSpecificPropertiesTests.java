// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.workloads.models.ProviderSpecificProperties;

public final class ProviderSpecificPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ProviderSpecificProperties model = BinaryData.fromString("{\"providerType\":\"ProviderSpecificProperties\"}")
            .toObject(ProviderSpecificProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ProviderSpecificProperties model = new ProviderSpecificProperties();
        model = BinaryData.fromObject(model).toObject(ProviderSpecificProperties.class);
    }
}
