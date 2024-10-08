// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Double encryption status as entered by the customer. It is compulsory to give this parameter if the 'Deny' or
 * 'Disabled' policy is configured.
 */
public final class DoubleEncryptionStatus extends ExpandableStringEnum<DoubleEncryptionStatus> {
    /**
     * Static value Disabled for DoubleEncryptionStatus.
     */
    public static final DoubleEncryptionStatus DISABLED = fromString("Disabled");

    /**
     * Static value Enabled for DoubleEncryptionStatus.
     */
    public static final DoubleEncryptionStatus ENABLED = fromString("Enabled");

    /**
     * Creates a new instance of DoubleEncryptionStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DoubleEncryptionStatus() {
    }

    /**
     * Creates or finds a DoubleEncryptionStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DoubleEncryptionStatus.
     */
    public static DoubleEncryptionStatus fromString(String name) {
        return fromString(name, DoubleEncryptionStatus.class);
    }

    /**
     * Gets known DoubleEncryptionStatus values.
     * 
     * @return known DoubleEncryptionStatus values.
     */
    public static Collection<DoubleEncryptionStatus> values() {
        return values(DoubleEncryptionStatus.class);
    }
}
