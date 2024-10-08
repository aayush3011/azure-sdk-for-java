// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.search.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Identity for the resource.
 */
@Fluent
public final class Identity implements JsonSerializable<Identity> {
    /*
     * The principal ID of the system-assigned identity of the search service.
     */
    private String principalId;

    /*
     * The tenant ID of the system-assigned identity of the search service.
     */
    private String tenantId;

    /*
     * The identity type.
     */
    private IdentityType type;

    /**
     * Creates an instance of Identity class.
     */
    public Identity() {
    }

    /**
     * Get the principalId property: The principal ID of the system-assigned identity of the search service.
     * 
     * @return the principalId value.
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Get the tenantId property: The tenant ID of the system-assigned identity of the search service.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Get the type property: The identity type.
     * 
     * @return the type value.
     */
    public IdentityType type() {
        return this.type;
    }

    /**
     * Set the type property: The identity type.
     * 
     * @param type the type value to set.
     * @return the Identity object itself.
     */
    public Identity withType(IdentityType type) {
        this.type = type;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (type() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property type in model Identity"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(Identity.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Identity from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Identity if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the Identity.
     */
    public static Identity fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Identity deserializedIdentity = new Identity();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedIdentity.type = IdentityType.fromString(reader.getString());
                } else if ("principalId".equals(fieldName)) {
                    deserializedIdentity.principalId = reader.getString();
                } else if ("tenantId".equals(fieldName)) {
                    deserializedIdentity.tenantId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIdentity;
        });
    }
}
