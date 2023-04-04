// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.generated;

import com.azure.resourcemanager.newrelicobservability.fluent.models.MetricRulesInner;
import com.azure.resourcemanager.newrelicobservability.models.FilteringTag;
import com.azure.resourcemanager.newrelicobservability.models.LogRules;
import com.azure.resourcemanager.newrelicobservability.models.SendAadLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.SendActivityLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.SendSubscriptionLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.TagAction;
import java.util.Arrays;

/** Samples for TagRules CreateOrUpdate. */
public final class TagRulesCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/newrelic/resource-manager/NewRelic.Observability/preview/2022-07-01-preview/examples/TagRules_CreateOrUpdate_MaximumSet_Gen.json
     */
    /**
     * Sample code: TagRules_CreateOrUpdate_MaximumSet_Gen.
     *
     * @param manager Entry point to NewRelicObservabilityManager.
     */
    public static void tagRulesCreateOrUpdateMaximumSetGen(
        com.azure.resourcemanager.newrelicobservability.NewRelicObservabilityManager manager) {
        manager
            .tagRules()
            .define("bxcantgzggsepbhqmedjqyrqeezmfb")
            .withExistingMonitor("rgopenapi", "ipxmlcbonyxtolzejcjshkmlron")
            .withLogRules(
                new LogRules()
                    .withSendAadLogs(SendAadLogsStatus.ENABLED)
                    .withSendSubscriptionLogs(SendSubscriptionLogsStatus.ENABLED)
                    .withSendActivityLogs(SendActivityLogsStatus.ENABLED)
                    .withFilteringTags(
                        Arrays
                            .asList(
                                new FilteringTag()
                                    .withName("saokgpjvdlorciqbjmjxazpee")
                                    .withValue("sarxrqsxouhdjwsrqqicbeirdb")
                                    .withAction(TagAction.INCLUDE))))
            .withMetricRules(
                new MetricRulesInner()
                    .withFilteringTags(
                        Arrays
                            .asList(
                                new FilteringTag()
                                    .withName("saokgpjvdlorciqbjmjxazpee")
                                    .withValue("sarxrqsxouhdjwsrqqicbeirdb")
                                    .withAction(TagAction.INCLUDE)))
                    .withUserEmail("test@testing.com"))
            .create();
    }

    /*
     * x-ms-original-file: specification/newrelic/resource-manager/NewRelic.Observability/preview/2022-07-01-preview/examples/TagRules_CreateOrUpdate_MinimumSet_Gen.json
     */
    /**
     * Sample code: TagRules_CreateOrUpdate_MinimumSet_Gen.
     *
     * @param manager Entry point to NewRelicObservabilityManager.
     */
    public static void tagRulesCreateOrUpdateMinimumSetGen(
        com.azure.resourcemanager.newrelicobservability.NewRelicObservabilityManager manager) {
        manager
            .tagRules()
            .define("bxcantgzggsepbhqmedjqyrqeezmfb")
            .withExistingMonitor("rgopenapi", "ipxmlcbonyxtolzejcjshkmlron")
            .create();
    }
}