// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.containers.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Trino Cluster profile.
 */
@Fluent
public final class TrinoProfile implements JsonSerializable<TrinoProfile> {
    /*
     * Trino cluster catalog options.
     */
    private CatalogOptions catalogOptions;

    /*
     * Trino Coordinator.
     */
    private TrinoCoordinator coordinator;

    /*
     * Trino user plugins spec
     */
    private TrinoUserPlugins userPluginsSpec;

    /*
     * User telemetry
     */
    private TrinoUserTelemetry userTelemetrySpec;

    /*
     * Trino worker.
     */
    private TrinoWorker worker;

    /**
     * Creates an instance of TrinoProfile class.
     */
    public TrinoProfile() {
    }

    /**
     * Get the catalogOptions property: Trino cluster catalog options.
     * 
     * @return the catalogOptions value.
     */
    public CatalogOptions catalogOptions() {
        return this.catalogOptions;
    }

    /**
     * Set the catalogOptions property: Trino cluster catalog options.
     * 
     * @param catalogOptions the catalogOptions value to set.
     * @return the TrinoProfile object itself.
     */
    public TrinoProfile withCatalogOptions(CatalogOptions catalogOptions) {
        this.catalogOptions = catalogOptions;
        return this;
    }

    /**
     * Get the coordinator property: Trino Coordinator.
     * 
     * @return the coordinator value.
     */
    public TrinoCoordinator coordinator() {
        return this.coordinator;
    }

    /**
     * Set the coordinator property: Trino Coordinator.
     * 
     * @param coordinator the coordinator value to set.
     * @return the TrinoProfile object itself.
     */
    public TrinoProfile withCoordinator(TrinoCoordinator coordinator) {
        this.coordinator = coordinator;
        return this;
    }

    /**
     * Get the userPluginsSpec property: Trino user plugins spec.
     * 
     * @return the userPluginsSpec value.
     */
    public TrinoUserPlugins userPluginsSpec() {
        return this.userPluginsSpec;
    }

    /**
     * Set the userPluginsSpec property: Trino user plugins spec.
     * 
     * @param userPluginsSpec the userPluginsSpec value to set.
     * @return the TrinoProfile object itself.
     */
    public TrinoProfile withUserPluginsSpec(TrinoUserPlugins userPluginsSpec) {
        this.userPluginsSpec = userPluginsSpec;
        return this;
    }

    /**
     * Get the userTelemetrySpec property: User telemetry.
     * 
     * @return the userTelemetrySpec value.
     */
    public TrinoUserTelemetry userTelemetrySpec() {
        return this.userTelemetrySpec;
    }

    /**
     * Set the userTelemetrySpec property: User telemetry.
     * 
     * @param userTelemetrySpec the userTelemetrySpec value to set.
     * @return the TrinoProfile object itself.
     */
    public TrinoProfile withUserTelemetrySpec(TrinoUserTelemetry userTelemetrySpec) {
        this.userTelemetrySpec = userTelemetrySpec;
        return this;
    }

    /**
     * Get the worker property: Trino worker.
     * 
     * @return the worker value.
     */
    public TrinoWorker worker() {
        return this.worker;
    }

    /**
     * Set the worker property: Trino worker.
     * 
     * @param worker the worker value to set.
     * @return the TrinoProfile object itself.
     */
    public TrinoProfile withWorker(TrinoWorker worker) {
        this.worker = worker;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (catalogOptions() != null) {
            catalogOptions().validate();
        }
        if (coordinator() != null) {
            coordinator().validate();
        }
        if (userPluginsSpec() != null) {
            userPluginsSpec().validate();
        }
        if (userTelemetrySpec() != null) {
            userTelemetrySpec().validate();
        }
        if (worker() != null) {
            worker().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("catalogOptions", this.catalogOptions);
        jsonWriter.writeJsonField("coordinator", this.coordinator);
        jsonWriter.writeJsonField("userPluginsSpec", this.userPluginsSpec);
        jsonWriter.writeJsonField("userTelemetrySpec", this.userTelemetrySpec);
        jsonWriter.writeJsonField("worker", this.worker);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TrinoProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TrinoProfile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the TrinoProfile.
     */
    public static TrinoProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TrinoProfile deserializedTrinoProfile = new TrinoProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("catalogOptions".equals(fieldName)) {
                    deserializedTrinoProfile.catalogOptions = CatalogOptions.fromJson(reader);
                } else if ("coordinator".equals(fieldName)) {
                    deserializedTrinoProfile.coordinator = TrinoCoordinator.fromJson(reader);
                } else if ("userPluginsSpec".equals(fieldName)) {
                    deserializedTrinoProfile.userPluginsSpec = TrinoUserPlugins.fromJson(reader);
                } else if ("userTelemetrySpec".equals(fieldName)) {
                    deserializedTrinoProfile.userTelemetrySpec = TrinoUserTelemetry.fromJson(reader);
                } else if ("worker".equals(fieldName)) {
                    deserializedTrinoProfile.worker = TrinoWorker.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTrinoProfile;
        });
    }
}
