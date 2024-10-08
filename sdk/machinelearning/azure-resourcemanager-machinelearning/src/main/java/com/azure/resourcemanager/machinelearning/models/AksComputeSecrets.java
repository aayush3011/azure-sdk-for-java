// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.machinelearning.fluent.models.ComputeSecretsInner;
import java.io.IOException;

/**
 * Secrets related to a Machine Learning compute based on AKS.
 */
@Fluent
public final class AksComputeSecrets extends ComputeSecretsInner {
    /*
     * The type of compute
     */
    private ComputeType computeType = ComputeType.AKS;

    /*
     * Content of kubeconfig file that can be used to connect to the Kubernetes cluster.
     */
    private String userKubeConfig;

    /*
     * Content of kubeconfig file that can be used to connect to the Kubernetes cluster.
     */
    private String adminKubeConfig;

    /*
     * Image registry pull secret.
     */
    private String imagePullSecretName;

    /**
     * Creates an instance of AksComputeSecrets class.
     */
    public AksComputeSecrets() {
    }

    /**
     * Get the computeType property: The type of compute.
     * 
     * @return the computeType value.
     */
    @Override
    public ComputeType computeType() {
        return this.computeType;
    }

    /**
     * Get the userKubeConfig property: Content of kubeconfig file that can be used to connect to the Kubernetes
     * cluster.
     * 
     * @return the userKubeConfig value.
     */
    public String userKubeConfig() {
        return this.userKubeConfig;
    }

    /**
     * Set the userKubeConfig property: Content of kubeconfig file that can be used to connect to the Kubernetes
     * cluster.
     * 
     * @param userKubeConfig the userKubeConfig value to set.
     * @return the AksComputeSecrets object itself.
     */
    public AksComputeSecrets withUserKubeConfig(String userKubeConfig) {
        this.userKubeConfig = userKubeConfig;
        return this;
    }

    /**
     * Get the adminKubeConfig property: Content of kubeconfig file that can be used to connect to the Kubernetes
     * cluster.
     * 
     * @return the adminKubeConfig value.
     */
    public String adminKubeConfig() {
        return this.adminKubeConfig;
    }

    /**
     * Set the adminKubeConfig property: Content of kubeconfig file that can be used to connect to the Kubernetes
     * cluster.
     * 
     * @param adminKubeConfig the adminKubeConfig value to set.
     * @return the AksComputeSecrets object itself.
     */
    public AksComputeSecrets withAdminKubeConfig(String adminKubeConfig) {
        this.adminKubeConfig = adminKubeConfig;
        return this;
    }

    /**
     * Get the imagePullSecretName property: Image registry pull secret.
     * 
     * @return the imagePullSecretName value.
     */
    public String imagePullSecretName() {
        return this.imagePullSecretName;
    }

    /**
     * Set the imagePullSecretName property: Image registry pull secret.
     * 
     * @param imagePullSecretName the imagePullSecretName value to set.
     * @return the AksComputeSecrets object itself.
     */
    public AksComputeSecrets withImagePullSecretName(String imagePullSecretName) {
        this.imagePullSecretName = imagePullSecretName;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("computeType", this.computeType == null ? null : this.computeType.toString());
        jsonWriter.writeStringField("userKubeConfig", this.userKubeConfig);
        jsonWriter.writeStringField("adminKubeConfig", this.adminKubeConfig);
        jsonWriter.writeStringField("imagePullSecretName", this.imagePullSecretName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AksComputeSecrets from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AksComputeSecrets if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AksComputeSecrets.
     */
    public static AksComputeSecrets fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AksComputeSecrets deserializedAksComputeSecrets = new AksComputeSecrets();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("computeType".equals(fieldName)) {
                    deserializedAksComputeSecrets.computeType = ComputeType.fromString(reader.getString());
                } else if ("userKubeConfig".equals(fieldName)) {
                    deserializedAksComputeSecrets.userKubeConfig = reader.getString();
                } else if ("adminKubeConfig".equals(fieldName)) {
                    deserializedAksComputeSecrets.adminKubeConfig = reader.getString();
                } else if ("imagePullSecretName".equals(fieldName)) {
                    deserializedAksComputeSecrets.imagePullSecretName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAksComputeSecrets;
        });
    }
}
