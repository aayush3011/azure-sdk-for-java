// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.billing.fluent.BillingRoleAssignmentsClient;
import com.azure.resourcemanager.billing.fluent.models.BillingRoleAssignmentInner;
import com.azure.resourcemanager.billing.fluent.models.BillingRoleAssignmentListResultInner;
import com.azure.resourcemanager.billing.models.BillingRoleAssignment;
import com.azure.resourcemanager.billing.models.BillingRoleAssignmentListResult;
import com.azure.resourcemanager.billing.models.BillingRoleAssignmentProperties;
import com.azure.resourcemanager.billing.models.BillingRoleAssignments;

public final class BillingRoleAssignmentsImpl implements BillingRoleAssignments {
    private static final ClientLogger LOGGER = new ClientLogger(BillingRoleAssignmentsImpl.class);

    private final BillingRoleAssignmentsClient innerClient;

    private final com.azure.resourcemanager.billing.BillingManager serviceManager;

    public BillingRoleAssignmentsImpl(BillingRoleAssignmentsClient innerClient,
        com.azure.resourcemanager.billing.BillingManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<Void> deleteByBillingProfileWithResponse(String billingAccountName, String billingProfileName,
        String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByBillingProfileWithResponse(billingAccountName, billingProfileName, billingRoleAssignmentName,
                context);
    }

    public void deleteByBillingProfile(String billingAccountName, String billingProfileName,
        String billingRoleAssignmentName) {
        this.serviceClient().deleteByBillingProfile(billingAccountName, billingProfileName, billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByBillingProfileWithResponse(String billingAccountName,
        String billingProfileName, String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByBillingProfileWithResponse(billingAccountName, billingProfileName, billingRoleAssignmentName,
                context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByBillingProfile(String billingAccountName, String billingProfileName,
        String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .getByBillingProfile(billingAccountName, billingProfileName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByBillingProfile(String billingAccountName,
        String billingProfileName) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByBillingProfile(billingAccountName, billingProfileName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByBillingProfile(String billingAccountName,
        String billingProfileName, String filter, Long top, Long skip, Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner = this.serviceClient()
            .listByBillingProfile(billingAccountName, billingProfileName, filter, top, skip, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public BillingRoleAssignment createByBillingProfile(String billingAccountName, String billingProfileName,
        BillingRoleAssignmentProperties parameters) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().createByBillingProfile(billingAccountName, billingProfileName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createByBillingProfile(String billingAccountName, String billingProfileName,
        BillingRoleAssignmentProperties parameters, Context context) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().createByBillingProfile(billingAccountName, billingProfileName, parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByCustomerWithResponse(String billingAccountName, String billingProfileName,
        String customerName, String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByCustomerWithResponse(billingAccountName, billingProfileName, customerName,
                billingRoleAssignmentName, context);
    }

    public void deleteByCustomer(String billingAccountName, String billingProfileName, String customerName,
        String billingRoleAssignmentName) {
        this.serviceClient()
            .deleteByCustomer(billingAccountName, billingProfileName, customerName, billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByCustomerWithResponse(String billingAccountName,
        String billingProfileName, String customerName, String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByCustomerWithResponse(billingAccountName, billingProfileName, customerName, billingRoleAssignmentName,
                context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByCustomer(String billingAccountName, String billingProfileName,
        String customerName, String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .getByCustomer(billingAccountName, billingProfileName, customerName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByCustomer(String billingAccountName, String billingProfileName,
        String customerName) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByCustomer(billingAccountName, billingProfileName, customerName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByCustomer(String billingAccountName, String billingProfileName,
        String customerName, String filter, Long top, Long skip, Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner = this.serviceClient()
            .listByCustomer(billingAccountName, billingProfileName, customerName, filter, top, skip, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public BillingRoleAssignment createByCustomer(String billingAccountName, String billingProfileName,
        String customerName, BillingRoleAssignmentProperties parameters) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().createByCustomer(billingAccountName, billingProfileName, customerName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createByCustomer(String billingAccountName, String billingProfileName,
        String customerName, BillingRoleAssignmentProperties parameters, Context context) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createByCustomer(billingAccountName, billingProfileName, customerName, parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByCustomer(String billingAccountName, String billingProfileName,
        String customerName) {
        BillingRoleAssignmentListResultInner inner
            = this.serviceClient().resolveByCustomer(billingAccountName, billingProfileName, customerName);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByCustomer(String billingAccountName, String billingProfileName,
        String customerName, Boolean resolveScopeDisplayNames, String filter, Context context) {
        BillingRoleAssignmentListResultInner inner = this.serviceClient()
            .resolveByCustomer(billingAccountName, billingProfileName, customerName, resolveScopeDisplayNames, filter,
                context);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByInvoiceSectionWithResponse(String billingAccountName, String billingProfileName,
        String invoiceSectionName, String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByInvoiceSectionWithResponse(billingAccountName, billingProfileName, invoiceSectionName,
                billingRoleAssignmentName, context);
    }

    public void deleteByInvoiceSection(String billingAccountName, String billingProfileName, String invoiceSectionName,
        String billingRoleAssignmentName) {
        this.serviceClient()
            .deleteByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName,
                billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByInvoiceSectionWithResponse(String billingAccountName,
        String billingProfileName, String invoiceSectionName, String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByInvoiceSectionWithResponse(billingAccountName, billingProfileName, invoiceSectionName,
                billingRoleAssignmentName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByInvoiceSection(String billingAccountName, String billingProfileName,
        String invoiceSectionName, String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .getByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByInvoiceSection(String billingAccountName,
        String billingProfileName, String invoiceSectionName) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByInvoiceSection(String billingAccountName,
        String billingProfileName, String invoiceSectionName, String filter, Long top, Long skip, Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner = this.serviceClient()
            .listByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName, filter, top, skip,
                context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public BillingRoleAssignment createByInvoiceSection(String billingAccountName, String billingProfileName,
        String invoiceSectionName, BillingRoleAssignmentProperties parameters) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createByInvoiceSection(String billingAccountName, String billingProfileName,
        String invoiceSectionName, BillingRoleAssignmentProperties parameters, Context context) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName, parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByInvoiceSection(String billingAccountName, String billingProfileName,
        String invoiceSectionName) {
        BillingRoleAssignmentListResultInner inner
            = this.serviceClient().resolveByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByInvoiceSection(String billingAccountName, String billingProfileName,
        String invoiceSectionName, Boolean resolveScopeDisplayNames, String filter, Context context) {
        BillingRoleAssignmentListResultInner inner = this.serviceClient()
            .resolveByInvoiceSection(billingAccountName, billingProfileName, invoiceSectionName,
                resolveScopeDisplayNames, filter, context);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByBillingProfile(String billingAccountName,
        String billingProfileName) {
        BillingRoleAssignmentListResultInner inner
            = this.serviceClient().resolveByBillingProfile(billingAccountName, billingProfileName);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByBillingProfile(String billingAccountName, String billingProfileName,
        Boolean resolveScopeDisplayNames, String filter, Context context) {
        BillingRoleAssignmentListResultInner inner = this.serviceClient()
            .resolveByBillingProfile(billingAccountName, billingProfileName, resolveScopeDisplayNames, filter, context);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByBillingAccountWithResponse(String billingAccountName,
        String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByBillingAccountWithResponse(billingAccountName, billingRoleAssignmentName, context);
    }

    public void deleteByBillingAccount(String billingAccountName, String billingRoleAssignmentName) {
        this.serviceClient().deleteByBillingAccount(billingAccountName, billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByBillingAccountWithResponse(String billingAccountName,
        String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByBillingAccountWithResponse(billingAccountName, billingRoleAssignmentName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByBillingAccount(String billingAccountName, String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().getByBillingAccount(billingAccountName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByBillingAccount(String billingAccountName,
        String billingRoleAssignmentName, BillingRoleAssignmentInner parameters) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByBillingAccount(billingAccountName, billingRoleAssignmentName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByBillingAccount(String billingAccountName,
        String billingRoleAssignmentName, BillingRoleAssignmentInner parameters, Context context) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByBillingAccount(billingAccountName, billingRoleAssignmentName, parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByBillingAccount(String billingAccountName) {
        PagedIterable<BillingRoleAssignmentInner> inner = this.serviceClient().listByBillingAccount(billingAccountName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByBillingAccount(String billingAccountName, String filter, Long top,
        Long skip, Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByBillingAccount(billingAccountName, filter, top, skip, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public BillingRoleAssignment createByBillingAccount(String billingAccountName,
        BillingRoleAssignmentProperties parameters) {
        BillingRoleAssignmentInner inner = this.serviceClient().createByBillingAccount(billingAccountName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createByBillingAccount(String billingAccountName,
        BillingRoleAssignmentProperties parameters, Context context) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().createByBillingAccount(billingAccountName, parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByDepartmentWithResponse(String billingAccountName, String departmentName,
        String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByDepartmentWithResponse(billingAccountName, departmentName, billingRoleAssignmentName, context);
    }

    public void deleteByDepartment(String billingAccountName, String departmentName, String billingRoleAssignmentName) {
        this.serviceClient().deleteByDepartment(billingAccountName, departmentName, billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByDepartmentWithResponse(String billingAccountName, String departmentName,
        String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByDepartmentWithResponse(billingAccountName, departmentName, billingRoleAssignmentName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByDepartment(String billingAccountName, String departmentName,
        String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner
            = this.serviceClient().getByDepartment(billingAccountName, departmentName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByDepartment(String billingAccountName, String departmentName,
        String billingRoleAssignmentName, BillingRoleAssignmentInner parameters) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByDepartment(billingAccountName, departmentName, billingRoleAssignmentName, parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByDepartment(String billingAccountName, String departmentName,
        String billingRoleAssignmentName, BillingRoleAssignmentInner parameters, Context context) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByDepartment(billingAccountName, departmentName, billingRoleAssignmentName, parameters,
                context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByDepartment(String billingAccountName, String departmentName) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByDepartment(billingAccountName, departmentName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByDepartment(String billingAccountName, String departmentName,
        Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByDepartment(billingAccountName, departmentName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public Response<Void> deleteByEnrollmentAccountWithResponse(String billingAccountName, String enrollmentAccountName,
        String billingRoleAssignmentName, Context context) {
        return this.serviceClient()
            .deleteByEnrollmentAccountWithResponse(billingAccountName, enrollmentAccountName, billingRoleAssignmentName,
                context);
    }

    public void deleteByEnrollmentAccount(String billingAccountName, String enrollmentAccountName,
        String billingRoleAssignmentName) {
        this.serviceClient()
            .deleteByEnrollmentAccount(billingAccountName, enrollmentAccountName, billingRoleAssignmentName);
    }

    public Response<BillingRoleAssignment> getByEnrollmentAccountWithResponse(String billingAccountName,
        String enrollmentAccountName, String billingRoleAssignmentName, Context context) {
        Response<BillingRoleAssignmentInner> inner = this.serviceClient()
            .getByEnrollmentAccountWithResponse(billingAccountName, enrollmentAccountName, billingRoleAssignmentName,
                context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new BillingRoleAssignmentImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BillingRoleAssignment getByEnrollmentAccount(String billingAccountName, String enrollmentAccountName,
        String billingRoleAssignmentName) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .getByEnrollmentAccount(billingAccountName, enrollmentAccountName, billingRoleAssignmentName);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByEnrollmentAccount(String billingAccountName,
        String enrollmentAccountName, String billingRoleAssignmentName, BillingRoleAssignmentInner parameters) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByEnrollmentAccount(billingAccountName, enrollmentAccountName, billingRoleAssignmentName,
                parameters);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignment createOrUpdateByEnrollmentAccount(String billingAccountName,
        String enrollmentAccountName, String billingRoleAssignmentName, BillingRoleAssignmentInner parameters,
        Context context) {
        BillingRoleAssignmentInner inner = this.serviceClient()
            .createOrUpdateByEnrollmentAccount(billingAccountName, enrollmentAccountName, billingRoleAssignmentName,
                parameters, context);
        if (inner != null) {
            return new BillingRoleAssignmentImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<BillingRoleAssignment> listByEnrollmentAccount(String billingAccountName,
        String enrollmentAccountName) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByEnrollmentAccount(billingAccountName, enrollmentAccountName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public PagedIterable<BillingRoleAssignment> listByEnrollmentAccount(String billingAccountName,
        String enrollmentAccountName, Context context) {
        PagedIterable<BillingRoleAssignmentInner> inner
            = this.serviceClient().listByEnrollmentAccount(billingAccountName, enrollmentAccountName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new BillingRoleAssignmentImpl(inner1, this.manager()));
    }

    public BillingRoleAssignmentListResult resolveByBillingAccount(String billingAccountName) {
        BillingRoleAssignmentListResultInner inner = this.serviceClient().resolveByBillingAccount(billingAccountName);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public BillingRoleAssignmentListResult resolveByBillingAccount(String billingAccountName,
        Boolean resolveScopeDisplayNames, String filter, Context context) {
        BillingRoleAssignmentListResultInner inner = this.serviceClient()
            .resolveByBillingAccount(billingAccountName, resolveScopeDisplayNames, filter, context);
        if (inner != null) {
            return new BillingRoleAssignmentListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private BillingRoleAssignmentsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.billing.BillingManager manager() {
        return this.serviceManager;
    }
}
