// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.recoveryservicesdatareplication.fluent.DrasClient;
import com.azure.resourcemanager.recoveryservicesdatareplication.fluent.models.DraModelInner;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.DraModel;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.Dras;

public final class DrasImpl implements Dras {
    private static final ClientLogger LOGGER = new ClientLogger(DrasImpl.class);

    private final DrasClient innerClient;

    private final com.azure.resourcemanager.recoveryservicesdatareplication.RecoveryServicesDataReplicationManager serviceManager;

    public DrasImpl(DrasClient innerClient,
        com.azure.resourcemanager.recoveryservicesdatareplication.RecoveryServicesDataReplicationManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<DraModel> getWithResponse(String resourceGroupName, String fabricName, String fabricAgentName,
        Context context) {
        Response<DraModelInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, fabricName, fabricAgentName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new DraModelImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public DraModel get(String resourceGroupName, String fabricName, String fabricAgentName) {
        DraModelInner inner = this.serviceClient().get(resourceGroupName, fabricName, fabricAgentName);
        if (inner != null) {
            return new DraModelImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String fabricName, String fabricAgentName) {
        this.serviceClient().delete(resourceGroupName, fabricName, fabricAgentName);
    }

    public void delete(String resourceGroupName, String fabricName, String fabricAgentName, Context context) {
        this.serviceClient().delete(resourceGroupName, fabricName, fabricAgentName, context);
    }

    public PagedIterable<DraModel> list(String resourceGroupName, String fabricName) {
        PagedIterable<DraModelInner> inner = this.serviceClient().list(resourceGroupName, fabricName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new DraModelImpl(inner1, this.manager()));
    }

    public PagedIterable<DraModel> list(String resourceGroupName, String fabricName, Context context) {
        PagedIterable<DraModelInner> inner = this.serviceClient().list(resourceGroupName, fabricName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new DraModelImpl(inner1, this.manager()));
    }

    public DraModel getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = ResourceManagerUtils.getValueFromIdByName(id, "replicationFabrics");
        if (fabricName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'replicationFabrics'.", id)));
        }
        String fabricAgentName = ResourceManagerUtils.getValueFromIdByName(id, "fabricAgents");
        if (fabricAgentName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'fabricAgents'.", id)));
        }
        return this.getWithResponse(resourceGroupName, fabricName, fabricAgentName, Context.NONE).getValue();
    }

    public Response<DraModel> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = ResourceManagerUtils.getValueFromIdByName(id, "replicationFabrics");
        if (fabricName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'replicationFabrics'.", id)));
        }
        String fabricAgentName = ResourceManagerUtils.getValueFromIdByName(id, "fabricAgents");
        if (fabricAgentName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'fabricAgents'.", id)));
        }
        return this.getWithResponse(resourceGroupName, fabricName, fabricAgentName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = ResourceManagerUtils.getValueFromIdByName(id, "replicationFabrics");
        if (fabricName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'replicationFabrics'.", id)));
        }
        String fabricAgentName = ResourceManagerUtils.getValueFromIdByName(id, "fabricAgents");
        if (fabricAgentName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'fabricAgents'.", id)));
        }
        this.delete(resourceGroupName, fabricName, fabricAgentName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String fabricName = ResourceManagerUtils.getValueFromIdByName(id, "replicationFabrics");
        if (fabricName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'replicationFabrics'.", id)));
        }
        String fabricAgentName = ResourceManagerUtils.getValueFromIdByName(id, "fabricAgents");
        if (fabricAgentName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'fabricAgents'.", id)));
        }
        this.delete(resourceGroupName, fabricName, fabricAgentName, context);
    }

    private DrasClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.recoveryservicesdatareplication.RecoveryServicesDataReplicationManager manager() {
        return this.serviceManager;
    }

    public DraModelImpl define(String name) {
        return new DraModelImpl(name, this.manager());
    }
}
