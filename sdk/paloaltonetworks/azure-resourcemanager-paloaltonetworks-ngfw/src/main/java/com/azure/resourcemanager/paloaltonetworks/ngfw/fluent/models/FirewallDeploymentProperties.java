// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.BooleanEnum;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.DnsSettings;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.FrontendSetting;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.MarketplaceDetails;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.NetworkProfile;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.PanoramaConfig;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.PlanData;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ProvisioningState;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.RulestackDetails;
import java.io.IOException;
import java.util.List;

/**
 * Properties specific to the Firewall resource deployment.
 */
@Fluent
public final class FirewallDeploymentProperties implements JsonSerializable<FirewallDeploymentProperties> {
    /*
     * panEtag info
     */
    private String panEtag;

    /*
     * Network settings
     */
    private NetworkProfile networkProfile;

    /*
     * Panorama Managed: Default is False. Default will be CloudSec managed
     */
    private BooleanEnum isPanoramaManaged;

    /*
     * Panorama Configuration
     */
    private PanoramaConfig panoramaConfig;

    /*
     * Associated Rulestack
     */
    private RulestackDetails associatedRulestack;

    /*
     * DNS settings for Firewall
     */
    private DnsSettings dnsSettings;

    /*
     * Frontend settings for Firewall
     */
    private List<FrontendSetting> frontEndSettings;

    /*
     * Provisioning state of the resource.
     */
    private ProvisioningState provisioningState;

    /*
     * Billing plan information.
     */
    private PlanData planData;

    /*
     * Marketplace details
     */
    private MarketplaceDetails marketplaceDetails;

    /**
     * Creates an instance of FirewallDeploymentProperties class.
     */
    public FirewallDeploymentProperties() {
    }

    /**
     * Get the panEtag property: panEtag info.
     * 
     * @return the panEtag value.
     */
    public String panEtag() {
        return this.panEtag;
    }

    /**
     * Set the panEtag property: panEtag info.
     * 
     * @param panEtag the panEtag value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withPanEtag(String panEtag) {
        this.panEtag = panEtag;
        return this;
    }

    /**
     * Get the networkProfile property: Network settings.
     * 
     * @return the networkProfile value.
     */
    public NetworkProfile networkProfile() {
        return this.networkProfile;
    }

    /**
     * Set the networkProfile property: Network settings.
     * 
     * @param networkProfile the networkProfile value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withNetworkProfile(NetworkProfile networkProfile) {
        this.networkProfile = networkProfile;
        return this;
    }

    /**
     * Get the isPanoramaManaged property: Panorama Managed: Default is False. Default will be CloudSec managed.
     * 
     * @return the isPanoramaManaged value.
     */
    public BooleanEnum isPanoramaManaged() {
        return this.isPanoramaManaged;
    }

    /**
     * Set the isPanoramaManaged property: Panorama Managed: Default is False. Default will be CloudSec managed.
     * 
     * @param isPanoramaManaged the isPanoramaManaged value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withIsPanoramaManaged(BooleanEnum isPanoramaManaged) {
        this.isPanoramaManaged = isPanoramaManaged;
        return this;
    }

    /**
     * Get the panoramaConfig property: Panorama Configuration.
     * 
     * @return the panoramaConfig value.
     */
    public PanoramaConfig panoramaConfig() {
        return this.panoramaConfig;
    }

    /**
     * Set the panoramaConfig property: Panorama Configuration.
     * 
     * @param panoramaConfig the panoramaConfig value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withPanoramaConfig(PanoramaConfig panoramaConfig) {
        this.panoramaConfig = panoramaConfig;
        return this;
    }

    /**
     * Get the associatedRulestack property: Associated Rulestack.
     * 
     * @return the associatedRulestack value.
     */
    public RulestackDetails associatedRulestack() {
        return this.associatedRulestack;
    }

    /**
     * Set the associatedRulestack property: Associated Rulestack.
     * 
     * @param associatedRulestack the associatedRulestack value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withAssociatedRulestack(RulestackDetails associatedRulestack) {
        this.associatedRulestack = associatedRulestack;
        return this;
    }

    /**
     * Get the dnsSettings property: DNS settings for Firewall.
     * 
     * @return the dnsSettings value.
     */
    public DnsSettings dnsSettings() {
        return this.dnsSettings;
    }

    /**
     * Set the dnsSettings property: DNS settings for Firewall.
     * 
     * @param dnsSettings the dnsSettings value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withDnsSettings(DnsSettings dnsSettings) {
        this.dnsSettings = dnsSettings;
        return this;
    }

    /**
     * Get the frontEndSettings property: Frontend settings for Firewall.
     * 
     * @return the frontEndSettings value.
     */
    public List<FrontendSetting> frontEndSettings() {
        return this.frontEndSettings;
    }

    /**
     * Set the frontEndSettings property: Frontend settings for Firewall.
     * 
     * @param frontEndSettings the frontEndSettings value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withFrontEndSettings(List<FrontendSetting> frontEndSettings) {
        this.frontEndSettings = frontEndSettings;
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the planData property: Billing plan information.
     * 
     * @return the planData value.
     */
    public PlanData planData() {
        return this.planData;
    }

    /**
     * Set the planData property: Billing plan information.
     * 
     * @param planData the planData value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withPlanData(PlanData planData) {
        this.planData = planData;
        return this;
    }

    /**
     * Get the marketplaceDetails property: Marketplace details.
     * 
     * @return the marketplaceDetails value.
     */
    public MarketplaceDetails marketplaceDetails() {
        return this.marketplaceDetails;
    }

    /**
     * Set the marketplaceDetails property: Marketplace details.
     * 
     * @param marketplaceDetails the marketplaceDetails value to set.
     * @return the FirewallDeploymentProperties object itself.
     */
    public FirewallDeploymentProperties withMarketplaceDetails(MarketplaceDetails marketplaceDetails) {
        this.marketplaceDetails = marketplaceDetails;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (networkProfile() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property networkProfile in model FirewallDeploymentProperties"));
        } else {
            networkProfile().validate();
        }
        if (panoramaConfig() != null) {
            panoramaConfig().validate();
        }
        if (associatedRulestack() != null) {
            associatedRulestack().validate();
        }
        if (dnsSettings() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property dnsSettings in model FirewallDeploymentProperties"));
        } else {
            dnsSettings().validate();
        }
        if (frontEndSettings() != null) {
            frontEndSettings().forEach(e -> e.validate());
        }
        if (planData() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property planData in model FirewallDeploymentProperties"));
        } else {
            planData().validate();
        }
        if (marketplaceDetails() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property marketplaceDetails in model FirewallDeploymentProperties"));
        } else {
            marketplaceDetails().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(FirewallDeploymentProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("networkProfile", this.networkProfile);
        jsonWriter.writeJsonField("dnsSettings", this.dnsSettings);
        jsonWriter.writeJsonField("planData", this.planData);
        jsonWriter.writeJsonField("marketplaceDetails", this.marketplaceDetails);
        jsonWriter.writeStringField("panEtag", this.panEtag);
        jsonWriter.writeStringField("isPanoramaManaged",
            this.isPanoramaManaged == null ? null : this.isPanoramaManaged.toString());
        jsonWriter.writeJsonField("panoramaConfig", this.panoramaConfig);
        jsonWriter.writeJsonField("associatedRulestack", this.associatedRulestack);
        jsonWriter.writeArrayField("frontEndSettings", this.frontEndSettings,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FirewallDeploymentProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FirewallDeploymentProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FirewallDeploymentProperties.
     */
    public static FirewallDeploymentProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FirewallDeploymentProperties deserializedFirewallDeploymentProperties = new FirewallDeploymentProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("networkProfile".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.networkProfile = NetworkProfile.fromJson(reader);
                } else if ("dnsSettings".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.dnsSettings = DnsSettings.fromJson(reader);
                } else if ("planData".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.planData = PlanData.fromJson(reader);
                } else if ("marketplaceDetails".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.marketplaceDetails = MarketplaceDetails.fromJson(reader);
                } else if ("panEtag".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.panEtag = reader.getString();
                } else if ("isPanoramaManaged".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.isPanoramaManaged
                        = BooleanEnum.fromString(reader.getString());
                } else if ("panoramaConfig".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.panoramaConfig = PanoramaConfig.fromJson(reader);
                } else if ("associatedRulestack".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.associatedRulestack = RulestackDetails.fromJson(reader);
                } else if ("frontEndSettings".equals(fieldName)) {
                    List<FrontendSetting> frontEndSettings
                        = reader.readArray(reader1 -> FrontendSetting.fromJson(reader1));
                    deserializedFirewallDeploymentProperties.frontEndSettings = frontEndSettings;
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedFirewallDeploymentProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFirewallDeploymentProperties;
        });
    }
}
