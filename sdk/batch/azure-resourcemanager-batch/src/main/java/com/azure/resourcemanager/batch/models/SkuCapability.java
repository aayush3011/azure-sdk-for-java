// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A SKU capability, such as the number of cores.
 */
@Immutable
public final class SkuCapability implements JsonSerializable<SkuCapability> {
    /*
     * The name of the feature.
     */
    private String name;

    /*
     * The value of the feature.
     */
    private String value;

    /**
     * Creates an instance of SkuCapability class.
     */
    public SkuCapability() {
    }

    /**
     * Get the name property: The name of the feature.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the value property: The value of the feature.
     * 
     * @return the value value.
     */
    public String value() {
        return this.value;
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
     * Reads an instance of SkuCapability from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SkuCapability if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SkuCapability.
     */
    public static SkuCapability fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SkuCapability deserializedSkuCapability = new SkuCapability();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedSkuCapability.name = reader.getString();
                } else if ("value".equals(fieldName)) {
                    deserializedSkuCapability.value = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSkuCapability;
        });
    }
}
