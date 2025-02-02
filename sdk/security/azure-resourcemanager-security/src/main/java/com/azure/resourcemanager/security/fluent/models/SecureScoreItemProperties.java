// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes properties of a calculated secure score.
 */
@Immutable
public final class SecureScoreItemProperties implements JsonSerializable<SecureScoreItemProperties> {
    /*
     * The initiative’s name
     */
    private String displayName;

    /*
     * score object
     */
    private ScoreDetails innerScore;

    /*
     * The relative weight for each subscription. Used when calculating an aggregated secure score for multiple
     * subscriptions.
     */
    private Long weight;

    /**
     * Creates an instance of SecureScoreItemProperties class.
     */
    public SecureScoreItemProperties() {
    }

    /**
     * Get the displayName property: The initiative’s name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Get the innerScore property: score object.
     * 
     * @return the innerScore value.
     */
    private ScoreDetails innerScore() {
        return this.innerScore;
    }

    /**
     * Get the weight property: The relative weight for each subscription. Used when calculating an aggregated secure
     * score for multiple subscriptions.
     * 
     * @return the weight value.
     */
    public Long weight() {
        return this.weight;
    }

    /**
     * Get the max property: Maximum score available.
     * 
     * @return the max value.
     */
    public Integer max() {
        return this.innerScore() == null ? null : this.innerScore().max();
    }

    /**
     * Get the current property: Current score.
     * 
     * @return the current value.
     */
    public Double current() {
        return this.innerScore() == null ? null : this.innerScore().current();
    }

    /**
     * Get the percentage property: Ratio of the current score divided by the maximum. Rounded to 4 digits after the
     * decimal point.
     * 
     * @return the percentage value.
     */
    public Double percentage() {
        return this.innerScore() == null ? null : this.innerScore().percentage();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerScore() != null) {
            innerScore().validate();
        }
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
     * Reads an instance of SecureScoreItemProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecureScoreItemProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SecureScoreItemProperties.
     */
    public static SecureScoreItemProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecureScoreItemProperties deserializedSecureScoreItemProperties = new SecureScoreItemProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedSecureScoreItemProperties.displayName = reader.getString();
                } else if ("score".equals(fieldName)) {
                    deserializedSecureScoreItemProperties.innerScore = ScoreDetails.fromJson(reader);
                } else if ("weight".equals(fieldName)) {
                    deserializedSecureScoreItemProperties.weight = reader.getNullable(JsonReader::getLong);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecureScoreItemProperties;
        });
    }
}
