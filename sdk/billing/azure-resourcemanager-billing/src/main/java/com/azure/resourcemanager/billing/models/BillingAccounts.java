// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Resource collection API of BillingAccounts.
 */
public interface BillingAccounts {
    /**
     * Adds payment terms to all the billing profiles under the billing account. Currently, payment terms can be added
     * only on billing accounts that have Agreement Type as 'Microsoft Customer Agreement' and AccountType as
     * 'Enterprise'. This action needs pre-authorization and only Field Sellers are authorized to add the payment terms
     * and is not a self-serve action.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters The properties of payment term.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount addPaymentTerms(String billingAccountName, List<PaymentTerm> parameters);

    /**
     * Adds payment terms to all the billing profiles under the billing account. Currently, payment terms can be added
     * only on billing accounts that have Agreement Type as 'Microsoft Customer Agreement' and AccountType as
     * 'Enterprise'. This action needs pre-authorization and only Field Sellers are authorized to add the payment terms
     * and is not a self-serve action.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters The properties of payment term.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount addPaymentTerms(String billingAccountName, List<PaymentTerm> parameters, Context context);

    /**
     * Cancels all the payment terms on billing account that falls after the cancellation date in the request.
     * Currently, cancel payment terms is only served by admin actions and is not a self-serve action.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters Date after which any payment terms that needs to be cancelled.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount cancelPaymentTerms(String billingAccountName, OffsetDateTime parameters);

    /**
     * Cancels all the payment terms on billing account that falls after the cancellation date in the request.
     * Currently, cancel payment terms is only served by admin actions and is not a self-serve action.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters Date after which any payment terms that needs to be cancelled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount cancelPaymentTerms(String billingAccountName, OffsetDateTime parameters, Context context);

    /**
     * Gets the transition details for a billing account that has transitioned from agreement type Microsoft Online
     * Services Program to agreement type Microsoft Customer Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the transition details for a billing account that has transitioned from agreement type Microsoft Online
     * Services Program to agreement type Microsoft Customer Agreement along with {@link Response}.
     */
    Response<TransitionDetails> confirmTransitionWithResponse(String billingAccountName, Context context);

    /**
     * Gets the transition details for a billing account that has transitioned from agreement type Microsoft Online
     * Services Program to agreement type Microsoft Customer Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the transition details for a billing account that has transitioned from agreement type Microsoft Online
     * Services Program to agreement type Microsoft Customer Agreement.
     */
    TransitionDetails confirmTransition(String billingAccountName);

    /**
     * Lists the invoice sections for which the user has permission to create Azure subscriptions. The operation is
     * supported only for billing accounts with agreement type Microsoft Customer Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a container for a list of resources as paginated response with {@link PagedIterable}.
     */
    PagedIterable<InvoiceSectionWithCreateSubPermission>
        listInvoiceSectionsByCreateSubscriptionPermission(String billingAccountName);

    /**
     * Lists the invoice sections for which the user has permission to create Azure subscriptions. The operation is
     * supported only for billing accounts with agreement type Microsoft Customer Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param filter The filter query option allows clients to filter a collection of resources that are addressed by a
     * request URL.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a container for a list of resources as paginated response with {@link PagedIterable}.
     */
    PagedIterable<InvoiceSectionWithCreateSubPermission>
        listInvoiceSectionsByCreateSubscriptionPermission(String billingAccountName, String filter, Context context);

    /**
     * Validates payment terms on a billing account with agreement type 'Microsoft Customer Agreement' and account type
     * 'Enterprise'.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters The properties of payment term.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the payment terms eligibility along with {@link Response}.
     */
    Response<PaymentTermsEligibilityResult> validatePaymentTermsWithResponse(String billingAccountName,
        List<PaymentTerm> parameters, Context context);

    /**
     * Validates payment terms on a billing account with agreement type 'Microsoft Customer Agreement' and account type
     * 'Enterprise'.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters The properties of payment term.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the payment terms eligibility.
     */
    PaymentTermsEligibilityResult validatePaymentTerms(String billingAccountName, List<PaymentTerm> parameters);

    /**
     * Gets a billing account by its ID.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account by its ID along with {@link Response}.
     */
    Response<BillingAccount> getWithResponse(String billingAccountName, Context context);

    /**
     * Gets a billing account by its ID.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account by its ID.
     */
    BillingAccount get(String billingAccountName);

    /**
     * Updates the properties of a billing account. Currently, displayName and address can be updated for billing
     * accounts with agreement type Microsoft Customer Agreement. Currently address and notification email address can
     * be updated for billing accounts with agreement type Microsoft Online Services Agreement. Currently, purchase
     * order number can be edited for billing accounts with agreement type Enterprise Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters A billing account.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount update(String billingAccountName, BillingAccountPatch parameters);

    /**
     * Updates the properties of a billing account. Currently, displayName and address can be updated for billing
     * accounts with agreement type Microsoft Customer Agreement. Currently address and notification email address can
     * be updated for billing accounts with agreement type Microsoft Online Services Agreement. Currently, purchase
     * order number can be edited for billing accounts with agreement type Enterprise Agreement.
     * 
     * @param billingAccountName The ID that uniquely identifies a billing account.
     * @param parameters A billing account.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a billing account.
     */
    BillingAccount update(String billingAccountName, BillingAccountPatch parameters, Context context);

    /**
     * Lists the billing accounts that a user has access to.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a container for a list of resources as paginated response with {@link PagedIterable}.
     */
    PagedIterable<BillingAccount> list();

    /**
     * Lists the billing accounts that a user has access to.
     * 
     * @param includeAll When true, results will include Billing Accounts that the user does not have a direct role
     * assignment on if the user has one of the following AAD roles: Global Administrator, Global Reader, Billing
     * Administrator.
     * @param includeAllWithoutBillingProfiles When true, results will include Billing Accounts that are not fully
     * created if the user has one of the following AAD roles: Global Administrator, Global Reader, Billing
     * Administrator.
     * @param includeDeleted When true, results will include any billing accounts in a deleted state.
     * @param includePendingAgreement Includes billing accounts with agreement pending signature that the user has
     * access to.
     * @param includeResellee Includes the customer's billing account of Microsoft Partner Agreement that the user has
     * access to.
     * @param legalOwnerTid Must be combined with legalOwnerOID, results will only include Billing Accounts for whom is
     * legally responsible for the Billing Accounts. Optional.
     * @param legalOwnerOid Must be combined with legalOwnerTID, results will only include Billing Accounts for whom is
     * legally responsible for the Billing Accounts. Optional.
     * @param filter The filter query option allows clients to filter a collection of resources that are addressed by a
     * request URL.
     * @param expand Expand is allowed for SoldTo and EnrollmentDetails/PONumber.
     * @param top The top query option requests the number of items in the queried collection to be included in the
     * result. The maximum supported value for top is 50.
     * @param skip The skip query option requests the number of items in the queried collection that are to be skipped
     * and not included in the result.
     * @param search The search query option allows clients to request items within a collection matching a free-text
     * search expression. search is only supported for string fields.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a container for a list of resources as paginated response with {@link PagedIterable}.
     */
    PagedIterable<BillingAccount> list(Boolean includeAll, Boolean includeAllWithoutBillingProfiles,
        Boolean includeDeleted, Boolean includePendingAgreement, Boolean includeResellee, String legalOwnerTid,
        String legalOwnerOid, String filter, String expand, Long top, Long skip, String search, Context context);
}
