// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.generated;

/**
 * Samples for Configurations List.
 */
public final class ConfigurationsListSamples {
    /*
     * x-ms-original-file:
     * specification/hdinsight/resource-manager/Microsoft.HDInsight/preview/2024-08-01-preview/examples/
     * HDI_Configurations_List.json
     */
    /**
     * Sample code: Get all configuration information.
     * 
     * @param manager Entry point to HDInsightManager.
     */
    public static void getAllConfigurationInformation(com.azure.resourcemanager.hdinsight.HDInsightManager manager) {
        manager.configurations().listWithResponse("rg1", "cluster1", com.azure.core.util.Context.NONE);
    }
}
