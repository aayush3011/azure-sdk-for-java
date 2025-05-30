// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.implementation;

import com.azure.core.management.SystemData;
import com.azure.resourcemanager.migration.assessment.fluent.models.AvsAssessedMachineInner;
import com.azure.resourcemanager.migration.assessment.models.AvsAssessedMachine;
import com.azure.resourcemanager.migration.assessment.models.AvsAssessedMachineProperties;

public final class AvsAssessedMachineImpl implements AvsAssessedMachine {
    private AvsAssessedMachineInner innerObject;

    private final com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager serviceManager;

    AvsAssessedMachineImpl(AvsAssessedMachineInner innerObject,
        com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public AvsAssessedMachineProperties properties() {
        return this.innerModel().properties();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public AvsAssessedMachineInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager manager() {
        return this.serviceManager;
    }
}
