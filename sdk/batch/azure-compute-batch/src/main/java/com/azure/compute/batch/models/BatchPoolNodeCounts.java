// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The number of Compute Nodes in each state for a Pool.
 */
@Immutable
public final class BatchPoolNodeCounts implements JsonSerializable<BatchPoolNodeCounts> {

    /*
     * The ID of the Pool.
     */
    @Generated
    private final String poolId;

    /*
     * The number of dedicated Compute Nodes in each state.
     */
    @Generated
    private BatchNodeCounts dedicated;

    /*
     * The number of Spot/Low-priority Compute Nodes in each state.
     */
    @Generated
    private BatchNodeCounts lowPriority;

    /**
     * Creates an instance of BatchPoolNodeCounts class.
     *
     * @param poolId the poolId value to set.
     */
    @Generated
    private BatchPoolNodeCounts(String poolId) {
        this.poolId = poolId;
    }

    /**
     * Get the poolId property: The ID of the Pool.
     *
     * @return the poolId value.
     */
    @Generated
    public String getPoolId() {
        return this.poolId;
    }

    /**
     * Get the dedicated property: The number of dedicated Compute Nodes in each state.
     *
     * @return the dedicated value.
     */
    @Generated
    public BatchNodeCounts getDedicated() {
        return this.dedicated;
    }

    /**
     * Get the lowPriority property: The number of Spot/Low-priority Compute Nodes in each state.
     *
     * @return the lowPriority value.
     */
    @Generated
    public BatchNodeCounts getLowPriority() {
        return this.lowPriority;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("poolId", this.poolId);
        jsonWriter.writeJsonField("dedicated", this.dedicated);
        jsonWriter.writeJsonField("lowPriority", this.lowPriority);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BatchPoolNodeCounts from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of BatchPoolNodeCounts if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BatchPoolNodeCounts.
     */
    @Generated
    public static BatchPoolNodeCounts fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String poolId = null;
            BatchNodeCounts dedicated = null;
            BatchNodeCounts lowPriority = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("poolId".equals(fieldName)) {
                    poolId = reader.getString();
                } else if ("dedicated".equals(fieldName)) {
                    dedicated = BatchNodeCounts.fromJson(reader);
                } else if ("lowPriority".equals(fieldName)) {
                    lowPriority = BatchNodeCounts.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            BatchPoolNodeCounts deserializedBatchPoolNodeCounts = new BatchPoolNodeCounts(poolId);
            deserializedBatchPoolNodeCounts.dedicated = dedicated;
            deserializedBatchPoolNodeCounts.lowPriority = lowPriority;
            return deserializedBatchPoolNodeCounts;
        });
    }
}
