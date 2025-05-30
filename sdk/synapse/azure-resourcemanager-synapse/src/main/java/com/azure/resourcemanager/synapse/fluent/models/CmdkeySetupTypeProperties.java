// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.synapse.models.SecretBase;
import java.io.IOException;

/**
 * Cmdkey command custom setup type properties.
 */
@Fluent
public final class CmdkeySetupTypeProperties implements JsonSerializable<CmdkeySetupTypeProperties> {
    /*
     * The server name of data source access.
     */
    private Object targetName;

    /*
     * The user name of data source access.
     */
    private Object username;

    /*
     * The password of data source access.
     */
    private SecretBase password;

    /**
     * Creates an instance of CmdkeySetupTypeProperties class.
     */
    public CmdkeySetupTypeProperties() {
    }

    /**
     * Get the targetName property: The server name of data source access.
     * 
     * @return the targetName value.
     */
    public Object targetName() {
        return this.targetName;
    }

    /**
     * Set the targetName property: The server name of data source access.
     * 
     * @param targetName the targetName value to set.
     * @return the CmdkeySetupTypeProperties object itself.
     */
    public CmdkeySetupTypeProperties withTargetName(Object targetName) {
        this.targetName = targetName;
        return this;
    }

    /**
     * Get the username property: The user name of data source access.
     * 
     * @return the username value.
     */
    public Object username() {
        return this.username;
    }

    /**
     * Set the username property: The user name of data source access.
     * 
     * @param username the username value to set.
     * @return the CmdkeySetupTypeProperties object itself.
     */
    public CmdkeySetupTypeProperties withUsername(Object username) {
        this.username = username;
        return this;
    }

    /**
     * Get the password property: The password of data source access.
     * 
     * @return the password value.
     */
    public SecretBase password() {
        return this.password;
    }

    /**
     * Set the password property: The password of data source access.
     * 
     * @param password the password value to set.
     * @return the CmdkeySetupTypeProperties object itself.
     */
    public CmdkeySetupTypeProperties withPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (targetName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property targetName in model CmdkeySetupTypeProperties"));
        }
        if (username() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property username in model CmdkeySetupTypeProperties"));
        }
        if (password() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property password in model CmdkeySetupTypeProperties"));
        } else {
            password().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CmdkeySetupTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("targetName", this.targetName);
        jsonWriter.writeUntypedField("userName", this.username);
        jsonWriter.writeJsonField("password", this.password);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CmdkeySetupTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CmdkeySetupTypeProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CmdkeySetupTypeProperties.
     */
    public static CmdkeySetupTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CmdkeySetupTypeProperties deserializedCmdkeySetupTypeProperties = new CmdkeySetupTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("targetName".equals(fieldName)) {
                    deserializedCmdkeySetupTypeProperties.targetName = reader.readUntyped();
                } else if ("userName".equals(fieldName)) {
                    deserializedCmdkeySetupTypeProperties.username = reader.readUntyped();
                } else if ("password".equals(fieldName)) {
                    deserializedCmdkeySetupTypeProperties.password = SecretBase.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCmdkeySetupTypeProperties;
        });
    }
}
