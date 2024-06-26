// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The resource quantity for required CPU and Memory of Application Live View component.
 */
@Immutable
public final class ApplicationLiveViewResourceRequests {
    /*
     * Cpu quantity allocated to each Application Live View component instance. 1 core can be represented by 1 or
     * 1000m.
     */
    @JsonProperty(value = "cpu", access = JsonProperty.Access.WRITE_ONLY)
    private String cpu;

    /*
     * Memory quantity allocated to each Application Live View component instance. 1 GB can be represented by 1Gi or
     * 1024Mi.
     */
    @JsonProperty(value = "memory", access = JsonProperty.Access.WRITE_ONLY)
    private String memory;

    /*
     * Desired instance count of Application Live View component instance.
     */
    @JsonProperty(value = "instanceCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer instanceCount;

    /**
     * Creates an instance of ApplicationLiveViewResourceRequests class.
     */
    public ApplicationLiveViewResourceRequests() {
    }

    /**
     * Get the cpu property: Cpu quantity allocated to each Application Live View component instance. 1 core can be
     * represented by 1 or 1000m.
     * 
     * @return the cpu value.
     */
    public String cpu() {
        return this.cpu;
    }

    /**
     * Get the memory property: Memory quantity allocated to each Application Live View component instance. 1 GB can be
     * represented by 1Gi or 1024Mi.
     * 
     * @return the memory value.
     */
    public String memory() {
        return this.memory;
    }

    /**
     * Get the instanceCount property: Desired instance count of Application Live View component instance.
     * 
     * @return the instanceCount value.
     */
    public Integer instanceCount() {
        return this.instanceCount;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
