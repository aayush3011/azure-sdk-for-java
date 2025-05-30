// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appcontainers.models.AppLogsConfiguration;
import com.azure.resourcemanager.appcontainers.models.CustomDomainConfiguration;
import com.azure.resourcemanager.appcontainers.models.DaprConfiguration;
import com.azure.resourcemanager.appcontainers.models.EnvironmentProvisioningState;
import com.azure.resourcemanager.appcontainers.models.KedaConfiguration;
import com.azure.resourcemanager.appcontainers.models.ManagedEnvironmentPropertiesPeerAuthentication;
import com.azure.resourcemanager.appcontainers.models.ManagedEnvironmentPropertiesPeerTrafficConfiguration;
import com.azure.resourcemanager.appcontainers.models.ManagedServiceIdentity;
import com.azure.resourcemanager.appcontainers.models.VnetConfiguration;
import com.azure.resourcemanager.appcontainers.models.WorkloadProfile;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * An environment for hosting container apps.
 */
@Fluent
public final class ManagedEnvironmentInner extends Resource {
    /*
     * Kind of the Environment.
     */
    private String kind;

    /*
     * Managed identities for the Managed Environment to interact with other Azure services without maintaining any
     * secrets or credentials in code.
     */
    private ManagedServiceIdentity identity;

    /*
     * Managed environment resource specific properties
     */
    private ManagedEnvironmentProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of ManagedEnvironmentInner class.
     */
    public ManagedEnvironmentInner() {
    }

    /**
     * Get the kind property: Kind of the Environment.
     * 
     * @return the kind value.
     */
    public String kind() {
        return this.kind;
    }

    /**
     * Set the kind property: Kind of the Environment.
     * 
     * @param kind the kind value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withKind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get the identity property: Managed identities for the Managed Environment to interact with other Azure services
     * without maintaining any secrets or credentials in code.
     * 
     * @return the identity value.
     */
    public ManagedServiceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: Managed identities for the Managed Environment to interact with other Azure services
     * without maintaining any secrets or credentials in code.
     * 
     * @param identity the identity value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withIdentity(ManagedServiceIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the innerProperties property: Managed environment resource specific properties.
     * 
     * @return the innerProperties value.
     */
    private ManagedEnvironmentProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ManagedEnvironmentInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ManagedEnvironmentInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the Environment.
     * 
     * @return the provisioningState value.
     */
    public EnvironmentProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the daprAIInstrumentationKey property: Azure Monitor instrumentation key used by Dapr to export Service to
     * Service communication telemetry.
     * 
     * @return the daprAIInstrumentationKey value.
     */
    public String daprAIInstrumentationKey() {
        return this.innerProperties() == null ? null : this.innerProperties().daprAIInstrumentationKey();
    }

    /**
     * Set the daprAIInstrumentationKey property: Azure Monitor instrumentation key used by Dapr to export Service to
     * Service communication telemetry.
     * 
     * @param daprAIInstrumentationKey the daprAIInstrumentationKey value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withDaprAIInstrumentationKey(String daprAIInstrumentationKey) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withDaprAIInstrumentationKey(daprAIInstrumentationKey);
        return this;
    }

    /**
     * Get the daprAIConnectionString property: Application Insights connection string used by Dapr to export Service to
     * Service communication telemetry.
     * 
     * @return the daprAIConnectionString value.
     */
    public String daprAIConnectionString() {
        return this.innerProperties() == null ? null : this.innerProperties().daprAIConnectionString();
    }

    /**
     * Set the daprAIConnectionString property: Application Insights connection string used by Dapr to export Service to
     * Service communication telemetry.
     * 
     * @param daprAIConnectionString the daprAIConnectionString value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withDaprAIConnectionString(String daprAIConnectionString) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withDaprAIConnectionString(daprAIConnectionString);
        return this;
    }

    /**
     * Get the vnetConfiguration property: Vnet configuration for the environment.
     * 
     * @return the vnetConfiguration value.
     */
    public VnetConfiguration vnetConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().vnetConfiguration();
    }

    /**
     * Set the vnetConfiguration property: Vnet configuration for the environment.
     * 
     * @param vnetConfiguration the vnetConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withVnetConfiguration(VnetConfiguration vnetConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withVnetConfiguration(vnetConfiguration);
        return this;
    }

    /**
     * Get the deploymentErrors property: Any errors that occurred during deployment or deployment validation.
     * 
     * @return the deploymentErrors value.
     */
    public String deploymentErrors() {
        return this.innerProperties() == null ? null : this.innerProperties().deploymentErrors();
    }

    /**
     * Get the defaultDomain property: Default Domain Name for the cluster.
     * 
     * @return the defaultDomain value.
     */
    public String defaultDomain() {
        return this.innerProperties() == null ? null : this.innerProperties().defaultDomain();
    }

    /**
     * Get the staticIp property: Static IP of the Environment.
     * 
     * @return the staticIp value.
     */
    public String staticIp() {
        return this.innerProperties() == null ? null : this.innerProperties().staticIp();
    }

    /**
     * Get the appLogsConfiguration property: Cluster configuration which enables the log daemon to export app logs to
     * configured destination.
     * 
     * @return the appLogsConfiguration value.
     */
    public AppLogsConfiguration appLogsConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().appLogsConfiguration();
    }

    /**
     * Set the appLogsConfiguration property: Cluster configuration which enables the log daemon to export app logs to
     * configured destination.
     * 
     * @param appLogsConfiguration the appLogsConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withAppLogsConfiguration(AppLogsConfiguration appLogsConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withAppLogsConfiguration(appLogsConfiguration);
        return this;
    }

    /**
     * Get the zoneRedundant property: Whether or not this Managed Environment is zone-redundant.
     * 
     * @return the zoneRedundant value.
     */
    public Boolean zoneRedundant() {
        return this.innerProperties() == null ? null : this.innerProperties().zoneRedundant();
    }

    /**
     * Set the zoneRedundant property: Whether or not this Managed Environment is zone-redundant.
     * 
     * @param zoneRedundant the zoneRedundant value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withZoneRedundant(Boolean zoneRedundant) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withZoneRedundant(zoneRedundant);
        return this;
    }

    /**
     * Get the customDomainConfiguration property: Custom domain configuration for the environment.
     * 
     * @return the customDomainConfiguration value.
     */
    public CustomDomainConfiguration customDomainConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().customDomainConfiguration();
    }

    /**
     * Set the customDomainConfiguration property: Custom domain configuration for the environment.
     * 
     * @param customDomainConfiguration the customDomainConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withCustomDomainConfiguration(CustomDomainConfiguration customDomainConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withCustomDomainConfiguration(customDomainConfiguration);
        return this;
    }

    /**
     * Get the eventStreamEndpoint property: The endpoint of the eventstream of the Environment.
     * 
     * @return the eventStreamEndpoint value.
     */
    public String eventStreamEndpoint() {
        return this.innerProperties() == null ? null : this.innerProperties().eventStreamEndpoint();
    }

    /**
     * Get the workloadProfiles property: Workload profiles configured for the Managed Environment.
     * 
     * @return the workloadProfiles value.
     */
    public List<WorkloadProfile> workloadProfiles() {
        return this.innerProperties() == null ? null : this.innerProperties().workloadProfiles();
    }

    /**
     * Set the workloadProfiles property: Workload profiles configured for the Managed Environment.
     * 
     * @param workloadProfiles the workloadProfiles value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withWorkloadProfiles(List<WorkloadProfile> workloadProfiles) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withWorkloadProfiles(workloadProfiles);
        return this;
    }

    /**
     * Get the kedaConfiguration property: The configuration of Keda component.
     * 
     * @return the kedaConfiguration value.
     */
    public KedaConfiguration kedaConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().kedaConfiguration();
    }

    /**
     * Set the kedaConfiguration property: The configuration of Keda component.
     * 
     * @param kedaConfiguration the kedaConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withKedaConfiguration(KedaConfiguration kedaConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withKedaConfiguration(kedaConfiguration);
        return this;
    }

    /**
     * Get the daprConfiguration property: The configuration of Dapr component.
     * 
     * @return the daprConfiguration value.
     */
    public DaprConfiguration daprConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().daprConfiguration();
    }

    /**
     * Set the daprConfiguration property: The configuration of Dapr component.
     * 
     * @param daprConfiguration the daprConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withDaprConfiguration(DaprConfiguration daprConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withDaprConfiguration(daprConfiguration);
        return this;
    }

    /**
     * Get the infrastructureResourceGroup property: Name of the platform-managed resource group created for the Managed
     * Environment to host infrastructure resources. If a subnet ID is provided, this resource group will be created in
     * the same subscription as the subnet.
     * 
     * @return the infrastructureResourceGroup value.
     */
    public String infrastructureResourceGroup() {
        return this.innerProperties() == null ? null : this.innerProperties().infrastructureResourceGroup();
    }

    /**
     * Set the infrastructureResourceGroup property: Name of the platform-managed resource group created for the Managed
     * Environment to host infrastructure resources. If a subnet ID is provided, this resource group will be created in
     * the same subscription as the subnet.
     * 
     * @param infrastructureResourceGroup the infrastructureResourceGroup value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner withInfrastructureResourceGroup(String infrastructureResourceGroup) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withInfrastructureResourceGroup(infrastructureResourceGroup);
        return this;
    }

    /**
     * Get the peerAuthentication property: Peer authentication settings for the Managed Environment.
     * 
     * @return the peerAuthentication value.
     */
    public ManagedEnvironmentPropertiesPeerAuthentication peerAuthentication() {
        return this.innerProperties() == null ? null : this.innerProperties().peerAuthentication();
    }

    /**
     * Set the peerAuthentication property: Peer authentication settings for the Managed Environment.
     * 
     * @param peerAuthentication the peerAuthentication value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner
        withPeerAuthentication(ManagedEnvironmentPropertiesPeerAuthentication peerAuthentication) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withPeerAuthentication(peerAuthentication);
        return this;
    }

    /**
     * Get the peerTrafficConfiguration property: Peer traffic settings for the Managed Environment.
     * 
     * @return the peerTrafficConfiguration value.
     */
    public ManagedEnvironmentPropertiesPeerTrafficConfiguration peerTrafficConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().peerTrafficConfiguration();
    }

    /**
     * Set the peerTrafficConfiguration property: Peer traffic settings for the Managed Environment.
     * 
     * @param peerTrafficConfiguration the peerTrafficConfiguration value to set.
     * @return the ManagedEnvironmentInner object itself.
     */
    public ManagedEnvironmentInner
        withPeerTrafficConfiguration(ManagedEnvironmentPropertiesPeerTrafficConfiguration peerTrafficConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagedEnvironmentProperties();
        }
        this.innerProperties().withPeerTrafficConfiguration(peerTrafficConfiguration);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (identity() != null) {
            identity().validate();
        }
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("kind", this.kind);
        jsonWriter.writeJsonField("identity", this.identity);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagedEnvironmentInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagedEnvironmentInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ManagedEnvironmentInner.
     */
    public static ManagedEnvironmentInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagedEnvironmentInner deserializedManagedEnvironmentInner = new ManagedEnvironmentInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedManagedEnvironmentInner.withTags(tags);
                } else if ("kind".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.kind = reader.getString();
                } else if ("identity".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.identity = ManagedServiceIdentity.fromJson(reader);
                } else if ("properties".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.innerProperties = ManagedEnvironmentProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedManagedEnvironmentInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagedEnvironmentInner;
        });
    }
}
