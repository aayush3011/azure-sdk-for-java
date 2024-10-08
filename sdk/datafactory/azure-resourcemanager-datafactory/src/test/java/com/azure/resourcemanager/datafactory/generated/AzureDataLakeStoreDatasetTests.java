// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureDataLakeStoreDataset;
import com.azure.resourcemanager.datafactory.models.DatasetCompression;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.DatasetStorageFormat;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class AzureDataLakeStoreDatasetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureDataLakeStoreDataset model = BinaryData.fromString(
            "{\"type\":\"AzureDataLakeStoreFile\",\"typeProperties\":{\"folderPath\":\"datajmdgjvxlhmpmhe\",\"fileName\":\"datayaphqeofytlsnlo\",\"format\":{\"type\":\"DatasetStorageFormat\",\"serializer\":\"datamcqixuanccqvjf\",\"deserializer\":\"datafqpmquxpj\",\"\":{\"gugrblwa\":\"dataaaradciovmuf\"}},\"compression\":{\"type\":\"dataossnq\",\"level\":\"dataaotbptgcsm\",\"\":{\"ecvtamqwzmno\":\"dataxrwqfmd\",\"wpsibxovuqoq\":\"datafe\",\"ycvtqnzjcy\":\"datarkblndyclw\",\"alb\":\"dataqzhembtbw\"}}},\"description\":\"pisjdleajv\",\"structure\":\"datavl\",\"schema\":\"dataubsfxip\",\"linkedServiceName\":{\"referenceName\":\"eopsk\",\"parameters\":{\"cdhus\":\"datajomlupfazus\",\"rgdqyxaj\":\"datagdw\"}},\"parameters\":{\"oqzkmqcwwsjnki\":{\"type\":\"Object\",\"defaultValue\":\"dataavqcwy\"},\"sqxile\":{\"type\":\"SecureString\",\"defaultValue\":\"datapbntqqwwgf\"}},\"annotations\":[\"datasewrzne\",\"datauqynttwk\"],\"folder\":{\"name\":\"jksb\"},\"\":{\"bssfcriqx\":\"datagjmqjhgcydijnmcv\",\"vcdkucpxpyafrwr\":\"dataixtdlxw\",\"krspnrsjsemlz\":\"dataorogeuv\"}}")
            .toObject(AzureDataLakeStoreDataset.class);
        Assertions.assertEquals("pisjdleajv", model.description());
        Assertions.assertEquals("eopsk", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.OBJECT, model.parameters().get("oqzkmqcwwsjnki").type());
        Assertions.assertEquals("jksb", model.folder().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureDataLakeStoreDataset model = new AzureDataLakeStoreDataset().withDescription("pisjdleajv")
            .withStructure("datavl")
            .withSchema("dataubsfxip")
            .withLinkedServiceName(new LinkedServiceReference().withReferenceName("eopsk")
                .withParameters(mapOf("cdhus", "datajomlupfazus", "rgdqyxaj", "datagdw")))
            .withParameters(mapOf("oqzkmqcwwsjnki",
                new ParameterSpecification().withType(ParameterType.OBJECT).withDefaultValue("dataavqcwy"), "sqxile",
                new ParameterSpecification().withType(ParameterType.SECURE_STRING).withDefaultValue("datapbntqqwwgf")))
            .withAnnotations(Arrays.asList("datasewrzne", "datauqynttwk"))
            .withFolder(new DatasetFolder().withName("jksb"))
            .withFolderPath("datajmdgjvxlhmpmhe")
            .withFileName("datayaphqeofytlsnlo")
            .withFormat(new DatasetStorageFormat().withSerializer("datamcqixuanccqvjf")
                .withDeserializer("datafqpmquxpj")
                .withAdditionalProperties(mapOf("type", "DatasetStorageFormat")))
            .withCompression(new DatasetCompression().withType("dataossnq")
                .withLevel("dataaotbptgcsm")
                .withAdditionalProperties(mapOf()));
        model = BinaryData.fromObject(model).toObject(AzureDataLakeStoreDataset.class);
        Assertions.assertEquals("pisjdleajv", model.description());
        Assertions.assertEquals("eopsk", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.OBJECT, model.parameters().get("oqzkmqcwwsjnki").type());
        Assertions.assertEquals("jksb", model.folder().name());
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
