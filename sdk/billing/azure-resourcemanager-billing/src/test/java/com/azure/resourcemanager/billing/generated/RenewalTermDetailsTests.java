// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.billing.models.RenewalTermDetails;
import org.junit.jupiter.api.Assertions;

public final class RenewalTermDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RenewalTermDetails model = BinaryData.fromString(
            "{\"billingFrequency\":\"chndbnwie\",\"productId\":\"lewjwiuubwef\",\"productTypeId\":\"fapaqtfer\",\"skuId\":\"wexjkmfxapjwogq\",\"termDuration\":\"o\",\"quantity\":6974301688992111876,\"termEndDate\":\"2021-02-14T03:20:28Z\"}")
            .toObject(RenewalTermDetails.class);
        Assertions.assertEquals(6974301688992111876L, model.quantity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RenewalTermDetails model = new RenewalTermDetails().withQuantity(6974301688992111876L);
        model = BinaryData.fromObject(model).toObject(RenewalTermDetails.class);
        Assertions.assertEquals(6974301688992111876L, model.quantity());
    }
}
