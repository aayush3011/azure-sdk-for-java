// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.batch.models.AccessRulePropertiesSubscriptionsItem;
import org.junit.jupiter.api.Assertions;

public final class AccessRulePropertiesSubscriptionsItemTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AccessRulePropertiesSubscriptionsItem model = BinaryData.fromString("{\"id\":\"qddrihpfhoqcaae\"}")
            .toObject(AccessRulePropertiesSubscriptionsItem.class);
        Assertions.assertEquals("qddrihpfhoqcaae", model.id());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AccessRulePropertiesSubscriptionsItem model
            = new AccessRulePropertiesSubscriptionsItem().withId("qddrihpfhoqcaae");
        model = BinaryData.fromObject(model).toObject(AccessRulePropertiesSubscriptionsItem.class);
        Assertions.assertEquals("qddrihpfhoqcaae", model.id());
    }
}
