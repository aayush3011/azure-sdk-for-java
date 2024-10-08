// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * The output configuration of a job step.
 */
@Fluent
public final class JobStepOutput implements JsonSerializable<JobStepOutput> {
    /*
     * The output destination type.
     */
    private JobStepOutputType type;

    /*
     * The output destination subscription id.
     */
    private UUID subscriptionId;

    /*
     * The output destination resource group.
     */
    private String resourceGroupName;

    /*
     * The output destination server name.
     */
    private String serverName;

    /*
     * The output destination database.
     */
    private String databaseName;

    /*
     * The output destination schema.
     */
    private String schemaName;

    /*
     * The output destination table.
     */
    private String tableName;

    /*
     * The resource ID of the credential to use to connect to the output destination.
     */
    private String credential;

    /**
     * Creates an instance of JobStepOutput class.
     */
    public JobStepOutput() {
    }

    /**
     * Get the type property: The output destination type.
     * 
     * @return the type value.
     */
    public JobStepOutputType type() {
        return this.type;
    }

    /**
     * Set the type property: The output destination type.
     * 
     * @param type the type value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withType(JobStepOutputType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the subscriptionId property: The output destination subscription id.
     * 
     * @return the subscriptionId value.
     */
    public UUID subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Set the subscriptionId property: The output destination subscription id.
     * 
     * @param subscriptionId the subscriptionId value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Get the resourceGroupName property: The output destination resource group.
     * 
     * @return the resourceGroupName value.
     */
    public String resourceGroupName() {
        return this.resourceGroupName;
    }

    /**
     * Set the resourceGroupName property: The output destination resource group.
     * 
     * @param resourceGroupName the resourceGroupName value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    /**
     * Get the serverName property: The output destination server name.
     * 
     * @return the serverName value.
     */
    public String serverName() {
        return this.serverName;
    }

    /**
     * Set the serverName property: The output destination server name.
     * 
     * @param serverName the serverName value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    /**
     * Get the databaseName property: The output destination database.
     * 
     * @return the databaseName value.
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Set the databaseName property: The output destination database.
     * 
     * @param databaseName the databaseName value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get the schemaName property: The output destination schema.
     * 
     * @return the schemaName value.
     */
    public String schemaName() {
        return this.schemaName;
    }

    /**
     * Set the schemaName property: The output destination schema.
     * 
     * @param schemaName the schemaName value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withSchemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }

    /**
     * Get the tableName property: The output destination table.
     * 
     * @return the tableName value.
     */
    public String tableName() {
        return this.tableName;
    }

    /**
     * Set the tableName property: The output destination table.
     * 
     * @param tableName the tableName value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Get the credential property: The resource ID of the credential to use to connect to the output destination.
     * 
     * @return the credential value.
     */
    public String credential() {
        return this.credential;
    }

    /**
     * Set the credential property: The resource ID of the credential to use to connect to the output destination.
     * 
     * @param credential the credential value to set.
     * @return the JobStepOutput object itself.
     */
    public JobStepOutput withCredential(String credential) {
        this.credential = credential;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (serverName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property serverName in model JobStepOutput"));
        }
        if (databaseName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property databaseName in model JobStepOutput"));
        }
        if (tableName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property tableName in model JobStepOutput"));
        }
        if (credential() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property credential in model JobStepOutput"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(JobStepOutput.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("serverName", this.serverName);
        jsonWriter.writeStringField("databaseName", this.databaseName);
        jsonWriter.writeStringField("tableName", this.tableName);
        jsonWriter.writeStringField("credential", this.credential);
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeStringField("subscriptionId", Objects.toString(this.subscriptionId, null));
        jsonWriter.writeStringField("resourceGroupName", this.resourceGroupName);
        jsonWriter.writeStringField("schemaName", this.schemaName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of JobStepOutput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of JobStepOutput if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the JobStepOutput.
     */
    public static JobStepOutput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            JobStepOutput deserializedJobStepOutput = new JobStepOutput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serverName".equals(fieldName)) {
                    deserializedJobStepOutput.serverName = reader.getString();
                } else if ("databaseName".equals(fieldName)) {
                    deserializedJobStepOutput.databaseName = reader.getString();
                } else if ("tableName".equals(fieldName)) {
                    deserializedJobStepOutput.tableName = reader.getString();
                } else if ("credential".equals(fieldName)) {
                    deserializedJobStepOutput.credential = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedJobStepOutput.type = JobStepOutputType.fromString(reader.getString());
                } else if ("subscriptionId".equals(fieldName)) {
                    deserializedJobStepOutput.subscriptionId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("resourceGroupName".equals(fieldName)) {
                    deserializedJobStepOutput.resourceGroupName = reader.getString();
                } else if ("schemaName".equals(fieldName)) {
                    deserializedJobStepOutput.schemaName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedJobStepOutput;
        });
    }
}
