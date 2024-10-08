// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Metadata pertaining to the geographic location of the resource.
 */
@Fluent
public final class LocationData implements JsonSerializable<LocationData> {
    /*
     * A canonical name for the geographic or physical location.
     */
    private String name;

    /*
     * The city or locality where the resource is located.
     */
    private String city;

    /*
     * The district, state, or province where the resource is located.
     */
    private String district;

    /*
     * The country or region where the resource is located
     */
    private String countryOrRegion;

    /**
     * Creates an instance of LocationData class.
     */
    public LocationData() {
    }

    /**
     * Get the name property: A canonical name for the geographic or physical location.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: A canonical name for the geographic or physical location.
     * 
     * @param name the name value to set.
     * @return the LocationData object itself.
     */
    public LocationData withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the city property: The city or locality where the resource is located.
     * 
     * @return the city value.
     */
    public String city() {
        return this.city;
    }

    /**
     * Set the city property: The city or locality where the resource is located.
     * 
     * @param city the city value to set.
     * @return the LocationData object itself.
     */
    public LocationData withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Get the district property: The district, state, or province where the resource is located.
     * 
     * @return the district value.
     */
    public String district() {
        return this.district;
    }

    /**
     * Set the district property: The district, state, or province where the resource is located.
     * 
     * @param district the district value to set.
     * @return the LocationData object itself.
     */
    public LocationData withDistrict(String district) {
        this.district = district;
        return this;
    }

    /**
     * Get the countryOrRegion property: The country or region where the resource is located.
     * 
     * @return the countryOrRegion value.
     */
    public String countryOrRegion() {
        return this.countryOrRegion;
    }

    /**
     * Set the countryOrRegion property: The country or region where the resource is located.
     * 
     * @param countryOrRegion the countryOrRegion value to set.
     * @return the LocationData object itself.
     */
    public LocationData withCountryOrRegion(String countryOrRegion) {
        this.countryOrRegion = countryOrRegion;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model LocationData"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(LocationData.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("city", this.city);
        jsonWriter.writeStringField("district", this.district);
        jsonWriter.writeStringField("countryOrRegion", this.countryOrRegion);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LocationData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LocationData if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LocationData.
     */
    public static LocationData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LocationData deserializedLocationData = new LocationData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedLocationData.name = reader.getString();
                } else if ("city".equals(fieldName)) {
                    deserializedLocationData.city = reader.getString();
                } else if ("district".equals(fieldName)) {
                    deserializedLocationData.district = reader.getString();
                } else if ("countryOrRegion".equals(fieldName)) {
                    deserializedLocationData.countryOrRegion = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLocationData;
        });
    }
}
