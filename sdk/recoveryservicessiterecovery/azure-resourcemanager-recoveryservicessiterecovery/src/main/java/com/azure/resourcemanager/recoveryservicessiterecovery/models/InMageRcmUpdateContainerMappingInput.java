// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * InMageRcm update protection container mapping.
 */
@Fluent
public final class InMageRcmUpdateContainerMappingInput extends ReplicationProviderSpecificUpdateContainerMappingInput {
    /*
     * The class type.
     */
    private String instanceType = "InMageRcm";

    /*
     * A value indicating whether agent auto upgrade has to be enabled.
     */
    private String enableAgentAutoUpgrade;

    /**
     * Creates an instance of InMageRcmUpdateContainerMappingInput class.
     */
    public InMageRcmUpdateContainerMappingInput() {
    }

    /**
     * Get the instanceType property: The class type.
     * 
     * @return the instanceType value.
     */
    @Override
    public String instanceType() {
        return this.instanceType;
    }

    /**
     * Get the enableAgentAutoUpgrade property: A value indicating whether agent auto upgrade has to be enabled.
     * 
     * @return the enableAgentAutoUpgrade value.
     */
    public String enableAgentAutoUpgrade() {
        return this.enableAgentAutoUpgrade;
    }

    /**
     * Set the enableAgentAutoUpgrade property: A value indicating whether agent auto upgrade has to be enabled.
     * 
     * @param enableAgentAutoUpgrade the enableAgentAutoUpgrade value to set.
     * @return the InMageRcmUpdateContainerMappingInput object itself.
     */
    public InMageRcmUpdateContainerMappingInput withEnableAgentAutoUpgrade(String enableAgentAutoUpgrade) {
        this.enableAgentAutoUpgrade = enableAgentAutoUpgrade;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (enableAgentAutoUpgrade() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property enableAgentAutoUpgrade in model InMageRcmUpdateContainerMappingInput"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(InMageRcmUpdateContainerMappingInput.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("enableAgentAutoUpgrade", this.enableAgentAutoUpgrade);
        jsonWriter.writeStringField("instanceType", this.instanceType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of InMageRcmUpdateContainerMappingInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of InMageRcmUpdateContainerMappingInput if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the InMageRcmUpdateContainerMappingInput.
     */
    public static InMageRcmUpdateContainerMappingInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            InMageRcmUpdateContainerMappingInput deserializedInMageRcmUpdateContainerMappingInput
                = new InMageRcmUpdateContainerMappingInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("enableAgentAutoUpgrade".equals(fieldName)) {
                    deserializedInMageRcmUpdateContainerMappingInput.enableAgentAutoUpgrade = reader.getString();
                } else if ("instanceType".equals(fieldName)) {
                    deserializedInMageRcmUpdateContainerMappingInput.instanceType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedInMageRcmUpdateContainerMappingInput;
        });
    }
}
