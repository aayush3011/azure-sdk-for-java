// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.implementation;

import com.azure.resourcemanager.machinelearning.fluent.models.ComputeSecretsInner;
import com.azure.resourcemanager.machinelearning.models.ComputeSecrets;
import com.azure.resourcemanager.machinelearning.models.ComputeType;

public final class ComputeSecretsImpl implements ComputeSecrets {
    private ComputeSecretsInner innerObject;

    private final com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager;

    ComputeSecretsImpl(ComputeSecretsInner innerObject,
        com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public ComputeType computeType() {
        return this.innerModel().computeType();
    }

    public ComputeSecretsInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.machinelearning.MachineLearningManager manager() {
        return this.serviceManager;
    }
}
