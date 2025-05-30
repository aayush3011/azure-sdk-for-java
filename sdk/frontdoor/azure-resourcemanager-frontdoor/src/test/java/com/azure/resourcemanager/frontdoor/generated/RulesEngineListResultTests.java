// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.frontdoor.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.frontdoor.models.RulesEngineListResult;
import org.junit.jupiter.api.Assertions;

public final class RulesEngineListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RulesEngineListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"resourceState\":\"Migrated\",\"rules\":[{\"name\":\"orxvxcjzhqiz\",\"priority\":1212582847,\"action\":{},\"matchConditions\":[{\"rulesEngineMatchVariable\":\"RequestUri\",\"rulesEngineOperator\":\"LessThanOrEqual\",\"rulesEngineMatchValue\":[]},{\"rulesEngineMatchVariable\":\"RequestFilenameExtension\",\"rulesEngineOperator\":\"Any\",\"rulesEngineMatchValue\":[]},{\"rulesEngineMatchVariable\":\"IsMobile\",\"rulesEngineOperator\":\"Equal\",\"rulesEngineMatchValue\":[]},{\"rulesEngineMatchVariable\":\"RequestScheme\",\"rulesEngineOperator\":\"Equal\",\"rulesEngineMatchValue\":[]}],\"matchProcessingBehavior\":\"Continue\"}]},\"id\":\"juhdqazkmtgguwpi\",\"name\":\"r\",\"type\":\"jcivmmg\"}],\"nextLink\":\"cf\"}")
            .toObject(RulesEngineListResult.class);
        Assertions.assertEquals("cf", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RulesEngineListResult model = new RulesEngineListResult().withNextLink("cf");
        model = BinaryData.fromObject(model).toObject(RulesEngineListResult.class);
        Assertions.assertEquals("cf", model.nextLink());
    }
}
