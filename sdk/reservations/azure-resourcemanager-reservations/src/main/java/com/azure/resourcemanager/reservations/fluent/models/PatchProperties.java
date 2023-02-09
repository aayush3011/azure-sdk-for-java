// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.reservations.models.AppliedScopeProperties;
import com.azure.resourcemanager.reservations.models.AppliedScopeType;
import com.azure.resourcemanager.reservations.models.InstanceFlexibility;
import com.azure.resourcemanager.reservations.models.PatchPropertiesRenewProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

/** Properties for reservation patch. */
@Fluent
public final class PatchProperties {
    /*
     * Type of the Applied Scope.
     */
    @JsonProperty(value = "appliedScopeType")
    private AppliedScopeType appliedScopeType;

    /*
     * List of the subscriptions that the benefit will be applied. Do not specify if AppliedScopeType is Shared.
     */
    @JsonProperty(value = "appliedScopes")
    private List<String> appliedScopes;

    /*
     * Properties specific to applied scope type. Not required if not applicable. Required and need to provide tenantId
     * and managementGroupId if AppliedScopeType is ManagementGroup
     */
    @JsonProperty(value = "appliedScopeProperties")
    private AppliedScopeProperties appliedScopeProperties;

    /*
     * Turning this on will apply the reservation discount to other VMs in the same VM size group. Only specify for
     * VirtualMachines reserved resource type.
     */
    @JsonProperty(value = "instanceFlexibility")
    private InstanceFlexibility instanceFlexibility;

    /*
     * Display name of the reservation
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Setting this to true will automatically purchase a new reservation on the expiration date time.
     */
    @JsonProperty(value = "renew")
    private Boolean renew;

    /*
     * The renewProperties property.
     */
    @JsonProperty(value = "renewProperties")
    private PatchPropertiesRenewProperties renewProperties;

    /*
     * This is the date-time when the Azure hybrid benefit needs to be reviewed.
     */
    @JsonProperty(value = "reviewDateTime")
    private OffsetDateTime reviewDateTime;

    /** Creates an instance of PatchProperties class. */
    public PatchProperties() {
    }

    /**
     * Get the appliedScopeType property: Type of the Applied Scope.
     *
     * @return the appliedScopeType value.
     */
    public AppliedScopeType appliedScopeType() {
        return this.appliedScopeType;
    }

    /**
     * Set the appliedScopeType property: Type of the Applied Scope.
     *
     * @param appliedScopeType the appliedScopeType value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withAppliedScopeType(AppliedScopeType appliedScopeType) {
        this.appliedScopeType = appliedScopeType;
        return this;
    }

    /**
     * Get the appliedScopes property: List of the subscriptions that the benefit will be applied. Do not specify if
     * AppliedScopeType is Shared.
     *
     * @return the appliedScopes value.
     */
    public List<String> appliedScopes() {
        return this.appliedScopes;
    }

    /**
     * Set the appliedScopes property: List of the subscriptions that the benefit will be applied. Do not specify if
     * AppliedScopeType is Shared.
     *
     * @param appliedScopes the appliedScopes value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withAppliedScopes(List<String> appliedScopes) {
        this.appliedScopes = appliedScopes;
        return this;
    }

    /**
     * Get the appliedScopeProperties property: Properties specific to applied scope type. Not required if not
     * applicable. Required and need to provide tenantId and managementGroupId if AppliedScopeType is ManagementGroup.
     *
     * @return the appliedScopeProperties value.
     */
    public AppliedScopeProperties appliedScopeProperties() {
        return this.appliedScopeProperties;
    }

    /**
     * Set the appliedScopeProperties property: Properties specific to applied scope type. Not required if not
     * applicable. Required and need to provide tenantId and managementGroupId if AppliedScopeType is ManagementGroup.
     *
     * @param appliedScopeProperties the appliedScopeProperties value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withAppliedScopeProperties(AppliedScopeProperties appliedScopeProperties) {
        this.appliedScopeProperties = appliedScopeProperties;
        return this;
    }

    /**
     * Get the instanceFlexibility property: Turning this on will apply the reservation discount to other VMs in the
     * same VM size group. Only specify for VirtualMachines reserved resource type.
     *
     * @return the instanceFlexibility value.
     */
    public InstanceFlexibility instanceFlexibility() {
        return this.instanceFlexibility;
    }

    /**
     * Set the instanceFlexibility property: Turning this on will apply the reservation discount to other VMs in the
     * same VM size group. Only specify for VirtualMachines reserved resource type.
     *
     * @param instanceFlexibility the instanceFlexibility value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withInstanceFlexibility(InstanceFlexibility instanceFlexibility) {
        this.instanceFlexibility = instanceFlexibility;
        return this;
    }

    /**
     * Get the name property: Display name of the reservation.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Display name of the reservation.
     *
     * @param name the name value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the renew property: Setting this to true will automatically purchase a new reservation on the expiration date
     * time.
     *
     * @return the renew value.
     */
    public Boolean renew() {
        return this.renew;
    }

    /**
     * Set the renew property: Setting this to true will automatically purchase a new reservation on the expiration date
     * time.
     *
     * @param renew the renew value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withRenew(Boolean renew) {
        this.renew = renew;
        return this;
    }

    /**
     * Get the renewProperties property: The renewProperties property.
     *
     * @return the renewProperties value.
     */
    public PatchPropertiesRenewProperties renewProperties() {
        return this.renewProperties;
    }

    /**
     * Set the renewProperties property: The renewProperties property.
     *
     * @param renewProperties the renewProperties value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withRenewProperties(PatchPropertiesRenewProperties renewProperties) {
        this.renewProperties = renewProperties;
        return this;
    }

    /**
     * Get the reviewDateTime property: This is the date-time when the Azure hybrid benefit needs to be reviewed.
     *
     * @return the reviewDateTime value.
     */
    public OffsetDateTime reviewDateTime() {
        return this.reviewDateTime;
    }

    /**
     * Set the reviewDateTime property: This is the date-time when the Azure hybrid benefit needs to be reviewed.
     *
     * @param reviewDateTime the reviewDateTime value to set.
     * @return the PatchProperties object itself.
     */
    public PatchProperties withReviewDateTime(OffsetDateTime reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (appliedScopeProperties() != null) {
            appliedScopeProperties().validate();
        }
        if (renewProperties() != null) {
            renewProperties().validate();
        }
    }
}