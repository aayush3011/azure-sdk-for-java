// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.consumption.fluent.models.LegacyUsageDetailProperties;

public final class LegacyUsageDetailPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LegacyUsageDetailProperties model = BinaryData.fromString(
            "{\"billingAccountId\":\"xjumvq\",\"billingAccountName\":\"lihrraiouaubr\",\"billingPeriodStartDate\":\"2021-09-02T09:26:55Z\",\"billingPeriodEndDate\":\"2021-11-22T06:02:08Z\",\"billingProfileId\":\"fuojrngif\",\"billingProfileName\":\"z\",\"accountOwnerId\":\"sccbiuimzd\",\"accountName\":\"jdfqwmkyoqufdvr\",\"subscriptionId\":\"slzojh\",\"subscriptionName\":\"tfnmdx\",\"date\":\"2021-08-06T02:53:59Z\",\"product\":\"dgug\",\"partNumber\":\"zihgrkyu\",\"meterId\":\"c000072e-2ee2-4252-886b-d6b1a95e8532\",\"meterDetails\":{\"meterName\":\"snmfpphojeevy\",\"meterCategory\":\"hsgz\",\"meterSubCategory\":\"zbgomfgbeg\",\"unitOfMeasure\":\"gleohi\",\"serviceFamily\":\"tnluankrr\"},\"billingCurrency\":\"tijv\",\"resourceLocation\":\"vbmqzbqq\",\"consumedService\":\"aj\",\"resourceId\":\"wxacevehj\",\"resourceName\":\"yxoaf\",\"serviceInfo1\":\"oqltfae\",\"serviceInfo2\":\"inmfgvxirp\",\"additionalInfo\":\"riypoqeyhlqhyk\",\"invoiceSection\":\"lpyznuciqdsmexi\",\"costCenter\":\"dfuxtya\",\"resourceGroup\":\"ibmi\",\"reservationId\":\"nnust\",\"reservationName\":\"ljhnmgixhcmav\",\"productOrderId\":\"foudor\",\"productOrderName\":\"gyyprotwy\",\"offerId\":\"ndm\",\"isAzureCreditEligible\":false,\"term\":\"gcmjkavl\",\"publisherName\":\"rb\",\"publisherType\":\"tp\",\"planName\":\"tzfjltf\",\"chargeType\":\"zcyjtot\",\"frequency\":\"opv\",\"benefitId\":\"bzqgqqi\",\"benefitName\":\"dsvqwt\",\"pricingModel\":\"Reservation\"}")
            .toObject(LegacyUsageDetailProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LegacyUsageDetailProperties model = new LegacyUsageDetailProperties();
        model = BinaryData.fromObject(model).toObject(LegacyUsageDetailProperties.class);
    }
}
