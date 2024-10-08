// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.vision.face.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Candidate for identify call.
 */
@Immutable
public final class FaceIdentificationCandidate implements JsonSerializable<FaceIdentificationCandidate> {

    /*
     * personId of candidate person.
     */
    @Generated
    private final String personId;

    /*
     * Confidence value of the candidate. The higher confidence, the more similar. Range between [0,1].
     */
    @Generated
    private final double confidence;

    /**
     * Creates an instance of FaceIdentificationCandidate class.
     *
     * @param personId the personId value to set.
     * @param confidence the confidence value to set.
     */
    @Generated
    private FaceIdentificationCandidate(String personId, double confidence) {
        this.personId = personId;
        this.confidence = confidence;
    }

    /**
     * Get the personId property: personId of candidate person.
     *
     * @return the personId value.
     */
    @Generated
    public String getPersonId() {
        return this.personId;
    }

    /**
     * Get the confidence property: Confidence value of the candidate. The higher confidence, the more similar. Range
     * between [0,1].
     *
     * @return the confidence value.
     */
    @Generated
    public double getConfidence() {
        return this.confidence;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("personId", this.personId);
        jsonWriter.writeDoubleField("confidence", this.confidence);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FaceIdentificationCandidate from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FaceIdentificationCandidate if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FaceIdentificationCandidate.
     */
    @Generated
    public static FaceIdentificationCandidate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String personId = null;
            double confidence = 0.0;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("personId".equals(fieldName)) {
                    personId = reader.getString();
                } else if ("confidence".equals(fieldName)) {
                    confidence = reader.getDouble();
                } else {
                    reader.skipChildren();
                }
            }
            return new FaceIdentificationCandidate(personId, confidence);
        });
    }
}
