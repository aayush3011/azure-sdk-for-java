// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The UserArtifactManage model.
 */
@Fluent
public final class UserArtifactManage implements JsonSerializable<UserArtifactManage> {
    /*
     * Required. The path and arguments to install the gallery application. This is limited to 4096 characters.
     */
    private String install;

    /*
     * Required. The path and arguments to remove the gallery application. This is limited to 4096 characters.
     */
    private String remove;

    /*
     * Optional. The path and arguments to update the gallery application. If not present, then update operation will
     * invoke remove command on the previous version and install command on the current version of the gallery
     * application. This is limited to 4096 characters.
     */
    private String update;

    /**
     * Creates an instance of UserArtifactManage class.
     */
    public UserArtifactManage() {
    }

    /**
     * Get the install property: Required. The path and arguments to install the gallery application. This is limited to
     * 4096 characters.
     * 
     * @return the install value.
     */
    public String install() {
        return this.install;
    }

    /**
     * Set the install property: Required. The path and arguments to install the gallery application. This is limited to
     * 4096 characters.
     * 
     * @param install the install value to set.
     * @return the UserArtifactManage object itself.
     */
    public UserArtifactManage withInstall(String install) {
        this.install = install;
        return this;
    }

    /**
     * Get the remove property: Required. The path and arguments to remove the gallery application. This is limited to
     * 4096 characters.
     * 
     * @return the remove value.
     */
    public String remove() {
        return this.remove;
    }

    /**
     * Set the remove property: Required. The path and arguments to remove the gallery application. This is limited to
     * 4096 characters.
     * 
     * @param remove the remove value to set.
     * @return the UserArtifactManage object itself.
     */
    public UserArtifactManage withRemove(String remove) {
        this.remove = remove;
        return this;
    }

    /**
     * Get the update property: Optional. The path and arguments to update the gallery application. If not present, then
     * update operation will invoke remove command on the previous version and install command on the current version of
     * the gallery application. This is limited to 4096 characters.
     * 
     * @return the update value.
     */
    public String update() {
        return this.update;
    }

    /**
     * Set the update property: Optional. The path and arguments to update the gallery application. If not present, then
     * update operation will invoke remove command on the previous version and install command on the current version of
     * the gallery application. This is limited to 4096 characters.
     * 
     * @param update the update value to set.
     * @return the UserArtifactManage object itself.
     */
    public UserArtifactManage withUpdate(String update) {
        this.update = update;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (install() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property install in model UserArtifactManage"));
        }
        if (remove() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property remove in model UserArtifactManage"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(UserArtifactManage.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("install", this.install);
        jsonWriter.writeStringField("remove", this.remove);
        jsonWriter.writeStringField("update", this.update);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UserArtifactManage from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UserArtifactManage if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the UserArtifactManage.
     */
    public static UserArtifactManage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UserArtifactManage deserializedUserArtifactManage = new UserArtifactManage();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("install".equals(fieldName)) {
                    deserializedUserArtifactManage.install = reader.getString();
                } else if ("remove".equals(fieldName)) {
                    deserializedUserArtifactManage.remove = reader.getString();
                } else if ("update".equals(fieldName)) {
                    deserializedUserArtifactManage.update = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUserArtifactManage;
        });
    }
}
