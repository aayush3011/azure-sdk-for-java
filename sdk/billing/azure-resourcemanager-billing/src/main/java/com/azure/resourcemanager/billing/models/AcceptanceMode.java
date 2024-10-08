// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The mode of acceptance for an agreement.
 */
public final class AcceptanceMode extends ExpandableStringEnum<AcceptanceMode> {
    /**
     * Static value Other for AcceptanceMode.
     */
    public static final AcceptanceMode OTHER = fromString("Other");

    /**
     * Static value ClickToAccept for AcceptanceMode.
     */
    public static final AcceptanceMode CLICK_TO_ACCEPT = fromString("ClickToAccept");

    /**
     * Static value ESignEmbedded for AcceptanceMode.
     */
    public static final AcceptanceMode ESIGN_EMBEDDED = fromString("ESignEmbedded");

    /**
     * Static value ESignOffline for AcceptanceMode.
     */
    public static final AcceptanceMode ESIGN_OFFLINE = fromString("ESignOffline");

    /**
     * Static value Implicit for AcceptanceMode.
     */
    public static final AcceptanceMode IMPLICIT = fromString("Implicit");

    /**
     * Static value Offline for AcceptanceMode.
     */
    public static final AcceptanceMode OFFLINE = fromString("Offline");

    /**
     * Static value PhysicalSign for AcceptanceMode.
     */
    public static final AcceptanceMode PHYSICAL_SIGN = fromString("PhysicalSign");

    /**
     * Creates a new instance of AcceptanceMode value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AcceptanceMode() {
    }

    /**
     * Creates or finds a AcceptanceMode from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AcceptanceMode.
     */
    public static AcceptanceMode fromString(String name) {
        return fromString(name, AcceptanceMode.class);
    }

    /**
     * Gets known AcceptanceMode values.
     * 
     * @return known AcceptanceMode values.
     */
    public static Collection<AcceptanceMode> values() {
        return values(AcceptanceMode.class);
    }
}
