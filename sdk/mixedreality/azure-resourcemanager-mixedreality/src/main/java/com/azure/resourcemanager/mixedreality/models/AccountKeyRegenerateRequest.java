// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mixedreality.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Request for account key regeneration. */
@Fluent
public final class AccountKeyRegenerateRequest {
    /*
     * serial of key to be regenerated
     */
    @JsonProperty(value = "serial")
    private Serial serial;

    /** Creates an instance of AccountKeyRegenerateRequest class. */
    public AccountKeyRegenerateRequest() {
    }

    /**
     * Get the serial property: serial of key to be regenerated.
     *
     * @return the serial value.
     */
    public Serial serial() {
        return this.serial;
    }

    /**
     * Set the serial property: serial of key to be regenerated.
     *
     * @param serial the serial value to set.
     * @return the AccountKeyRegenerateRequest object itself.
     */
    public AccountKeyRegenerateRequest withSerial(Serial serial) {
        this.serial = serial;
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
