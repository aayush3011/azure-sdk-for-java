// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appservice.models.StackMajorVersion;
import java.io.IOException;
import java.util.List;

/**
 * Application stack.
 */
@Fluent
public final class ApplicationStack implements JsonSerializable<ApplicationStack> {
    /*
     * Application stack name.
     */
    private String name;

    /*
     * Application stack display name.
     */
    private String display;

    /*
     * Application stack dependency.
     */
    private String dependency;

    /*
     * List of major versions available.
     */
    private List<StackMajorVersion> majorVersions;

    /*
     * List of frameworks associated with application stack.
     */
    private List<ApplicationStack> frameworks;

    /*
     * <code>true</code> if this is the stack is deprecated; otherwise, <code>false</code>.
     */
    private List<ApplicationStack> isDeprecated;

    /**
     * Creates an instance of ApplicationStack class.
     */
    public ApplicationStack() {
    }

    /**
     * Get the name property: Application stack name.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Application stack name.
     * 
     * @param name the name value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the display property: Application stack display name.
     * 
     * @return the display value.
     */
    public String display() {
        return this.display;
    }

    /**
     * Set the display property: Application stack display name.
     * 
     * @param display the display value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withDisplay(String display) {
        this.display = display;
        return this;
    }

    /**
     * Get the dependency property: Application stack dependency.
     * 
     * @return the dependency value.
     */
    public String dependency() {
        return this.dependency;
    }

    /**
     * Set the dependency property: Application stack dependency.
     * 
     * @param dependency the dependency value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withDependency(String dependency) {
        this.dependency = dependency;
        return this;
    }

    /**
     * Get the majorVersions property: List of major versions available.
     * 
     * @return the majorVersions value.
     */
    public List<StackMajorVersion> majorVersions() {
        return this.majorVersions;
    }

    /**
     * Set the majorVersions property: List of major versions available.
     * 
     * @param majorVersions the majorVersions value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withMajorVersions(List<StackMajorVersion> majorVersions) {
        this.majorVersions = majorVersions;
        return this;
    }

    /**
     * Get the frameworks property: List of frameworks associated with application stack.
     * 
     * @return the frameworks value.
     */
    public List<ApplicationStack> frameworks() {
        return this.frameworks;
    }

    /**
     * Set the frameworks property: List of frameworks associated with application stack.
     * 
     * @param frameworks the frameworks value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withFrameworks(List<ApplicationStack> frameworks) {
        this.frameworks = frameworks;
        return this;
    }

    /**
     * Get the isDeprecated property: &lt;code&gt;true&lt;/code&gt; if this is the stack is deprecated; otherwise,
     * &lt;code&gt;false&lt;/code&gt;.
     * 
     * @return the isDeprecated value.
     */
    public List<ApplicationStack> isDeprecated() {
        return this.isDeprecated;
    }

    /**
     * Set the isDeprecated property: &lt;code&gt;true&lt;/code&gt; if this is the stack is deprecated; otherwise,
     * &lt;code&gt;false&lt;/code&gt;.
     * 
     * @param isDeprecated the isDeprecated value to set.
     * @return the ApplicationStack object itself.
     */
    public ApplicationStack withIsDeprecated(List<ApplicationStack> isDeprecated) {
        this.isDeprecated = isDeprecated;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (majorVersions() != null) {
            majorVersions().forEach(e -> e.validate());
        }
        if (frameworks() != null) {
            frameworks().forEach(e -> e.validate());
        }
        if (isDeprecated() != null) {
            isDeprecated().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("display", this.display);
        jsonWriter.writeStringField("dependency", this.dependency);
        jsonWriter.writeArrayField("majorVersions", this.majorVersions, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("frameworks", this.frameworks, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("isDeprecated", this.isDeprecated, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApplicationStack from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationStack if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ApplicationStack.
     */
    public static ApplicationStack fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationStack deserializedApplicationStack = new ApplicationStack();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedApplicationStack.name = reader.getString();
                } else if ("display".equals(fieldName)) {
                    deserializedApplicationStack.display = reader.getString();
                } else if ("dependency".equals(fieldName)) {
                    deserializedApplicationStack.dependency = reader.getString();
                } else if ("majorVersions".equals(fieldName)) {
                    List<StackMajorVersion> majorVersions
                        = reader.readArray(reader1 -> StackMajorVersion.fromJson(reader1));
                    deserializedApplicationStack.majorVersions = majorVersions;
                } else if ("frameworks".equals(fieldName)) {
                    List<ApplicationStack> frameworks = reader.readArray(reader1 -> ApplicationStack.fromJson(reader1));
                    deserializedApplicationStack.frameworks = frameworks;
                } else if ("isDeprecated".equals(fieldName)) {
                    List<ApplicationStack> isDeprecated
                        = reader.readArray(reader1 -> ApplicationStack.fromJson(reader1));
                    deserializedApplicationStack.isDeprecated = isDeprecated;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationStack;
        });
    }
}
