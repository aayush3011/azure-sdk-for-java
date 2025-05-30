// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * SecretArchiveSettings represents the settings for the secret archive used to hold credentials for the cluster.
 */
@Fluent
public final class SecretArchiveSettings implements JsonSerializable<SecretArchiveSettings> {
    /*
     * The selection of the managed identity to use with this vault URI. The identity type must be either system
     * assigned or user assigned.
     */
    private IdentitySelector associatedIdentity;

    /*
     * The URI for the key vault used as the secret archive.
     */
    private String vaultUri;

    /**
     * Creates an instance of SecretArchiveSettings class.
     */
    public SecretArchiveSettings() {
    }

    /**
     * Get the associatedIdentity property: The selection of the managed identity to use with this vault URI. The
     * identity type must be either system assigned or user assigned.
     * 
     * @return the associatedIdentity value.
     */
    public IdentitySelector associatedIdentity() {
        return this.associatedIdentity;
    }

    /**
     * Set the associatedIdentity property: The selection of the managed identity to use with this vault URI. The
     * identity type must be either system assigned or user assigned.
     * 
     * @param associatedIdentity the associatedIdentity value to set.
     * @return the SecretArchiveSettings object itself.
     */
    public SecretArchiveSettings withAssociatedIdentity(IdentitySelector associatedIdentity) {
        this.associatedIdentity = associatedIdentity;
        return this;
    }

    /**
     * Get the vaultUri property: The URI for the key vault used as the secret archive.
     * 
     * @return the vaultUri value.
     */
    public String vaultUri() {
        return this.vaultUri;
    }

    /**
     * Set the vaultUri property: The URI for the key vault used as the secret archive.
     * 
     * @param vaultUri the vaultUri value to set.
     * @return the SecretArchiveSettings object itself.
     */
    public SecretArchiveSettings withVaultUri(String vaultUri) {
        this.vaultUri = vaultUri;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (associatedIdentity() != null) {
            associatedIdentity().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("associatedIdentity", this.associatedIdentity);
        jsonWriter.writeStringField("vaultUri", this.vaultUri);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecretArchiveSettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecretArchiveSettings if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SecretArchiveSettings.
     */
    public static SecretArchiveSettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecretArchiveSettings deserializedSecretArchiveSettings = new SecretArchiveSettings();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("associatedIdentity".equals(fieldName)) {
                    deserializedSecretArchiveSettings.associatedIdentity = IdentitySelector.fromJson(reader);
                } else if ("vaultUri".equals(fieldName)) {
                    deserializedSecretArchiveSettings.vaultUri = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecretArchiveSettings;
        });
    }
}
