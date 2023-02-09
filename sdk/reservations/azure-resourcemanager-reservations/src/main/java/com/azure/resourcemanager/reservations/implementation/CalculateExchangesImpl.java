// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.implementation;

import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.reservations.fluent.CalculateExchangesClient;
import com.azure.resourcemanager.reservations.fluent.models.CalculateExchangeOperationResultResponseInner;
import com.azure.resourcemanager.reservations.models.CalculateExchangeOperationResultResponse;
import com.azure.resourcemanager.reservations.models.CalculateExchangeRequest;
import com.azure.resourcemanager.reservations.models.CalculateExchanges;

public final class CalculateExchangesImpl implements CalculateExchanges {
    private static final ClientLogger LOGGER = new ClientLogger(CalculateExchangesImpl.class);

    private final CalculateExchangesClient innerClient;

    private final com.azure.resourcemanager.reservations.ReservationsManager serviceManager;

    public CalculateExchangesImpl(
        CalculateExchangesClient innerClient,
        com.azure.resourcemanager.reservations.ReservationsManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public CalculateExchangeOperationResultResponse post(CalculateExchangeRequest body) {
        CalculateExchangeOperationResultResponseInner inner = this.serviceClient().post(body);
        if (inner != null) {
            return new CalculateExchangeOperationResultResponseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public CalculateExchangeOperationResultResponse post(CalculateExchangeRequest body, Context context) {
        CalculateExchangeOperationResultResponseInner inner = this.serviceClient().post(body, context);
        if (inner != null) {
            return new CalculateExchangeOperationResultResponseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private CalculateExchangesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.reservations.ReservationsManager manager() {
        return this.serviceManager;
    }
}