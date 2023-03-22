// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AlertSyncSettings;
import org.junit.jupiter.api.Assertions;

public final class AlertSyncSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AlertSyncSettings model =
            BinaryData
                .fromString(
                    "{\"kind\":\"AlertSyncSettings\",\"properties\":{\"enabled\":true},\"id\":\"cfsrhkhgsn\",\"name\":\"uww\",\"type\":\"pphefsbzx\"}")
                .toObject(AlertSyncSettings.class);
        Assertions.assertEquals(true, model.enabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AlertSyncSettings model = new AlertSyncSettings().withEnabled(true);
        model = BinaryData.fromObject(model).toObject(AlertSyncSettings.class);
        Assertions.assertEquals(true, model.enabled());
    }
}