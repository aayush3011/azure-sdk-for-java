// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.BackupManagementType;
import com.azure.resourcemanager.recoveryservicesbackup.models.ContainerIdentityInfo;
import com.azure.resourcemanager.recoveryservicesbackup.models.GenericContainer;
import com.azure.resourcemanager.recoveryservicesbackup.models.GenericContainerExtendedInfo;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class GenericContainerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GenericContainer model =
            BinaryData
                .fromString(
                    "{\"containerType\":\"GenericContainer\",\"fabricName\":\"yetesy\",\"extendedInformation\":{\"rawCertData\":\"dbztjhqtfbov\",\"containerIdentityInfo\":{\"uniqueName\":\"kbwetnj\",\"aadTenantId\":\"p\",\"servicePrincipalClientId\":\"rkzyaupia\",\"audience\":\"xnafbw\"},\"serviceEndpoints\":{\"tu\":\"ohtuovmaonur\",\"clbl\":\"ghihpvecms\",\"bsjuscvsfx\":\"jxl\",\"cydrtceukdqkk\":\"gctmgxuupbezq\"}},\"friendlyName\":\"hztgeqmgqzgwld\",\"backupManagementType\":\"AzureIaasVM\",\"registrationStatus\":\"illcecfehu\",\"healthStatus\":\"oaguhic\",\"protectableObjectType\":\"lizst\"}")
                .toObject(GenericContainer.class);
        Assertions.assertEquals("hztgeqmgqzgwld", model.friendlyName());
        Assertions.assertEquals(BackupManagementType.AZURE_IAAS_VM, model.backupManagementType());
        Assertions.assertEquals("illcecfehu", model.registrationStatus());
        Assertions.assertEquals("oaguhic", model.healthStatus());
        Assertions.assertEquals("lizst", model.protectableObjectType());
        Assertions.assertEquals("yetesy", model.fabricName());
        Assertions.assertEquals("dbztjhqtfbov", model.extendedInformation().rawCertData());
        Assertions.assertEquals("kbwetnj", model.extendedInformation().containerIdentityInfo().uniqueName());
        Assertions.assertEquals("p", model.extendedInformation().containerIdentityInfo().aadTenantId());
        Assertions
            .assertEquals("rkzyaupia", model.extendedInformation().containerIdentityInfo().servicePrincipalClientId());
        Assertions.assertEquals("xnafbw", model.extendedInformation().containerIdentityInfo().audience());
        Assertions.assertEquals("ohtuovmaonur", model.extendedInformation().serviceEndpoints().get("tu"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GenericContainer model =
            new GenericContainer()
                .withFriendlyName("hztgeqmgqzgwld")
                .withBackupManagementType(BackupManagementType.AZURE_IAAS_VM)
                .withRegistrationStatus("illcecfehu")
                .withHealthStatus("oaguhic")
                .withProtectableObjectType("lizst")
                .withFabricName("yetesy")
                .withExtendedInformation(
                    new GenericContainerExtendedInfo()
                        .withRawCertData("dbztjhqtfbov")
                        .withContainerIdentityInfo(
                            new ContainerIdentityInfo()
                                .withUniqueName("kbwetnj")
                                .withAadTenantId("p")
                                .withServicePrincipalClientId("rkzyaupia")
                                .withAudience("xnafbw"))
                        .withServiceEndpoints(
                            mapOf(
                                "tu",
                                "ohtuovmaonur",
                                "clbl",
                                "ghihpvecms",
                                "bsjuscvsfx",
                                "jxl",
                                "cydrtceukdqkk",
                                "gctmgxuupbezq")));
        model = BinaryData.fromObject(model).toObject(GenericContainer.class);
        Assertions.assertEquals("hztgeqmgqzgwld", model.friendlyName());
        Assertions.assertEquals(BackupManagementType.AZURE_IAAS_VM, model.backupManagementType());
        Assertions.assertEquals("illcecfehu", model.registrationStatus());
        Assertions.assertEquals("oaguhic", model.healthStatus());
        Assertions.assertEquals("lizst", model.protectableObjectType());
        Assertions.assertEquals("yetesy", model.fabricName());
        Assertions.assertEquals("dbztjhqtfbov", model.extendedInformation().rawCertData());
        Assertions.assertEquals("kbwetnj", model.extendedInformation().containerIdentityInfo().uniqueName());
        Assertions.assertEquals("p", model.extendedInformation().containerIdentityInfo().aadTenantId());
        Assertions
            .assertEquals("rkzyaupia", model.extendedInformation().containerIdentityInfo().servicePrincipalClientId());
        Assertions.assertEquals("xnafbw", model.extendedInformation().containerIdentityInfo().audience());
        Assertions.assertEquals("ohtuovmaonur", model.extendedInformation().serviceEndpoints().get("tu"));
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}