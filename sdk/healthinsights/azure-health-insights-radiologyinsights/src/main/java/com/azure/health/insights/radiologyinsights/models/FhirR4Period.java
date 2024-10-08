// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.radiologyinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A time period defined by a start and end date and optionally time
 * Based on [FHIR Period](https://www.hl7.org/fhir/R4/datatypes.html#Period).
 */
@Fluent
public final class FhirR4Period extends FhirR4Element {

    /*
     * Starting time with inclusive boundary
     */
    @Generated
    private String start;

    /*
     * End time with inclusive boundary, if not ongoing
     */
    @Generated
    private String end;

    /**
     * Creates an instance of FhirR4Period class.
     */
    @Generated
    public FhirR4Period() {
    }

    /**
     * Get the start property: Starting time with inclusive boundary.
     *
     * @return the start value.
     */
    @Generated
    public String getStart() {
        return this.start;
    }

    /**
     * Set the start property: Starting time with inclusive boundary.
     *
     * @param start the start value to set.
     * @return the FhirR4Period object itself.
     */
    @Generated
    public FhirR4Period setStart(String start) {
        this.start = start;
        return this;
    }

    /**
     * Get the end property: End time with inclusive boundary, if not ongoing.
     *
     * @return the end value.
     */
    @Generated
    public String getEnd() {
        return this.end;
    }

    /**
     * Set the end property: End time with inclusive boundary, if not ongoing.
     *
     * @param end the end value to set.
     * @return the FhirR4Period object itself.
     */
    @Generated
    public FhirR4Period setEnd(String end) {
        this.end = end;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public FhirR4Period setId(String id) {
        super.setId(id);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public FhirR4Period setExtension(List<FhirR4Extension> extension) {
        super.setExtension(extension);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", getId());
        jsonWriter.writeArrayField("extension", getExtension(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("start", this.start);
        jsonWriter.writeStringField("end", this.end);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FhirR4Period from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FhirR4Period if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the FhirR4Period.
     */
    @Generated
    public static FhirR4Period fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FhirR4Period deserializedFhirR4Period = new FhirR4Period();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    deserializedFhirR4Period.setId(reader.getString());
                } else if ("extension".equals(fieldName)) {
                    List<FhirR4Extension> extension = reader.readArray(reader1 -> FhirR4Extension.fromJson(reader1));
                    deserializedFhirR4Period.setExtension(extension);
                } else if ("start".equals(fieldName)) {
                    deserializedFhirR4Period.start = reader.getString();
                } else if ("end".equals(fieldName)) {
                    deserializedFhirR4Period.end = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedFhirR4Period;
        });
    }
}
