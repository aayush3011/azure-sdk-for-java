// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;

/**
 * scale settings for AML Compute.
 */
@Fluent
public final class ScaleSettings implements JsonSerializable<ScaleSettings> {
    /*
     * Max number of nodes to use
     */
    private int maxNodeCount;

    /*
     * Min number of nodes to use
     */
    private Integer minNodeCount;

    /*
     * Node Idle Time before scaling down amlCompute. This string needs to be in the RFC Format.
     */
    private Duration nodeIdleTimeBeforeScaleDown;

    /**
     * Creates an instance of ScaleSettings class.
     */
    public ScaleSettings() {
    }

    /**
     * Get the maxNodeCount property: Max number of nodes to use.
     * 
     * @return the maxNodeCount value.
     */
    public int maxNodeCount() {
        return this.maxNodeCount;
    }

    /**
     * Set the maxNodeCount property: Max number of nodes to use.
     * 
     * @param maxNodeCount the maxNodeCount value to set.
     * @return the ScaleSettings object itself.
     */
    public ScaleSettings withMaxNodeCount(int maxNodeCount) {
        this.maxNodeCount = maxNodeCount;
        return this;
    }

    /**
     * Get the minNodeCount property: Min number of nodes to use.
     * 
     * @return the minNodeCount value.
     */
    public Integer minNodeCount() {
        return this.minNodeCount;
    }

    /**
     * Set the minNodeCount property: Min number of nodes to use.
     * 
     * @param minNodeCount the minNodeCount value to set.
     * @return the ScaleSettings object itself.
     */
    public ScaleSettings withMinNodeCount(Integer minNodeCount) {
        this.minNodeCount = minNodeCount;
        return this;
    }

    /**
     * Get the nodeIdleTimeBeforeScaleDown property: Node Idle Time before scaling down amlCompute. This string needs to
     * be in the RFC Format.
     * 
     * @return the nodeIdleTimeBeforeScaleDown value.
     */
    public Duration nodeIdleTimeBeforeScaleDown() {
        return this.nodeIdleTimeBeforeScaleDown;
    }

    /**
     * Set the nodeIdleTimeBeforeScaleDown property: Node Idle Time before scaling down amlCompute. This string needs to
     * be in the RFC Format.
     * 
     * @param nodeIdleTimeBeforeScaleDown the nodeIdleTimeBeforeScaleDown value to set.
     * @return the ScaleSettings object itself.
     */
    public ScaleSettings withNodeIdleTimeBeforeScaleDown(Duration nodeIdleTimeBeforeScaleDown) {
        this.nodeIdleTimeBeforeScaleDown = nodeIdleTimeBeforeScaleDown;
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
        jsonWriter.writeIntField("maxNodeCount", this.maxNodeCount);
        jsonWriter.writeNumberField("minNodeCount", this.minNodeCount);
        jsonWriter.writeStringField("nodeIdleTimeBeforeScaleDown",
            CoreUtils.durationToStringWithDays(this.nodeIdleTimeBeforeScaleDown));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ScaleSettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ScaleSettings if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ScaleSettings.
     */
    public static ScaleSettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ScaleSettings deserializedScaleSettings = new ScaleSettings();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("maxNodeCount".equals(fieldName)) {
                    deserializedScaleSettings.maxNodeCount = reader.getInt();
                } else if ("minNodeCount".equals(fieldName)) {
                    deserializedScaleSettings.minNodeCount = reader.getNullable(JsonReader::getInt);
                } else if ("nodeIdleTimeBeforeScaleDown".equals(fieldName)) {
                    deserializedScaleSettings.nodeIdleTimeBeforeScaleDown
                        = reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedScaleSettings;
        });
    }
}
