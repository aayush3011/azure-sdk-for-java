// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managedapplications.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** List token request body. */
@Fluent
public final class ListTokenRequest {
    /*
     * The authorization audience.
     */
    @JsonProperty(value = "authorizationAudience")
    private String authorizationAudience;

    /*
     * The user assigned identities.
     */
    @JsonProperty(value = "userAssignedIdentities")
    private List<String> userAssignedIdentities;

    /** Creates an instance of ListTokenRequest class. */
    public ListTokenRequest() {
    }

    /**
     * Get the authorizationAudience property: The authorization audience.
     *
     * @return the authorizationAudience value.
     */
    public String authorizationAudience() {
        return this.authorizationAudience;
    }

    /**
     * Set the authorizationAudience property: The authorization audience.
     *
     * @param authorizationAudience the authorizationAudience value to set.
     * @return the ListTokenRequest object itself.
     */
    public ListTokenRequest withAuthorizationAudience(String authorizationAudience) {
        this.authorizationAudience = authorizationAudience;
        return this;
    }

    /**
     * Get the userAssignedIdentities property: The user assigned identities.
     *
     * @return the userAssignedIdentities value.
     */
    public List<String> userAssignedIdentities() {
        return this.userAssignedIdentities;
    }

    /**
     * Set the userAssignedIdentities property: The user assigned identities.
     *
     * @param userAssignedIdentities the userAssignedIdentities value to set.
     * @return the ListTokenRequest object itself.
     */
    public ListTokenRequest withUserAssignedIdentities(List<String> userAssignedIdentities) {
        this.userAssignedIdentities = userAssignedIdentities;
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
