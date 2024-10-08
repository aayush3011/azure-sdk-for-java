// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.FlavorData;
import com.azure.resourcemanager.machinelearning.models.ModelVersionProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ModelVersionPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ModelVersionProperties model = BinaryData.fromString(
            "{\"flavors\":{\"neqvcwwyyurmo\":{\"data\":{\"utmzlbiojlvfhrbb\":\"la\"}}},\"modelType\":\"ppr\",\"modelUri\":\"snmokayzej\",\"jobName\":\"lbkpb\",\"provisioningState\":\"Failed\",\"stage\":\"iljhahz\",\"isArchived\":true,\"isAnonymous\":false,\"description\":\"bnwieholew\",\"tags\":{\"fqsfa\":\"uubw\",\"wexjkmfxapjwogq\":\"aqtferr\",\"awbzasqb\":\"nobpudcdabtqwpw\"},\"properties\":{\"yexaoguy\":\"jg\",\"ids\":\"i\"}}")
            .toObject(ModelVersionProperties.class);
        Assertions.assertEquals("bnwieholew", model.description());
        Assertions.assertEquals("uubw", model.tags().get("fqsfa"));
        Assertions.assertEquals("jg", model.properties().get("yexaoguy"));
        Assertions.assertEquals(true, model.isArchived());
        Assertions.assertEquals(false, model.isAnonymous());
        Assertions.assertEquals("la", model.flavors().get("neqvcwwyyurmo").data().get("utmzlbiojlvfhrbb"));
        Assertions.assertEquals("ppr", model.modelType());
        Assertions.assertEquals("snmokayzej", model.modelUri());
        Assertions.assertEquals("lbkpb", model.jobName());
        Assertions.assertEquals("iljhahz", model.stage());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ModelVersionProperties model = new ModelVersionProperties().withDescription("bnwieholew")
            .withTags(mapOf("fqsfa", "uubw", "wexjkmfxapjwogq", "aqtferr", "awbzasqb", "nobpudcdabtqwpw"))
            .withProperties(mapOf("yexaoguy", "jg", "ids", "i"))
            .withIsArchived(true)
            .withIsAnonymous(false)
            .withFlavors(mapOf("neqvcwwyyurmo", new FlavorData().withData(mapOf("utmzlbiojlvfhrbb", "la"))))
            .withModelType("ppr")
            .withModelUri("snmokayzej")
            .withJobName("lbkpb")
            .withStage("iljhahz");
        model = BinaryData.fromObject(model).toObject(ModelVersionProperties.class);
        Assertions.assertEquals("bnwieholew", model.description());
        Assertions.assertEquals("uubw", model.tags().get("fqsfa"));
        Assertions.assertEquals("jg", model.properties().get("yexaoguy"));
        Assertions.assertEquals(true, model.isArchived());
        Assertions.assertEquals(false, model.isAnonymous());
        Assertions.assertEquals("la", model.flavors().get("neqvcwwyyurmo").data().get("utmzlbiojlvfhrbb"));
        Assertions.assertEquals("ppr", model.modelType());
        Assertions.assertEquals("snmokayzej", model.modelUri());
        Assertions.assertEquals("lbkpb", model.jobName());
        Assertions.assertEquals("iljhahz", model.stage());
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
