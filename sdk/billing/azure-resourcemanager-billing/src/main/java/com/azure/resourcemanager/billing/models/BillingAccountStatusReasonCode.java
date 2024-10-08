// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Reason for the specified billing account status.
 */
public final class BillingAccountStatusReasonCode extends ExpandableStringEnum<BillingAccountStatusReasonCode> {
    /**
     * Static value Other for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode OTHER = fromString("Other");

    /**
     * Static value UnusualActivity for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode UNUSUAL_ACTIVITY = fromString("UnusualActivity");

    /**
     * Static value ManuallyTerminated for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode MANUALLY_TERMINATED = fromString("ManuallyTerminated");

    /**
     * Static value Expired for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode EXPIRED = fromString("Expired");

    /**
     * Static value Transferred for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode TRANSFERRED = fromString("Transferred");

    /**
     * Static value TerminateProcessing for BillingAccountStatusReasonCode.
     */
    public static final BillingAccountStatusReasonCode TERMINATE_PROCESSING = fromString("TerminateProcessing");

    /**
     * Creates a new instance of BillingAccountStatusReasonCode value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public BillingAccountStatusReasonCode() {
    }

    /**
     * Creates or finds a BillingAccountStatusReasonCode from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding BillingAccountStatusReasonCode.
     */
    public static BillingAccountStatusReasonCode fromString(String name) {
        return fromString(name, BillingAccountStatusReasonCode.class);
    }

    /**
     * Gets known BillingAccountStatusReasonCode values.
     * 
     * @return known BillingAccountStatusReasonCode values.
     */
    public static Collection<BillingAccountStatusReasonCode> values() {
        return values(BillingAccountStatusReasonCode.class);
    }
}
