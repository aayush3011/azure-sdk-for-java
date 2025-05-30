// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotfirmwaredefense.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Properties of a reference link for a CVE.
 */
@Immutable
public final class CveLink implements JsonSerializable<CveLink> {
    /*
     * The destination of the reference link.
     */
    private String href;

    /*
     * The label of the reference link.
     */
    private String label;

    /**
     * Creates an instance of CveLink class.
     */
    private CveLink() {
    }

    /**
     * Get the href property: The destination of the reference link.
     * 
     * @return the href value.
     */
    public String href() {
        return this.href;
    }

    /**
     * Get the label property: The label of the reference link.
     * 
     * @return the label value.
     */
    public String label() {
        return this.label;
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
        jsonWriter.writeStringField("href", this.href);
        jsonWriter.writeStringField("label", this.label);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CveLink from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CveLink if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the CveLink.
     */
    public static CveLink fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CveLink deserializedCveLink = new CveLink();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("href".equals(fieldName)) {
                    deserializedCveLink.href = reader.getString();
                } else if ("label".equals(fieldName)) {
                    deserializedCveLink.label = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCveLink;
        });
    }
}
