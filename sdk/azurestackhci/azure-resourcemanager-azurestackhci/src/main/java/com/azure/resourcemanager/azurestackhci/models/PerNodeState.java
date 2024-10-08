// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Status of Arc agent for a particular node in HCI Cluster.
 */
@Immutable
public final class PerNodeState implements JsonSerializable<PerNodeState> {
    /*
     * Name of the Node in HCI Cluster
     */
    private String name;

    /*
     * Fully qualified resource ID for the Arc agent of this node.
     */
    private String arcInstance;

    /*
     * The service principal id of the arc for server node
     */
    private String arcNodeServicePrincipalObjectId;

    /*
     * State of Arc agent in this node.
     */
    private NodeArcState state;

    /**
     * Creates an instance of PerNodeState class.
     */
    public PerNodeState() {
    }

    /**
     * Get the name property: Name of the Node in HCI Cluster.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the arcInstance property: Fully qualified resource ID for the Arc agent of this node.
     * 
     * @return the arcInstance value.
     */
    public String arcInstance() {
        return this.arcInstance;
    }

    /**
     * Get the arcNodeServicePrincipalObjectId property: The service principal id of the arc for server node.
     * 
     * @return the arcNodeServicePrincipalObjectId value.
     */
    public String arcNodeServicePrincipalObjectId() {
        return this.arcNodeServicePrincipalObjectId;
    }

    /**
     * Get the state property: State of Arc agent in this node.
     * 
     * @return the state value.
     */
    public NodeArcState state() {
        return this.state;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PerNodeState from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PerNodeState if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PerNodeState.
     */
    public static PerNodeState fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PerNodeState deserializedPerNodeState = new PerNodeState();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedPerNodeState.name = reader.getString();
                } else if ("arcInstance".equals(fieldName)) {
                    deserializedPerNodeState.arcInstance = reader.getString();
                } else if ("arcNodeServicePrincipalObjectId".equals(fieldName)) {
                    deserializedPerNodeState.arcNodeServicePrincipalObjectId = reader.getString();
                } else if ("state".equals(fieldName)) {
                    deserializedPerNodeState.state = NodeArcState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPerNodeState;
        });
    }
}
