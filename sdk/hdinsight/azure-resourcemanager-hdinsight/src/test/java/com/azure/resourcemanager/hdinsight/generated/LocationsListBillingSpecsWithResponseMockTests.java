// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hdinsight.HDInsightManager;
import com.azure.resourcemanager.hdinsight.models.BillingResponseListResult;
import com.azure.resourcemanager.hdinsight.models.FilterMode;
import com.azure.resourcemanager.hdinsight.models.OSType;
import com.azure.resourcemanager.hdinsight.models.Tier;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class LocationsListBillingSpecsWithResponseMockTests {
    @Test
    public void testListBillingSpecsWithResponse() throws Exception {
        String responseStr
            = "{\"vmSizes\":[\"gbrt\",\"uiaclkiexhajlfn\"],\"vmSizesWithEncryptionAtHost\":[\"qfyuttd\",\"ygbpvnwswmt\",\"k\"],\"vmSizeFilters\":[{\"filterMode\":\"Default\",\"regions\":[\"wxjlmec\",\"og\"],\"clusterFlavors\":[\"yvneeza\",\"fg\",\"tmoqqtlffhzb\",\"rkjjjavfqnvhnq\"],\"nodeTypes\":[\"dogiyetesyp\",\"idbz\",\"jhqt\"],\"clusterVersions\":[\"vnynkb\",\"etnjuhpsprkz\",\"aupia\",\"cxnafbwqrooh\"],\"osType\":[\"Linux\",\"Windows\",\"Linux\"],\"vmSizes\":[\"urjtumghi\"],\"espApplied\":\"ve\",\"computeIsolationSupported\":\"slclblyjxltbsju\"},{\"filterMode\":\"Default\",\"regions\":[\"xigc\"],\"clusterFlavors\":[\"xu\",\"pbezqccydrtceu\",\"d\",\"kkyihzt\"],\"nodeTypes\":[\"mgqzgwldoyc\"],\"clusterVersions\":[\"lcecfeh\",\"waoaguhi\",\"qllizstac\",\"jvhrweft\"],\"osType\":[\"Linux\",\"Windows\",\"Linux\",\"Windows\"],\"vmSizes\":[\"s\"],\"espApplied\":\"aepwamcxtcz\",\"computeIsolationSupported\":\"peuknijd\"}],\"vmSizeProperties\":[{\"name\":\"spyd\",\"cores\":170648646,\"dataDiskStorageTier\":\"c\",\"label\":\"hhulrtywikdm\",\"maxDataDiskCount\":8125875686859497328,\"memoryInMb\":8589946500530915839,\"supportedByVirtualMachines\":false,\"supportedByWebWorkerRoles\":true,\"virtualMachineResourceDiskSizeInMb\":1422437735145461244,\"webWorkerResourceDiskSizeInMb\":4631933065455269635},{\"name\":\"mxu\",\"cores\":665007263,\"dataDiskStorageTier\":\"yjq\",\"label\":\"kfnozoeoqbvj\",\"maxDataDiskCount\":1136473991978940820,\"memoryInMb\":3118293287303219985,\"supportedByVirtualMachines\":false,\"supportedByWebWorkerRoles\":false,\"virtualMachineResourceDiskSizeInMb\":2962662676791309250,\"webWorkerResourceDiskSizeInMb\":2279733952870508149},{\"name\":\"ymxbulpzealb\",\"cores\":204967420,\"dataDiskStorageTier\":\"ojwyvf\",\"label\":\"btsuahxs\",\"maxDataDiskCount\":3253463579939415002,\"memoryInMb\":6128823487295073104,\"supportedByVirtualMachines\":false,\"supportedByWebWorkerRoles\":false,\"virtualMachineResourceDiskSizeInMb\":5228689904808376707,\"webWorkerResourceDiskSizeInMb\":1482066446768394569},{\"name\":\"npxqwodi\",\"cores\":1160303234,\"dataDiskStorageTier\":\"cjrmmua\",\"label\":\"ibvjogjonmcy\",\"maxDataDiskCount\":6735107623298340704,\"memoryInMb\":9033210529539978303,\"supportedByVirtualMachines\":false,\"supportedByWebWorkerRoles\":false,\"virtualMachineResourceDiskSizeInMb\":5845997176249673648,\"webWorkerResourceDiskSizeInMb\":4142402580801552647}],\"billingResources\":[{\"region\":\"oldtvevboclzhz\",\"billingMeters\":[{\"meterParameter\":\"uxgvttxpnr\",\"meter\":\"zaamrdixtrekid\",\"unit\":\"yskbruff\"}],\"diskBillingMeters\":[{\"diskRpMeter\":\"k\",\"sku\":\"tvlxhrpqh\",\"tier\":\"Premium\"},{\"diskRpMeter\":\"couqehb\",\"sku\":\"cdsziryrand\",\"tier\":\"Premium\"},{\"diskRpMeter\":\"blto\",\"sku\":\"mkfqlwxldy\",\"tier\":\"Standard\"},{\"diskRpMeter\":\"ygaolnjpnnb\",\"sku\":\"ksibjgsjjxx\",\"tier\":\"Standard\"}]},{\"region\":\"nadzyq\",\"billingMeters\":[{\"meterParameter\":\"iv\",\"meter\":\"nbm\",\"unit\":\"bjijkgqxnh\"},{\"meterParameter\":\"keznjaujvaa\",\"meter\":\"ggiycwkdtaawxwf\",\"unit\":\"aumrrqmbzmqkrat\"},{\"meterParameter\":\"xwbjs\",\"meter\":\"birkfpksokdg\",\"unit\":\"ewijymrhbguz\"}],\"diskBillingMeters\":[{\"diskRpMeter\":\"ewnf\",\"sku\":\"hhhqosm\",\"tier\":\"Premium\"},{\"diskRpMeter\":\"utycyarnroohguab\",\"sku\":\"ghktdpy\",\"tier\":\"Premium\"},{\"diskRpMeter\":\"oeocnhzqrott\",\"sku\":\"cfyjzp\",\"tier\":\"Standard\"},{\"diskRpMeter\":\"ohapqinfsz\",\"sku\":\"glqdhm\",\"tier\":\"Premium\"}]},{\"region\":\"alcxpjbyy\",\"billingMeters\":[{\"meterParameter\":\"qcjenkyhf\",\"meter\":\"vsqxfxjelgcmpzqj\",\"unit\":\"hqxu\"},{\"meterParameter\":\"vcacoyv\",\"meter\":\"bsizus\",\"unit\":\"zlbscmnlziji\"},{\"meterParameter\":\"ehgmvflnwyv\",\"meter\":\"xrerlniylylyf\",\"unit\":\"zutgqztwhghmupg\"},{\"meterParameter\":\"jtcdxabbujftaben\",\"meter\":\"klqpx\",\"unit\":\"cafeddw\"}],\"diskBillingMeters\":[{\"diskRpMeter\":\"a\",\"sku\":\"xud\",\"tier\":\"Premium\"},{\"diskRpMeter\":\"ookrtalvnbw\",\"sku\":\"bemeluclvd\",\"tier\":\"Premium\"}]}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HDInsightManager manager = HDInsightManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        BillingResponseListResult response
            = manager.locations().listBillingSpecsWithResponse("qa", com.azure.core.util.Context.NONE).getValue();

        Assertions.assertEquals("gbrt", response.vmSizes().get(0));
        Assertions.assertEquals("qfyuttd", response.vmSizesWithEncryptionAtHost().get(0));
        Assertions.assertEquals(FilterMode.DEFAULT, response.vmSizeFilters().get(0).filterMode());
        Assertions.assertEquals("wxjlmec", response.vmSizeFilters().get(0).regions().get(0));
        Assertions.assertEquals("yvneeza", response.vmSizeFilters().get(0).clusterFlavors().get(0));
        Assertions.assertEquals("dogiyetesyp", response.vmSizeFilters().get(0).nodeTypes().get(0));
        Assertions.assertEquals("vnynkb", response.vmSizeFilters().get(0).clusterVersions().get(0));
        Assertions.assertEquals(OSType.LINUX, response.vmSizeFilters().get(0).osType().get(0));
        Assertions.assertEquals("urjtumghi", response.vmSizeFilters().get(0).vmSizes().get(0));
        Assertions.assertEquals("ve", response.vmSizeFilters().get(0).espApplied());
        Assertions.assertEquals("slclblyjxltbsju", response.vmSizeFilters().get(0).computeIsolationSupported());
        Assertions.assertEquals("oldtvevboclzhz", response.billingResources().get(0).region());
        Assertions.assertEquals("uxgvttxpnr",
            response.billingResources().get(0).billingMeters().get(0).meterParameter());
        Assertions.assertEquals("zaamrdixtrekid", response.billingResources().get(0).billingMeters().get(0).meter());
        Assertions.assertEquals("yskbruff", response.billingResources().get(0).billingMeters().get(0).unit());
        Assertions.assertEquals("k", response.billingResources().get(0).diskBillingMeters().get(0).diskRpMeter());
        Assertions.assertEquals("tvlxhrpqh", response.billingResources().get(0).diskBillingMeters().get(0).sku());
        Assertions.assertEquals(Tier.PREMIUM, response.billingResources().get(0).diskBillingMeters().get(0).tier());
    }
}
