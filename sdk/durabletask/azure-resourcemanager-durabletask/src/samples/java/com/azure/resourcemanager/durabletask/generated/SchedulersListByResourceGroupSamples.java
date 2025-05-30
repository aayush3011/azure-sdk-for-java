// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.durabletask.generated;

/**
 * Samples for Schedulers ListByResourceGroup.
 */
public final class SchedulersListByResourceGroupSamples {
    /*
     * x-ms-original-file: 2025-04-01-preview/Schedulers_ListByResourceGroup.json
     */
    /**
     * Sample code: Schedulers_ListByResourceGroup.
     * 
     * @param manager Entry point to DurableTaskManager.
     */
    public static void schedulersListByResourceGroup(com.azure.resourcemanager.durabletask.DurableTaskManager manager) {
        manager.schedulers().listByResourceGroup("rgopenapi", com.azure.core.util.Context.NONE);
    }
}
