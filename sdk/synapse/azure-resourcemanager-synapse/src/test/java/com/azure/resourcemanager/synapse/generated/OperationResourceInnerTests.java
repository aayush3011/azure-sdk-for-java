// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.OperationResourceInner;
import com.azure.resourcemanager.synapse.models.OperationStatus;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class OperationResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OperationResourceInner model =
            BinaryData
                .fromString(
                    "{\"id\":\"fepgzgq\",\"name\":\"zloc\",\"status\":\"InProgress\",\"properties\":\"dataaierhhb\",\"startTime\":\"2021-09-10T20:40:36Z\",\"endTime\":\"2021-07-20T05:11Z\",\"percentComplete\":4.375696}")
                .toObject(OperationResourceInner.class);
        Assertions.assertEquals("fepgzgq", model.id());
        Assertions.assertEquals("zloc", model.name());
        Assertions.assertEquals(OperationStatus.IN_PROGRESS, model.status());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-10T20:40:36Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-20T05:11Z"), model.endTime());
        Assertions.assertEquals(4.375696F, model.percentComplete());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OperationResourceInner model =
            new OperationResourceInner()
                .withId("fepgzgq")
                .withName("zloc")
                .withStatus(OperationStatus.IN_PROGRESS)
                .withProperties("dataaierhhb")
                .withStartTime(OffsetDateTime.parse("2021-09-10T20:40:36Z"))
                .withEndTime(OffsetDateTime.parse("2021-07-20T05:11Z"))
                .withPercentComplete(4.375696F);
        model = BinaryData.fromObject(model).toObject(OperationResourceInner.class);
        Assertions.assertEquals("fepgzgq", model.id());
        Assertions.assertEquals("zloc", model.name());
        Assertions.assertEquals(OperationStatus.IN_PROGRESS, model.status());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-10T20:40:36Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-20T05:11Z"), model.endTime());
        Assertions.assertEquals(4.375696F, model.percentComplete());
    }
}