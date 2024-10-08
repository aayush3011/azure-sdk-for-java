// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An arm role receiver.
 */
@Fluent
public final class ArmRoleReceiver implements JsonSerializable<ArmRoleReceiver> {
    /*
     * The name of the arm role receiver. Names must be unique across all receivers within an action group.
     */
    private String name;

    /*
     * The arm role id.
     */
    private String roleId;

    /*
     * Indicates whether to use common alert schema.
     */
    private Boolean useCommonAlertSchema;

    /**
     * Creates an instance of ArmRoleReceiver class.
     */
    public ArmRoleReceiver() {
    }

    /**
     * Get the name property: The name of the arm role receiver. Names must be unique across all receivers within an
     * action group.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the arm role receiver. Names must be unique across all receivers within an
     * action group.
     * 
     * @param name the name value to set.
     * @return the ArmRoleReceiver object itself.
     */
    public ArmRoleReceiver withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the roleId property: The arm role id.
     * 
     * @return the roleId value.
     */
    public String roleId() {
        return this.roleId;
    }

    /**
     * Set the roleId property: The arm role id.
     * 
     * @param roleId the roleId value to set.
     * @return the ArmRoleReceiver object itself.
     */
    public ArmRoleReceiver withRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    /**
     * Get the useCommonAlertSchema property: Indicates whether to use common alert schema.
     * 
     * @return the useCommonAlertSchema value.
     */
    public Boolean useCommonAlertSchema() {
        return this.useCommonAlertSchema;
    }

    /**
     * Set the useCommonAlertSchema property: Indicates whether to use common alert schema.
     * 
     * @param useCommonAlertSchema the useCommonAlertSchema value to set.
     * @return the ArmRoleReceiver object itself.
     */
    public ArmRoleReceiver withUseCommonAlertSchema(Boolean useCommonAlertSchema) {
        this.useCommonAlertSchema = useCommonAlertSchema;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model ArmRoleReceiver"));
        }
        if (roleId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property roleId in model ArmRoleReceiver"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ArmRoleReceiver.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("roleId", this.roleId);
        jsonWriter.writeBooleanField("useCommonAlertSchema", this.useCommonAlertSchema);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ArmRoleReceiver from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ArmRoleReceiver if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ArmRoleReceiver.
     */
    public static ArmRoleReceiver fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ArmRoleReceiver deserializedArmRoleReceiver = new ArmRoleReceiver();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedArmRoleReceiver.name = reader.getString();
                } else if ("roleId".equals(fieldName)) {
                    deserializedArmRoleReceiver.roleId = reader.getString();
                } else if ("useCommonAlertSchema".equals(fieldName)) {
                    deserializedArmRoleReceiver.useCommonAlertSchema = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedArmRoleReceiver;
        });
    }
}
