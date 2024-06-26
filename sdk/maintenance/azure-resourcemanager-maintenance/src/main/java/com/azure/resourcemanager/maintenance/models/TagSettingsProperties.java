// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.maintenance.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** Tag filter information for the VM. */
@Fluent
public final class TagSettingsProperties {
    /*
     * Dictionary of tags with its list of values.
     */
    @JsonProperty(value = "tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, List<String>> tags;

    /*
     * Filter VMs by Any or All specified tags.
     */
    @JsonProperty(value = "filterOperator")
    private TagOperators filterOperator;

    /** Creates an instance of TagSettingsProperties class. */
    public TagSettingsProperties() {
    }

    /**
     * Get the tags property: Dictionary of tags with its list of values.
     *
     * @return the tags value.
     */
    public Map<String, List<String>> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Dictionary of tags with its list of values.
     *
     * @param tags the tags value to set.
     * @return the TagSettingsProperties object itself.
     */
    public TagSettingsProperties withTags(Map<String, List<String>> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the filterOperator property: Filter VMs by Any or All specified tags.
     *
     * @return the filterOperator value.
     */
    public TagOperators filterOperator() {
        return this.filterOperator;
    }

    /**
     * Set the filterOperator property: Filter VMs by Any or All specified tags.
     *
     * @param filterOperator the filterOperator value to set.
     * @return the TagSettingsProperties object itself.
     */
    public TagSettingsProperties withFilterOperator(TagOperators filterOperator) {
        this.filterOperator = filterOperator;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
