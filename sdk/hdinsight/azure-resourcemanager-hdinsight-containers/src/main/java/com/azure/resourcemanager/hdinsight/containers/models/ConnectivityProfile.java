// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.containers.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Cluster connectivity profile.
 */
@Fluent
public final class ConnectivityProfile implements JsonSerializable<ConnectivityProfile> {
    /*
     * Web connectivity endpoint details.
     */
    private ConnectivityProfileWeb web;

    /*
     * List of SSH connectivity endpoints.
     */
    private List<SshConnectivityEndpoint> ssh;

    /**
     * Creates an instance of ConnectivityProfile class.
     */
    public ConnectivityProfile() {
    }

    /**
     * Get the web property: Web connectivity endpoint details.
     * 
     * @return the web value.
     */
    public ConnectivityProfileWeb web() {
        return this.web;
    }

    /**
     * Set the web property: Web connectivity endpoint details.
     * 
     * @param web the web value to set.
     * @return the ConnectivityProfile object itself.
     */
    public ConnectivityProfile withWeb(ConnectivityProfileWeb web) {
        this.web = web;
        return this;
    }

    /**
     * Get the ssh property: List of SSH connectivity endpoints.
     * 
     * @return the ssh value.
     */
    public List<SshConnectivityEndpoint> ssh() {
        return this.ssh;
    }

    /**
     * Set the ssh property: List of SSH connectivity endpoints.
     * 
     * @param ssh the ssh value to set.
     * @return the ConnectivityProfile object itself.
     */
    public ConnectivityProfile withSsh(List<SshConnectivityEndpoint> ssh) {
        this.ssh = ssh;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (web() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property web in model ConnectivityProfile"));
        } else {
            web().validate();
        }
        if (ssh() != null) {
            ssh().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ConnectivityProfile.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("web", this.web);
        jsonWriter.writeArrayField("ssh", this.ssh, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ConnectivityProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectivityProfile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ConnectivityProfile.
     */
    public static ConnectivityProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectivityProfile deserializedConnectivityProfile = new ConnectivityProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("web".equals(fieldName)) {
                    deserializedConnectivityProfile.web = ConnectivityProfileWeb.fromJson(reader);
                } else if ("ssh".equals(fieldName)) {
                    List<SshConnectivityEndpoint> ssh
                        = reader.readArray(reader1 -> SshConnectivityEndpoint.fromJson(reader1));
                    deserializedConnectivityProfile.ssh = ssh;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectivityProfile;
        });
    }
}
