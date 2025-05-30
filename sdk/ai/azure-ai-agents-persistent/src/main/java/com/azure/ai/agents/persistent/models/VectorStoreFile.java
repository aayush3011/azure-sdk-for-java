// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.agents.persistent.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Description of a file attached to a vector store.
 */
@Immutable
public final class VectorStoreFile implements JsonSerializable<VectorStoreFile> {

    /*
     * The identifier, which can be referenced in API endpoints.
     */
    @Generated
    private final String id;

    /*
     * The object type, which is always `vector_store.file`.
     */
    @Generated
    private final String object = "vector_store.file";

    /*
     * The total vector store usage in bytes. Note that this may be different from the original file
     * size.
     */
    @Generated
    private final int usageBytes;

    /*
     * The Unix timestamp (in seconds) for when the vector store file was created.
     */
    @Generated
    private final long createdAt;

    /*
     * The ID of the vector store that the file is attached to.
     */
    @Generated
    private final String vectorStoreId;

    /*
     * The status of the vector store file, which can be either `in_progress`, `completed`, `cancelled`, or `failed`.
     * The status `completed` indicates that the vector store file is ready for use.
     */
    @Generated
    private final VectorStoreFileStatus status;

    /*
     * The last error associated with this vector store file. Will be `null` if there are no errors.
     */
    @Generated
    private final VectorStoreFileError lastError;

    /*
     * The strategy used to chunk the file.
     */
    @Generated
    private final VectorStoreChunkingStrategyResponse chunkingStrategy;

    /**
     * Creates an instance of VectorStoreFile class.
     *
     * @param id the id value to set.
     * @param usageBytes the usageBytes value to set.
     * @param createdAt the createdAt value to set.
     * @param vectorStoreId the vectorStoreId value to set.
     * @param status the status value to set.
     * @param lastError the lastError value to set.
     * @param chunkingStrategy the chunkingStrategy value to set.
     */
    @Generated
    private VectorStoreFile(String id, int usageBytes, OffsetDateTime createdAt, String vectorStoreId,
        VectorStoreFileStatus status, VectorStoreFileError lastError,
        VectorStoreChunkingStrategyResponse chunkingStrategy) {
        this.id = id;
        this.usageBytes = usageBytes;
        if (createdAt == null) {
            this.createdAt = 0L;
        } else {
            this.createdAt = createdAt.toEpochSecond();
        }
        this.vectorStoreId = vectorStoreId;
        this.status = status;
        this.lastError = lastError;
        this.chunkingStrategy = chunkingStrategy;
    }

    /**
     * Get the id property: The identifier, which can be referenced in API endpoints.
     *
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Get the object property: The object type, which is always `vector_store.file`.
     *
     * @return the object value.
     */
    @Generated
    public String getObject() {
        return this.object;
    }

    /**
     * Get the usageBytes property: The total vector store usage in bytes. Note that this may be different from the
     * original file
     * size.
     *
     * @return the usageBytes value.
     */
    @Generated
    public int getUsageBytes() {
        return this.usageBytes;
    }

    /**
     * Get the createdAt property: The Unix timestamp (in seconds) for when the vector store file was created.
     *
     * @return the createdAt value.
     */
    @Generated
    public OffsetDateTime getCreatedAt() {
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.createdAt), ZoneOffset.UTC);
    }

    /**
     * Get the vectorStoreId property: The ID of the vector store that the file is attached to.
     *
     * @return the vectorStoreId value.
     */
    @Generated
    public String getVectorStoreId() {
        return this.vectorStoreId;
    }

    /**
     * Get the status property: The status of the vector store file, which can be either `in_progress`, `completed`,
     * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is ready for use.
     *
     * @return the status value.
     */
    @Generated
    public VectorStoreFileStatus getStatus() {
        return this.status;
    }

    /**
     * Get the lastError property: The last error associated with this vector store file. Will be `null` if there are no
     * errors.
     *
     * @return the lastError value.
     */
    @Generated
    public VectorStoreFileError getLastError() {
        return this.lastError;
    }

    /**
     * Get the chunkingStrategy property: The strategy used to chunk the file.
     *
     * @return the chunkingStrategy value.
     */
    @Generated
    public VectorStoreChunkingStrategyResponse getChunkingStrategy() {
        return this.chunkingStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("object", this.object);
        jsonWriter.writeIntField("usage_bytes", this.usageBytes);
        jsonWriter.writeLongField("created_at", this.createdAt);
        jsonWriter.writeStringField("vector_store_id", this.vectorStoreId);
        jsonWriter.writeStringField("status", this.status == null ? null : this.status.toString());
        jsonWriter.writeJsonField("last_error", this.lastError);
        jsonWriter.writeJsonField("chunking_strategy", this.chunkingStrategy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VectorStoreFile from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of VectorStoreFile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the VectorStoreFile.
     */
    @Generated
    public static VectorStoreFile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String id = null;
            int usageBytes = 0;
            OffsetDateTime createdAt = null;
            String vectorStoreId = null;
            VectorStoreFileStatus status = null;
            VectorStoreFileError lastError = null;
            VectorStoreChunkingStrategyResponse chunkingStrategy = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    id = reader.getString();
                } else if ("usage_bytes".equals(fieldName)) {
                    usageBytes = reader.getInt();
                } else if ("created_at".equals(fieldName)) {
                    createdAt = OffsetDateTime.ofInstant(Instant.ofEpochSecond(reader.getLong()), ZoneOffset.UTC);
                } else if ("vector_store_id".equals(fieldName)) {
                    vectorStoreId = reader.getString();
                } else if ("status".equals(fieldName)) {
                    status = VectorStoreFileStatus.fromString(reader.getString());
                } else if ("last_error".equals(fieldName)) {
                    lastError = VectorStoreFileError.fromJson(reader);
                } else if ("chunking_strategy".equals(fieldName)) {
                    chunkingStrategy = VectorStoreChunkingStrategyResponse.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return new VectorStoreFile(id, usageBytes, createdAt, vectorStoreId, status, lastError, chunkingStrategy);
        });
    }
}
