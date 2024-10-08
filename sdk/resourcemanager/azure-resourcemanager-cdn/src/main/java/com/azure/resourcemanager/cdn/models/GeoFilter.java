// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Rules defining user's geo access within a CDN endpoint.
 */
@Fluent
public final class GeoFilter implements JsonSerializable<GeoFilter> {
    /*
     * Relative path applicable to geo filter. (e.g. '/mypictures', '/mypicture/kitty.jpg', and etc.)
     */
    private String relativePath;

    /*
     * Action of the geo filter, i.e. allow or block access.
     */
    private GeoFilterActions action;

    /*
     * Two letter country or region codes defining user country or region access in a geo filter, e.g. AU, MX, US.
     */
    private List<String> countryCodes;

    /**
     * Creates an instance of GeoFilter class.
     */
    public GeoFilter() {
    }

    /**
     * Get the relativePath property: Relative path applicable to geo filter. (e.g. '/mypictures',
     * '/mypicture/kitty.jpg', and etc.).
     * 
     * @return the relativePath value.
     */
    public String relativePath() {
        return this.relativePath;
    }

    /**
     * Set the relativePath property: Relative path applicable to geo filter. (e.g. '/mypictures',
     * '/mypicture/kitty.jpg', and etc.).
     * 
     * @param relativePath the relativePath value to set.
     * @return the GeoFilter object itself.
     */
    public GeoFilter withRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    /**
     * Get the action property: Action of the geo filter, i.e. allow or block access.
     * 
     * @return the action value.
     */
    public GeoFilterActions action() {
        return this.action;
    }

    /**
     * Set the action property: Action of the geo filter, i.e. allow or block access.
     * 
     * @param action the action value to set.
     * @return the GeoFilter object itself.
     */
    public GeoFilter withAction(GeoFilterActions action) {
        this.action = action;
        return this;
    }

    /**
     * Get the countryCodes property: Two letter country or region codes defining user country or region access in a geo
     * filter, e.g. AU, MX, US.
     * 
     * @return the countryCodes value.
     */
    public List<String> countryCodes() {
        return this.countryCodes;
    }

    /**
     * Set the countryCodes property: Two letter country or region codes defining user country or region access in a geo
     * filter, e.g. AU, MX, US.
     * 
     * @param countryCodes the countryCodes value to set.
     * @return the GeoFilter object itself.
     */
    public GeoFilter withCountryCodes(List<String> countryCodes) {
        this.countryCodes = countryCodes;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (relativePath() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property relativePath in model GeoFilter"));
        }
        if (action() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property action in model GeoFilter"));
        }
        if (countryCodes() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property countryCodes in model GeoFilter"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GeoFilter.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("relativePath", this.relativePath);
        jsonWriter.writeStringField("action", this.action == null ? null : this.action.toString());
        jsonWriter.writeArrayField("countryCodes", this.countryCodes, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GeoFilter from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GeoFilter if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GeoFilter.
     */
    public static GeoFilter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GeoFilter deserializedGeoFilter = new GeoFilter();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("relativePath".equals(fieldName)) {
                    deserializedGeoFilter.relativePath = reader.getString();
                } else if ("action".equals(fieldName)) {
                    deserializedGeoFilter.action = GeoFilterActions.fromString(reader.getString());
                } else if ("countryCodes".equals(fieldName)) {
                    List<String> countryCodes = reader.readArray(reader1 -> reader1.getString());
                    deserializedGeoFilter.countryCodes = countryCodes;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGeoFilter;
        });
    }
}
