// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.logic.fluent.models.IntegrationAccountSchemaInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The list of integration account schemas. */
@Fluent
public final class IntegrationAccountSchemaListResult {
    /*
     * The list of integration account schemas.
     */
    @JsonProperty(value = "value")
    private List<IntegrationAccountSchemaInner> value;

    /*
     * The URL to get the next set of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of IntegrationAccountSchemaListResult class. */
    public IntegrationAccountSchemaListResult() {
    }

    /**
     * Get the value property: The list of integration account schemas.
     *
     * @return the value value.
     */
    public List<IntegrationAccountSchemaInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of integration account schemas.
     *
     * @param value the value value to set.
     * @return the IntegrationAccountSchemaListResult object itself.
     */
    public IntegrationAccountSchemaListResult withValue(List<IntegrationAccountSchemaInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to get the next set of results.
     *
     * @param nextLink the nextLink value to set.
     * @return the IntegrationAccountSchemaListResult object itself.
     */
    public IntegrationAccountSchemaListResult withNextLink(String nextLink) {
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
