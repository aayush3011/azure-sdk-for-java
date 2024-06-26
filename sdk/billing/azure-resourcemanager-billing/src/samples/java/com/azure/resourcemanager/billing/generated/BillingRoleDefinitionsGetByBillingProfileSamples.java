// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

/** Samples for BillingRoleDefinitions GetByBillingProfile. */
public final class BillingRoleDefinitionsGetByBillingProfileSamples {
    /*
     * x-ms-original-file: specification/billing/resource-manager/Microsoft.Billing/stable/2020-05-01/examples/BillingProfileRoleDefinition.json
     */
    /**
     * Sample code: BillingProfileRoleDefinition.
     *
     * @param manager Entry point to BillingManager.
     */
    public static void billingProfileRoleDefinition(com.azure.resourcemanager.billing.BillingManager manager) {
        manager
            .billingRoleDefinitions()
            .getByBillingProfileWithResponse(
                "{billingAccountName}",
                "{billingProfileName}",
                "{billingRoleDefinitionName}",
                com.azure.core.util.Context.NONE);
    }
}
