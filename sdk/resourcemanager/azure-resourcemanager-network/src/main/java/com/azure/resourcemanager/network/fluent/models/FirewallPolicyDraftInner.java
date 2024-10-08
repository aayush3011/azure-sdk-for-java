// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SubResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.AzureFirewallThreatIntelMode;
import com.azure.resourcemanager.network.models.DnsSettings;
import com.azure.resourcemanager.network.models.ExplicitProxy;
import com.azure.resourcemanager.network.models.FirewallPolicyInsights;
import com.azure.resourcemanager.network.models.FirewallPolicyIntrusionDetection;
import com.azure.resourcemanager.network.models.FirewallPolicySnat;
import com.azure.resourcemanager.network.models.FirewallPolicySql;
import com.azure.resourcemanager.network.models.FirewallPolicyThreatIntelWhitelist;
import java.io.IOException;
import java.util.Map;

/**
 * FirewallPolicy Resource.
 */
@Fluent
public final class FirewallPolicyDraftInner extends Resource {
    /*
     * Properties of the firewall policy.
     */
    private FirewallPolicyDraftProperties innerProperties;

    /*
     * Resource ID.
     */
    private String id;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /**
     * Creates an instance of FirewallPolicyDraftInner class.
     */
    public FirewallPolicyDraftInner() {
    }

    /**
     * Get the innerProperties property: Properties of the firewall policy.
     * 
     * @return the innerProperties value.
     */
    private FirewallPolicyDraftProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the id property: Resource ID.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Resource ID.
     * 
     * @param id the id value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withId(String id) {
        this.id = id;
        return this;
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
     * {@inheritDoc}
     */
    @Override
    public FirewallPolicyDraftInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallPolicyDraftInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the basePolicy property: The parent firewall policy from which rules are inherited.
     * 
     * @return the basePolicy value.
     */
    public SubResource basePolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().basePolicy();
    }

    /**
     * Set the basePolicy property: The parent firewall policy from which rules are inherited.
     * 
     * @param basePolicy the basePolicy value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withBasePolicy(SubResource basePolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withBasePolicy(basePolicy);
        return this;
    }

    /**
     * Get the threatIntelMode property: The operation mode for Threat Intelligence.
     * 
     * @return the threatIntelMode value.
     */
    public AzureFirewallThreatIntelMode threatIntelMode() {
        return this.innerProperties() == null ? null : this.innerProperties().threatIntelMode();
    }

    /**
     * Set the threatIntelMode property: The operation mode for Threat Intelligence.
     * 
     * @param threatIntelMode the threatIntelMode value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withThreatIntelMode(AzureFirewallThreatIntelMode threatIntelMode) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withThreatIntelMode(threatIntelMode);
        return this;
    }

    /**
     * Get the threatIntelWhitelist property: ThreatIntel Whitelist for Firewall Policy.
     * 
     * @return the threatIntelWhitelist value.
     */
    public FirewallPolicyThreatIntelWhitelist threatIntelWhitelist() {
        return this.innerProperties() == null ? null : this.innerProperties().threatIntelWhitelist();
    }

    /**
     * Set the threatIntelWhitelist property: ThreatIntel Whitelist for Firewall Policy.
     * 
     * @param threatIntelWhitelist the threatIntelWhitelist value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withThreatIntelWhitelist(FirewallPolicyThreatIntelWhitelist threatIntelWhitelist) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withThreatIntelWhitelist(threatIntelWhitelist);
        return this;
    }

    /**
     * Get the insights property: Insights on Firewall Policy.
     * 
     * @return the insights value.
     */
    public FirewallPolicyInsights insights() {
        return this.innerProperties() == null ? null : this.innerProperties().insights();
    }

    /**
     * Set the insights property: Insights on Firewall Policy.
     * 
     * @param insights the insights value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withInsights(FirewallPolicyInsights insights) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withInsights(insights);
        return this;
    }

    /**
     * Get the snat property: The private IP addresses/IP ranges to which traffic will not be SNAT.
     * 
     * @return the snat value.
     */
    public FirewallPolicySnat snat() {
        return this.innerProperties() == null ? null : this.innerProperties().snat();
    }

    /**
     * Set the snat property: The private IP addresses/IP ranges to which traffic will not be SNAT.
     * 
     * @param snat the snat value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withSnat(FirewallPolicySnat snat) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withSnat(snat);
        return this;
    }

    /**
     * Get the sql property: SQL Settings definition.
     * 
     * @return the sql value.
     */
    public FirewallPolicySql sql() {
        return this.innerProperties() == null ? null : this.innerProperties().sql();
    }

    /**
     * Set the sql property: SQL Settings definition.
     * 
     * @param sql the sql value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withSql(FirewallPolicySql sql) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withSql(sql);
        return this;
    }

    /**
     * Get the dnsSettings property: DNS Proxy Settings definition.
     * 
     * @return the dnsSettings value.
     */
    public DnsSettings dnsSettings() {
        return this.innerProperties() == null ? null : this.innerProperties().dnsSettings();
    }

    /**
     * Set the dnsSettings property: DNS Proxy Settings definition.
     * 
     * @param dnsSettings the dnsSettings value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withDnsSettings(DnsSettings dnsSettings) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withDnsSettings(dnsSettings);
        return this;
    }

    /**
     * Get the explicitProxy property: Explicit Proxy Settings definition.
     * 
     * @return the explicitProxy value.
     */
    public ExplicitProxy explicitProxy() {
        return this.innerProperties() == null ? null : this.innerProperties().explicitProxy();
    }

    /**
     * Set the explicitProxy property: Explicit Proxy Settings definition.
     * 
     * @param explicitProxy the explicitProxy value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withExplicitProxy(ExplicitProxy explicitProxy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withExplicitProxy(explicitProxy);
        return this;
    }

    /**
     * Get the intrusionDetection property: The configuration for Intrusion detection.
     * 
     * @return the intrusionDetection value.
     */
    public FirewallPolicyIntrusionDetection intrusionDetection() {
        return this.innerProperties() == null ? null : this.innerProperties().intrusionDetection();
    }

    /**
     * Set the intrusionDetection property: The configuration for Intrusion detection.
     * 
     * @param intrusionDetection the intrusionDetection value to set.
     * @return the FirewallPolicyDraftInner object itself.
     */
    public FirewallPolicyDraftInner withIntrusionDetection(FirewallPolicyIntrusionDetection intrusionDetection) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FirewallPolicyDraftProperties();
        }
        this.innerProperties().withIntrusionDetection(intrusionDetection);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
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
        jsonWriter.writeJsonField("properties", this.innerProperties);
        jsonWriter.writeStringField("id", this.id);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FirewallPolicyDraftInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FirewallPolicyDraftInner if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FirewallPolicyDraftInner.
     */
    public static FirewallPolicyDraftInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FirewallPolicyDraftInner deserializedFirewallPolicyDraftInner = new FirewallPolicyDraftInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedFirewallPolicyDraftInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedFirewallPolicyDraftInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedFirewallPolicyDraftInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedFirewallPolicyDraftInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedFirewallPolicyDraftInner.innerProperties
                        = FirewallPolicyDraftProperties.fromJson(reader);
                } else if ("id".equals(fieldName)) {
                    deserializedFirewallPolicyDraftInner.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFirewallPolicyDraftInner;
        });
    }
}
