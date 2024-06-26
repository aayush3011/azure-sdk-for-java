// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.vmwarecloudsimple.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.vmwarecloudsimple.fluent.models.VirtualNetworkInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** List of virtual networks. */
@Fluent
public final class VirtualNetworkListResponse {
    /*
     * Link for next list of VirtualNetwork
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /*
     * Results of the VirtualNetwork list
     */
    @JsonProperty(value = "value")
    private List<VirtualNetworkInner> value;

    /** Creates an instance of VirtualNetworkListResponse class. */
    public VirtualNetworkListResponse() {
    }

    /**
     * Get the nextLink property: Link for next list of VirtualNetwork.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for next list of VirtualNetwork.
     *
     * @param nextLink the nextLink value to set.
     * @return the VirtualNetworkListResponse object itself.
     */
    public VirtualNetworkListResponse withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Get the value property: Results of the VirtualNetwork list.
     *
     * @return the value value.
     */
    public List<VirtualNetworkInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Results of the VirtualNetwork list.
     *
     * @param value the value value to set.
     * @return the VirtualNetworkListResponse object itself.
     */
    public VirtualNetworkListResponse withValue(List<VirtualNetworkInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
