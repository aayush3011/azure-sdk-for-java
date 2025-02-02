// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.models.DnnIpPair;
import com.azure.resourcemanager.mobilenetwork.models.RatType;
import com.azure.resourcemanager.mobilenetwork.models.UeInfoPropertiesFormat;
import com.azure.resourcemanager.mobilenetwork.models.UeIpAddress;
import com.azure.resourcemanager.mobilenetwork.models.UeState;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class UeInfoPropertiesFormatTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UeInfoPropertiesFormat model = BinaryData.fromString(
            "{\"ratType\":\"4G\",\"ueState\":\"Deregistered\",\"ueIpAddresses\":[{\"dnn\":\"daultxijjumfq\",\"ueIpAddress\":{\"ipV4Addr\":\"lnqnmcjn\"}},{\"dnn\":\"qdqx\",\"ueIpAddress\":{\"ipV4Addr\":\"wgnyfusfzsvtui\"}},{\"dnn\":\"hajqglcfh\",\"ueIpAddress\":{\"ipV4Addr\":\"qryxyn\"}},{\"dnn\":\"zrdpsovwxznptgoe\",\"ueIpAddress\":{\"ipV4Addr\":\"b\"}}],\"lastReadAt\":\"2021-02-22T05:27:57Z\"}")
            .toObject(UeInfoPropertiesFormat.class);
        Assertions.assertEquals(RatType.FOURG, model.ratType());
        Assertions.assertEquals(UeState.DEREGISTERED, model.ueState());
        Assertions.assertEquals("daultxijjumfq", model.ueIpAddresses().get(0).dnn());
        Assertions.assertEquals("lnqnmcjn", model.ueIpAddresses().get(0).ueIpAddress().ipV4Addr());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-22T05:27:57Z"), model.lastReadAt());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UeInfoPropertiesFormat model = new UeInfoPropertiesFormat().withRatType(RatType.FOURG)
            .withUeState(UeState.DEREGISTERED)
            .withUeIpAddresses(Arrays.asList(
                new DnnIpPair().withDnn("daultxijjumfq").withUeIpAddress(new UeIpAddress().withIpV4Addr("lnqnmcjn")),
                new DnnIpPair().withDnn("qdqx").withUeIpAddress(new UeIpAddress().withIpV4Addr("wgnyfusfzsvtui")),
                new DnnIpPair().withDnn("hajqglcfh").withUeIpAddress(new UeIpAddress().withIpV4Addr("qryxyn")),
                new DnnIpPair().withDnn("zrdpsovwxznptgoe").withUeIpAddress(new UeIpAddress().withIpV4Addr("b"))))
            .withLastReadAt(OffsetDateTime.parse("2021-02-22T05:27:57Z"));
        model = BinaryData.fromObject(model).toObject(UeInfoPropertiesFormat.class);
        Assertions.assertEquals(RatType.FOURG, model.ratType());
        Assertions.assertEquals(UeState.DEREGISTERED, model.ueState());
        Assertions.assertEquals("daultxijjumfq", model.ueIpAddresses().get(0).dnn());
        Assertions.assertEquals("lnqnmcjn", model.ueIpAddresses().get(0).ueIpAddress().ipV4Addr());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-22T05:27:57Z"), model.lastReadAt());
    }
}
