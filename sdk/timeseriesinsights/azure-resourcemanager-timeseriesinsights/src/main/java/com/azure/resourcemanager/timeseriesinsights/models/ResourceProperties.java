// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.timeseriesinsights.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Properties that are common to all tracked resources. */
@Immutable
public class ResourceProperties {
    /*
     * Provisioning state of the resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * The time the resource was created.
     */
    @JsonProperty(value = "creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime creationTime;

    /** Creates an instance of ResourceProperties class. */
    public ResourceProperties() {
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the creationTime property: The time the resource was created.
     *
     * @return the creationTime value.
     */
    public OffsetDateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
