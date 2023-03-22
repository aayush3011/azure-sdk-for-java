// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.orbital.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.orbital.fluent.models.ContactProfileProperties;
import com.azure.resourcemanager.orbital.models.AutoTrackingConfiguration;
import com.azure.resourcemanager.orbital.models.ContactProfileLink;
import com.azure.resourcemanager.orbital.models.ContactProfileThirdPartyConfiguration;
import com.azure.resourcemanager.orbital.models.ContactProfilesPropertiesNetworkConfiguration;
import com.azure.resourcemanager.orbital.models.ContactProfilesPropertiesProvisioningState;
import com.azure.resourcemanager.orbital.models.Direction;
import com.azure.resourcemanager.orbital.models.Polarization;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ContactProfilePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ContactProfileProperties model =
            BinaryData
                .fromString(
                    "{\"provisioningState\":\"updating\",\"minimumViableContactDuration\":\"lcuiywgqywgndr\",\"minimumElevationDegrees\":74.8914,\"autoTrackingConfiguration\":\"sBand\",\"eventHubUri\":\"pphrcgynco\",\"networkConfiguration\":{\"subnetId\":\"pec\"},\"thirdPartyConfigurations\":[{\"providerName\":\"mcoo\",\"missionConfiguration\":\"sxlzevgbmqj\"}],\"links\":[{\"name\":\"bcypmi\",\"polarization\":\"linearHorizontal\",\"direction\":\"Uplink\",\"gainOverTemperature\":95.442825,\"eirpdBW\":26.09846,\"channels\":[]},{\"name\":\"c\",\"polarization\":\"LHCP\",\"direction\":\"Downlink\",\"gainOverTemperature\":31.47868,\"eirpdBW\":23.643381,\"channels\":[]},{\"name\":\"fionl\",\"polarization\":\"linearVertical\",\"direction\":\"Uplink\",\"gainOverTemperature\":76.34291,\"eirpdBW\":38.62387,\"channels\":[]}]}")
                .toObject(ContactProfileProperties.class);
        Assertions.assertEquals(ContactProfilesPropertiesProvisioningState.UPDATING, model.provisioningState());
        Assertions.assertEquals("lcuiywgqywgndr", model.minimumViableContactDuration());
        Assertions.assertEquals(74.8914F, model.minimumElevationDegrees());
        Assertions.assertEquals(AutoTrackingConfiguration.S_BAND, model.autoTrackingConfiguration());
        Assertions.assertEquals("pphrcgynco", model.eventHubUri());
        Assertions.assertEquals("pec", model.networkConfiguration().subnetId());
        Assertions.assertEquals("mcoo", model.thirdPartyConfigurations().get(0).providerName());
        Assertions.assertEquals("sxlzevgbmqj", model.thirdPartyConfigurations().get(0).missionConfiguration());
        Assertions.assertEquals("bcypmi", model.links().get(0).name());
        Assertions.assertEquals(Polarization.LINEAR_HORIZONTAL, model.links().get(0).polarization());
        Assertions.assertEquals(Direction.UPLINK, model.links().get(0).direction());
        Assertions.assertEquals(95.442825F, model.links().get(0).gainOverTemperature());
        Assertions.assertEquals(26.09846F, model.links().get(0).eirpdBW());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ContactProfileProperties model =
            new ContactProfileProperties()
                .withProvisioningState(ContactProfilesPropertiesProvisioningState.UPDATING)
                .withMinimumViableContactDuration("lcuiywgqywgndr")
                .withMinimumElevationDegrees(74.8914F)
                .withAutoTrackingConfiguration(AutoTrackingConfiguration.S_BAND)
                .withEventHubUri("pphrcgynco")
                .withNetworkConfiguration(new ContactProfilesPropertiesNetworkConfiguration().withSubnetId("pec"))
                .withThirdPartyConfigurations(
                    Arrays
                        .asList(
                            new ContactProfileThirdPartyConfiguration()
                                .withProviderName("mcoo")
                                .withMissionConfiguration("sxlzevgbmqj")))
                .withLinks(
                    Arrays
                        .asList(
                            new ContactProfileLink()
                                .withName("bcypmi")
                                .withPolarization(Polarization.LINEAR_HORIZONTAL)
                                .withDirection(Direction.UPLINK)
                                .withGainOverTemperature(95.442825F)
                                .withEirpdBW(26.09846F)
                                .withChannels(Arrays.asList()),
                            new ContactProfileLink()
                                .withName("c")
                                .withPolarization(Polarization.LHCP)
                                .withDirection(Direction.DOWNLINK)
                                .withGainOverTemperature(31.47868F)
                                .withEirpdBW(23.643381F)
                                .withChannels(Arrays.asList()),
                            new ContactProfileLink()
                                .withName("fionl")
                                .withPolarization(Polarization.LINEAR_VERTICAL)
                                .withDirection(Direction.UPLINK)
                                .withGainOverTemperature(76.34291F)
                                .withEirpdBW(38.62387F)
                                .withChannels(Arrays.asList())));
        model = BinaryData.fromObject(model).toObject(ContactProfileProperties.class);
        Assertions.assertEquals(ContactProfilesPropertiesProvisioningState.UPDATING, model.provisioningState());
        Assertions.assertEquals("lcuiywgqywgndr", model.minimumViableContactDuration());
        Assertions.assertEquals(74.8914F, model.minimumElevationDegrees());
        Assertions.assertEquals(AutoTrackingConfiguration.S_BAND, model.autoTrackingConfiguration());
        Assertions.assertEquals("pphrcgynco", model.eventHubUri());
        Assertions.assertEquals("pec", model.networkConfiguration().subnetId());
        Assertions.assertEquals("mcoo", model.thirdPartyConfigurations().get(0).providerName());
        Assertions.assertEquals("sxlzevgbmqj", model.thirdPartyConfigurations().get(0).missionConfiguration());
        Assertions.assertEquals("bcypmi", model.links().get(0).name());
        Assertions.assertEquals(Polarization.LINEAR_HORIZONTAL, model.links().get(0).polarization());
        Assertions.assertEquals(Direction.UPLINK, model.links().get(0).direction());
        Assertions.assertEquals(95.442825F, model.links().get(0).gainOverTemperature());
        Assertions.assertEquals(26.09846F, model.links().get(0).eirpdBW());
    }
}