// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.generated;

/**
 * Samples for WorkflowRunActionScopeRepetitions List.
 */
public final class WorkflowRunActionScopeRepetitionsListSamples {
    /*
     * x-ms-original-file: specification/logic/resource-manager/Microsoft.Logic/stable/2019-05-01/examples/
     * WorkflowRunActionScopeRepetitions_List.json
     */
    /**
     * Sample code: List the scoped repetitions.
     * 
     * @param manager Entry point to LogicManager.
     */
    public static void listTheScopedRepetitions(com.azure.resourcemanager.logic.LogicManager manager) {
        manager.workflowRunActionScopeRepetitions()
            .list("testResourceGroup", "testFlow", "08586776228332053161046300351", "for_each",
                com.azure.core.util.Context.NONE);
    }
}
