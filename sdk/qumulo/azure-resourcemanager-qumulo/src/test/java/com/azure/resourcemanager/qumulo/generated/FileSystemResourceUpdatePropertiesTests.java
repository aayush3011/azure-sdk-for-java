// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.qumulo.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.qumulo.models.FileSystemResourceUpdateProperties;
import com.azure.resourcemanager.qumulo.models.MarketplaceDetails;
import com.azure.resourcemanager.qumulo.models.UserDetails;
import org.junit.jupiter.api.Assertions;

public final class FileSystemResourceUpdatePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FileSystemResourceUpdateProperties model = BinaryData.fromString(
            "{\"marketplaceDetails\":{\"marketplaceSubscriptionId\":\"gou\",\"planId\":\"zndlikwy\",\"offerId\":\"kgfg\",\"publisherId\":\"madgakeqsrxyb\",\"termUnit\":\"qedqytbciqfoufl\",\"marketplaceSubscriptionStatus\":\"Suspended\"},\"userDetails\":{\"email\":\"zsm\"},\"delegatedSubnetId\":\"mglougpbkw\"}")
            .toObject(FileSystemResourceUpdateProperties.class);
        Assertions.assertEquals("gou", model.marketplaceDetails().marketplaceSubscriptionId());
        Assertions.assertEquals("zndlikwy", model.marketplaceDetails().planId());
        Assertions.assertEquals("kgfg", model.marketplaceDetails().offerId());
        Assertions.assertEquals("madgakeqsrxyb", model.marketplaceDetails().publisherId());
        Assertions.assertEquals("qedqytbciqfoufl", model.marketplaceDetails().termUnit());
        Assertions.assertEquals("zsm", model.userDetails().email());
        Assertions.assertEquals("mglougpbkw", model.delegatedSubnetId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FileSystemResourceUpdateProperties model = new FileSystemResourceUpdateProperties()
            .withMarketplaceDetails(new MarketplaceDetails().withMarketplaceSubscriptionId("gou")
                .withPlanId("zndlikwy")
                .withOfferId("kgfg")
                .withPublisherId("madgakeqsrxyb")
                .withTermUnit("qedqytbciqfoufl"))
            .withUserDetails(new UserDetails().withEmail("zsm"))
            .withDelegatedSubnetId("mglougpbkw");
        model = BinaryData.fromObject(model).toObject(FileSystemResourceUpdateProperties.class);
        Assertions.assertEquals("gou", model.marketplaceDetails().marketplaceSubscriptionId());
        Assertions.assertEquals("zndlikwy", model.marketplaceDetails().planId());
        Assertions.assertEquals("kgfg", model.marketplaceDetails().offerId());
        Assertions.assertEquals("madgakeqsrxyb", model.marketplaceDetails().publisherId());
        Assertions.assertEquals("qedqytbciqfoufl", model.marketplaceDetails().termUnit());
        Assertions.assertEquals("zsm", model.userDetails().email());
        Assertions.assertEquals("mglougpbkw", model.delegatedSubnetId());
    }
}
