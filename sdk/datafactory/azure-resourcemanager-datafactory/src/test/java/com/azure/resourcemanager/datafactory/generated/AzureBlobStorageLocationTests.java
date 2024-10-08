// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureBlobStorageLocation;

public final class AzureBlobStorageLocationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureBlobStorageLocation model = BinaryData.fromString(
            "{\"type\":\"AzureBlobStorageLocation\",\"container\":\"datazpzlpryf\",\"folderPath\":\"datamdutzfk\",\"fileName\":\"datalnoud\",\"\":{\"gdpri\":\"datand\"}}")
            .toObject(AzureBlobStorageLocation.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureBlobStorageLocation model = new AzureBlobStorageLocation().withFolderPath("datamdutzfk")
            .withFileName("datalnoud")
            .withContainer("datazpzlpryf");
        model = BinaryData.fromObject(model).toObject(AzureBlobStorageLocation.class);
    }
}
