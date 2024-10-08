// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The output format for the exported resources.
 */
public final class ExportTemplateOutputFormat extends ExpandableStringEnum<ExportTemplateOutputFormat> {
    /**
     * Static value Json for ExportTemplateOutputFormat.
     */
    public static final ExportTemplateOutputFormat JSON = fromString("Json");

    /**
     * Static value Bicep for ExportTemplateOutputFormat.
     */
    public static final ExportTemplateOutputFormat BICEP = fromString("Bicep");

    /**
     * Creates a new instance of ExportTemplateOutputFormat value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ExportTemplateOutputFormat() {
    }

    /**
     * Creates or finds a ExportTemplateOutputFormat from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ExportTemplateOutputFormat.
     */
    public static ExportTemplateOutputFormat fromString(String name) {
        return fromString(name, ExportTemplateOutputFormat.class);
    }

    /**
     * Gets known ExportTemplateOutputFormat values.
     * 
     * @return known ExportTemplateOutputFormat values.
     */
    public static Collection<ExportTemplateOutputFormat> values() {
        return values(ExportTemplateOutputFormat.class);
    }
}
