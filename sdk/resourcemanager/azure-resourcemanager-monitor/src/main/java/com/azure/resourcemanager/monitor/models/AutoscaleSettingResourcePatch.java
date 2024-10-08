// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.monitor.fluent.models.AutoscaleProfileInner;
import com.azure.resourcemanager.monitor.fluent.models.AutoscaleSetting;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The autoscale setting object for patch operations.
 */
@Fluent
public final class AutoscaleSettingResourcePatch implements JsonSerializable<AutoscaleSettingResourcePatch> {
    /*
     * Resource tags
     */
    private Map<String, String> tags;

    /*
     * The autoscale setting properties of the update operation.
     */
    private AutoscaleSetting innerProperties;

    /**
     * Creates an instance of AutoscaleSettingResourcePatch class.
     */
    public AutoscaleSettingResourcePatch() {
    }

    /**
     * Get the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Resource tags.
     * 
     * @param tags the tags value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the innerProperties property: The autoscale setting properties of the update operation.
     * 
     * @return the innerProperties value.
     */
    private AutoscaleSetting innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the profiles property: the collection of automatic scaling profiles that specify different scaling parameters
     * for different time periods. A maximum of 20 profiles can be specified.
     * 
     * @return the profiles value.
     */
    public List<AutoscaleProfileInner> profiles() {
        return this.innerProperties() == null ? null : this.innerProperties().profiles();
    }

    /**
     * Set the profiles property: the collection of automatic scaling profiles that specify different scaling parameters
     * for different time periods. A maximum of 20 profiles can be specified.
     * 
     * @param profiles the profiles value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withProfiles(List<AutoscaleProfileInner> profiles) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withProfiles(profiles);
        return this;
    }

    /**
     * Get the notifications property: the collection of notifications.
     * 
     * @return the notifications value.
     */
    public List<AutoscaleNotification> notifications() {
        return this.innerProperties() == null ? null : this.innerProperties().notifications();
    }

    /**
     * Set the notifications property: the collection of notifications.
     * 
     * @param notifications the notifications value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withNotifications(List<AutoscaleNotification> notifications) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withNotifications(notifications);
        return this;
    }

    /**
     * Get the enabled property: the enabled flag. Specifies whether automatic scaling is enabled for the resource. The
     * default value is 'false'.
     * 
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.innerProperties() == null ? null : this.innerProperties().enabled();
    }

    /**
     * Set the enabled property: the enabled flag. Specifies whether automatic scaling is enabled for the resource. The
     * default value is 'false'.
     * 
     * @param enabled the enabled value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withEnabled(Boolean enabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withEnabled(enabled);
        return this;
    }

    /**
     * Get the predictiveAutoscalePolicy property: the predictive autoscale policy mode.
     * 
     * @return the predictiveAutoscalePolicy value.
     */
    public PredictiveAutoscalePolicy predictiveAutoscalePolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().predictiveAutoscalePolicy();
    }

    /**
     * Set the predictiveAutoscalePolicy property: the predictive autoscale policy mode.
     * 
     * @param predictiveAutoscalePolicy the predictiveAutoscalePolicy value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch
        withPredictiveAutoscalePolicy(PredictiveAutoscalePolicy predictiveAutoscalePolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withPredictiveAutoscalePolicy(predictiveAutoscalePolicy);
        return this;
    }

    /**
     * Get the name property: the name of the autoscale setting.
     * 
     * @return the name value.
     */
    public String name() {
        return this.innerProperties() == null ? null : this.innerProperties().name();
    }

    /**
     * Set the name property: the name of the autoscale setting.
     * 
     * @param name the name value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withName(String name) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withName(name);
        return this;
    }

    /**
     * Get the targetResourceUri property: the resource identifier of the resource that the autoscale setting should be
     * added to.
     * 
     * @return the targetResourceUri value.
     */
    public String targetResourceUri() {
        return this.innerProperties() == null ? null : this.innerProperties().targetResourceUri();
    }

    /**
     * Set the targetResourceUri property: the resource identifier of the resource that the autoscale setting should be
     * added to.
     * 
     * @param targetResourceUri the targetResourceUri value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withTargetResourceUri(String targetResourceUri) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withTargetResourceUri(targetResourceUri);
        return this;
    }

    /**
     * Get the targetResourceLocation property: the location of the resource that the autoscale setting should be added
     * to.
     * 
     * @return the targetResourceLocation value.
     */
    public String targetResourceLocation() {
        return this.innerProperties() == null ? null : this.innerProperties().targetResourceLocation();
    }

    /**
     * Set the targetResourceLocation property: the location of the resource that the autoscale setting should be added
     * to.
     * 
     * @param targetResourceLocation the targetResourceLocation value to set.
     * @return the AutoscaleSettingResourcePatch object itself.
     */
    public AutoscaleSettingResourcePatch withTargetResourceLocation(String targetResourceLocation) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutoscaleSetting();
        }
        this.innerProperties().withTargetResourceLocation(targetResourceLocation);
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
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutoscaleSettingResourcePatch from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutoscaleSettingResourcePatch if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AutoscaleSettingResourcePatch.
     */
    public static AutoscaleSettingResourcePatch fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutoscaleSettingResourcePatch deserializedAutoscaleSettingResourcePatch
                = new AutoscaleSettingResourcePatch();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedAutoscaleSettingResourcePatch.tags = tags;
                } else if ("properties".equals(fieldName)) {
                    deserializedAutoscaleSettingResourcePatch.innerProperties = AutoscaleSetting.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutoscaleSettingResourcePatch;
        });
    }
}
