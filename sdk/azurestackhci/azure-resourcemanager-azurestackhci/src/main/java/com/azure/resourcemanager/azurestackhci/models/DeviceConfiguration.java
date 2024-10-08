// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The device Configuration for edge device.
 */
@Fluent
public final class DeviceConfiguration implements JsonSerializable<DeviceConfiguration> {
    /*
     * NIC Details of device
     */
    private List<NicDetail> nicDetails;

    /*
     * Device metadata details.
     */
    private String deviceMetadata;

    /**
     * Creates an instance of DeviceConfiguration class.
     */
    public DeviceConfiguration() {
    }

    /**
     * Get the nicDetails property: NIC Details of device.
     * 
     * @return the nicDetails value.
     */
    public List<NicDetail> nicDetails() {
        return this.nicDetails;
    }

    /**
     * Set the nicDetails property: NIC Details of device.
     * 
     * @param nicDetails the nicDetails value to set.
     * @return the DeviceConfiguration object itself.
     */
    public DeviceConfiguration withNicDetails(List<NicDetail> nicDetails) {
        this.nicDetails = nicDetails;
        return this;
    }

    /**
     * Get the deviceMetadata property: Device metadata details.
     * 
     * @return the deviceMetadata value.
     */
    public String deviceMetadata() {
        return this.deviceMetadata;
    }

    /**
     * Set the deviceMetadata property: Device metadata details.
     * 
     * @param deviceMetadata the deviceMetadata value to set.
     * @return the DeviceConfiguration object itself.
     */
    public DeviceConfiguration withDeviceMetadata(String deviceMetadata) {
        this.deviceMetadata = deviceMetadata;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (nicDetails() != null) {
            nicDetails().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("nicDetails", this.nicDetails, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("deviceMetadata", this.deviceMetadata);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DeviceConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeviceConfiguration if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DeviceConfiguration.
     */
    public static DeviceConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeviceConfiguration deserializedDeviceConfiguration = new DeviceConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("nicDetails".equals(fieldName)) {
                    List<NicDetail> nicDetails = reader.readArray(reader1 -> NicDetail.fromJson(reader1));
                    deserializedDeviceConfiguration.nicDetails = nicDetails;
                } else if ("deviceMetadata".equals(fieldName)) {
                    deserializedDeviceConfiguration.deviceMetadata = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDeviceConfiguration;
        });
    }
}
