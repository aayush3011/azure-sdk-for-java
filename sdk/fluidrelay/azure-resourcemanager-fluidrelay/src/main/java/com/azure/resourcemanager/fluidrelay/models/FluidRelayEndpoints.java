// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.fluidrelay.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The Fluid Relay endpoints for this server. */
@Immutable
public final class FluidRelayEndpoints {
    /*
     * The Fluid Relay Orderer endpoints.
     */
    @JsonProperty(value = "ordererEndpoints", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> ordererEndpoints;

    /*
     * The Fluid Relay storage endpoints.
     */
    @JsonProperty(value = "storageEndpoints", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> storageEndpoints;

    /*
     * The Fluid Relay service endpoints.
     */
    @JsonProperty(value = "serviceEndpoints", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> serviceEndpoints;

    /**
     * Get the ordererEndpoints property: The Fluid Relay Orderer endpoints.
     *
     * @return the ordererEndpoints value.
     */
    public List<String> ordererEndpoints() {
        return this.ordererEndpoints;
    }

    /**
     * Get the storageEndpoints property: The Fluid Relay storage endpoints.
     *
     * @return the storageEndpoints value.
     */
    public List<String> storageEndpoints() {
        return this.storageEndpoints;
    }

    /**
     * Get the serviceEndpoints property: The Fluid Relay service endpoints.
     *
     * @return the serviceEndpoints value.
     */
    public List<String> serviceEndpoints() {
        return this.serviceEndpoints;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
