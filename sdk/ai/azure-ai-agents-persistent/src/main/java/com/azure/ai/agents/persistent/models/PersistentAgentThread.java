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
import java.util.Map;

/**
 * Information about a single thread associated with an agent.
 */
@Immutable
public final class PersistentAgentThread implements JsonSerializable<PersistentAgentThread> {

    /*
     * The identifier, which can be referenced in API endpoints.
     */
    @Generated
    private final String id;

    /*
     * The object type, which is always 'thread'.
     */
    @Generated
    private final String object = "thread";

    /*
     * The Unix timestamp, in seconds, representing when this object was created.
     */
    @Generated
    private final long createdAt;

    /*
     * A set of resources that are made available to the agent's tools in this thread. The resources are specific to the
     * type
     * of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the `file_search` tool
     * requires a list
     * of vector store IDs.
     */
    @Generated
    private final ToolResources toolResources;

    /*
     * A set of up to 16 key/value pairs that can be attached to an object, used for storing additional information
     * about that object in a structured format. Keys may be up to 64 characters in length and values may be up to 512
     * characters in length.
     */
    @Generated
    private final Map<String, String> metadata;

    /**
     * Creates an instance of PersistentAgentThread class.
     *
     * @param id the id value to set.
     * @param createdAt the createdAt value to set.
     * @param toolResources the toolResources value to set.
     * @param metadata the metadata value to set.
     */
    @Generated
    private PersistentAgentThread(String id, OffsetDateTime createdAt, ToolResources toolResources,
        Map<String, String> metadata) {
        this.id = id;
        if (createdAt == null) {
            this.createdAt = 0L;
        } else {
            this.createdAt = createdAt.toEpochSecond();
        }
        this.toolResources = toolResources;
        this.metadata = metadata;
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
     * Get the object property: The object type, which is always 'thread'.
     *
     * @return the object value.
     */
    @Generated
    public String getObject() {
        return this.object;
    }

    /**
     * Get the createdAt property: The Unix timestamp, in seconds, representing when this object was created.
     *
     * @return the createdAt value.
     */
    @Generated
    public OffsetDateTime getCreatedAt() {
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.createdAt), ZoneOffset.UTC);
    }

    /**
     * Get the toolResources property: A set of resources that are made available to the agent's tools in this thread.
     * The resources are specific to the type
     * of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the `file_search` tool
     * requires a list
     * of vector store IDs.
     *
     * @return the toolResources value.
     */
    @Generated
    public ToolResources getToolResources() {
        return this.toolResources;
    }

    /**
     * Get the metadata property: A set of up to 16 key/value pairs that can be attached to an object, used for storing
     * additional information about that object in a structured format. Keys may be up to 64 characters in length and
     * values may be up to 512 characters in length.
     *
     * @return the metadata value.
     */
    @Generated
    public Map<String, String> getMetadata() {
        return this.metadata;
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
        jsonWriter.writeLongField("created_at", this.createdAt);
        jsonWriter.writeJsonField("tool_resources", this.toolResources);
        jsonWriter.writeMapField("metadata", this.metadata, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PersistentAgentThread from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of PersistentAgentThread if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PersistentAgentThread.
     */
    @Generated
    public static PersistentAgentThread fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String id = null;
            OffsetDateTime createdAt = null;
            ToolResources toolResources = null;
            Map<String, String> metadata = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    id = reader.getString();
                } else if ("created_at".equals(fieldName)) {
                    createdAt = OffsetDateTime.ofInstant(Instant.ofEpochSecond(reader.getLong()), ZoneOffset.UTC);
                } else if ("tool_resources".equals(fieldName)) {
                    toolResources = ToolResources.fromJson(reader);
                } else if ("metadata".equals(fieldName)) {
                    metadata = reader.readMap(reader1 -> reader1.getString());
                } else {
                    reader.skipChildren();
                }
            }
            return new PersistentAgentThread(id, createdAt, toolResources, metadata);
        });
    }
}
