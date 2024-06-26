// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.models.PlacementPoliciesList;

public final class PlacementPoliciesListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PlacementPoliciesList model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"type\":\"PlacementPolicyProperties\",\"state\":\"Disabled\",\"displayName\":\"umwctondz\",\"provisioningState\":\"Canceled\"},\"id\":\"udfdlwgg\",\"name\":\"tsbwtovvtgse\",\"type\":\"nqfiufxqknpi\"},{\"properties\":{\"type\":\"PlacementPolicyProperties\",\"state\":\"Disabled\",\"displayName\":\"ttwqmsni\",\"provisioningState\":\"Deleting\"},\"id\":\"dmqnrojlpij\",\"name\":\"k\",\"type\":\"xfrdd\"}],\"nextLink\":\"ratiz\"}")
                .toObject(PlacementPoliciesList.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PlacementPoliciesList model = new PlacementPoliciesList();
        model = BinaryData.fromObject(model).toObject(PlacementPoliciesList.class);
    }
}
