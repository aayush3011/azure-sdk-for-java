// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Properties of the application rule protocol.
 */
@Fluent
public final class FirewallPolicyRuleApplicationProtocol
    implements JsonSerializable<FirewallPolicyRuleApplicationProtocol> {
    /*
     * Protocol type.
     */
    private FirewallPolicyRuleApplicationProtocolType protocolType;

    /*
     * Port number for the protocol, cannot be greater than 64000.
     */
    private Integer port;

    /**
     * Creates an instance of FirewallPolicyRuleApplicationProtocol class.
     */
    public FirewallPolicyRuleApplicationProtocol() {
    }

    /**
     * Get the protocolType property: Protocol type.
     * 
     * @return the protocolType value.
     */
    public FirewallPolicyRuleApplicationProtocolType protocolType() {
        return this.protocolType;
    }

    /**
     * Set the protocolType property: Protocol type.
     * 
     * @param protocolType the protocolType value to set.
     * @return the FirewallPolicyRuleApplicationProtocol object itself.
     */
    public FirewallPolicyRuleApplicationProtocol
        withProtocolType(FirewallPolicyRuleApplicationProtocolType protocolType) {
        this.protocolType = protocolType;
        return this;
    }

    /**
     * Get the port property: Port number for the protocol, cannot be greater than 64000.
     * 
     * @return the port value.
     */
    public Integer port() {
        return this.port;
    }

    /**
     * Set the port property: Port number for the protocol, cannot be greater than 64000.
     * 
     * @param port the port value to set.
     * @return the FirewallPolicyRuleApplicationProtocol object itself.
     */
    public FirewallPolicyRuleApplicationProtocol withPort(Integer port) {
        this.port = port;
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
        jsonWriter.writeStringField("protocolType", this.protocolType == null ? null : this.protocolType.toString());
        jsonWriter.writeNumberField("port", this.port);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FirewallPolicyRuleApplicationProtocol from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FirewallPolicyRuleApplicationProtocol if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the FirewallPolicyRuleApplicationProtocol.
     */
    public static FirewallPolicyRuleApplicationProtocol fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FirewallPolicyRuleApplicationProtocol deserializedFirewallPolicyRuleApplicationProtocol
                = new FirewallPolicyRuleApplicationProtocol();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("protocolType".equals(fieldName)) {
                    deserializedFirewallPolicyRuleApplicationProtocol.protocolType
                        = FirewallPolicyRuleApplicationProtocolType.fromString(reader.getString());
                } else if ("port".equals(fieldName)) {
                    deserializedFirewallPolicyRuleApplicationProtocol.port = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFirewallPolicyRuleApplicationProtocol;
        });
    }
}
