// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mariadb.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.mariadb.fluent.models.LogFileInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A list of log files. */
@Fluent
public final class LogFileListResult {
    /*
     * The list of log files.
     */
    @JsonProperty(value = "value")
    private List<LogFileInner> value;

    /** Creates an instance of LogFileListResult class. */
    public LogFileListResult() {
    }

    /**
     * Get the value property: The list of log files.
     *
     * @return the value value.
     */
    public List<LogFileInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of log files.
     *
     * @param value the value value to set.
     * @return the LogFileListResult object itself.
     */
    public LogFileListResult withValue(List<LogFileInner> value) {
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
