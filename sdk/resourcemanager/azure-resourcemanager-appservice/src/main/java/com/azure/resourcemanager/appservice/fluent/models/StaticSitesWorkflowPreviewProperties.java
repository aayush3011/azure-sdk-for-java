// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * StaticSitesWorkflowPreview resource specific properties.
 */
@Immutable
public final class StaticSitesWorkflowPreviewProperties
    implements JsonSerializable<StaticSitesWorkflowPreviewProperties> {
    /*
     * The path for the workflow file to be generated
     */
    private String path;

    /*
     * The contents for the workflow file to be generated
     */
    private String contents;

    /**
     * Creates an instance of StaticSitesWorkflowPreviewProperties class.
     */
    public StaticSitesWorkflowPreviewProperties() {
    }

    /**
     * Get the path property: The path for the workflow file to be generated.
     * 
     * @return the path value.
     */
    public String path() {
        return this.path;
    }

    /**
     * Get the contents property: The contents for the workflow file to be generated.
     * 
     * @return the contents value.
     */
    public String contents() {
        return this.contents;
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
     * Reads an instance of StaticSitesWorkflowPreviewProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StaticSitesWorkflowPreviewProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the StaticSitesWorkflowPreviewProperties.
     */
    public static StaticSitesWorkflowPreviewProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StaticSitesWorkflowPreviewProperties deserializedStaticSitesWorkflowPreviewProperties
                = new StaticSitesWorkflowPreviewProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("path".equals(fieldName)) {
                    deserializedStaticSitesWorkflowPreviewProperties.path = reader.getString();
                } else if ("contents".equals(fieldName)) {
                    deserializedStaticSitesWorkflowPreviewProperties.contents = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStaticSitesWorkflowPreviewProperties;
        });
    }
}
