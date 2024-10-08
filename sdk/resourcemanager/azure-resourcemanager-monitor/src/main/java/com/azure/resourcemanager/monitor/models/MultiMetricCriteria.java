// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The types of conditions for a multi resource alert.
 */
@Fluent
public class MultiMetricCriteria implements JsonSerializable<MultiMetricCriteria> {
    /*
     * Specifies the type of threshold criteria
     */
    private CriterionType criterionType = CriterionType.fromString("MultiMetricCriteria");

    /*
     * Name of the criteria.
     */
    private String name;

    /*
     * Name of the metric.
     */
    private String metricName;

    /*
     * Namespace of the metric.
     */
    private String metricNamespace;

    /*
     * the criteria time aggregation types.
     */
    private AggregationTypeEnum timeAggregation;

    /*
     * List of dimension conditions.
     */
    private List<MetricDimension> dimensions;

    /*
     * Allows creating an alert rule on a custom metric that isn't yet emitted, by causing the metric validation to be
     * skipped.
     */
    private Boolean skipMetricValidation;

    /*
     * The types of conditions for a multi resource alert.
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of MultiMetricCriteria class.
     */
    public MultiMetricCriteria() {
    }

    /**
     * Get the criterionType property: Specifies the type of threshold criteria.
     * 
     * @return the criterionType value.
     */
    public CriterionType criterionType() {
        return this.criterionType;
    }

    /**
     * Get the name property: Name of the criteria.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the criteria.
     * 
     * @param name the name value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the metricName property: Name of the metric.
     * 
     * @return the metricName value.
     */
    public String metricName() {
        return this.metricName;
    }

    /**
     * Set the metricName property: Name of the metric.
     * 
     * @param metricName the metricName value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withMetricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    /**
     * Get the metricNamespace property: Namespace of the metric.
     * 
     * @return the metricNamespace value.
     */
    public String metricNamespace() {
        return this.metricNamespace;
    }

    /**
     * Set the metricNamespace property: Namespace of the metric.
     * 
     * @param metricNamespace the metricNamespace value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withMetricNamespace(String metricNamespace) {
        this.metricNamespace = metricNamespace;
        return this;
    }

    /**
     * Get the timeAggregation property: the criteria time aggregation types.
     * 
     * @return the timeAggregation value.
     */
    public AggregationTypeEnum timeAggregation() {
        return this.timeAggregation;
    }

    /**
     * Set the timeAggregation property: the criteria time aggregation types.
     * 
     * @param timeAggregation the timeAggregation value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withTimeAggregation(AggregationTypeEnum timeAggregation) {
        this.timeAggregation = timeAggregation;
        return this;
    }

    /**
     * Get the dimensions property: List of dimension conditions.
     * 
     * @return the dimensions value.
     */
    public List<MetricDimension> dimensions() {
        return this.dimensions;
    }

    /**
     * Set the dimensions property: List of dimension conditions.
     * 
     * @param dimensions the dimensions value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withDimensions(List<MetricDimension> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * Get the skipMetricValidation property: Allows creating an alert rule on a custom metric that isn't yet emitted,
     * by causing the metric validation to be skipped.
     * 
     * @return the skipMetricValidation value.
     */
    public Boolean skipMetricValidation() {
        return this.skipMetricValidation;
    }

    /**
     * Set the skipMetricValidation property: Allows creating an alert rule on a custom metric that isn't yet emitted,
     * by causing the metric validation to be skipped.
     * 
     * @param skipMetricValidation the skipMetricValidation value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withSkipMetricValidation(Boolean skipMetricValidation) {
        this.skipMetricValidation = skipMetricValidation;
        return this;
    }

    /**
     * Get the additionalProperties property: The types of conditions for a multi resource alert.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: The types of conditions for a multi resource alert.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the MultiMetricCriteria object itself.
     */
    public MultiMetricCriteria withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model MultiMetricCriteria"));
        }
        if (metricName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property metricName in model MultiMetricCriteria"));
        }
        if (timeAggregation() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property timeAggregation in model MultiMetricCriteria"));
        }
        if (dimensions() != null) {
            dimensions().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MultiMetricCriteria.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("metricName", this.metricName);
        jsonWriter.writeStringField("timeAggregation",
            this.timeAggregation == null ? null : this.timeAggregation.toString());
        jsonWriter.writeStringField("criterionType", this.criterionType == null ? null : this.criterionType.toString());
        jsonWriter.writeStringField("metricNamespace", this.metricNamespace);
        jsonWriter.writeArrayField("dimensions", this.dimensions, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeBooleanField("skipMetricValidation", this.skipMetricValidation);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MultiMetricCriteria from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MultiMetricCriteria if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MultiMetricCriteria.
     */
    public static MultiMetricCriteria fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("criterionType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("StaticThresholdCriterion".equals(discriminatorValue)) {
                    return MetricCriteria.fromJson(readerToUse.reset());
                } else if ("DynamicThresholdCriterion".equals(discriminatorValue)) {
                    return DynamicMetricCriteria.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static MultiMetricCriteria fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MultiMetricCriteria deserializedMultiMetricCriteria = new MultiMetricCriteria();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedMultiMetricCriteria.name = reader.getString();
                } else if ("metricName".equals(fieldName)) {
                    deserializedMultiMetricCriteria.metricName = reader.getString();
                } else if ("timeAggregation".equals(fieldName)) {
                    deserializedMultiMetricCriteria.timeAggregation
                        = AggregationTypeEnum.fromString(reader.getString());
                } else if ("criterionType".equals(fieldName)) {
                    deserializedMultiMetricCriteria.criterionType = CriterionType.fromString(reader.getString());
                } else if ("metricNamespace".equals(fieldName)) {
                    deserializedMultiMetricCriteria.metricNamespace = reader.getString();
                } else if ("dimensions".equals(fieldName)) {
                    List<MetricDimension> dimensions = reader.readArray(reader1 -> MetricDimension.fromJson(reader1));
                    deserializedMultiMetricCriteria.dimensions = dimensions;
                } else if ("skipMetricValidation".equals(fieldName)) {
                    deserializedMultiMetricCriteria.skipMetricValidation = reader.getNullable(JsonReader::getBoolean);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedMultiMetricCriteria.additionalProperties = additionalProperties;

            return deserializedMultiMetricCriteria;
        });
    }
}
