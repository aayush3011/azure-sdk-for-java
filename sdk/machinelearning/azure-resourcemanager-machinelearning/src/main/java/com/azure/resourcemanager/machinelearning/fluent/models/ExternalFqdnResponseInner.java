// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.machinelearning.models.FqdnEndpoints;
import java.io.IOException;
import java.util.List;

/**
 * The ExternalFqdnResponse model.
 */
@Fluent
public final class ExternalFqdnResponseInner implements JsonSerializable<ExternalFqdnResponseInner> {
    /*
     * The value property.
     */
    private List<FqdnEndpoints> value;

    /**
     * Creates an instance of ExternalFqdnResponseInner class.
     */
    public ExternalFqdnResponseInner() {
    }

    /**
     * Get the value property: The value property.
     * 
     * @return the value value.
     */
    public List<FqdnEndpoints> value() {
        return this.value;
    }

    /**
     * Set the value property: The value property.
     * 
     * @param value the value value to set.
     * @return the ExternalFqdnResponseInner object itself.
     */
    public ExternalFqdnResponseInner withValue(List<FqdnEndpoints> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExternalFqdnResponseInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExternalFqdnResponseInner if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExternalFqdnResponseInner.
     */
    public static ExternalFqdnResponseInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExternalFqdnResponseInner deserializedExternalFqdnResponseInner = new ExternalFqdnResponseInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<FqdnEndpoints> value = reader.readArray(reader1 -> FqdnEndpoints.fromJson(reader1));
                    deserializedExternalFqdnResponseInner.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExternalFqdnResponseInner;
        });
    }
}
