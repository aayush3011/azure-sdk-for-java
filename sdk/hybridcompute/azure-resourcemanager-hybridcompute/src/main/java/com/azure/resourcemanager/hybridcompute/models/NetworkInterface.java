// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Describes a network interface.
 */
@Fluent
public final class NetworkInterface implements JsonSerializable<NetworkInterface> {
    /*
     * The list of IP addresses in this interface.
     */
    private List<IpAddress> ipAddresses;

    /**
     * Creates an instance of NetworkInterface class.
     */
    public NetworkInterface() {
    }

    /**
     * Get the ipAddresses property: The list of IP addresses in this interface.
     * 
     * @return the ipAddresses value.
     */
    public List<IpAddress> ipAddresses() {
        return this.ipAddresses;
    }

    /**
     * Set the ipAddresses property: The list of IP addresses in this interface.
     * 
     * @param ipAddresses the ipAddresses value to set.
     * @return the NetworkInterface object itself.
     */
    public NetworkInterface withIpAddresses(List<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (ipAddresses() != null) {
            ipAddresses().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("ipAddresses", this.ipAddresses, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NetworkInterface from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NetworkInterface if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the NetworkInterface.
     */
    public static NetworkInterface fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NetworkInterface deserializedNetworkInterface = new NetworkInterface();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ipAddresses".equals(fieldName)) {
                    List<IpAddress> ipAddresses = reader.readArray(reader1 -> IpAddress.fromJson(reader1));
                    deserializedNetworkInterface.ipAddresses = ipAddresses;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNetworkInterface;
        });
    }
}
