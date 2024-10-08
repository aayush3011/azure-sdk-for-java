// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * A request submitted by a user to manage billing. Users with an owner role on the scope can approve or decline these
 * requests.
 */
@Fluent
public final class BillingRequestProperties implements JsonSerializable<BillingRequestProperties> {
    /*
     * The provisioning state of the resource during a long-running operation.
     */
    private ProvisioningState provisioningState;

    /*
     * Additional information for the billing request.
     */
    private Map<String, String> additionalInformation;

    /*
     * The principal of the request reviewer. Will only be set if request is approved.
     */
    private BillingRequestPropertiesReviewedBy reviewedBy;

    /*
     * The date and time when the request was reviewed.
     */
    private OffsetDateTime reviewalDate;

    /*
     * The fully qualified ID that uniquely identifies a billing account.
     */
    private String billingAccountId;

    /*
     * The ID that uniquely identifies a billing account.
     */
    private String billingAccountName;

    /*
     * The name of the billing account.
     */
    private String billingAccountDisplayName;

    /*
     * The primary tenant ID of the billing account for which the billing request was submitted.
     */
    private String billingAccountPrimaryBillingTenantId;

    /*
     * The fully qualified ID that uniquely identifies a billing profile.
     */
    private String billingProfileId;

    /*
     * The ID that uniquely identifies a billing profile.
     */
    private String billingProfileName;

    /*
     * The name of the billing profile.
     */
    private String billingProfileDisplayName;

    /*
     * The principal of the entity who created the request.
     */
    private BillingRequestPropertiesCreatedBy createdBy;

    /*
     * The date and time when the request was created.
     */
    private OffsetDateTime creationDate;

    /*
     * The date and time when the request expires.
     */
    private OffsetDateTime expirationDate;

    /*
     * The reason to approve or decline the request.
     */
    private String decisionReason;

    /*
     * The fully qualified ID that uniquely identifies an invoice section.
     */
    private String invoiceSectionId;

    /*
     * The ID that uniquely identifies an invoice section.
     */
    private String invoiceSectionName;

    /*
     * The name of the invoice section.
     */
    private String invoiceSectionDisplayName;

    /*
     * The fully qualified ID that uniquely identifies a customer.
     */
    private String customerId;

    /*
     * The ID that uniquely identifies a customer.
     */
    private String customerName;

    /*
     * The name of the customer.
     */
    private String customerDisplayName;

    /*
     * The fully qualified ID that uniquely identifies a billing subscription.
     */
    private String subscriptionId;

    /*
     * The ID that uniquely identifies a billing subscription.
     */
    private String subscriptionName;

    /*
     * The name of the billing subscription.
     */
    private String subscriptionDisplayName;

    /*
     * Justification for submitting request.
     */
    private String justification;

    /*
     * The recipients of the billing request.
     */
    private List<Principal> recipients;

    /*
     * The billing scope for which the request was submitted (ex.
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountName}/billingProfiles/{billingProfileName}').
     */
    private String requestScope;

    /*
     * The billing scope for which the request will be applied. This is a read only property derived by the service.
     */
    private String billingScope;

    /*
     * Status of billing request.
     */
    private BillingRequestStatus status;

    /*
     * Type of billing request.
     */
    private BillingRequestType type;

    /*
     * The principal of the entity who last updated the request.
     */
    private BillingRequestPropertiesLastUpdatedBy lastUpdatedBy;

    /*
     * Date and time of last update.
     */
    private OffsetDateTime lastUpdatedDate;

    /**
     * Creates an instance of BillingRequestProperties class.
     */
    public BillingRequestProperties() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the resource during a long-running operation.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the additionalInformation property: Additional information for the billing request.
     * 
     * @return the additionalInformation value.
     */
    public Map<String, String> additionalInformation() {
        return this.additionalInformation;
    }

    /**
     * Set the additionalInformation property: Additional information for the billing request.
     * 
     * @param additionalInformation the additionalInformation value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withAdditionalInformation(Map<String, String> additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get the reviewedBy property: The principal of the request reviewer. Will only be set if request is approved.
     * 
     * @return the reviewedBy value.
     */
    public BillingRequestPropertiesReviewedBy reviewedBy() {
        return this.reviewedBy;
    }

    /**
     * Set the reviewedBy property: The principal of the request reviewer. Will only be set if request is approved.
     * 
     * @param reviewedBy the reviewedBy value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withReviewedBy(BillingRequestPropertiesReviewedBy reviewedBy) {
        this.reviewedBy = reviewedBy;
        return this;
    }

    /**
     * Get the reviewalDate property: The date and time when the request was reviewed.
     * 
     * @return the reviewalDate value.
     */
    public OffsetDateTime reviewalDate() {
        return this.reviewalDate;
    }

    /**
     * Get the billingAccountId property: The fully qualified ID that uniquely identifies a billing account.
     * 
     * @return the billingAccountId value.
     */
    public String billingAccountId() {
        return this.billingAccountId;
    }

    /**
     * Get the billingAccountName property: The ID that uniquely identifies a billing account.
     * 
     * @return the billingAccountName value.
     */
    public String billingAccountName() {
        return this.billingAccountName;
    }

    /**
     * Get the billingAccountDisplayName property: The name of the billing account.
     * 
     * @return the billingAccountDisplayName value.
     */
    public String billingAccountDisplayName() {
        return this.billingAccountDisplayName;
    }

    /**
     * Get the billingAccountPrimaryBillingTenantId property: The primary tenant ID of the billing account for which the
     * billing request was submitted.
     * 
     * @return the billingAccountPrimaryBillingTenantId value.
     */
    public String billingAccountPrimaryBillingTenantId() {
        return this.billingAccountPrimaryBillingTenantId;
    }

    /**
     * Get the billingProfileId property: The fully qualified ID that uniquely identifies a billing profile.
     * 
     * @return the billingProfileId value.
     */
    public String billingProfileId() {
        return this.billingProfileId;
    }

    /**
     * Get the billingProfileName property: The ID that uniquely identifies a billing profile.
     * 
     * @return the billingProfileName value.
     */
    public String billingProfileName() {
        return this.billingProfileName;
    }

    /**
     * Get the billingProfileDisplayName property: The name of the billing profile.
     * 
     * @return the billingProfileDisplayName value.
     */
    public String billingProfileDisplayName() {
        return this.billingProfileDisplayName;
    }

    /**
     * Get the createdBy property: The principal of the entity who created the request.
     * 
     * @return the createdBy value.
     */
    public BillingRequestPropertiesCreatedBy createdBy() {
        return this.createdBy;
    }

    /**
     * Set the createdBy property: The principal of the entity who created the request.
     * 
     * @param createdBy the createdBy value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withCreatedBy(BillingRequestPropertiesCreatedBy createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get the creationDate property: The date and time when the request was created.
     * 
     * @return the creationDate value.
     */
    public OffsetDateTime creationDate() {
        return this.creationDate;
    }

    /**
     * Get the expirationDate property: The date and time when the request expires.
     * 
     * @return the expirationDate value.
     */
    public OffsetDateTime expirationDate() {
        return this.expirationDate;
    }

    /**
     * Get the decisionReason property: The reason to approve or decline the request.
     * 
     * @return the decisionReason value.
     */
    public String decisionReason() {
        return this.decisionReason;
    }

    /**
     * Set the decisionReason property: The reason to approve or decline the request.
     * 
     * @param decisionReason the decisionReason value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withDecisionReason(String decisionReason) {
        this.decisionReason = decisionReason;
        return this;
    }

    /**
     * Get the invoiceSectionId property: The fully qualified ID that uniquely identifies an invoice section.
     * 
     * @return the invoiceSectionId value.
     */
    public String invoiceSectionId() {
        return this.invoiceSectionId;
    }

    /**
     * Get the invoiceSectionName property: The ID that uniquely identifies an invoice section.
     * 
     * @return the invoiceSectionName value.
     */
    public String invoiceSectionName() {
        return this.invoiceSectionName;
    }

    /**
     * Get the invoiceSectionDisplayName property: The name of the invoice section.
     * 
     * @return the invoiceSectionDisplayName value.
     */
    public String invoiceSectionDisplayName() {
        return this.invoiceSectionDisplayName;
    }

    /**
     * Get the customerId property: The fully qualified ID that uniquely identifies a customer.
     * 
     * @return the customerId value.
     */
    public String customerId() {
        return this.customerId;
    }

    /**
     * Get the customerName property: The ID that uniquely identifies a customer.
     * 
     * @return the customerName value.
     */
    public String customerName() {
        return this.customerName;
    }

    /**
     * Get the customerDisplayName property: The name of the customer.
     * 
     * @return the customerDisplayName value.
     */
    public String customerDisplayName() {
        return this.customerDisplayName;
    }

    /**
     * Get the subscriptionId property: The fully qualified ID that uniquely identifies a billing subscription.
     * 
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Get the subscriptionName property: The ID that uniquely identifies a billing subscription.
     * 
     * @return the subscriptionName value.
     */
    public String subscriptionName() {
        return this.subscriptionName;
    }

    /**
     * Get the subscriptionDisplayName property: The name of the billing subscription.
     * 
     * @return the subscriptionDisplayName value.
     */
    public String subscriptionDisplayName() {
        return this.subscriptionDisplayName;
    }

    /**
     * Get the justification property: Justification for submitting request.
     * 
     * @return the justification value.
     */
    public String justification() {
        return this.justification;
    }

    /**
     * Set the justification property: Justification for submitting request.
     * 
     * @param justification the justification value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withJustification(String justification) {
        this.justification = justification;
        return this;
    }

    /**
     * Get the recipients property: The recipients of the billing request.
     * 
     * @return the recipients value.
     */
    public List<Principal> recipients() {
        return this.recipients;
    }

    /**
     * Set the recipients property: The recipients of the billing request.
     * 
     * @param recipients the recipients value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withRecipients(List<Principal> recipients) {
        this.recipients = recipients;
        return this;
    }

    /**
     * Get the requestScope property: The billing scope for which the request was submitted (ex.
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountName}/billingProfiles/{billingProfileName}').
     * 
     * @return the requestScope value.
     */
    public String requestScope() {
        return this.requestScope;
    }

    /**
     * Set the requestScope property: The billing scope for which the request was submitted (ex.
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountName}/billingProfiles/{billingProfileName}').
     * 
     * @param requestScope the requestScope value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withRequestScope(String requestScope) {
        this.requestScope = requestScope;
        return this;
    }

    /**
     * Get the billingScope property: The billing scope for which the request will be applied. This is a read only
     * property derived by the service.
     * 
     * @return the billingScope value.
     */
    public String billingScope() {
        return this.billingScope;
    }

    /**
     * Get the status property: Status of billing request.
     * 
     * @return the status value.
     */
    public BillingRequestStatus status() {
        return this.status;
    }

    /**
     * Set the status property: Status of billing request.
     * 
     * @param status the status value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withStatus(BillingRequestStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the type property: Type of billing request.
     * 
     * @return the type value.
     */
    public BillingRequestType type() {
        return this.type;
    }

    /**
     * Set the type property: Type of billing request.
     * 
     * @param type the type value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withType(BillingRequestType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the lastUpdatedBy property: The principal of the entity who last updated the request.
     * 
     * @return the lastUpdatedBy value.
     */
    public BillingRequestPropertiesLastUpdatedBy lastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Set the lastUpdatedBy property: The principal of the entity who last updated the request.
     * 
     * @param lastUpdatedBy the lastUpdatedBy value to set.
     * @return the BillingRequestProperties object itself.
     */
    public BillingRequestProperties withLastUpdatedBy(BillingRequestPropertiesLastUpdatedBy lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    /**
     * Get the lastUpdatedDate property: Date and time of last update.
     * 
     * @return the lastUpdatedDate value.
     */
    public OffsetDateTime lastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (reviewedBy() != null) {
            reviewedBy().validate();
        }
        if (createdBy() != null) {
            createdBy().validate();
        }
        if (recipients() != null) {
            recipients().forEach(e -> e.validate());
        }
        if (lastUpdatedBy() != null) {
            lastUpdatedBy().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("additionalInformation", this.additionalInformation,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("reviewedBy", this.reviewedBy);
        jsonWriter.writeJsonField("createdBy", this.createdBy);
        jsonWriter.writeStringField("decisionReason", this.decisionReason);
        jsonWriter.writeStringField("justification", this.justification);
        jsonWriter.writeArrayField("recipients", this.recipients, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("requestScope", this.requestScope);
        jsonWriter.writeStringField("status", this.status == null ? null : this.status.toString());
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeJsonField("lastUpdatedBy", this.lastUpdatedBy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BillingRequestProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BillingRequestProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the BillingRequestProperties.
     */
    public static BillingRequestProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BillingRequestProperties deserializedBillingRequestProperties = new BillingRequestProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedBillingRequestProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("additionalInformation".equals(fieldName)) {
                    Map<String, String> additionalInformation = reader.readMap(reader1 -> reader1.getString());
                    deserializedBillingRequestProperties.additionalInformation = additionalInformation;
                } else if ("reviewedBy".equals(fieldName)) {
                    deserializedBillingRequestProperties.reviewedBy
                        = BillingRequestPropertiesReviewedBy.fromJson(reader);
                } else if ("reviewalDate".equals(fieldName)) {
                    deserializedBillingRequestProperties.reviewalDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("billingAccountId".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingAccountId = reader.getString();
                } else if ("billingAccountName".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingAccountName = reader.getString();
                } else if ("billingAccountDisplayName".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingAccountDisplayName = reader.getString();
                } else if ("billingAccountPrimaryBillingTenantId".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingAccountPrimaryBillingTenantId = reader.getString();
                } else if ("billingProfileId".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingProfileId = reader.getString();
                } else if ("billingProfileName".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingProfileName = reader.getString();
                } else if ("billingProfileDisplayName".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingProfileDisplayName = reader.getString();
                } else if ("createdBy".equals(fieldName)) {
                    deserializedBillingRequestProperties.createdBy = BillingRequestPropertiesCreatedBy.fromJson(reader);
                } else if ("creationDate".equals(fieldName)) {
                    deserializedBillingRequestProperties.creationDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("expirationDate".equals(fieldName)) {
                    deserializedBillingRequestProperties.expirationDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("decisionReason".equals(fieldName)) {
                    deserializedBillingRequestProperties.decisionReason = reader.getString();
                } else if ("invoiceSectionId".equals(fieldName)) {
                    deserializedBillingRequestProperties.invoiceSectionId = reader.getString();
                } else if ("invoiceSectionName".equals(fieldName)) {
                    deserializedBillingRequestProperties.invoiceSectionName = reader.getString();
                } else if ("invoiceSectionDisplayName".equals(fieldName)) {
                    deserializedBillingRequestProperties.invoiceSectionDisplayName = reader.getString();
                } else if ("customerId".equals(fieldName)) {
                    deserializedBillingRequestProperties.customerId = reader.getString();
                } else if ("customerName".equals(fieldName)) {
                    deserializedBillingRequestProperties.customerName = reader.getString();
                } else if ("customerDisplayName".equals(fieldName)) {
                    deserializedBillingRequestProperties.customerDisplayName = reader.getString();
                } else if ("subscriptionId".equals(fieldName)) {
                    deserializedBillingRequestProperties.subscriptionId = reader.getString();
                } else if ("subscriptionName".equals(fieldName)) {
                    deserializedBillingRequestProperties.subscriptionName = reader.getString();
                } else if ("subscriptionDisplayName".equals(fieldName)) {
                    deserializedBillingRequestProperties.subscriptionDisplayName = reader.getString();
                } else if ("justification".equals(fieldName)) {
                    deserializedBillingRequestProperties.justification = reader.getString();
                } else if ("recipients".equals(fieldName)) {
                    List<Principal> recipients = reader.readArray(reader1 -> Principal.fromJson(reader1));
                    deserializedBillingRequestProperties.recipients = recipients;
                } else if ("requestScope".equals(fieldName)) {
                    deserializedBillingRequestProperties.requestScope = reader.getString();
                } else if ("billingScope".equals(fieldName)) {
                    deserializedBillingRequestProperties.billingScope = reader.getString();
                } else if ("status".equals(fieldName)) {
                    deserializedBillingRequestProperties.status = BillingRequestStatus.fromString(reader.getString());
                } else if ("type".equals(fieldName)) {
                    deserializedBillingRequestProperties.type = BillingRequestType.fromString(reader.getString());
                } else if ("lastUpdatedBy".equals(fieldName)) {
                    deserializedBillingRequestProperties.lastUpdatedBy
                        = BillingRequestPropertiesLastUpdatedBy.fromJson(reader);
                } else if ("lastUpdatedDate".equals(fieldName)) {
                    deserializedBillingRequestProperties.lastUpdatedDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBillingRequestProperties;
        });
    }
}
