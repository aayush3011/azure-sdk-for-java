// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.models;

import com.azure.resourcemanager.policyinsights.fluent.models.PolicyStateInner;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of PolicyState.
 */
public interface PolicyState {
    /**
     * Gets the odataId property: OData entity ID; always set to null since policy state records do not have an entity
     * ID.
     * 
     * @return the odataId value.
     */
    String odataId();

    /**
     * Gets the odataContext property: OData context string; used by OData clients to resolve type information based on
     * metadata.
     * 
     * @return the odataContext value.
     */
    String odataContext();

    /**
     * Gets the timestamp property: Timestamp for the policy state record.
     * 
     * @return the timestamp value.
     */
    OffsetDateTime timestamp();

    /**
     * Gets the resourceId property: Resource ID.
     * 
     * @return the resourceId value.
     */
    String resourceId();

    /**
     * Gets the policyAssignmentId property: Policy assignment ID.
     * 
     * @return the policyAssignmentId value.
     */
    String policyAssignmentId();

    /**
     * Gets the policyDefinitionId property: Policy definition ID.
     * 
     * @return the policyDefinitionId value.
     */
    String policyDefinitionId();

    /**
     * Gets the effectiveParameters property: Effective parameters for the policy assignment.
     * 
     * @return the effectiveParameters value.
     */
    String effectiveParameters();

    /**
     * Gets the isCompliant property: Flag which states whether the resource is compliant against the policy assignment
     * it was evaluated against. This property is deprecated; please use ComplianceState instead.
     * 
     * @return the isCompliant value.
     */
    Boolean isCompliant();

    /**
     * Gets the subscriptionId property: Subscription ID.
     * 
     * @return the subscriptionId value.
     */
    String subscriptionId();

    /**
     * Gets the resourceType property: Resource type.
     * 
     * @return the resourceType value.
     */
    String resourceType();

    /**
     * Gets the resourceLocation property: Resource location.
     * 
     * @return the resourceLocation value.
     */
    String resourceLocation();

    /**
     * Gets the resourceGroup property: Resource group name.
     * 
     * @return the resourceGroup value.
     */
    String resourceGroup();

    /**
     * Gets the resourceTags property: List of resource tags.
     * 
     * @return the resourceTags value.
     */
    String resourceTags();

    /**
     * Gets the policyAssignmentName property: Policy assignment name.
     * 
     * @return the policyAssignmentName value.
     */
    String policyAssignmentName();

    /**
     * Gets the policyAssignmentOwner property: Policy assignment owner.
     * 
     * @return the policyAssignmentOwner value.
     */
    String policyAssignmentOwner();

    /**
     * Gets the policyAssignmentParameters property: Policy assignment parameters.
     * 
     * @return the policyAssignmentParameters value.
     */
    String policyAssignmentParameters();

    /**
     * Gets the policyAssignmentScope property: Policy assignment scope.
     * 
     * @return the policyAssignmentScope value.
     */
    String policyAssignmentScope();

    /**
     * Gets the policyDefinitionName property: Policy definition name.
     * 
     * @return the policyDefinitionName value.
     */
    String policyDefinitionName();

    /**
     * Gets the policyDefinitionAction property: Policy definition action, i.e. effect.
     * 
     * @return the policyDefinitionAction value.
     */
    String policyDefinitionAction();

    /**
     * Gets the policyDefinitionCategory property: Policy definition category.
     * 
     * @return the policyDefinitionCategory value.
     */
    String policyDefinitionCategory();

    /**
     * Gets the policySetDefinitionId property: Policy set definition ID, if the policy assignment is for a policy set.
     * 
     * @return the policySetDefinitionId value.
     */
    String policySetDefinitionId();

    /**
     * Gets the policySetDefinitionName property: Policy set definition name, if the policy assignment is for a policy
     * set.
     * 
     * @return the policySetDefinitionName value.
     */
    String policySetDefinitionName();

    /**
     * Gets the policySetDefinitionOwner property: Policy set definition owner, if the policy assignment is for a policy
     * set.
     * 
     * @return the policySetDefinitionOwner value.
     */
    String policySetDefinitionOwner();

    /**
     * Gets the policySetDefinitionCategory property: Policy set definition category, if the policy assignment is for a
     * policy set.
     * 
     * @return the policySetDefinitionCategory value.
     */
    String policySetDefinitionCategory();

    /**
     * Gets the policySetDefinitionParameters property: Policy set definition parameters, if the policy assignment is
     * for a policy set.
     * 
     * @return the policySetDefinitionParameters value.
     */
    String policySetDefinitionParameters();

    /**
     * Gets the managementGroupIds property: Comma separated list of management group IDs, which represent the hierarchy
     * of the management groups the resource is under.
     * 
     * @return the managementGroupIds value.
     */
    String managementGroupIds();

    /**
     * Gets the policyDefinitionReferenceId property: Reference ID for the policy definition inside the policy set, if
     * the policy assignment is for a policy set.
     * 
     * @return the policyDefinitionReferenceId value.
     */
    String policyDefinitionReferenceId();

    /**
     * Gets the complianceState property: Compliance state of the resource.
     * 
     * @return the complianceState value.
     */
    String complianceState();

    /**
     * Gets the policyEvaluationDetails property: Policy evaluation details.
     * 
     * @return the policyEvaluationDetails value.
     */
    PolicyEvaluationDetails policyEvaluationDetails();

    /**
     * Gets the policyDefinitionGroupNames property: Policy definition group names.
     * 
     * @return the policyDefinitionGroupNames value.
     */
    List<String> policyDefinitionGroupNames();

    /**
     * Gets the components property: Components state compliance records populated only when URL contains
     * $expand=components clause.
     * 
     * @return the components value.
     */
    List<ComponentStateDetails> components();

    /**
     * Gets the policyDefinitionVersion property: Evaluated policy definition version.
     * 
     * @return the policyDefinitionVersion value.
     */
    String policyDefinitionVersion();

    /**
     * Gets the policySetDefinitionVersion property: Evaluated policy set definition version.
     * 
     * @return the policySetDefinitionVersion value.
     */
    String policySetDefinitionVersion();

    /**
     * Gets the policyAssignmentVersion property: Evaluated policy assignment version.
     * 
     * @return the policyAssignmentVersion value.
     */
    String policyAssignmentVersion();

    /**
     * Gets the additionalProperties property: Policy state record.
     * 
     * @return the additionalProperties value.
     */
    Map<String, Object> additionalProperties();

    /**
     * Gets the inner com.azure.resourcemanager.policyinsights.fluent.models.PolicyStateInner object.
     * 
     * @return the inner object.
     */
    PolicyStateInner innerModel();
}
