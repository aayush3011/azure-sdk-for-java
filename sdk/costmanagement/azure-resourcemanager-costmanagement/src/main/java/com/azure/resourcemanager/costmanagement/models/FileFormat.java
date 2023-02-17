// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Destination of the view data. Currently only CSV format is supported. */
public final class FileFormat extends ExpandableStringEnum<FileFormat> {
    /** Static value Csv for FileFormat. */
    public static final FileFormat CSV = fromString("Csv");

    /**
     * Creates a new instance of FileFormat value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FileFormat() {
    }

    /**
     * Creates or finds a FileFormat from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding FileFormat.
     */
    @JsonCreator
    public static FileFormat fromString(String name) {
        return fromString(name, FileFormat.class);
    }

    /**
     * Gets known FileFormat values.
     *
     * @return known FileFormat values.
     */
    public static Collection<FileFormat> values() {
        return values(FileFormat.class);
    }
}