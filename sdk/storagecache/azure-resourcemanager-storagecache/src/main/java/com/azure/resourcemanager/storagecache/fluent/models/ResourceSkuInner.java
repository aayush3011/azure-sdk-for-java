// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.storagecache.models.ResourceSkuCapabilities;
import com.azure.resourcemanager.storagecache.models.ResourceSkuLocationInfo;
import com.azure.resourcemanager.storagecache.models.Restriction;
import java.io.IOException;
import java.util.List;

/**
 * A resource SKU.
 */
@Fluent
public final class ResourceSkuInner implements JsonSerializable<ResourceSkuInner> {
    /*
     * The type of resource the SKU applies to.
     */
    private String resourceType;

    /*
     * A list of capabilities of this SKU, such as throughput or ops/sec.
     */
    private List<ResourceSkuCapabilities> capabilities;

    /*
     * The set of locations where the SKU is available. This is the supported and registered Azure Geo Regions (e.g.,
     * West US, East US, Southeast Asia, etc.).
     */
    private List<String> locations;

    /*
     * The set of locations where the SKU is available.
     */
    private List<ResourceSkuLocationInfo> locationInfo;

    /*
     * The name of this SKU.
     */
    private String name;

    /*
     * The restrictions preventing this SKU from being used. This is empty if there are no restrictions.
     */
    private List<Restriction> restrictions;

    /**
     * Creates an instance of ResourceSkuInner class.
     */
    public ResourceSkuInner() {
    }

    /**
     * Get the resourceType property: The type of resource the SKU applies to.
     * 
     * @return the resourceType value.
     */
    public String resourceType() {
        return this.resourceType;
    }

    /**
     * Get the capabilities property: A list of capabilities of this SKU, such as throughput or ops/sec.
     * 
     * @return the capabilities value.
     */
    public List<ResourceSkuCapabilities> capabilities() {
        return this.capabilities;
    }

    /**
     * Set the capabilities property: A list of capabilities of this SKU, such as throughput or ops/sec.
     * 
     * @param capabilities the capabilities value to set.
     * @return the ResourceSkuInner object itself.
     */
    public ResourceSkuInner withCapabilities(List<ResourceSkuCapabilities> capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    /**
     * Get the locations property: The set of locations where the SKU is available. This is the supported and registered
     * Azure Geo Regions (e.g., West US, East US, Southeast Asia, etc.).
     * 
     * @return the locations value.
     */
    public List<String> locations() {
        return this.locations;
    }

    /**
     * Get the locationInfo property: The set of locations where the SKU is available.
     * 
     * @return the locationInfo value.
     */
    public List<ResourceSkuLocationInfo> locationInfo() {
        return this.locationInfo;
    }

    /**
     * Set the locationInfo property: The set of locations where the SKU is available.
     * 
     * @param locationInfo the locationInfo value to set.
     * @return the ResourceSkuInner object itself.
     */
    public ResourceSkuInner withLocationInfo(List<ResourceSkuLocationInfo> locationInfo) {
        this.locationInfo = locationInfo;
        return this;
    }

    /**
     * Get the name property: The name of this SKU.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of this SKU.
     * 
     * @param name the name value to set.
     * @return the ResourceSkuInner object itself.
     */
    public ResourceSkuInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the restrictions property: The restrictions preventing this SKU from being used. This is empty if there are
     * no restrictions.
     * 
     * @return the restrictions value.
     */
    public List<Restriction> restrictions() {
        return this.restrictions;
    }

    /**
     * Set the restrictions property: The restrictions preventing this SKU from being used. This is empty if there are
     * no restrictions.
     * 
     * @param restrictions the restrictions value to set.
     * @return the ResourceSkuInner object itself.
     */
    public ResourceSkuInner withRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (capabilities() != null) {
            capabilities().forEach(e -> e.validate());
        }
        if (locationInfo() != null) {
            locationInfo().forEach(e -> e.validate());
        }
        if (restrictions() != null) {
            restrictions().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("capabilities", this.capabilities, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("locationInfo", this.locationInfo, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeArrayField("restrictions", this.restrictions, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceSkuInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceSkuInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ResourceSkuInner.
     */
    public static ResourceSkuInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceSkuInner deserializedResourceSkuInner = new ResourceSkuInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceType".equals(fieldName)) {
                    deserializedResourceSkuInner.resourceType = reader.getString();
                } else if ("capabilities".equals(fieldName)) {
                    List<ResourceSkuCapabilities> capabilities
                        = reader.readArray(reader1 -> ResourceSkuCapabilities.fromJson(reader1));
                    deserializedResourceSkuInner.capabilities = capabilities;
                } else if ("locations".equals(fieldName)) {
                    List<String> locations = reader.readArray(reader1 -> reader1.getString());
                    deserializedResourceSkuInner.locations = locations;
                } else if ("locationInfo".equals(fieldName)) {
                    List<ResourceSkuLocationInfo> locationInfo
                        = reader.readArray(reader1 -> ResourceSkuLocationInfo.fromJson(reader1));
                    deserializedResourceSkuInner.locationInfo = locationInfo;
                } else if ("name".equals(fieldName)) {
                    deserializedResourceSkuInner.name = reader.getString();
                } else if ("restrictions".equals(fieldName)) {
                    List<Restriction> restrictions = reader.readArray(reader1 -> Restriction.fromJson(reader1));
                    deserializedResourceSkuInner.restrictions = restrictions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceSkuInner;
        });
    }
}
