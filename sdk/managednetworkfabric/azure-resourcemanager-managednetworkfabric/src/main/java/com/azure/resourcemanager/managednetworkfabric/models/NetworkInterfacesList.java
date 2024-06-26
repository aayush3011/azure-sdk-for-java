// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.NetworkInterfaceInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** List of NetworkInterfaces. */
@Fluent
public final class NetworkInterfacesList {
    /*
     * List of NetworkInterfaces resources.
     */
    @JsonProperty(value = "value")
    private List<NetworkInterfaceInner> value;

    /*
     * Url to follow for getting next page of resources.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of NetworkInterfacesList class. */
    public NetworkInterfacesList() {
    }

    /**
     * Get the value property: List of NetworkInterfaces resources.
     *
     * @return the value value.
     */
    public List<NetworkInterfaceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of NetworkInterfaces resources.
     *
     * @param value the value value to set.
     * @return the NetworkInterfacesList object itself.
     */
    public NetworkInterfacesList withValue(List<NetworkInterfaceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Url to follow for getting next page of resources.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Url to follow for getting next page of resources.
     *
     * @param nextLink the nextLink value to set.
     * @return the NetworkInterfacesList object itself.
     */
    public NetworkInterfacesList withNextLink(String nextLink) {
        this.nextLink = nextLink;
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
