// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.fluent.models.PortalSignupSettingsProperties;
import com.azure.resourcemanager.apimanagement.models.TermsOfServiceProperties;
import org.junit.jupiter.api.Assertions;

public final class PortalSignupSettingsPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PortalSignupSettingsProperties model = BinaryData.fromString(
            "{\"enabled\":true,\"termsOfService\":{\"text\":\"jvcfoczh\",\"enabled\":false,\"consentRequired\":false}}")
            .toObject(PortalSignupSettingsProperties.class);
        Assertions.assertTrue(model.enabled());
        Assertions.assertEquals("jvcfoczh", model.termsOfService().text());
        Assertions.assertFalse(model.termsOfService().enabled());
        Assertions.assertFalse(model.termsOfService().consentRequired());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PortalSignupSettingsProperties model = new PortalSignupSettingsProperties().withEnabled(true)
            .withTermsOfService(
                new TermsOfServiceProperties().withText("jvcfoczh").withEnabled(false).withConsentRequired(false));
        model = BinaryData.fromObject(model).toObject(PortalSignupSettingsProperties.class);
        Assertions.assertTrue(model.enabled());
        Assertions.assertEquals("jvcfoczh", model.termsOfService().text());
        Assertions.assertFalse(model.termsOfService().enabled());
        Assertions.assertFalse(model.termsOfService().consentRequired());
    }
}
