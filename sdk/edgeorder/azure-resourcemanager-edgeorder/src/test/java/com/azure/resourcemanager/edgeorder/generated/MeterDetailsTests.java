// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.edgeorder.models.MeterDetails;

public final class MeterDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MeterDetails model = BinaryData
            .fromString(
                "{\"billingType\":\"MeterDetails\",\"multiplier\":88.18883517379254,\"chargingType\":\"PerDevice\"}")
            .toObject(MeterDetails.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MeterDetails model = new MeterDetails();
        model = BinaryData.fromObject(model).toObject(MeterDetails.class);
    }
}
