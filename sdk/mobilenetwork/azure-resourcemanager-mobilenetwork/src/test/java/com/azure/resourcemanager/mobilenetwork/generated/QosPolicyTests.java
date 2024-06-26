// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.models.Ambr;
import com.azure.resourcemanager.mobilenetwork.models.PreemptionCapability;
import com.azure.resourcemanager.mobilenetwork.models.PreemptionVulnerability;
import com.azure.resourcemanager.mobilenetwork.models.QosPolicy;
import org.junit.jupiter.api.Assertions;

public final class QosPolicyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        QosPolicy model = BinaryData.fromString(
            "{\"5qi\":192957128,\"allocationAndRetentionPriorityLevel\":2075344266,\"preemptionCapability\":\"MayPreempt\",\"preemptionVulnerability\":\"NotPreemptable\",\"maximumBitRate\":{\"uplink\":\"xmueed\",\"downlink\":\"drd\"}}")
            .toObject(QosPolicy.class);
        Assertions.assertEquals(192957128, model.fiveQi());
        Assertions.assertEquals(2075344266, model.allocationAndRetentionPriorityLevel());
        Assertions.assertEquals(PreemptionCapability.MAY_PREEMPT, model.preemptionCapability());
        Assertions.assertEquals(PreemptionVulnerability.NOT_PREEMPTABLE, model.preemptionVulnerability());
        Assertions.assertEquals("xmueed", model.maximumBitRate().uplink());
        Assertions.assertEquals("drd", model.maximumBitRate().downlink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        QosPolicy model = new QosPolicy().withFiveQi(192957128).withAllocationAndRetentionPriorityLevel(2075344266)
            .withPreemptionCapability(PreemptionCapability.MAY_PREEMPT)
            .withPreemptionVulnerability(PreemptionVulnerability.NOT_PREEMPTABLE)
            .withMaximumBitRate(new Ambr().withUplink("xmueed").withDownlink("drd"));
        model = BinaryData.fromObject(model).toObject(QosPolicy.class);
        Assertions.assertEquals(192957128, model.fiveQi());
        Assertions.assertEquals(2075344266, model.allocationAndRetentionPriorityLevel());
        Assertions.assertEquals(PreemptionCapability.MAY_PREEMPT, model.preemptionCapability());
        Assertions.assertEquals(PreemptionVulnerability.NOT_PREEMPTABLE, model.preemptionVulnerability());
        Assertions.assertEquals("xmueed", model.maximumBitRate().uplink());
        Assertions.assertEquals("drd", model.maximumBitRate().downlink());
    }
}
