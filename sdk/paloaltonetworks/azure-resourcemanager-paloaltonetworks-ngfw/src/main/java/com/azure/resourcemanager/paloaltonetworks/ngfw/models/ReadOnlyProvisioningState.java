// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Provisioning state of the firewall resource.
 */
public final class ReadOnlyProvisioningState extends ExpandableStringEnum<ReadOnlyProvisioningState> {
    /**
     * Static value Succeeded for ReadOnlyProvisioningState.
     */
    public static final ReadOnlyProvisioningState SUCCEEDED = fromString("Succeeded");

    /**
     * Static value Failed for ReadOnlyProvisioningState.
     */
    public static final ReadOnlyProvisioningState FAILED = fromString("Failed");

    /**
     * Static value Deleted for ReadOnlyProvisioningState.
     */
    public static final ReadOnlyProvisioningState DELETED = fromString("Deleted");

    /**
     * Creates a new instance of ReadOnlyProvisioningState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ReadOnlyProvisioningState() {
    }

    /**
     * Creates or finds a ReadOnlyProvisioningState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ReadOnlyProvisioningState.
     */
    public static ReadOnlyProvisioningState fromString(String name) {
        return fromString(name, ReadOnlyProvisioningState.class);
    }

    /**
     * Gets known ReadOnlyProvisioningState values.
     * 
     * @return known ReadOnlyProvisioningState values.
     */
    public static Collection<ReadOnlyProvisioningState> values() {
        return values(ReadOnlyProvisioningState.class);
    }
}
