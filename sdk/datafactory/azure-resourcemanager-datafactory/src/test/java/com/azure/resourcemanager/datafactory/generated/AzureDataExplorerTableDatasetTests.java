// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureDataExplorerTableDataset;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class AzureDataExplorerTableDatasetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureDataExplorerTableDataset model = BinaryData.fromString(
            "{\"type\":\"faky\",\"typeProperties\":{\"table\":\"datatbgvlpgfyg\"},\"description\":\"psihzqieoympp\",\"structure\":\"dataxjsfgbyy\",\"schema\":\"dataazlycx\",\"linkedServiceName\":{\"referenceName\":\"ubru\",\"parameters\":{\"dkg\":\"databuoyr\"}},\"parameters\":{\"xuvsveamseauuuvh\":{\"type\":\"Array\",\"defaultValue\":\"datavjmfjjf\"},\"lmufzuuysz\":{\"type\":\"String\",\"defaultValue\":\"datah\"},\"fvwgwphwxiav\":{\"type\":\"String\",\"defaultValue\":\"dataemtyosdpxtsdywfg\"}},\"annotations\":[\"dataxaqgfpuhh\",\"datawrsjumlkjsvk\",\"datatmlixalphkg\",\"datainhecj\"],\"folder\":{\"name\":\"djmsngm\"},\"\":{\"pjthizsabcylzzi\":\"datarlkpismmrmr\"}}")
            .toObject(AzureDataExplorerTableDataset.class);
        Assertions.assertEquals("psihzqieoympp", model.description());
        Assertions.assertEquals("ubru", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.ARRAY, model.parameters().get("xuvsveamseauuuvh").type());
        Assertions.assertEquals("djmsngm", model.folder().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureDataExplorerTableDataset model = new AzureDataExplorerTableDataset().withDescription("psihzqieoympp")
            .withStructure("dataxjsfgbyy")
            .withSchema("dataazlycx")
            .withLinkedServiceName(
                new LinkedServiceReference().withReferenceName("ubru").withParameters(mapOf("dkg", "databuoyr")))
            .withParameters(mapOf("xuvsveamseauuuvh",
                new ParameterSpecification().withType(ParameterType.ARRAY).withDefaultValue("datavjmfjjf"),
                "lmufzuuysz", new ParameterSpecification().withType(ParameterType.STRING).withDefaultValue("datah"),
                "fvwgwphwxiav",
                new ParameterSpecification().withType(ParameterType.STRING).withDefaultValue("dataemtyosdpxtsdywfg")))
            .withAnnotations(Arrays.asList("dataxaqgfpuhh", "datawrsjumlkjsvk", "datatmlixalphkg", "datainhecj"))
            .withFolder(new DatasetFolder().withName("djmsngm"))
            .withTable("datatbgvlpgfyg");
        model = BinaryData.fromObject(model).toObject(AzureDataExplorerTableDataset.class);
        Assertions.assertEquals("psihzqieoympp", model.description());
        Assertions.assertEquals("ubru", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.ARRAY, model.parameters().get("xuvsveamseauuuvh").type());
        Assertions.assertEquals("djmsngm", model.folder().name());
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
