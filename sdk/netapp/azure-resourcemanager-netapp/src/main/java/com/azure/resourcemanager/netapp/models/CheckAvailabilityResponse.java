// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.models;

import com.azure.resourcemanager.netapp.fluent.models.CheckAvailabilityResponseInner;

/**
 * An immutable client-side representation of CheckAvailabilityResponse.
 */
public interface CheckAvailabilityResponse {
    /**
     * Gets the isAvailable property: &lt;code&gt;true&lt;/code&gt; indicates name is valid and available.
     * &lt;code&gt;false&lt;/code&gt; indicates the name is invalid, unavailable, or both.
     * 
     * @return the isAvailable value.
     */
    Boolean isAvailable();

    /**
     * Gets the reason property: &lt;code&gt;Invalid&lt;/code&gt; indicates the name provided does not match Azure App
     * Service naming requirements. &lt;code&gt;AlreadyExists&lt;/code&gt; indicates that the name is already in use and
     * is therefore unavailable.
     * 
     * @return the reason value.
     */
    InAvailabilityReasonType reason();

    /**
     * Gets the message property: If reason == invalid, provide the user with the reason why the given name is invalid,
     * and provide the resource naming requirements so that the user can select a valid name. If reason ==
     * AlreadyExists, explain that resource name is already in use, and direct them to select a different name.
     * 
     * @return the message value.
     */
    String message();

    /**
     * Gets the inner com.azure.resourcemanager.netapp.fluent.models.CheckAvailabilityResponseInner object.
     * 
     * @return the inner object.
     */
    CheckAvailabilityResponseInner innerModel();
}
