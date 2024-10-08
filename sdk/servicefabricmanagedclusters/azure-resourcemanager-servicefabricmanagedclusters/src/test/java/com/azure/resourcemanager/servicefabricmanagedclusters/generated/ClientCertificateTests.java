// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ClientCertificate;
import org.junit.jupiter.api.Assertions;

public final class ClientCertificateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ClientCertificate model = BinaryData.fromString(
            "{\"isAdmin\":false,\"thumbprint\":\"bcvkcvqvpkeq\",\"commonName\":\"vdrhvoo\",\"issuerThumbprint\":\"otbobzdopcj\"}")
            .toObject(ClientCertificate.class);
        Assertions.assertEquals(false, model.isAdmin());
        Assertions.assertEquals("bcvkcvqvpkeq", model.thumbprint());
        Assertions.assertEquals("vdrhvoo", model.commonName());
        Assertions.assertEquals("otbobzdopcj", model.issuerThumbprint());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ClientCertificate model = new ClientCertificate().withIsAdmin(false)
            .withThumbprint("bcvkcvqvpkeq")
            .withCommonName("vdrhvoo")
            .withIssuerThumbprint("otbobzdopcj");
        model = BinaryData.fromObject(model).toObject(ClientCertificate.class);
        Assertions.assertEquals(false, model.isAdmin());
        Assertions.assertEquals("bcvkcvqvpkeq", model.thumbprint());
        Assertions.assertEquals("vdrhvoo", model.commonName());
        Assertions.assertEquals("otbobzdopcj", model.issuerThumbprint());
    }
}
