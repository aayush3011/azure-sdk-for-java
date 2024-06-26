// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.models.IdentityAndTagsObject;
import com.azure.resourcemanager.mobilenetwork.models.ManagedServiceIdentity;
import com.azure.resourcemanager.mobilenetwork.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.mobilenetwork.models.UserAssignedIdentity;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class IdentityAndTagsObjectTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IdentityAndTagsObject model = BinaryData.fromString(
            "{\"identity\":{\"type\":\"None\",\"userAssignedIdentities\":{\"ej\":{\"principalId\":\"93ba844f-51a2-4cf1-a1a0-adff1fc878ed\",\"clientId\":\"07b594cc-6127-454b-9e97-3a39b96d70da\"},\"orxzdmohctbqvud\":{\"principalId\":\"da7330a6-1c41-4510-b455-035718204891\",\"clientId\":\"8eb90e3a-4ff4-48c5-bd22-5c5ff3ecfe66\"},\"ndnvo\":{\"principalId\":\"f12a39a2-ab2d-433f-90f9-1164fb80612a\",\"clientId\":\"9bfb80f5-1b67-4891-91b8-adef5e306f20\"}}},\"tags\":{\"dyggdtjixhbku\":\"jjugwdkcglhslaz\",\"fyexfwhy\":\"fqweykhmene\",\"amdecte\":\"cibvyvdcsitynn\"}}")
            .toObject(IdentityAndTagsObject.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.identity().type());
        Assertions.assertEquals("jjugwdkcglhslaz", model.tags().get("dyggdtjixhbku"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IdentityAndTagsObject model = new IdentityAndTagsObject()
            .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.NONE)
                .withUserAssignedIdentities(mapOf("ej", new UserAssignedIdentity(), "orxzdmohctbqvud",
                    new UserAssignedIdentity(), "ndnvo", new UserAssignedIdentity())))
            .withTags(
                mapOf("dyggdtjixhbku", "jjugwdkcglhslaz", "fyexfwhy", "fqweykhmene", "amdecte", "cibvyvdcsitynn"));
        model = BinaryData.fromObject(model).toObject(IdentityAndTagsObject.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.identity().type());
        Assertions.assertEquals("jjugwdkcglhslaz", model.tags().get("dyggdtjixhbku"));
    }

    // Use "Map.of" if available
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
