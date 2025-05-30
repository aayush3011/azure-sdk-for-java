// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.HyperVReplicaAzurePolicyDetails;
import org.junit.jupiter.api.Assertions;

public final class HyperVReplicaAzurePolicyDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HyperVReplicaAzurePolicyDetails model = BinaryData.fromString(
            "{\"instanceType\":\"HyperVReplicaAzure\",\"recoveryPointHistoryDurationInHours\":811287506,\"applicationConsistentSnapshotFrequencyInHours\":1031258499,\"replicationInterval\":1327385429,\"onlineReplicationStartTime\":\"byejuwyqwdqigm\",\"encryption\":\"ginz\",\"activeStorageAccountId\":\"lujkhn\"}")
            .toObject(HyperVReplicaAzurePolicyDetails.class);
        Assertions.assertEquals(811287506, model.recoveryPointHistoryDurationInHours());
        Assertions.assertEquals(1031258499, model.applicationConsistentSnapshotFrequencyInHours());
        Assertions.assertEquals(1327385429, model.replicationInterval());
        Assertions.assertEquals("byejuwyqwdqigm", model.onlineReplicationStartTime());
        Assertions.assertEquals("ginz", model.encryption());
        Assertions.assertEquals("lujkhn", model.activeStorageAccountId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HyperVReplicaAzurePolicyDetails model
            = new HyperVReplicaAzurePolicyDetails().withRecoveryPointHistoryDurationInHours(811287506)
                .withApplicationConsistentSnapshotFrequencyInHours(1031258499)
                .withReplicationInterval(1327385429)
                .withOnlineReplicationStartTime("byejuwyqwdqigm")
                .withEncryption("ginz")
                .withActiveStorageAccountId("lujkhn");
        model = BinaryData.fromObject(model).toObject(HyperVReplicaAzurePolicyDetails.class);
        Assertions.assertEquals(811287506, model.recoveryPointHistoryDurationInHours());
        Assertions.assertEquals(1031258499, model.applicationConsistentSnapshotFrequencyInHours());
        Assertions.assertEquals(1327385429, model.replicationInterval());
        Assertions.assertEquals("byejuwyqwdqigm", model.onlineReplicationStartTime());
        Assertions.assertEquals("ginz", model.encryption());
        Assertions.assertEquals("lujkhn", model.activeStorageAccountId());
    }
}
