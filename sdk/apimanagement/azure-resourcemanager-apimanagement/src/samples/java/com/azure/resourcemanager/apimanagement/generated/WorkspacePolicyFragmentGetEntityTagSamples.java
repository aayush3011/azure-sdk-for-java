// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

/**
 * Samples for WorkspacePolicyFragment GetEntityTag.
 */
public final class WorkspacePolicyFragmentGetEntityTagSamples {
    /*
     * x-ms-original-file:
     * specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2024-05-01/examples/
     * ApiManagementHeadWorkspacePolicyFragment.json
     */
    /**
     * Sample code: ApiManagementHeadWorkspacePolicyFragment.
     * 
     * @param manager Entry point to ApiManagementManager.
     */
    public static void
        apiManagementHeadWorkspacePolicyFragment(com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.workspacePolicyFragments()
            .getEntityTagWithResponse("rg1", "apimService1", "wks1", "policyFragment1",
                com.azure.core.util.Context.NONE);
    }
}
