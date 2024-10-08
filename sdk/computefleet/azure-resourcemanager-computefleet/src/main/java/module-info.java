// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

module com.azure.resourcemanager.computefleet {
    requires transitive com.azure.core.management;

    exports com.azure.resourcemanager.computefleet;
    exports com.azure.resourcemanager.computefleet.fluent;
    exports com.azure.resourcemanager.computefleet.fluent.models;
    exports com.azure.resourcemanager.computefleet.models;

    opens com.azure.resourcemanager.computefleet.fluent.models to com.azure.core;
    opens com.azure.resourcemanager.computefleet.models to com.azure.core;
    opens com.azure.resourcemanager.computefleet.implementation.models to com.azure.core;
}
