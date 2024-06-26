// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elastic.models.UserEmailId;
import org.junit.jupiter.api.Assertions;

public final class UserEmailIdTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UserEmailId model = BinaryData.fromString("{\"emailId\":\"rxnjeaseipheofl\"}").toObject(UserEmailId.class);
        Assertions.assertEquals("rxnjeaseipheofl", model.emailId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UserEmailId model = new UserEmailId().withEmailId("rxnjeaseipheofl");
        model = BinaryData.fromObject(model).toObject(UserEmailId.class);
        Assertions.assertEquals("rxnjeaseipheofl", model.emailId());
    }
}
