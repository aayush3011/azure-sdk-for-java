// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.search.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.search.models.QuotaUsageResultName;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes the quota usage for a particular SKU. */
@Fluent
public final class QuotaUsageResultInner {
    /*
     * The resource ID of the quota usage SKU endpoint for Microsoft.Search provider.
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * The unit of measurement for the search SKU.
     */
    @JsonProperty(value = "unit")
    private String unit;

    /*
     * The currently used up value for the particular search SKU.
     */
    @JsonProperty(value = "currentValue")
    private Integer currentValue;

    /*
     * The quota limit for the particular search SKU.
     */
    @JsonProperty(value = "limit")
    private Integer limit;

    /*
     * The name of the SKU supported by Azure AI Search.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private QuotaUsageResultName name;

    /** Creates an instance of QuotaUsageResultInner class. */
    public QuotaUsageResultInner() {
    }

    /**
     * Get the id property: The resource ID of the quota usage SKU endpoint for Microsoft.Search provider.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: The resource ID of the quota usage SKU endpoint for Microsoft.Search provider.
     *
     * @param id the id value to set.
     * @return the QuotaUsageResultInner object itself.
     */
    public QuotaUsageResultInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the unit property: The unit of measurement for the search SKU.
     *
     * @return the unit value.
     */
    public String unit() {
        return this.unit;
    }

    /**
     * Set the unit property: The unit of measurement for the search SKU.
     *
     * @param unit the unit value to set.
     * @return the QuotaUsageResultInner object itself.
     */
    public QuotaUsageResultInner withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the currentValue property: The currently used up value for the particular search SKU.
     *
     * @return the currentValue value.
     */
    public Integer currentValue() {
        return this.currentValue;
    }

    /**
     * Set the currentValue property: The currently used up value for the particular search SKU.
     *
     * @param currentValue the currentValue value to set.
     * @return the QuotaUsageResultInner object itself.
     */
    public QuotaUsageResultInner withCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
        return this;
    }

    /**
     * Get the limit property: The quota limit for the particular search SKU.
     *
     * @return the limit value.
     */
    public Integer limit() {
        return this.limit;
    }

    /**
     * Set the limit property: The quota limit for the particular search SKU.
     *
     * @param limit the limit value to set.
     * @return the QuotaUsageResultInner object itself.
     */
    public QuotaUsageResultInner withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Get the name property: The name of the SKU supported by Azure AI Search.
     *
     * @return the name value.
     */
    public QuotaUsageResultName name() {
        return this.name;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() != null) {
            name().validate();
        }
    }
}
