// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Statistics related to Pool usage information.
 */
@Immutable
public final class BatchPoolUsageStatistics implements JsonSerializable<BatchPoolUsageStatistics> {

    /*
     * The start time of the time range covered by the statistics.
     */
    @Generated
    private final OffsetDateTime startTime;

    /*
     * The time at which the statistics were last updated. All statistics are limited to the range between startTime and lastUpdateTime.
     */
    @Generated
    private final OffsetDateTime lastUpdateTime;

    /*
     * The aggregated wall-clock time of the dedicated Compute Node cores being part of the Pool.
     */
    @Generated
    private final Duration dedicatedCoreTime;

    /**
     * Creates an instance of BatchPoolUsageStatistics class.
     *
     * @param startTime the startTime value to set.
     * @param lastUpdateTime the lastUpdateTime value to set.
     * @param dedicatedCoreTime the dedicatedCoreTime value to set.
     */
    @Generated
    private BatchPoolUsageStatistics(OffsetDateTime startTime, OffsetDateTime lastUpdateTime,
        Duration dedicatedCoreTime) {
        this.startTime = startTime;
        this.lastUpdateTime = lastUpdateTime;
        this.dedicatedCoreTime = dedicatedCoreTime;
    }

    /**
     * Get the startTime property: The start time of the time range covered by the statistics.
     *
     * @return the startTime value.
     */
    @Generated
    public OffsetDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Get the lastUpdateTime property: The time at which the statistics were last updated. All statistics are limited
     * to the range between startTime and lastUpdateTime.
     *
     * @return the lastUpdateTime value.
     */
    @Generated
    public OffsetDateTime getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /**
     * Get the dedicatedCoreTime property: The aggregated wall-clock time of the dedicated Compute Node cores being part
     * of the Pool.
     *
     * @return the dedicatedCoreTime value.
     */
    @Generated
    public Duration getDedicatedCoreTime() {
        return this.dedicatedCoreTime;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("startTime",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("lastUpdateTime",
            this.lastUpdateTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.lastUpdateTime));
        jsonWriter.writeStringField("dedicatedCoreTime", CoreUtils.durationToStringWithDays(this.dedicatedCoreTime));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BatchPoolUsageStatistics from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of BatchPoolUsageStatistics if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BatchPoolUsageStatistics.
     */
    @Generated
    public static BatchPoolUsageStatistics fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OffsetDateTime startTime = null;
            OffsetDateTime lastUpdateTime = null;
            Duration dedicatedCoreTime = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("startTime".equals(fieldName)) {
                    startTime = reader.getNullable(nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                } else if ("lastUpdateTime".equals(fieldName)) {
                    lastUpdateTime
                        = reader.getNullable(nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                } else if ("dedicatedCoreTime".equals(fieldName)) {
                    dedicatedCoreTime = reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }
            return new BatchPoolUsageStatistics(startTime, lastUpdateTime, dedicatedCoreTime);
        });
    }
}
