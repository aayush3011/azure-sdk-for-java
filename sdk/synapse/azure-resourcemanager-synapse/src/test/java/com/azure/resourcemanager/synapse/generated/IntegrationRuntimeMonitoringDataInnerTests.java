// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.IntegrationRuntimeMonitoringDataInner;
import com.azure.resourcemanager.synapse.models.IntegrationRuntimeNodeMonitoringData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class IntegrationRuntimeMonitoringDataInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IntegrationRuntimeMonitoringDataInner model = BinaryData.fromString(
            "{\"name\":\"hmgkbrpyy\",\"nodes\":[{\"nodeName\":\"nuqqkpikadrgvt\",\"availableMemoryInMB\":1163936229,\"cpuUtilization\":424672875,\"concurrentJobsLimit\":122504841,\"concurrentJobsRunning\":1620063095,\"maxConcurrentJobs\":1131716397,\"sentBytes\":92.13511,\"receivedBytes\":16.016691,\"\":{\"zzmhjrunmpxttd\":\"datasiarbutrcvpn\",\"nbtkcxywnytnr\":\"datahrbnlankxmyskpbh\",\"qidybyx\":\"datayn\"}},{\"nodeName\":\"fclhaaxdbabphlwr\",\"availableMemoryInMB\":818210611,\"cpuUtilization\":285105336,\"concurrentJobsLimit\":1003967781,\"concurrentJobsRunning\":1927626418,\"maxConcurrentJobs\":801364840,\"sentBytes\":56.913887,\"receivedBytes\":98.78118,\"\":{\"bt\":\"dataazt\",\"ckzywbiexzfeyue\":\"datawrqpue\",\"zyoxaepdkzjan\":\"dataxibxujwbhqwalm\",\"hdwbavxbniwdjs\":\"dataux\"}},{\"nodeName\":\"tsdbpgn\",\"availableMemoryInMB\":862771413,\"cpuUtilization\":686373242,\"concurrentJobsLimit\":999605731,\"concurrentJobsRunning\":1621747655,\"maxConcurrentJobs\":936315847,\"sentBytes\":65.9889,\"receivedBytes\":6.1180353,\"\":{\"wtctyqi\":\"datacuh\",\"bhvgy\":\"datalbbovplw\",\"svmkfssxquk\":\"datagu\",\"mg\":\"datafpl\"}}]}")
            .toObject(IntegrationRuntimeMonitoringDataInner.class);
        Assertions.assertEquals("hmgkbrpyy", model.name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IntegrationRuntimeMonitoringDataInner model = new IntegrationRuntimeMonitoringDataInner().withName("hmgkbrpyy")
            .withNodes(Arrays.asList(
                new IntegrationRuntimeNodeMonitoringData().withAdditionalProperties(
                    mapOf("nodeName", "nuqqkpikadrgvt", "cpuUtilization", 424672875, "receivedBytes", 16.016691f,
                        "concurrentJobsLimit", 122504841, "concurrentJobsRunning", 1620063095, "maxConcurrentJobs",
                        1131716397, "availableMemoryInMB", 1163936229, "sentBytes", 92.13511f)),
                new IntegrationRuntimeNodeMonitoringData().withAdditionalProperties(
                    mapOf("nodeName", "fclhaaxdbabphlwr", "cpuUtilization", 285105336, "receivedBytes", 98.78118f,
                        "concurrentJobsLimit", 1003967781, "concurrentJobsRunning", 1927626418, "maxConcurrentJobs",
                        801364840, "availableMemoryInMB", 818210611, "sentBytes", 56.913887f)),
                new IntegrationRuntimeNodeMonitoringData()
                    .withAdditionalProperties(mapOf("nodeName", "tsdbpgn", "cpuUtilization", 686373242, "receivedBytes",
                        6.1180353f, "concurrentJobsLimit", 999605731, "concurrentJobsRunning", 1621747655,
                        "maxConcurrentJobs", 936315847, "availableMemoryInMB", 862771413, "sentBytes", 65.9889f))));
        model = BinaryData.fromObject(model).toObject(IntegrationRuntimeMonitoringDataInner.class);
        Assertions.assertEquals("hmgkbrpyy", model.name());
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
