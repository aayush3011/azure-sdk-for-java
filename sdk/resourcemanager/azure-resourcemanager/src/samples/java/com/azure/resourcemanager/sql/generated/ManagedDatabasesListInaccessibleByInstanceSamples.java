// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

/**
 * Samples for ManagedDatabases ListInaccessibleByInstance.
 */
public final class ManagedDatabasesListInaccessibleByInstanceSamples {
    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/stable/2021-11-01/examples/
     * InaccessibleManagedDatabaseListByManagedInstance.json
     */
    /**
     * Sample code: List inaccessible managed databases by managed instances.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        listInaccessibleManagedDatabasesByManagedInstances(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.sqlServers()
            .manager()
            .serviceClient()
            .getManagedDatabases()
            .listInaccessibleByInstance("testrg", "testcl", com.azure.core.util.Context.NONE);
    }
}
