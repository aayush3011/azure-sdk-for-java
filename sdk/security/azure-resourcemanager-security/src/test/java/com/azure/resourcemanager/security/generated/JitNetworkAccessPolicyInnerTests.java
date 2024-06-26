// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.JitNetworkAccessPolicyInner;
import com.azure.resourcemanager.security.fluent.models.JitNetworkAccessRequestInner;
import com.azure.resourcemanager.security.models.JitNetworkAccessPolicyVirtualMachine;
import com.azure.resourcemanager.security.models.JitNetworkAccessPortRule;
import com.azure.resourcemanager.security.models.JitNetworkAccessRequestPort;
import com.azure.resourcemanager.security.models.JitNetworkAccessRequestVirtualMachine;
import com.azure.resourcemanager.security.models.Protocol;
import com.azure.resourcemanager.security.models.Status;
import com.azure.resourcemanager.security.models.StatusReason;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class JitNetworkAccessPolicyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        JitNetworkAccessPolicyInner model = BinaryData.fromString(
            "{\"properties\":{\"virtualMachines\":[{\"id\":\"qady\",\"ports\":[{\"number\":1191953854,\"protocol\":\"TCP\",\"allowedSourceAddressPrefix\":\"wriuomzczfkic\",\"allowedSourceAddressPrefixes\":[\"saaxwspca\",\"ikhfjqebglcxk\"],\"maxRequestAccessDuration\":\"gzzromv\"},{\"number\":120556433,\"protocol\":\"*\",\"allowedSourceAddressPrefix\":\"emtm\",\"allowedSourceAddressPrefixes\":[\"fsvpink\"],\"maxRequestAccessDuration\":\"pat\"},{\"number\":1765927549,\"protocol\":\"UDP\",\"allowedSourceAddressPrefix\":\"swxspvckojaz\",\"allowedSourceAddressPrefixes\":[\"spftesubzpv\",\"vdylytcovqseusrf\"],\"maxRequestAccessDuration\":\"bdxzfxnxmlbmu\"}],\"publicIpAddress\":\"wkjmdihd\"}],\"requests\":[{\"virtualMachines\":[{\"id\":\"zlwhbwzjnufzrfgm\",\"ports\":[{\"number\":2027483725,\"endTimeUtc\":\"2021-10-25T13:27:22Z\",\"status\":\"Revoked\",\"statusReason\":\"NewerRequestInitiated\"},{\"number\":1127579002,\"endTimeUtc\":\"2021-02-24T03:04:59Z\",\"status\":\"Revoked\",\"statusReason\":\"NewerRequestInitiated\"}]},{\"id\":\"tedzu\",\"ports\":[{\"number\":1680853411,\"endTimeUtc\":\"2021-08-16T22:24:01Z\",\"status\":\"Revoked\",\"statusReason\":\"NewerRequestInitiated\"},{\"number\":1437195748,\"endTimeUtc\":\"2021-09-07T06:41:27Z\",\"status\":\"Revoked\",\"statusReason\":\"UserRequested\"},{\"number\":1496766181,\"endTimeUtc\":\"2020-12-25T16:12:51Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":1095681099,\"endTimeUtc\":\"2021-06-19T07:30:33Z\",\"status\":\"Initiated\",\"statusReason\":\"UserRequested\"}]},{\"id\":\"pwwobtdphti\",\"ports\":[{\"number\":1752077948,\"endTimeUtc\":\"2021-05-30T17:27:57Z\",\"status\":\"Revoked\",\"statusReason\":\"UserRequested\"},{\"number\":1593105475,\"endTimeUtc\":\"2021-04-02T11:40:50Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":560959800,\"endTimeUtc\":\"2021-01-01T20:33:57Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":70088648,\"endTimeUtc\":\"2021-01-05T04:20:36Z\",\"status\":\"Revoked\",\"statusReason\":\"NewerRequestInitiated\"}]},{\"id\":\"zcgwdfriw\",\"ports\":[{\"number\":1976825993,\"endTimeUtc\":\"2021-09-07T00:09:29Z\",\"status\":\"Revoked\",\"statusReason\":\"Expired\"},{\"number\":1769252552,\"endTimeUtc\":\"2021-10-30T04:15:21Z\",\"status\":\"Initiated\",\"statusReason\":\"UserRequested\"},{\"number\":231116873,\"endTimeUtc\":\"2021-09-04T08:52:04Z\",\"status\":\"Initiated\",\"statusReason\":\"NewerRequestInitiated\"}]}],\"startTimeUtc\":\"2021-10-18T17:54:55Z\",\"requestor\":\"ixdgbyfgwewqkj\",\"justification\":\"prwpxsoohu\"},{\"virtualMachines\":[{\"id\":\"lcsklt\",\"ports\":[{\"number\":964103530,\"endTimeUtc\":\"2021-01-30T10:41:38Z\",\"status\":\"Revoked\",\"statusReason\":\"Expired\"}]},{\"id\":\"gzlf\",\"ports\":[{\"number\":1280061028,\"endTimeUtc\":\"2021-05-28T15:32:03Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":2110152605,\"endTimeUtc\":\"2021-08-12T22:14Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":225944795,\"endTimeUtc\":\"2021-02-04T07:11:07Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":1216756136,\"endTimeUtc\":\"2021-05-23T13:53:15Z\",\"status\":\"Revoked\",\"statusReason\":\"NewerRequestInitiated\"}]},{\"id\":\"pilttjzgc\",\"ports\":[{\"number\":416804114,\"endTimeUtc\":\"2021-03-01T06:48:56Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"}]}],\"startTimeUtc\":\"2021-10-27T13:57:47Z\",\"requestor\":\"bodetr\",\"justification\":\"rgvtsh\"},{\"virtualMachines\":[{\"id\":\"ft\",\"ports\":[{\"number\":1332333212,\"endTimeUtc\":\"2021-01-07T02:46:58Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"}]},{\"id\":\"qkevzgj\",\"ports\":[{\"number\":1026409362,\"endTimeUtc\":\"2021-07-29T11:42:16Z\",\"status\":\"Revoked\",\"statusReason\":\"Expired\"},{\"number\":2125032022,\"endTimeUtc\":\"2021-08-20T09:01:24Z\",\"status\":\"Initiated\",\"statusReason\":\"Expired\"},{\"number\":578650,\"endTimeUtc\":\"2021-06-06T18:24:53Z\",\"status\":\"Revoked\",\"statusReason\":\"UserRequested\"}]}],\"startTimeUtc\":\"2021-11-26T01:01:25Z\",\"requestor\":\"wzjwotnxlkfhg\",\"justification\":\"rfo\"}],\"provisioningState\":\"wecr\"},\"kind\":\"hpcselqxovp\",\"location\":\"ibuk\",\"id\":\"lvzrlrmlcc\",\"name\":\"etjsczivfqbqna\",\"type\":\"dsyenzsieuscpl\"}")
            .toObject(JitNetworkAccessPolicyInner.class);
        Assertions.assertEquals("hpcselqxovp", model.kind());
        Assertions.assertEquals("qady", model.virtualMachines().get(0).id());
        Assertions.assertEquals(1191953854, model.virtualMachines().get(0).ports().get(0).number());
        Assertions.assertEquals(Protocol.TCP, model.virtualMachines().get(0).ports().get(0).protocol());
        Assertions.assertEquals("wriuomzczfkic",
            model.virtualMachines().get(0).ports().get(0).allowedSourceAddressPrefix());
        Assertions.assertEquals("saaxwspca",
            model.virtualMachines().get(0).ports().get(0).allowedSourceAddressPrefixes().get(0));
        Assertions.assertEquals("gzzromv", model.virtualMachines().get(0).ports().get(0).maxRequestAccessDuration());
        Assertions.assertEquals("wkjmdihd", model.virtualMachines().get(0).publicIpAddress());
        Assertions.assertEquals("zlwhbwzjnufzrfgm", model.requests().get(0).virtualMachines().get(0).id());
        Assertions.assertEquals(2027483725, model.requests().get(0).virtualMachines().get(0).ports().get(0).number());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-25T13:27:22Z"),
            model.requests().get(0).virtualMachines().get(0).ports().get(0).endTimeUtc());
        Assertions.assertEquals(Status.REVOKED,
            model.requests().get(0).virtualMachines().get(0).ports().get(0).status());
        Assertions.assertEquals(StatusReason.NEWER_REQUEST_INITIATED,
            model.requests().get(0).virtualMachines().get(0).ports().get(0).statusReason());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-18T17:54:55Z"), model.requests().get(0).startTimeUtc());
        Assertions.assertEquals("ixdgbyfgwewqkj", model.requests().get(0).requestor());
        Assertions.assertEquals("prwpxsoohu", model.requests().get(0).justification());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        JitNetworkAccessPolicyInner model
            = new JitNetworkAccessPolicyInner().withKind("hpcselqxovp")
                .withVirtualMachines(
                    Arrays
                        .asList(new JitNetworkAccessPolicyVirtualMachine().withId("qady")
                            .withPorts(Arrays.asList(
                                new JitNetworkAccessPortRule().withNumber(1191953854).withProtocol(Protocol.TCP)
                                    .withAllowedSourceAddressPrefix("wriuomzczfkic")
                                    .withAllowedSourceAddressPrefixes(
                                        Arrays.asList("saaxwspca", "ikhfjqebglcxk"))
                                    .withMaxRequestAccessDuration("gzzromv"),
                                new JitNetworkAccessPortRule().withNumber(120556433).withProtocol(Protocol.ASTERISK)
                                    .withAllowedSourceAddressPrefix("emtm")
                                    .withAllowedSourceAddressPrefixes(Arrays.asList("fsvpink"))
                                    .withMaxRequestAccessDuration("pat"),
                                new JitNetworkAccessPortRule().withNumber(1765927549).withProtocol(Protocol.UDP)
                                    .withAllowedSourceAddressPrefix("swxspvckojaz")
                                    .withAllowedSourceAddressPrefixes(Arrays.asList("spftesubzpv", "vdylytcovqseusrf"))
                                    .withMaxRequestAccessDuration("bdxzfxnxmlbmu")))
                            .withPublicIpAddress("wkjmdihd")))
                .withRequests(
                    Arrays
                        .asList(
                            new JitNetworkAccessRequestInner()
                                .withVirtualMachines(
                                    Arrays
                                        .asList(
                                            new JitNetworkAccessRequestVirtualMachine().withId("zlwhbwzjnufzrfgm")
                                                .withPorts(Arrays.asList(
                                                    new JitNetworkAccessRequestPort().withNumber(2027483725)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-10-25T13:27:22Z"))
                                                        .withStatus(Status.REVOKED)
                                                        .withStatusReason(StatusReason.NEWER_REQUEST_INITIATED),
                                                    new JitNetworkAccessRequestPort().withNumber(1127579002)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-02-24T03:04:59Z"))
                                                        .withStatus(Status.REVOKED)
                                                        .withStatusReason(StatusReason.NEWER_REQUEST_INITIATED))),
                                            new JitNetworkAccessRequestVirtualMachine().withId("tedzu")
                                                .withPorts(Arrays.asList(
                                                    new JitNetworkAccessRequestPort().withNumber(1680853411)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-08-16T22:24:01Z"))
                                                        .withStatus(Status.REVOKED)
                                                        .withStatusReason(StatusReason.NEWER_REQUEST_INITIATED),
                                                    new JitNetworkAccessRequestPort().withNumber(1437195748)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-09-07T06:41:27Z"))
                                                        .withStatus(Status.REVOKED).withStatusReason(
                                                            StatusReason.USER_REQUESTED),
                                                    new JitNetworkAccessRequestPort().withNumber(1496766181)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2020-12-25T16:12:51Z"))
                                                        .withStatus(Status.INITIATED).withStatusReason(
                                                            StatusReason.EXPIRED),
                                                    new JitNetworkAccessRequestPort().withNumber(1095681099)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-06-19T07:30:33Z"))
                                                        .withStatus(Status.INITIATED)
                                                        .withStatusReason(StatusReason.USER_REQUESTED))),
                                            new JitNetworkAccessRequestVirtualMachine().withId("pwwobtdphti")
                                                .withPorts(
                                                    Arrays
                                                        .asList(
                                                            new JitNetworkAccessRequestPort().withNumber(1752077948)
                                                                .withEndTimeUtc(
                                                                    OffsetDateTime.parse("2021-05-30T17:27:57Z"))
                                                                .withStatus(Status.REVOKED)
                                                                .withStatusReason(StatusReason.USER_REQUESTED),
                                                            new JitNetworkAccessRequestPort().withNumber(1593105475)
                                                                .withEndTimeUtc(
                                                                    OffsetDateTime.parse("2021-04-02T11:40:50Z"))
                                                                .withStatus(Status.INITIATED)
                                                                .withStatusReason(StatusReason.EXPIRED),
                                                            new JitNetworkAccessRequestPort().withNumber(560959800)
                                                                .withEndTimeUtc(
                                                                    OffsetDateTime.parse("2021-01-01T20:33:57Z"))
                                                                .withStatus(Status.INITIATED)
                                                                .withStatusReason(StatusReason.EXPIRED),
                                                            new JitNetworkAccessRequestPort().withNumber(70088648)
                                                                .withEndTimeUtc(
                                                                    OffsetDateTime.parse("2021-01-05T04:20:36Z"))
                                                                .withStatus(Status.REVOKED).withStatusReason(
                                                                    StatusReason.NEWER_REQUEST_INITIATED))),
                                            new JitNetworkAccessRequestVirtualMachine().withId("zcgwdfriw").withPorts(
                                                Arrays.asList(new JitNetworkAccessRequestPort().withNumber(1976825993)
                                                    .withEndTimeUtc(OffsetDateTime.parse("2021-09-07T00:09:29Z"))
                                                    .withStatus(Status.REVOKED).withStatusReason(StatusReason.EXPIRED),
                                                    new JitNetworkAccessRequestPort().withNumber(1769252552)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-10-30T04:15:21Z"))
                                                        .withStatus(Status.INITIATED).withStatusReason(
                                                            StatusReason.USER_REQUESTED),
                                                    new JitNetworkAccessRequestPort().withNumber(231116873)
                                                        .withEndTimeUtc(OffsetDateTime.parse("2021-09-04T08:52:04Z"))
                                                        .withStatus(Status.INITIATED)
                                                        .withStatusReason(StatusReason.NEWER_REQUEST_INITIATED)))))
                                .withStartTimeUtc(OffsetDateTime.parse("2021-10-18T17:54:55Z"))
                                .withRequestor("ixdgbyfgwewqkj").withJustification("prwpxsoohu"),
                            new JitNetworkAccessRequestInner()
                                .withVirtualMachines(Arrays.asList(
                                    new JitNetworkAccessRequestVirtualMachine().withId("lcsklt")
                                        .withPorts(Arrays.asList(new JitNetworkAccessRequestPort().withNumber(964103530)
                                            .withEndTimeUtc(OffsetDateTime.parse("2021-01-30T10:41:38Z")).withStatus(
                                                Status.REVOKED)
                                            .withStatusReason(StatusReason.EXPIRED))),
                                    new JitNetworkAccessRequestVirtualMachine().withId("gzlf").withPorts(Arrays.asList(
                                        new JitNetworkAccessRequestPort().withNumber(1280061028)
                                            .withEndTimeUtc(OffsetDateTime.parse("2021-05-28T15:32:03Z"))
                                            .withStatus(Status.INITIATED).withStatusReason(StatusReason.EXPIRED),
                                        new JitNetworkAccessRequestPort().withNumber(2110152605)
                                            .withEndTimeUtc(OffsetDateTime.parse("2021-08-12T22:14Z"))
                                            .withStatus(Status.INITIATED).withStatusReason(StatusReason.EXPIRED),
                                        new JitNetworkAccessRequestPort().withNumber(225944795)
                                            .withEndTimeUtc(OffsetDateTime.parse("2021-02-04T07:11:07Z"))
                                            .withStatus(Status.INITIATED).withStatusReason(StatusReason.EXPIRED),
                                        new JitNetworkAccessRequestPort().withNumber(1216756136)
                                            .withEndTimeUtc(OffsetDateTime.parse("2021-05-23T13:53:15Z"))
                                            .withStatus(Status.REVOKED)
                                            .withStatusReason(StatusReason.NEWER_REQUEST_INITIATED))),
                                    new JitNetworkAccessRequestVirtualMachine()
                                        .withId("pilttjzgc").withPorts(Arrays
                                            .asList(new JitNetworkAccessRequestPort().withNumber(416804114)
                                                .withEndTimeUtc(OffsetDateTime.parse("2021-03-01T06:48:56Z"))
                                                .withStatus(Status.INITIATED).withStatusReason(StatusReason.EXPIRED)))))
                                .withStartTimeUtc(
                                    OffsetDateTime.parse("2021-10-27T13:57:47Z"))
                                .withRequestor("bodetr").withJustification("rgvtsh"),
                            new JitNetworkAccessRequestInner()
                                .withVirtualMachines(
                                    Arrays.asList(
                                        new JitNetworkAccessRequestVirtualMachine()
                                            .withId("ft")
                                            .withPorts(
                                                Arrays.asList(new JitNetworkAccessRequestPort().withNumber(1332333212)
                                                    .withEndTimeUtc(OffsetDateTime.parse("2021-01-07T02:46:58Z"))
                                                    .withStatus(Status.INITIATED)
                                                    .withStatusReason(StatusReason.EXPIRED))),
                                        new JitNetworkAccessRequestVirtualMachine().withId("qkevzgj")
                                            .withPorts(
                                                Arrays
                                                    .asList(
                                                        new JitNetworkAccessRequestPort().withNumber(1026409362)
                                                            .withEndTimeUtc(
                                                                OffsetDateTime.parse("2021-07-29T11:42:16Z"))
                                                            .withStatus(Status.REVOKED)
                                                            .withStatusReason(StatusReason.EXPIRED),
                                                        new JitNetworkAccessRequestPort().withNumber(2125032022)
                                                            .withEndTimeUtc(
                                                                OffsetDateTime.parse("2021-08-20T09:01:24Z"))
                                                            .withStatus(Status.INITIATED)
                                                            .withStatusReason(StatusReason.EXPIRED),
                                                        new JitNetworkAccessRequestPort().withNumber(578650)
                                                            .withEndTimeUtc(
                                                                OffsetDateTime.parse("2021-06-06T18:24:53Z"))
                                                            .withStatus(Status.REVOKED)
                                                            .withStatusReason(StatusReason.USER_REQUESTED)))))
                                .withStartTimeUtc(OffsetDateTime.parse("2021-11-26T01:01:25Z"))
                                .withRequestor("wzjwotnxlkfhg").withJustification("rfo")));
        model = BinaryData.fromObject(model).toObject(JitNetworkAccessPolicyInner.class);
        Assertions.assertEquals("hpcselqxovp", model.kind());
        Assertions.assertEquals("qady", model.virtualMachines().get(0).id());
        Assertions.assertEquals(1191953854, model.virtualMachines().get(0).ports().get(0).number());
        Assertions.assertEquals(Protocol.TCP, model.virtualMachines().get(0).ports().get(0).protocol());
        Assertions.assertEquals("wriuomzczfkic",
            model.virtualMachines().get(0).ports().get(0).allowedSourceAddressPrefix());
        Assertions.assertEquals("saaxwspca",
            model.virtualMachines().get(0).ports().get(0).allowedSourceAddressPrefixes().get(0));
        Assertions.assertEquals("gzzromv", model.virtualMachines().get(0).ports().get(0).maxRequestAccessDuration());
        Assertions.assertEquals("wkjmdihd", model.virtualMachines().get(0).publicIpAddress());
        Assertions.assertEquals("zlwhbwzjnufzrfgm", model.requests().get(0).virtualMachines().get(0).id());
        Assertions.assertEquals(2027483725, model.requests().get(0).virtualMachines().get(0).ports().get(0).number());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-25T13:27:22Z"),
            model.requests().get(0).virtualMachines().get(0).ports().get(0).endTimeUtc());
        Assertions.assertEquals(Status.REVOKED,
            model.requests().get(0).virtualMachines().get(0).ports().get(0).status());
        Assertions.assertEquals(StatusReason.NEWER_REQUEST_INITIATED,
            model.requests().get(0).virtualMachines().get(0).ports().get(0).statusReason());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-18T17:54:55Z"), model.requests().get(0).startTimeUtc());
        Assertions.assertEquals("ixdgbyfgwewqkj", model.requests().get(0).requestor());
        Assertions.assertEquals("prwpxsoohu", model.requests().get(0).justification());
    }
}
