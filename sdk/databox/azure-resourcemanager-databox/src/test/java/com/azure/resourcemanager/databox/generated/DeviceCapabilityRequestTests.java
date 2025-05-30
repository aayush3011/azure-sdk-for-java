// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databox.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.databox.models.DeviceCapabilityRequest;
import com.azure.resourcemanager.databox.models.ModelName;
import com.azure.resourcemanager.databox.models.SkuName;
import org.junit.jupiter.api.Assertions;

public final class DeviceCapabilityRequestTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DeviceCapabilityRequest model = BinaryData.fromString("{\"skuName\":\"DataBoxDisk\",\"model\":\"DataBoxDisk\"}")
            .toObject(DeviceCapabilityRequest.class);
        Assertions.assertEquals(SkuName.DATA_BOX_DISK, model.skuName());
        Assertions.assertEquals(ModelName.DATA_BOX_DISK, model.model());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DeviceCapabilityRequest model
            = new DeviceCapabilityRequest().withSkuName(SkuName.DATA_BOX_DISK).withModel(ModelName.DATA_BOX_DISK);
        model = BinaryData.fromObject(model).toObject(DeviceCapabilityRequest.class);
        Assertions.assertEquals(SkuName.DATA_BOX_DISK, model.skuName());
        Assertions.assertEquals(ModelName.DATA_BOX_DISK, model.model());
    }
}
