// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The access keys for the given database account.
 */
@Immutable
public final class DatabaseAccountListKeysResultInner extends DatabaseAccountListReadOnlyKeysResultInner {
    /*
     * Base 64 encoded value of the primary read-write key.
     */
    private String primaryMasterKey;

    /*
     * Base 64 encoded value of the secondary read-write key.
     */
    private String secondaryMasterKey;

    /*
     * Base 64 encoded value of the secondary read-only key.
     */
    private String secondaryReadonlyMasterKey;

    /*
     * Base 64 encoded value of the primary read-only key.
     */
    private String primaryReadonlyMasterKey;

    /**
     * Creates an instance of DatabaseAccountListKeysResultInner class.
     */
    public DatabaseAccountListKeysResultInner() {
    }

    /**
     * Get the primaryMasterKey property: Base 64 encoded value of the primary read-write key.
     * 
     * @return the primaryMasterKey value.
     */
    public String primaryMasterKey() {
        return this.primaryMasterKey;
    }

    /**
     * Get the secondaryMasterKey property: Base 64 encoded value of the secondary read-write key.
     * 
     * @return the secondaryMasterKey value.
     */
    public String secondaryMasterKey() {
        return this.secondaryMasterKey;
    }

    /**
     * Get the secondaryReadonlyMasterKey property: Base 64 encoded value of the secondary read-only key.
     * 
     * @return the secondaryReadonlyMasterKey value.
     */
    @Override
    public String secondaryReadonlyMasterKey() {
        return this.secondaryReadonlyMasterKey;
    }

    /**
     * Get the primaryReadonlyMasterKey property: Base 64 encoded value of the primary read-only key.
     * 
     * @return the primaryReadonlyMasterKey value.
     */
    @Override
    public String primaryReadonlyMasterKey() {
        return this.primaryReadonlyMasterKey;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
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
     * Reads an instance of DatabaseAccountListKeysResultInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DatabaseAccountListKeysResultInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DatabaseAccountListKeysResultInner.
     */
    public static DatabaseAccountListKeysResultInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DatabaseAccountListKeysResultInner deserializedDatabaseAccountListKeysResultInner
                = new DatabaseAccountListKeysResultInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("primaryReadonlyMasterKey".equals(fieldName)) {
                    deserializedDatabaseAccountListKeysResultInner.primaryReadonlyMasterKey = reader.getString();
                } else if ("secondaryReadonlyMasterKey".equals(fieldName)) {
                    deserializedDatabaseAccountListKeysResultInner.secondaryReadonlyMasterKey = reader.getString();
                } else if ("primaryMasterKey".equals(fieldName)) {
                    deserializedDatabaseAccountListKeysResultInner.primaryMasterKey = reader.getString();
                } else if ("secondaryMasterKey".equals(fieldName)) {
                    deserializedDatabaseAccountListKeysResultInner.secondaryMasterKey = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDatabaseAccountListKeysResultInner;
        });
    }
}
