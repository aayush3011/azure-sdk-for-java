// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logz.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.logz.fluent.models.LogzMonitorResourceInner;
import com.azure.resourcemanager.logz.fluent.models.MonitoredResourceInner;
import com.azure.resourcemanager.logz.fluent.models.VMExtensionPayloadInner;
import com.azure.resourcemanager.logz.fluent.models.VMResourcesInner;
import com.azure.resourcemanager.logz.models.LogzMonitorResourceUpdateParameters;
import com.azure.resourcemanager.logz.models.VMHostUpdateRequest;

/**
 * An instance of this class provides access to all the operations defined in SubAccountsClient.
 */
public interface SubAccountsClient {
    /**
     * List the sub account under a given monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogzMonitorResourceInner> list(String resourceGroupName, String monitorName);

    /**
     * List the sub account under a given monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LogzMonitorResourceInner> list(String resourceGroupName, String monitorName, Context context);

    /**
     * Create sub account under a given monitor resource. This create operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<LogzMonitorResourceInner>, LogzMonitorResourceInner> beginCreate(String resourceGroupName,
        String monitorName, String subAccountName);

    /**
     * Create sub account under a given monitor resource. This create operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param body The body parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<LogzMonitorResourceInner>, LogzMonitorResourceInner> beginCreate(String resourceGroupName,
        String monitorName, String subAccountName, LogzMonitorResourceInner body, Context context);

    /**
     * Create sub account under a given monitor resource. This create operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogzMonitorResourceInner create(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * Create sub account under a given monitor resource. This create operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param body The body parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogzMonitorResourceInner create(String resourceGroupName, String monitorName, String subAccountName,
        LogzMonitorResourceInner body, Context context);

    /**
     * Get a sub account under a given monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sub account under a given monitor resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogzMonitorResourceInner> getWithResponse(String resourceGroupName, String monitorName,
        String subAccountName, Context context);

    /**
     * Get a sub account under a given monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sub account under a given monitor resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogzMonitorResourceInner get(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * Delete a sub account resource. This delete operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * Delete a sub account resource. This delete operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String monitorName, String subAccountName,
        Context context);

    /**
     * Delete a sub account resource. This delete operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * Delete a sub account resource. This delete operation can take upto 10 minutes to complete.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String monitorName, String subAccountName, Context context);

    /**
     * Update a monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param body The body parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LogzMonitorResourceInner> updateWithResponse(String resourceGroupName, String monitorName,
        String subAccountName, LogzMonitorResourceUpdateParameters body, Context context);

    /**
     * Update a monitor resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LogzMonitorResourceInner update(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * List the resources currently being monitored by the Logz sub account resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitoredResourceInner> listMonitoredResources(String resourceGroupName, String monitorName,
        String subAccountName);

    /**
     * List the resources currently being monitored by the Logz sub account resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitoredResourceInner> listMonitoredResources(String resourceGroupName, String monitorName,
        String subAccountName, Context context);

    /**
     * Returns the payload that needs to be passed as a request for installing Logz.io agent on a VM.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of payload to be passed while installing VM agent along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<VMExtensionPayloadInner> vMHostPayloadWithResponse(String resourceGroupName, String monitorName,
        String subAccountName, Context context);

    /**
     * Returns the payload that needs to be passed as a request for installing Logz.io agent on a VM.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of payload to be passed while installing VM agent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    VMExtensionPayloadInner vMHostPayload(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * Sending request to update the collection when Logz.io agent has been installed on a VM for a given monitor.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Update Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMResourcesInner> listVmHostUpdate(String resourceGroupName, String monitorName,
        String subAccountName);

    /**
     * Sending request to update the collection when Logz.io agent has been installed on a VM for a given monitor.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param body Request body to update the collection for agent installed in the given monitor.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Update Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMResourcesInner> listVmHostUpdate(String resourceGroupName, String monitorName,
        String subAccountName, VMHostUpdateRequest body, Context context);

    /**
     * List the compute resources currently being monitored by the Logz sub account resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Update Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMResourcesInner> listVMHosts(String resourceGroupName, String monitorName, String subAccountName);

    /**
     * List the compute resources currently being monitored by the Logz sub account resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Monitor resource name.
     * @param subAccountName Sub Account resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Update Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMResourcesInner> listVMHosts(String resourceGroupName, String monitorName, String subAccountName,
        Context context);
}
