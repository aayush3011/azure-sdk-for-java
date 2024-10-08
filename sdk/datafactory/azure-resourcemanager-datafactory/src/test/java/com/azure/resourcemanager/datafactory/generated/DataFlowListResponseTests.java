// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.DataFlowResourceInner;
import com.azure.resourcemanager.datafactory.models.DataFlow;
import com.azure.resourcemanager.datafactory.models.DataFlowFolder;
import com.azure.resourcemanager.datafactory.models.DataFlowListResponse;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class DataFlowListResponseTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DataFlowListResponse model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"type\":\"DataFlow\",\"description\":\"resmkssjhoiftxfk\",\"annotations\":[\"datagpr\",\"dataptil\",\"dataucb\"],\"folder\":{\"name\":\"gdqoh\"}},\"name\":\"wsldrizetpwbr\",\"type\":\"llibphbqzmizak\",\"etag\":\"ankjpdnjzh\",\"id\":\"oylhjlmuoyxprimr\"},{\"properties\":{\"type\":\"DataFlow\",\"description\":\"pteecjme\",\"annotations\":[\"datastvasylwxdzaumw\"],\"folder\":{\"name\":\"hguuf\"}},\"name\":\"boyjathwt\",\"type\":\"lbaemwmdxmeb\",\"etag\":\"scjpahlxv\",\"id\":\"bfqxnmwmqtibxyi\"},{\"properties\":{\"type\":\"DataFlow\",\"description\":\"dt\",\"annotations\":[\"datattadijae\",\"datakmr\"],\"folder\":{\"name\":\"ekpndzaapmudq\"}},\"name\":\"qwigpibudqwyxe\",\"type\":\"ybpmzznrtffyaq\",\"etag\":\"mhh\",\"id\":\"oqaqhvseufuq\"}],\"nextLink\":\"xpdlcgqlsis\"}")
            .toObject(DataFlowListResponse.class);
        Assertions.assertEquals("oylhjlmuoyxprimr", model.value().get(0).id());
        Assertions.assertEquals("resmkssjhoiftxfk", model.value().get(0).properties().description());
        Assertions.assertEquals("gdqoh", model.value().get(0).properties().folder().name());
        Assertions.assertEquals("xpdlcgqlsis", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DataFlowListResponse model = new DataFlowListResponse().withValue(Arrays.asList(
            new DataFlowResourceInner().withId("oylhjlmuoyxprimr")
                .withProperties(new DataFlow().withDescription("resmkssjhoiftxfk")
                    .withAnnotations(Arrays.asList("datagpr", "dataptil", "dataucb"))
                    .withFolder(new DataFlowFolder().withName("gdqoh"))),
            new DataFlowResourceInner().withId("bfqxnmwmqtibxyi")
                .withProperties(new DataFlow().withDescription("pteecjme")
                    .withAnnotations(Arrays.asList("datastvasylwxdzaumw"))
                    .withFolder(new DataFlowFolder().withName("hguuf"))),
            new DataFlowResourceInner().withId("oqaqhvseufuq")
                .withProperties(new DataFlow().withDescription("dt")
                    .withAnnotations(Arrays.asList("datattadijae", "datakmr"))
                    .withFolder(new DataFlowFolder().withName("ekpndzaapmudq")))))
            .withNextLink("xpdlcgqlsis");
        model = BinaryData.fromObject(model).toObject(DataFlowListResponse.class);
        Assertions.assertEquals("oylhjlmuoyxprimr", model.value().get(0).id());
        Assertions.assertEquals("resmkssjhoiftxfk", model.value().get(0).properties().description());
        Assertions.assertEquals("gdqoh", model.value().get(0).properties().folder().name());
        Assertions.assertEquals("xpdlcgqlsis", model.nextLink());
    }
}
