// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.fluent.models.UpdateWorkspaceQuotasResultInner;

public final class UpdateWorkspaceQuotasResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UpdateWorkspaceQuotasResultInner model = BinaryData.fromString(
            "{\"value\":[{\"id\":\"dybyxczfclhaa\",\"type\":\"babphlwrqlfk\",\"limit\":4312008787205173543,\"unit\":\"Count\",\"status\":\"OperationNotEnabledForRegion\"},{\"id\":\"mnyyazt\",\"type\":\"twwrqp\",\"limit\":2759149426383242118,\"unit\":\"Count\",\"status\":\"InvalidQuotaExceedsSubscriptionLimit\"}],\"nextLink\":\"iexzfeyue\"}")
            .toObject(UpdateWorkspaceQuotasResultInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UpdateWorkspaceQuotasResultInner model = new UpdateWorkspaceQuotasResultInner();
        model = BinaryData.fromObject(model).toObject(UpdateWorkspaceQuotasResultInner.class);
    }
}
