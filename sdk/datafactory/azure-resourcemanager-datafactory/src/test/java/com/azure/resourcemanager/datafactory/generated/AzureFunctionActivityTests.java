// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.ActivityDependency;
import com.azure.resourcemanager.datafactory.models.ActivityOnInactiveMarkAs;
import com.azure.resourcemanager.datafactory.models.ActivityPolicy;
import com.azure.resourcemanager.datafactory.models.ActivityState;
import com.azure.resourcemanager.datafactory.models.AzureFunctionActivity;
import com.azure.resourcemanager.datafactory.models.AzureFunctionActivityMethod;
import com.azure.resourcemanager.datafactory.models.DependencyCondition;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.UserProperty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class AzureFunctionActivityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureFunctionActivity model = BinaryData.fromString(
            "{\"type\":\"AzureFunctionActivity\",\"typeProperties\":{\"method\":\"HEAD\",\"functionName\":\"datahwybbdaedqttzslt\",\"headers\":{\"ieaum\":\"datadacetjmap\",\"lhfxjcq\":\"datajxdirdcxuiamr\",\"xqpemqogto\":\"datafpwjjtdzfyivv\"},\"body\":\"datafvysvudbj\"},\"linkedServiceName\":{\"referenceName\":\"htxvmnyslpdq\",\"parameters\":{\"pblnervtym\":\"dataj\"}},\"policy\":{\"timeout\":\"datanjxvtvyyasil\",\"retry\":\"dataqygn\",\"retryIntervalInSeconds\":99436162,\"secureInput\":true,\"secureOutput\":false,\"\":{\"jsugkdv\":\"datavjhmqpjbk\",\"efdsgfztmhvu\":\"datagpeitfbgyznsh\"}},\"name\":\"avpoookhc\",\"description\":\"wgbjzznmjwqwyhh\",\"state\":\"Inactive\",\"onInactiveMarkAs\":\"Failed\",\"dependsOn\":[{\"activity\":\"jtfnjrrx\",\"dependencyConditions\":[\"Failed\",\"Skipped\",\"Failed\",\"Succeeded\"],\"\":{\"uhywdckvcof\":\"dataxnbbsjgvalowmmh\",\"vtakijwkwed\":\"datatceehqeahlfujp\"}},{\"activity\":\"uumldunalo\",\"dependencyConditions\":[\"Skipped\",\"Failed\"],\"\":{\"ucdvhqec\":\"dataqcbeunss\",\"uiuzsnjjgnmpuqsj\":\"dataqiulwfzoszgbgtwa\"}},{\"activity\":\"vdaj\",\"dependencyConditions\":[\"Completed\",\"Failed\",\"Completed\"],\"\":{\"jzleeup\":\"datamtwtbrpdtbgkxzx\"}},{\"activity\":\"lszcwomayr\",\"dependencyConditions\":[\"Failed\",\"Failed\"],\"\":{\"tiwinnhowih\":\"dataardfxn\",\"dzgmfnpel\":\"datag\"}}],\"userProperties\":[{\"name\":\"sicpxu\",\"value\":\"dataupngorwvayrgu\"},{\"name\":\"fjjg\",\"value\":\"dataf\"},{\"name\":\"fwgrubofhkbjgx\",\"value\":\"datarppxjnrujdskkkzq\"}],\"\":{\"jirhaqe\":\"dataib\",\"xzha\":\"datafuazdak\",\"jfrpbdxsjceyyebg\":\"datacwhjv\",\"vwhqct\":\"dataffntrb\"}}")
            .toObject(AzureFunctionActivity.class);
        Assertions.assertEquals("avpoookhc", model.name());
        Assertions.assertEquals("wgbjzznmjwqwyhh", model.description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.FAILED, model.onInactiveMarkAs());
        Assertions.assertEquals("jtfnjrrx", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.FAILED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("sicpxu", model.userProperties().get(0).name());
        Assertions.assertEquals("htxvmnyslpdq", model.linkedServiceName().referenceName());
        Assertions.assertEquals(99436162, model.policy().retryIntervalInSeconds());
        Assertions.assertEquals(true, model.policy().secureInput());
        Assertions.assertEquals(false, model.policy().secureOutput());
        Assertions.assertEquals(AzureFunctionActivityMethod.HEAD, model.method());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureFunctionActivity model = new AzureFunctionActivity().withName("avpoookhc")
            .withDescription("wgbjzznmjwqwyhh")
            .withState(ActivityState.INACTIVE)
            .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.FAILED)
            .withDependsOn(Arrays.asList(
                new ActivityDependency().withActivity("jtfnjrrx")
                    .withDependencyConditions(Arrays.asList(DependencyCondition.FAILED, DependencyCondition.SKIPPED,
                        DependencyCondition.FAILED, DependencyCondition.SUCCEEDED))
                    .withAdditionalProperties(mapOf()),
                new ActivityDependency().withActivity("uumldunalo")
                    .withDependencyConditions(Arrays.asList(DependencyCondition.SKIPPED, DependencyCondition.FAILED))
                    .withAdditionalProperties(mapOf()),
                new ActivityDependency().withActivity("vdaj")
                    .withDependencyConditions(Arrays.asList(DependencyCondition.COMPLETED, DependencyCondition.FAILED,
                        DependencyCondition.COMPLETED))
                    .withAdditionalProperties(mapOf()),
                new ActivityDependency().withActivity("lszcwomayr")
                    .withDependencyConditions(Arrays.asList(DependencyCondition.FAILED, DependencyCondition.FAILED))
                    .withAdditionalProperties(mapOf())))
            .withUserProperties(Arrays.asList(new UserProperty().withName("sicpxu").withValue("dataupngorwvayrgu"),
                new UserProperty().withName("fjjg").withValue("dataf"),
                new UserProperty().withName("fwgrubofhkbjgx").withValue("datarppxjnrujdskkkzq")))
            .withLinkedServiceName(new LinkedServiceReference().withReferenceName("htxvmnyslpdq")
                .withParameters(mapOf("pblnervtym", "dataj")))
            .withPolicy(new ActivityPolicy().withTimeout("datanjxvtvyyasil")
                .withRetry("dataqygn")
                .withRetryIntervalInSeconds(99436162)
                .withSecureInput(true)
                .withSecureOutput(false)
                .withAdditionalProperties(mapOf()))
            .withMethod(AzureFunctionActivityMethod.HEAD)
            .withFunctionName("datahwybbdaedqttzslt")
            .withHeaders(
                mapOf("ieaum", "datadacetjmap", "lhfxjcq", "datajxdirdcxuiamr", "xqpemqogto", "datafpwjjtdzfyivv"))
            .withBody("datafvysvudbj");
        model = BinaryData.fromObject(model).toObject(AzureFunctionActivity.class);
        Assertions.assertEquals("avpoookhc", model.name());
        Assertions.assertEquals("wgbjzznmjwqwyhh", model.description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.FAILED, model.onInactiveMarkAs());
        Assertions.assertEquals("jtfnjrrx", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.FAILED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("sicpxu", model.userProperties().get(0).name());
        Assertions.assertEquals("htxvmnyslpdq", model.linkedServiceName().referenceName());
        Assertions.assertEquals(99436162, model.policy().retryIntervalInSeconds());
        Assertions.assertEquals(true, model.policy().secureInput());
        Assertions.assertEquals(false, model.policy().secureOutput());
        Assertions.assertEquals(AzureFunctionActivityMethod.HEAD, model.method());
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
