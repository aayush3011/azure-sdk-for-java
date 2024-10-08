// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.RecurrenceFrequency;
import com.azure.resourcemanager.machinelearning.models.RecurrenceSchedule;
import com.azure.resourcemanager.machinelearning.models.RecurrenceTrigger;
import com.azure.resourcemanager.machinelearning.models.WeekDay;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RecurrenceTriggerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RecurrenceTrigger model = BinaryData.fromString(
            "{\"triggerType\":\"Recurrence\",\"frequency\":\"Week\",\"interval\":875349489,\"schedule\":{\"hours\":[2010585731,1159894455,1470565403,964360782],\"minutes\":[213294039,384841052,1302563571,1151725969],\"weekDays\":[\"Thursday\",\"Sunday\",\"Sunday\"],\"monthDays\":[491471659]},\"endTime\":\"qagnepzwakl\",\"startTime\":\"sbq\",\"timeZone\":\"agwwrxaom\"}")
            .toObject(RecurrenceTrigger.class);
        Assertions.assertEquals("qagnepzwakl", model.endTime());
        Assertions.assertEquals("sbq", model.startTime());
        Assertions.assertEquals("agwwrxaom", model.timeZone());
        Assertions.assertEquals(RecurrenceFrequency.WEEK, model.frequency());
        Assertions.assertEquals(875349489, model.interval());
        Assertions.assertEquals(2010585731, model.schedule().hours().get(0));
        Assertions.assertEquals(213294039, model.schedule().minutes().get(0));
        Assertions.assertEquals(WeekDay.THURSDAY, model.schedule().weekDays().get(0));
        Assertions.assertEquals(491471659, model.schedule().monthDays().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RecurrenceTrigger model = new RecurrenceTrigger().withEndTime("qagnepzwakl")
            .withStartTime("sbq")
            .withTimeZone("agwwrxaom")
            .withFrequency(RecurrenceFrequency.WEEK)
            .withInterval(875349489)
            .withSchedule(
                new RecurrenceSchedule().withHours(Arrays.asList(2010585731, 1159894455, 1470565403, 964360782))
                    .withMinutes(Arrays.asList(213294039, 384841052, 1302563571, 1151725969))
                    .withWeekDays(Arrays.asList(WeekDay.THURSDAY, WeekDay.SUNDAY, WeekDay.SUNDAY))
                    .withMonthDays(Arrays.asList(491471659)));
        model = BinaryData.fromObject(model).toObject(RecurrenceTrigger.class);
        Assertions.assertEquals("qagnepzwakl", model.endTime());
        Assertions.assertEquals("sbq", model.startTime());
        Assertions.assertEquals("agwwrxaom", model.timeZone());
        Assertions.assertEquals(RecurrenceFrequency.WEEK, model.frequency());
        Assertions.assertEquals(875349489, model.interval());
        Assertions.assertEquals(2010585731, model.schedule().hours().get(0));
        Assertions.assertEquals(213294039, model.schedule().minutes().get(0));
        Assertions.assertEquals(WeekDay.THURSDAY, model.schedule().weekDays().get(0));
        Assertions.assertEquals(491471659, model.schedule().monthDays().get(0));
    }
}
