// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The PE network resource that is linked to this PE connection.
 */
@Fluent
public final class PrivateEndpointResource extends PrivateEndpoint {
    /*
     * The subnetId that the private endpoint is connected to.
     */
    private String subnetArmId;

    /*
     * The ARM identifier for Private Endpoint
     */
    private String id;

    /**
     * Creates an instance of PrivateEndpointResource class.
     */
    public PrivateEndpointResource() {
    }

    /**
     * Get the subnetArmId property: The subnetId that the private endpoint is connected to.
     * 
     * @return the subnetArmId value.
     */
    public String subnetArmId() {
        return this.subnetArmId;
    }

    /**
     * Set the subnetArmId property: The subnetId that the private endpoint is connected to.
     * 
     * @param subnetArmId the subnetArmId value to set.
     * @return the PrivateEndpointResource object itself.
     */
    public PrivateEndpointResource withSubnetArmId(String subnetArmId) {
        this.subnetArmId = subnetArmId;
        return this;
    }

    /**
     * Get the id property: The ARM identifier for Private Endpoint.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("subnetArmId", this.subnetArmId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PrivateEndpointResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrivateEndpointResource if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PrivateEndpointResource.
     */
    public static PrivateEndpointResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrivateEndpointResource deserializedPrivateEndpointResource = new PrivateEndpointResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedPrivateEndpointResource.id = reader.getString();
                } else if ("subnetArmId".equals(fieldName)) {
                    deserializedPrivateEndpointResource.subnetArmId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrivateEndpointResource;
        });
    }
}
