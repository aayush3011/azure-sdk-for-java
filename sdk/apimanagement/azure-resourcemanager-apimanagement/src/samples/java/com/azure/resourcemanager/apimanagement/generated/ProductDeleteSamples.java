// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

/**
 * Samples for Product Delete.
 */
public final class ProductDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2024-05-01/examples/
     * ApiManagementDeleteProduct.json
     */
    /**
     * Sample code: ApiManagementDeleteProduct.
     * 
     * @param manager Entry point to ApiManagementManager.
     */
    public static void
        apiManagementDeleteProduct(com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.products()
            .deleteWithResponse("rg1", "apimService1", "testproduct", "*", true, com.azure.core.util.Context.NONE);
    }
}
