// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.portalservicescopilot.generated;

/**
 * Samples for Operations List.
 */
public final class OperationsListSamples {
    /*
     * x-ms-original-file: 2024-04-01-preview/Operations_List.json
     */
    /**
     * Sample code: List the operations for the Microsoft.PortalServices provider.
     * 
     * @param manager Entry point to PortalServicesCopilotManager.
     */
    public static void listTheOperationsForTheMicrosoftPortalServicesProvider(
        com.azure.resourcemanager.portalservicescopilot.PortalServicesCopilotManager manager) {
        manager.operations().list(com.azure.core.util.Context.NONE);
    }
}
