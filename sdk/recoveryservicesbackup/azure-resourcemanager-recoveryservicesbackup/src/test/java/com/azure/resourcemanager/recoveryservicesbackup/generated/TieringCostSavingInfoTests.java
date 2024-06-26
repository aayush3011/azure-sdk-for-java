// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.TieringCostSavingInfo;
import org.junit.jupiter.api.Assertions;

public final class TieringCostSavingInfoTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TieringCostSavingInfo model = BinaryData.fromString(
            "{\"objectType\":\"TieringCostSavingInfo\",\"sourceTierSizeReductionInBytes\":3125841616685088977,\"targetTierSizeIncreaseInBytes\":5242135231276354943,\"retailSourceTierCostPerGBPerMonth\":2.487068606101328,\"retailTargetTierCostPerGBPerMonth\":82.07378625813297}")
            .toObject(TieringCostSavingInfo.class);
        Assertions.assertEquals(3125841616685088977L, model.sourceTierSizeReductionInBytes());
        Assertions.assertEquals(5242135231276354943L, model.targetTierSizeIncreaseInBytes());
        Assertions.assertEquals(2.487068606101328, model.retailSourceTierCostPerGBPerMonth());
        Assertions.assertEquals(82.07378625813297, model.retailTargetTierCostPerGBPerMonth());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TieringCostSavingInfo model
            = new TieringCostSavingInfo().withSourceTierSizeReductionInBytes(3125841616685088977L)
                .withTargetTierSizeIncreaseInBytes(5242135231276354943L)
                .withRetailSourceTierCostPerGBPerMonth(2.487068606101328)
                .withRetailTargetTierCostPerGBPerMonth(82.07378625813297);
        model = BinaryData.fromObject(model).toObject(TieringCostSavingInfo.class);
        Assertions.assertEquals(3125841616685088977L, model.sourceTierSizeReductionInBytes());
        Assertions.assertEquals(5242135231276354943L, model.targetTierSizeIncreaseInBytes());
        Assertions.assertEquals(2.487068606101328, model.retailSourceTierCostPerGBPerMonth());
        Assertions.assertEquals(82.07378625813297, model.retailTargetTierCostPerGBPerMonth());
    }
}
