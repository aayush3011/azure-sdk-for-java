// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Reference to an asset via its ARM resource ID.
 */
@Fluent
public final class IdAssetReference extends AssetReferenceBase {
    /*
     * [Required] Specifies the type of asset reference.
     */
    private ReferenceType referenceType = ReferenceType.ID;

    /*
     * [Required] ARM resource ID of the asset.
     */
    private String assetId;

    /**
     * Creates an instance of IdAssetReference class.
     */
    public IdAssetReference() {
    }

    /**
     * Get the referenceType property: [Required] Specifies the type of asset reference.
     * 
     * @return the referenceType value.
     */
    @Override
    public ReferenceType referenceType() {
        return this.referenceType;
    }

    /**
     * Get the assetId property: [Required] ARM resource ID of the asset.
     * 
     * @return the assetId value.
     */
    public String assetId() {
        return this.assetId;
    }

    /**
     * Set the assetId property: [Required] ARM resource ID of the asset.
     * 
     * @param assetId the assetId value to set.
     * @return the IdAssetReference object itself.
     */
    public IdAssetReference withAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (assetId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property assetId in model IdAssetReference"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IdAssetReference.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("assetId", this.assetId);
        jsonWriter.writeStringField("referenceType", this.referenceType == null ? null : this.referenceType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IdAssetReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IdAssetReference if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IdAssetReference.
     */
    public static IdAssetReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IdAssetReference deserializedIdAssetReference = new IdAssetReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("assetId".equals(fieldName)) {
                    deserializedIdAssetReference.assetId = reader.getString();
                } else if ("referenceType".equals(fieldName)) {
                    deserializedIdAssetReference.referenceType = ReferenceType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIdAssetReference;
        });
    }
}
