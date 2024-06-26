// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.fluent.NetworkSecurityPerimeterConfigurationsClient;
import com.azure.resourcemanager.eventgrid.fluent.models.NetworkSecurityPerimeterConfigurationInner;
import com.azure.resourcemanager.eventgrid.models.NetworkSecurityPerimeterConfiguration;
import com.azure.resourcemanager.eventgrid.models.NetworkSecurityPerimeterConfigurations;
import com.azure.resourcemanager.eventgrid.models.NetworkSecurityPerimeterResourceType;

public final class NetworkSecurityPerimeterConfigurationsImpl implements NetworkSecurityPerimeterConfigurations {
    private static final ClientLogger LOGGER = new ClientLogger(NetworkSecurityPerimeterConfigurationsImpl.class);

    private final NetworkSecurityPerimeterConfigurationsClient innerClient;

    private final com.azure.resourcemanager.eventgrid.EventGridManager serviceManager;

    public NetworkSecurityPerimeterConfigurationsImpl(NetworkSecurityPerimeterConfigurationsClient innerClient,
        com.azure.resourcemanager.eventgrid.EventGridManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<NetworkSecurityPerimeterConfiguration> getWithResponse(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName, String perimeterGuid,
        String associationName, Context context) {
        Response<NetworkSecurityPerimeterConfigurationInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, resourceType, resourceName, perimeterGuid, associationName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new NetworkSecurityPerimeterConfigurationImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public NetworkSecurityPerimeterConfiguration get(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName, String perimeterGuid,
        String associationName) {
        NetworkSecurityPerimeterConfigurationInner inner
            = this.serviceClient().get(resourceGroupName, resourceType, resourceName, perimeterGuid, associationName);
        if (inner != null) {
            return new NetworkSecurityPerimeterConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public NetworkSecurityPerimeterConfiguration reconcile(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName, String perimeterGuid,
        String associationName) {
        NetworkSecurityPerimeterConfigurationInner inner = this.serviceClient()
            .reconcile(resourceGroupName, resourceType, resourceName, perimeterGuid, associationName);
        if (inner != null) {
            return new NetworkSecurityPerimeterConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public NetworkSecurityPerimeterConfiguration reconcile(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName, String perimeterGuid,
        String associationName, Context context) {
        NetworkSecurityPerimeterConfigurationInner inner = this.serviceClient()
            .reconcile(resourceGroupName, resourceType, resourceName, perimeterGuid, associationName, context);
        if (inner != null) {
            return new NetworkSecurityPerimeterConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<NetworkSecurityPerimeterConfiguration> list(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName) {
        PagedIterable<NetworkSecurityPerimeterConfigurationInner> inner
            = this.serviceClient().list(resourceGroupName, resourceType, resourceName);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new NetworkSecurityPerimeterConfigurationImpl(inner1, this.manager()));
    }

    public PagedIterable<NetworkSecurityPerimeterConfiguration> list(String resourceGroupName,
        NetworkSecurityPerimeterResourceType resourceType, String resourceName, Context context) {
        PagedIterable<NetworkSecurityPerimeterConfigurationInner> inner
            = this.serviceClient().list(resourceGroupName, resourceType, resourceName, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new NetworkSecurityPerimeterConfigurationImpl(inner1, this.manager()));
    }

    private NetworkSecurityPerimeterConfigurationsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.eventgrid.EventGridManager manager() {
        return this.serviceManager;
    }
}
