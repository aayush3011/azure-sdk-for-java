// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.hybridnetwork.models.ArtifactManifestState;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The artifact manifest updating request payload. Only the 'Uploaded' state is allowed for updates. Other states are
 * used for internal state transitioning.
 */
@Fluent
public final class ArtifactManifestUpdateStateInner {
    /*
     * The artifact manifest state.
     */
    @JsonProperty(value = "artifactManifestState")
    private ArtifactManifestState artifactManifestState;

    /**
     * Creates an instance of ArtifactManifestUpdateStateInner class.
     */
    public ArtifactManifestUpdateStateInner() {
    }

    /**
     * Get the artifactManifestState property: The artifact manifest state.
     * 
     * @return the artifactManifestState value.
     */
    public ArtifactManifestState artifactManifestState() {
        return this.artifactManifestState;
    }

    /**
     * Set the artifactManifestState property: The artifact manifest state.
     * 
     * @param artifactManifestState the artifactManifestState value to set.
     * @return the ArtifactManifestUpdateStateInner object itself.
     */
    public ArtifactManifestUpdateStateInner withArtifactManifestState(ArtifactManifestState artifactManifestState) {
        this.artifactManifestState = artifactManifestState;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
