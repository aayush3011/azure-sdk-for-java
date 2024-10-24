// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.purview.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.purview.models.OperationMetaServiceSpecification;
import java.io.IOException;

/**
 * properties on meta info.
 */
@Fluent
public final class OperationProperties implements JsonSerializable<OperationProperties> {
    /*
     * meta service specification
     */
    private OperationMetaServiceSpecification serviceSpecification;

    /**
     * Creates an instance of OperationProperties class.
     */
    public OperationProperties() {
    }

    /**
     * Get the serviceSpecification property: meta service specification.
     * 
     * @return the serviceSpecification value.
     */
    public OperationMetaServiceSpecification serviceSpecification() {
        return this.serviceSpecification;
    }

    /**
     * Set the serviceSpecification property: meta service specification.
     * 
     * @param serviceSpecification the serviceSpecification value to set.
     * @return the OperationProperties object itself.
     */
    public OperationProperties withServiceSpecification(OperationMetaServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (serviceSpecification() != null) {
            serviceSpecification().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("serviceSpecification", this.serviceSpecification);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OperationProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the OperationProperties.
     */
    public static OperationProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationProperties deserializedOperationProperties = new OperationProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serviceSpecification".equals(fieldName)) {
                    deserializedOperationProperties.serviceSpecification
                        = OperationMetaServiceSpecification.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationProperties;
        });
    }
}
