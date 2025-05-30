// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineCommandSpecification;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineRunDataExtractsParameters;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class BareMetalMachineRunDataExtractsParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BareMetalMachineRunDataExtractsParameters model = BinaryData.fromString(
            "{\"commands\":[{\"arguments\":[\"oxgjiuqhibt\"],\"command\":\"z\"}],\"limitTimeSeconds\":7164344086895072546}")
            .toObject(BareMetalMachineRunDataExtractsParameters.class);
        Assertions.assertEquals("oxgjiuqhibt", model.commands().get(0).arguments().get(0));
        Assertions.assertEquals("z", model.commands().get(0).command());
        Assertions.assertEquals(7164344086895072546L, model.limitTimeSeconds());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BareMetalMachineRunDataExtractsParameters model = new BareMetalMachineRunDataExtractsParameters().withCommands(
            Arrays.asList(new BareMetalMachineCommandSpecification().withArguments(Arrays.asList("oxgjiuqhibt"))
                .withCommand("z")))
            .withLimitTimeSeconds(7164344086895072546L);
        model = BinaryData.fromObject(model).toObject(BareMetalMachineRunDataExtractsParameters.class);
        Assertions.assertEquals("oxgjiuqhibt", model.commands().get(0).arguments().get(0));
        Assertions.assertEquals("z", model.commands().get(0).command());
        Assertions.assertEquals(7164344086895072546L, model.limitTimeSeconds());
    }
}
