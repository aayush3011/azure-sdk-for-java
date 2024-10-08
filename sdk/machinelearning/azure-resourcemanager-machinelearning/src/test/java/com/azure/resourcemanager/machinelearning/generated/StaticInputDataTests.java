// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.JobInputType;
import com.azure.resourcemanager.machinelearning.models.StaticInputData;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class StaticInputDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StaticInputData model = BinaryData.fromString(
            "{\"inputDataType\":\"Static\",\"windowStart\":\"2021-07-21T17:55:57Z\",\"windowEnd\":\"2021-02-10T17:01:52Z\",\"preprocessingComponentId\":\"qekwanklpurl\",\"dataContext\":\"djh\",\"jobInputType\":\"mlflow_model\",\"uri\":\"jse\",\"columns\":{\"urdon\":\"yn\",\"swknpdrgn\":\"gobxblrdolen\",\"fqckie\":\"zaofro\",\"jyoybkqftusdw\":\"yr\"}}")
            .toObject(StaticInputData.class);
        Assertions.assertEquals("djh", model.dataContext());
        Assertions.assertEquals(JobInputType.MLFLOW_MODEL, model.jobInputType());
        Assertions.assertEquals("jse", model.uri());
        Assertions.assertEquals("yn", model.columns().get("urdon"));
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-21T17:55:57Z"), model.windowStart());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-10T17:01:52Z"), model.windowEnd());
        Assertions.assertEquals("qekwanklpurl", model.preprocessingComponentId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        StaticInputData model = new StaticInputData().withDataContext("djh")
            .withJobInputType(JobInputType.MLFLOW_MODEL)
            .withUri("jse")
            .withColumns(mapOf("urdon", "yn", "swknpdrgn", "gobxblrdolen", "fqckie", "zaofro", "jyoybkqftusdw", "yr"))
            .withWindowStart(OffsetDateTime.parse("2021-07-21T17:55:57Z"))
            .withWindowEnd(OffsetDateTime.parse("2021-02-10T17:01:52Z"))
            .withPreprocessingComponentId("qekwanklpurl");
        model = BinaryData.fromObject(model).toObject(StaticInputData.class);
        Assertions.assertEquals("djh", model.dataContext());
        Assertions.assertEquals(JobInputType.MLFLOW_MODEL, model.jobInputType());
        Assertions.assertEquals("jse", model.uri());
        Assertions.assertEquals("yn", model.columns().get("urdon"));
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-21T17:55:57Z"), model.windowStart());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-10T17:01:52Z"), model.windowEnd());
        Assertions.assertEquals("qekwanklpurl", model.preprocessingComponentId());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
