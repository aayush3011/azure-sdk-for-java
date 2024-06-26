// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import java.time.Duration;
import java.util.List;

/** The DefaultRolloutSpecificationRestOfTheWorldGroupOne model. */
@Fluent
public final class DefaultRolloutSpecificationRestOfTheWorldGroupOne extends TrafficRegionRolloutConfiguration {
    /** Creates an instance of DefaultRolloutSpecificationRestOfTheWorldGroupOne class. */
    public DefaultRolloutSpecificationRestOfTheWorldGroupOne() {
    }

    /** {@inheritDoc} */
    @Override
    public DefaultRolloutSpecificationRestOfTheWorldGroupOne withWaitDuration(Duration waitDuration) {
        super.withWaitDuration(waitDuration);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DefaultRolloutSpecificationRestOfTheWorldGroupOne withRegions(List<String> regions) {
        super.withRegions(regions);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
