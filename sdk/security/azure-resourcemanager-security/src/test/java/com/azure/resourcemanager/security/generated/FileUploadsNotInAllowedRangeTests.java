// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.FileUploadsNotInAllowedRange;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class FileUploadsNotInAllowedRangeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FileUploadsNotInAllowedRange model =
            BinaryData
                .fromString(
                    "{\"ruleType\":\"FileUploadsNotInAllowedRange\",\"timeWindowSize\":\"PT130H37M29S\",\"minThreshold\":1418655458,\"maxThreshold\":647013015,\"displayName\":\"vadswzs\",\"description\":\"yemlowuowhlxln\",\"isEnabled\":false}")
                .toObject(FileUploadsNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(1418655458, model.minThreshold());
        Assertions.assertEquals(647013015, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT130H37M29S"), model.timeWindowSize());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FileUploadsNotInAllowedRange model =
            new FileUploadsNotInAllowedRange()
                .withIsEnabled(false)
                .withMinThreshold(1418655458)
                .withMaxThreshold(647013015)
                .withTimeWindowSize(Duration.parse("PT130H37M29S"));
        model = BinaryData.fromObject(model).toObject(FileUploadsNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(1418655458, model.minThreshold());
        Assertions.assertEquals(647013015, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT130H37M29S"), model.timeWindowSize());
    }
}