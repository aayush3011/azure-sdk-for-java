// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagepool.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.storagepool.fluent.models.IscsiTargetUpdateProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Payload for iSCSI Target update requests. */
@Fluent
public final class IscsiTargetUpdate extends ProxyResource {
    /*
     * Properties for iSCSI Target update request.
     */
    @JsonProperty(value = "properties", required = true)
    private IscsiTargetUpdateProperties innerProperties = new IscsiTargetUpdateProperties();

    /*
     * Azure resource id. Indicates if this resource is managed by another Azure resource.
     */
    @JsonProperty(value = "managedBy")
    private String managedBy;

    /*
     * List of Azure resource ids that manage this resource.
     */
    @JsonProperty(value = "managedByExtended")
    private List<String> managedByExtended;

    /** Creates an instance of IscsiTargetUpdate class. */
    public IscsiTargetUpdate() {
    }

    /**
     * Get the innerProperties property: Properties for iSCSI Target update request.
     *
     * @return the innerProperties value.
     */
    private IscsiTargetUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the managedBy property: Azure resource id. Indicates if this resource is managed by another Azure resource.
     *
     * @return the managedBy value.
     */
    public String managedBy() {
        return this.managedBy;
    }

    /**
     * Set the managedBy property: Azure resource id. Indicates if this resource is managed by another Azure resource.
     *
     * @param managedBy the managedBy value to set.
     * @return the IscsiTargetUpdate object itself.
     */
    public IscsiTargetUpdate withManagedBy(String managedBy) {
        this.managedBy = managedBy;
        return this;
    }

    /**
     * Get the managedByExtended property: List of Azure resource ids that manage this resource.
     *
     * @return the managedByExtended value.
     */
    public List<String> managedByExtended() {
        return this.managedByExtended;
    }

    /**
     * Set the managedByExtended property: List of Azure resource ids that manage this resource.
     *
     * @param managedByExtended the managedByExtended value to set.
     * @return the IscsiTargetUpdate object itself.
     */
    public IscsiTargetUpdate withManagedByExtended(List<String> managedByExtended) {
        this.managedByExtended = managedByExtended;
        return this;
    }

    /**
     * Get the staticAcls property: Access Control List (ACL) for an iSCSI Target; defines LUN masking policy.
     *
     * @return the staticAcls value.
     */
    public List<Acl> staticAcls() {
        return this.innerProperties() == null ? null : this.innerProperties().staticAcls();
    }

    /**
     * Set the staticAcls property: Access Control List (ACL) for an iSCSI Target; defines LUN masking policy.
     *
     * @param staticAcls the staticAcls value to set.
     * @return the IscsiTargetUpdate object itself.
     */
    public IscsiTargetUpdate withStaticAcls(List<Acl> staticAcls) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IscsiTargetUpdateProperties();
        }
        this.innerProperties().withStaticAcls(staticAcls);
        return this;
    }

    /**
     * Get the luns property: List of LUNs to be exposed through iSCSI Target.
     *
     * @return the luns value.
     */
    public List<IscsiLun> luns() {
        return this.innerProperties() == null ? null : this.innerProperties().luns();
    }

    /**
     * Set the luns property: List of LUNs to be exposed through iSCSI Target.
     *
     * @param luns the luns value to set.
     * @return the IscsiTargetUpdate object itself.
     */
    public IscsiTargetUpdate withLuns(List<IscsiLun> luns) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IscsiTargetUpdateProperties();
        }
        this.innerProperties().withLuns(luns);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property innerProperties in model IscsiTargetUpdate"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IscsiTargetUpdate.class);
}
