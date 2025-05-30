// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The configuration of dataset in the report.
 */
@Fluent
public final class ReportConfigDatasetConfiguration implements JsonSerializable<ReportConfigDatasetConfiguration> {
    /*
     * Array of column names to be included in the report. Any valid report column name is allowed. If not provided,
     * then report includes all columns.
     */
    private List<String> columns;

    /**
     * Creates an instance of ReportConfigDatasetConfiguration class.
     */
    public ReportConfigDatasetConfiguration() {
    }

    /**
     * Get the columns property: Array of column names to be included in the report. Any valid report column name is
     * allowed. If not provided, then report includes all columns.
     * 
     * @return the columns value.
     */
    public List<String> columns() {
        return this.columns;
    }

    /**
     * Set the columns property: Array of column names to be included in the report. Any valid report column name is
     * allowed. If not provided, then report includes all columns.
     * 
     * @param columns the columns value to set.
     * @return the ReportConfigDatasetConfiguration object itself.
     */
    public ReportConfigDatasetConfiguration withColumns(List<String> columns) {
        this.columns = columns;
        return this;
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
        jsonWriter.writeArrayField("columns", this.columns, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ReportConfigDatasetConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ReportConfigDatasetConfiguration if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ReportConfigDatasetConfiguration.
     */
    public static ReportConfigDatasetConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ReportConfigDatasetConfiguration deserializedReportConfigDatasetConfiguration
                = new ReportConfigDatasetConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("columns".equals(fieldName)) {
                    List<String> columns = reader.readArray(reader1 -> reader1.getString());
                    deserializedReportConfigDatasetConfiguration.columns = columns;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedReportConfigDatasetConfiguration;
        });
    }
}
