// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.radiologyinsights.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Stage/grade, usually assessed formally
 * Based on [FHIR Condition.Stage](https://www.hl7.org/fhir/R4/condition.html).
 */
@Immutable
public final class FhirR4ConditionStage implements JsonSerializable<FhirR4ConditionStage> {

    /*
     * Simple summary (disease specific)
     */
    @Generated
    private FhirR4CodeableConcept summary;

    /*
     * Kind of staging
     */
    @Generated
    private FhirR4CodeableConcept type;

    /**
     * Creates an instance of FhirR4ConditionStage class.
     */
    @Generated
    private FhirR4ConditionStage() {
    }

    /**
     * Get the summary property: Simple summary (disease specific).
     *
     * @return the summary value.
     */
    @Generated
    public FhirR4CodeableConcept getSummary() {
        return this.summary;
    }

    /**
     * Get the type property: Kind of staging.
     *
     * @return the type value.
     */
    @Generated
    public FhirR4CodeableConcept getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("summary", this.summary);
        jsonWriter.writeJsonField("type", this.type);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FhirR4ConditionStage from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FhirR4ConditionStage if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the FhirR4ConditionStage.
     */
    @Generated
    public static FhirR4ConditionStage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FhirR4ConditionStage deserializedFhirR4ConditionStage = new FhirR4ConditionStage();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("summary".equals(fieldName)) {
                    deserializedFhirR4ConditionStage.summary = FhirR4CodeableConcept.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedFhirR4ConditionStage.type = FhirR4CodeableConcept.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedFhirR4ConditionStage;
        });
    }
}
