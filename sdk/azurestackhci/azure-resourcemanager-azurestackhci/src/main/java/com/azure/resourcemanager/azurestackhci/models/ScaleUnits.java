// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Scale units will contains list of deployment data.
 */
@Fluent
public final class ScaleUnits implements JsonSerializable<ScaleUnits> {
    /*
     * Deployment Data to deploy AzureStackHCI Cluster.
     */
    private DeploymentData deploymentData;

    /*
     * Solution builder extension (SBE) partner properties
     */
    private SbePartnerInfo sbePartnerInfo;

    /**
     * Creates an instance of ScaleUnits class.
     */
    public ScaleUnits() {
    }

    /**
     * Get the deploymentData property: Deployment Data to deploy AzureStackHCI Cluster.
     * 
     * @return the deploymentData value.
     */
    public DeploymentData deploymentData() {
        return this.deploymentData;
    }

    /**
     * Set the deploymentData property: Deployment Data to deploy AzureStackHCI Cluster.
     * 
     * @param deploymentData the deploymentData value to set.
     * @return the ScaleUnits object itself.
     */
    public ScaleUnits withDeploymentData(DeploymentData deploymentData) {
        this.deploymentData = deploymentData;
        return this;
    }

    /**
     * Get the sbePartnerInfo property: Solution builder extension (SBE) partner properties.
     * 
     * @return the sbePartnerInfo value.
     */
    public SbePartnerInfo sbePartnerInfo() {
        return this.sbePartnerInfo;
    }

    /**
     * Set the sbePartnerInfo property: Solution builder extension (SBE) partner properties.
     * 
     * @param sbePartnerInfo the sbePartnerInfo value to set.
     * @return the ScaleUnits object itself.
     */
    public ScaleUnits withSbePartnerInfo(SbePartnerInfo sbePartnerInfo) {
        this.sbePartnerInfo = sbePartnerInfo;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (deploymentData() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property deploymentData in model ScaleUnits"));
        } else {
            deploymentData().validate();
        }
        if (sbePartnerInfo() != null) {
            sbePartnerInfo().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ScaleUnits.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("deploymentData", this.deploymentData);
        jsonWriter.writeJsonField("sbePartnerInfo", this.sbePartnerInfo);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ScaleUnits from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ScaleUnits if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ScaleUnits.
     */
    public static ScaleUnits fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ScaleUnits deserializedScaleUnits = new ScaleUnits();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("deploymentData".equals(fieldName)) {
                    deserializedScaleUnits.deploymentData = DeploymentData.fromJson(reader);
                } else if ("sbePartnerInfo".equals(fieldName)) {
                    deserializedScaleUnits.sbePartnerInfo = SbePartnerInfo.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedScaleUnits;
        });
    }
}
