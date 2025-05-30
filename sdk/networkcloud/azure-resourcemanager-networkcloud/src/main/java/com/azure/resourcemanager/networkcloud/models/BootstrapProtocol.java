// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The type of bootstrap protocol used.
 */
public final class BootstrapProtocol extends ExpandableStringEnum<BootstrapProtocol> {
    /**
     * Static value PXE for BootstrapProtocol.
     */
    public static final BootstrapProtocol PXE = fromString("PXE");

    /**
     * Creates a new instance of BootstrapProtocol value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public BootstrapProtocol() {
    }

    /**
     * Creates or finds a BootstrapProtocol from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding BootstrapProtocol.
     */
    public static BootstrapProtocol fromString(String name) {
        return fromString(name, BootstrapProtocol.class);
    }

    /**
     * Gets known BootstrapProtocol values.
     * 
     * @return known BootstrapProtocol values.
     */
    public static Collection<BootstrapProtocol> values() {
        return values(BootstrapProtocol.class);
    }
}
