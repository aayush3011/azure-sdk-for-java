// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicenetworking.generated;

/**
 * Samples for SecurityPoliciesInterface Delete.
 */
public final class SecurityPoliciesInterfaceDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/servicenetworking/resource-manager/Microsoft.ServiceNetworking/preview/2024-05-01-preview/examples/
     * SecurityPolicyDelete.json
     */
    /**
     * Sample code: Delete SecurityPolicy.
     * 
     * @param manager Entry point to TrafficControllerManager.
     */
    public static void
        deleteSecurityPolicy(com.azure.resourcemanager.servicenetworking.TrafficControllerManager manager) {
        manager.securityPoliciesInterfaces().delete("rg1", "tc1", "sp1", com.azure.core.util.Context.NONE);
    }
}
