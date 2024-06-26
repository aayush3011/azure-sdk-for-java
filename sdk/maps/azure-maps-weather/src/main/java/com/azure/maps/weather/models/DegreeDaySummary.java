// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.weather.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DegreeDaySummary model. */
@Fluent
public final class DegreeDaySummary {
    /*
     * Number of degrees that the mean temperature is below 65 degrees F/ 18 degree C.
     */
    @JsonProperty(value = "heating")
    private WeatherUnitDetails heating;

    /*
     * Number of degrees that the mean temperature is above 65 degrees F/ 18 degree C.
     */
    @JsonProperty(value = "cooling")
    private WeatherUnitDetails cooling;

    /** Set default DegreeDaySummary constructor to private */
    private DegreeDaySummary() {}

    /**
     * Get the heating property: Number of degrees that the mean temperature is below 65 degrees F/ 18 degree C.
     *
     * @return the heating value.
     */
    public WeatherUnitDetails getHeating() {
        return this.heating;
    }

    /**
     * Get the cooling property: Number of degrees that the mean temperature is above 65 degrees F/ 18 degree C.
     *
     * @return the cooling value.
     */
    public WeatherUnitDetails getCooling() {
        return this.cooling;
    }
}
