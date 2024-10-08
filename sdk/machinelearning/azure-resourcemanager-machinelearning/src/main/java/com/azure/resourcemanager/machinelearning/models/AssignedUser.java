// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A user that can be assigned to a compute instance.
 */
@Fluent
public final class AssignedUser implements JsonSerializable<AssignedUser> {
    /*
     * User’s AAD Object Id.
     */
    private String objectId;

    /*
     * User’s AAD Tenant Id.
     */
    private String tenantId;

    /**
     * Creates an instance of AssignedUser class.
     */
    public AssignedUser() {
    }

    /**
     * Get the objectId property: User’s AAD Object Id.
     * 
     * @return the objectId value.
     */
    public String objectId() {
        return this.objectId;
    }

    /**
     * Set the objectId property: User’s AAD Object Id.
     * 
     * @param objectId the objectId value to set.
     * @return the AssignedUser object itself.
     */
    public AssignedUser withObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    /**
     * Get the tenantId property: User’s AAD Tenant Id.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Set the tenantId property: User’s AAD Tenant Id.
     * 
     * @param tenantId the tenantId value to set.
     * @return the AssignedUser object itself.
     */
    public AssignedUser withTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (objectId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property objectId in model AssignedUser"));
        }
        if (tenantId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property tenantId in model AssignedUser"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AssignedUser.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("objectId", this.objectId);
        jsonWriter.writeStringField("tenantId", this.tenantId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AssignedUser from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AssignedUser if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AssignedUser.
     */
    public static AssignedUser fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AssignedUser deserializedAssignedUser = new AssignedUser();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("objectId".equals(fieldName)) {
                    deserializedAssignedUser.objectId = reader.getString();
                } else if ("tenantId".equals(fieldName)) {
                    deserializedAssignedUser.tenantId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAssignedUser;
        });
    }
}
