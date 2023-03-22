// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.ChownMode;
import com.azure.resourcemanager.netapp.models.ExportPolicyRule;
import com.azure.resourcemanager.netapp.models.VolumePatchPropertiesExportPolicy;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VolumePatchPropertiesExportPolicyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VolumePatchPropertiesExportPolicy model =
            BinaryData
                .fromString(
                    "{\"rules\":[{\"ruleIndex\":1309356083,\"unixReadOnly\":false,\"unixReadWrite\":true,\"kerberos5ReadOnly\":false,\"kerberos5ReadWrite\":false,\"kerberos5iReadOnly\":true,\"kerberos5iReadWrite\":false,\"kerberos5pReadOnly\":true,\"kerberos5pReadWrite\":false,\"cifs\":false,\"nfsv3\":true,\"nfsv41\":true,\"allowedClients\":\"tyfjfcnjbkcnxdhb\",\"hasRootAccess\":true,\"chownMode\":\"Restricted\"},{\"ruleIndex\":789098072,\"unixReadOnly\":false,\"unixReadWrite\":false,\"kerberos5ReadOnly\":true,\"kerberos5ReadWrite\":false,\"kerberos5iReadOnly\":true,\"kerberos5iReadWrite\":false,\"kerberos5pReadOnly\":false,\"kerberos5pReadWrite\":false,\"cifs\":false,\"nfsv3\":false,\"nfsv41\":true,\"allowedClients\":\"rpabg\",\"hasRootAccess\":false,\"chownMode\":\"Unrestricted\"},{\"ruleIndex\":1974668378,\"unixReadOnly\":false,\"unixReadWrite\":true,\"kerberos5ReadOnly\":true,\"kerberos5ReadWrite\":false,\"kerberos5iReadOnly\":false,\"kerberos5iReadWrite\":false,\"kerberos5pReadOnly\":false,\"kerberos5pReadWrite\":true,\"cifs\":false,\"nfsv3\":true,\"nfsv41\":true,\"allowedClients\":\"ids\",\"hasRootAccess\":true,\"chownMode\":\"Unrestricted\"},{\"ruleIndex\":1361175767,\"unixReadOnly\":true,\"unixReadWrite\":false,\"kerberos5ReadOnly\":false,\"kerberos5ReadWrite\":false,\"kerberos5iReadOnly\":true,\"kerberos5iReadWrite\":true,\"kerberos5pReadOnly\":false,\"kerberos5pReadWrite\":true,\"cifs\":false,\"nfsv3\":true,\"nfsv41\":false,\"allowedClients\":\"vwfudwpzntxhd\",\"hasRootAccess\":true,\"chownMode\":\"Restricted\"}]}")
                .toObject(VolumePatchPropertiesExportPolicy.class);
        Assertions.assertEquals(1309356083, model.rules().get(0).ruleIndex());
        Assertions.assertEquals(false, model.rules().get(0).unixReadOnly());
        Assertions.assertEquals(true, model.rules().get(0).unixReadWrite());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5ReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5ReadWrite());
        Assertions.assertEquals(true, model.rules().get(0).kerberos5IReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5IReadWrite());
        Assertions.assertEquals(true, model.rules().get(0).kerberos5PReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5PReadWrite());
        Assertions.assertEquals(false, model.rules().get(0).cifs());
        Assertions.assertEquals(true, model.rules().get(0).nfsv3());
        Assertions.assertEquals(true, model.rules().get(0).nfsv41());
        Assertions.assertEquals("tyfjfcnjbkcnxdhb", model.rules().get(0).allowedClients());
        Assertions.assertEquals(true, model.rules().get(0).hasRootAccess());
        Assertions.assertEquals(ChownMode.RESTRICTED, model.rules().get(0).chownMode());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VolumePatchPropertiesExportPolicy model =
            new VolumePatchPropertiesExportPolicy()
                .withRules(
                    Arrays
                        .asList(
                            new ExportPolicyRule()
                                .withRuleIndex(1309356083)
                                .withUnixReadOnly(false)
                                .withUnixReadWrite(true)
                                .withKerberos5ReadOnly(false)
                                .withKerberos5ReadWrite(false)
                                .withKerberos5IReadOnly(true)
                                .withKerberos5IReadWrite(false)
                                .withKerberos5PReadOnly(true)
                                .withKerberos5PReadWrite(false)
                                .withCifs(false)
                                .withNfsv3(true)
                                .withNfsv41(true)
                                .withAllowedClients("tyfjfcnjbkcnxdhb")
                                .withHasRootAccess(true)
                                .withChownMode(ChownMode.RESTRICTED),
                            new ExportPolicyRule()
                                .withRuleIndex(789098072)
                                .withUnixReadOnly(false)
                                .withUnixReadWrite(false)
                                .withKerberos5ReadOnly(true)
                                .withKerberos5ReadWrite(false)
                                .withKerberos5IReadOnly(true)
                                .withKerberos5IReadWrite(false)
                                .withKerberos5PReadOnly(false)
                                .withKerberos5PReadWrite(false)
                                .withCifs(false)
                                .withNfsv3(false)
                                .withNfsv41(true)
                                .withAllowedClients("rpabg")
                                .withHasRootAccess(false)
                                .withChownMode(ChownMode.UNRESTRICTED),
                            new ExportPolicyRule()
                                .withRuleIndex(1974668378)
                                .withUnixReadOnly(false)
                                .withUnixReadWrite(true)
                                .withKerberos5ReadOnly(true)
                                .withKerberos5ReadWrite(false)
                                .withKerberos5IReadOnly(false)
                                .withKerberos5IReadWrite(false)
                                .withKerberos5PReadOnly(false)
                                .withKerberos5PReadWrite(true)
                                .withCifs(false)
                                .withNfsv3(true)
                                .withNfsv41(true)
                                .withAllowedClients("ids")
                                .withHasRootAccess(true)
                                .withChownMode(ChownMode.UNRESTRICTED),
                            new ExportPolicyRule()
                                .withRuleIndex(1361175767)
                                .withUnixReadOnly(true)
                                .withUnixReadWrite(false)
                                .withKerberos5ReadOnly(false)
                                .withKerberos5ReadWrite(false)
                                .withKerberos5IReadOnly(true)
                                .withKerberos5IReadWrite(true)
                                .withKerberos5PReadOnly(false)
                                .withKerberos5PReadWrite(true)
                                .withCifs(false)
                                .withNfsv3(true)
                                .withNfsv41(false)
                                .withAllowedClients("vwfudwpzntxhd")
                                .withHasRootAccess(true)
                                .withChownMode(ChownMode.RESTRICTED)));
        model = BinaryData.fromObject(model).toObject(VolumePatchPropertiesExportPolicy.class);
        Assertions.assertEquals(1309356083, model.rules().get(0).ruleIndex());
        Assertions.assertEquals(false, model.rules().get(0).unixReadOnly());
        Assertions.assertEquals(true, model.rules().get(0).unixReadWrite());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5ReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5ReadWrite());
        Assertions.assertEquals(true, model.rules().get(0).kerberos5IReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5IReadWrite());
        Assertions.assertEquals(true, model.rules().get(0).kerberos5PReadOnly());
        Assertions.assertEquals(false, model.rules().get(0).kerberos5PReadWrite());
        Assertions.assertEquals(false, model.rules().get(0).cifs());
        Assertions.assertEquals(true, model.rules().get(0).nfsv3());
        Assertions.assertEquals(true, model.rules().get(0).nfsv41());
        Assertions.assertEquals("tyfjfcnjbkcnxdhb", model.rules().get(0).allowedClients());
        Assertions.assertEquals(true, model.rules().get(0).hasRootAccess());
        Assertions.assertEquals(ChownMode.RESTRICTED, model.rules().get(0).chownMode());
    }
}