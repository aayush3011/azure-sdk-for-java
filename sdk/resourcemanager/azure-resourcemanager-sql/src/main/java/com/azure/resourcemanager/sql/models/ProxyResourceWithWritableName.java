// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.models;

import com.azure.core.annotation.Fluent;

/** ARM proxy resource. */
@Fluent
public class ProxyResourceWithWritableName extends ResourceWithWritableName {
    /** Creates an instance of ProxyResourceWithWritableName class. */
    public ProxyResourceWithWritableName() {
    }

    /** {@inheritDoc} */
    @Override
    public ProxyResourceWithWritableName withName(String name) {
        super.withName(name);
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
}
