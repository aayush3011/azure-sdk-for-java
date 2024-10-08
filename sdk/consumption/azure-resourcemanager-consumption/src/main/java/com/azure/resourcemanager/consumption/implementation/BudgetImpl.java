// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption.implementation;

import com.azure.core.util.Context;
import com.azure.resourcemanager.consumption.fluent.models.BudgetInner;
import com.azure.resourcemanager.consumption.models.Budget;
import com.azure.resourcemanager.consumption.models.BudgetFilter;
import com.azure.resourcemanager.consumption.models.BudgetTimePeriod;
import com.azure.resourcemanager.consumption.models.CategoryType;
import com.azure.resourcemanager.consumption.models.CurrentSpend;
import com.azure.resourcemanager.consumption.models.ForecastSpend;
import com.azure.resourcemanager.consumption.models.Notification;
import com.azure.resourcemanager.consumption.models.TimeGrainType;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public final class BudgetImpl implements Budget, Budget.Definition, Budget.Update {
    private BudgetInner innerObject;

    private final com.azure.resourcemanager.consumption.ConsumptionManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String etag() {
        return this.innerModel().etag();
    }

    public CategoryType category() {
        return this.innerModel().category();
    }

    public BigDecimal amount() {
        return this.innerModel().amount();
    }

    public TimeGrainType timeGrain() {
        return this.innerModel().timeGrain();
    }

    public BudgetTimePeriod timePeriod() {
        return this.innerModel().timePeriod();
    }

    public BudgetFilter filter() {
        return this.innerModel().filter();
    }

    public CurrentSpend currentSpend() {
        return this.innerModel().currentSpend();
    }

    public Map<String, Notification> notifications() {
        Map<String, Notification> inner = this.innerModel().notifications();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public ForecastSpend forecastSpend() {
        return this.innerModel().forecastSpend();
    }

    public BudgetInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.consumption.ConsumptionManager manager() {
        return this.serviceManager;
    }

    private String scope;

    private String budgetName;

    public BudgetImpl withExistingScope(String scope) {
        this.scope = scope;
        return this;
    }

    public Budget create() {
        this.innerObject = serviceManager.serviceClient()
            .getBudgets()
            .createOrUpdateWithResponse(scope, budgetName, this.innerModel(), Context.NONE)
            .getValue();
        return this;
    }

    public Budget create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getBudgets()
            .createOrUpdateWithResponse(scope, budgetName, this.innerModel(), context)
            .getValue();
        return this;
    }

    BudgetImpl(String name, com.azure.resourcemanager.consumption.ConsumptionManager serviceManager) {
        this.innerObject = new BudgetInner();
        this.serviceManager = serviceManager;
        this.budgetName = name;
    }

    public BudgetImpl update() {
        return this;
    }

    public Budget apply() {
        this.innerObject = serviceManager.serviceClient()
            .getBudgets()
            .createOrUpdateWithResponse(scope, budgetName, this.innerModel(), Context.NONE)
            .getValue();
        return this;
    }

    public Budget apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getBudgets()
            .createOrUpdateWithResponse(scope, budgetName, this.innerModel(), context)
            .getValue();
        return this;
    }

    BudgetImpl(BudgetInner innerObject, com.azure.resourcemanager.consumption.ConsumptionManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.scope = ResourceManagerUtils.getValueFromIdByParameterName(innerObject.id(),
            "/{scope}/providers/Microsoft.Consumption/budgets/{budgetName}", "scope");
        this.budgetName = ResourceManagerUtils.getValueFromIdByParameterName(innerObject.id(),
            "/{scope}/providers/Microsoft.Consumption/budgets/{budgetName}", "budgetName");
    }

    public Budget refresh() {
        this.innerObject
            = serviceManager.serviceClient().getBudgets().getWithResponse(scope, budgetName, Context.NONE).getValue();
        return this;
    }

    public Budget refresh(Context context) {
        this.innerObject
            = serviceManager.serviceClient().getBudgets().getWithResponse(scope, budgetName, context).getValue();
        return this;
    }

    public BudgetImpl withEtag(String etag) {
        this.innerModel().withEtag(etag);
        return this;
    }

    public BudgetImpl withCategory(CategoryType category) {
        this.innerModel().withCategory(category);
        return this;
    }

    public BudgetImpl withAmount(BigDecimal amount) {
        this.innerModel().withAmount(amount);
        return this;
    }

    public BudgetImpl withTimeGrain(TimeGrainType timeGrain) {
        this.innerModel().withTimeGrain(timeGrain);
        return this;
    }

    public BudgetImpl withTimePeriod(BudgetTimePeriod timePeriod) {
        this.innerModel().withTimePeriod(timePeriod);
        return this;
    }

    public BudgetImpl withFilter(BudgetFilter filter) {
        this.innerModel().withFilter(filter);
        return this;
    }

    public BudgetImpl withNotifications(Map<String, Notification> notifications) {
        this.innerModel().withNotifications(notifications);
        return this;
    }
}
