// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.appservice.implementation;

import com.azure.core.http.HttpResponse;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.management.serializer.SerializerFactory;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.resourcemanager.appservice.AppServiceManager;
import com.azure.resourcemanager.appservice.fluent.models.SiteConfigResourceInner;
import com.azure.resourcemanager.appservice.fluent.models.SiteInner;
import com.azure.resourcemanager.appservice.fluent.models.SiteLogsConfigInner;
import com.azure.resourcemanager.appservice.fluent.models.StringDictionaryInner;
import com.azure.resourcemanager.appservice.models.AppServicePlan;
import com.azure.resourcemanager.appservice.models.CsmDeploymentStatus;
import com.azure.resourcemanager.appservice.models.DeployOptions;
import com.azure.resourcemanager.appservice.models.DeployType;
import com.azure.resourcemanager.appservice.models.DeploymentSlots;
import com.azure.resourcemanager.appservice.models.KuduDeploymentResult;
import com.azure.resourcemanager.appservice.models.OperatingSystem;
import com.azure.resourcemanager.appservice.models.PricingTier;
import com.azure.resourcemanager.appservice.models.RuntimeStack;
import com.azure.resourcemanager.appservice.models.WebApp;
import com.azure.resourcemanager.appservice.models.WebAppRuntimeStack;
import com.azure.resourcemanager.resources.fluentcore.model.Creatable;
import com.azure.resourcemanager.resources.fluentcore.model.Indexable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

/** The implementation for WebApp. */
class WebAppImpl extends AppServiceBaseImpl<WebApp, WebAppImpl, WebApp.DefinitionStages.WithCreate, WebApp.Update>
    implements WebApp, WebApp.Definition, WebApp.DefinitionStages.ExistingWindowsPlanWithGroup,
    WebApp.DefinitionStages.ExistingLinuxPlanWithGroup, WebApp.Update, WebApp.UpdateStages.WithCredentials,
    WebApp.UpdateStages.WithStartUpCommand {

    private DeploymentSlots deploymentSlots;
    private WebAppRuntimeStack runtimeStackOnWindowsOSToUpdate;

    WebAppImpl(String name, SiteInner innerObject, SiteConfigResourceInner siteConfig, SiteLogsConfigInner logConfig,
        AppServiceManager manager) {
        super(name, innerObject, siteConfig, logConfig, manager);
    }

    @Override
    public WebAppImpl update() {
        runtimeStackOnWindowsOSToUpdate = null;
        return super.update();
    }

    @Override
    public DeploymentSlots deploymentSlots() {
        if (deploymentSlots == null) {
            deploymentSlots = new DeploymentSlotsImpl(this);
        }
        return deploymentSlots;
    }

    @Override
    public WebAppImpl withBuiltInImage(RuntimeStack runtimeStack) {
        ensureLinuxPlan();
        cleanUpContainerSettings();
        if (siteConfig == null) {
            siteConfig = new SiteConfigResourceInner();
        }
        siteConfig.withLinuxFxVersion(String.format("%s|%s", runtimeStack.stack(), runtimeStack.version()));
        if (runtimeStack.stack().equals("NODE")) {
            siteConfig.withNodeVersion(runtimeStack.version());
        }
        if (runtimeStack.stack().equals("PHP")) {
            siteConfig.withPhpVersion(runtimeStack.version());
        }
        if (runtimeStack.stack().equals("DOTNETCORE")) {
            siteConfig.withNetFrameworkVersion(runtimeStack.version());
        }
        return this;
    }

    @Override
    protected void cleanUpContainerSettings() {
        if (siteConfig != null && siteConfig.linuxFxVersion() != null) {
            siteConfig.withLinuxFxVersion(null);
        }
        if (siteConfig != null && siteConfig.windowsFxVersion() != null) {
            siteConfig.withWindowsFxVersion(null);
        }
        // PHP
        if (siteConfig != null && siteConfig.phpVersion() != null) {
            siteConfig.withPhpVersion(null);
        }
        // Node
        if (siteConfig != null && siteConfig.nodeVersion() != null) {
            siteConfig.withNodeVersion(null);
        }
        // Python
        if (siteConfig != null && siteConfig.pythonVersion() != null) {
            siteConfig.withPythonVersion(null);
        }
        // Java
        if (siteConfig != null && siteConfig.javaVersion() != null) {
            siteConfig.withJavaVersion(null);
        }
        // .NET
        if (siteConfig != null && siteConfig.netFrameworkVersion() != null) {
            siteConfig.withNetFrameworkVersion("v4.0");
        }
        // Docker Hub
        withoutAppSetting(SETTING_DOCKER_IMAGE);
        withoutAppSetting(SETTING_REGISTRY_SERVER);
        withoutAppSetting(SETTING_REGISTRY_USERNAME);
        withoutAppSetting(SETTING_REGISTRY_PASSWORD);
    }

    @Override
    public WebAppImpl withStartUpCommand(String startUpCommand) {
        if (siteConfig == null) {
            siteConfig = new SiteConfigResourceInner();
        }
        siteConfig.withAppCommandLine(startUpCommand);
        return this;
    }

    @Override
    public WebAppImpl withExistingWindowsPlan(AppServicePlan appServicePlan) {
        return super.withExistingAppServicePlan(appServicePlan);
    }

    @Override
    public WebAppImpl withExistingLinuxPlan(AppServicePlan appServicePlan) {
        return super.withExistingAppServicePlan(appServicePlan);
    }

    @Override
    public WebAppImpl withNewWindowsPlan(PricingTier pricingTier) {
        return super.withNewAppServicePlan(OperatingSystem.WINDOWS, pricingTier);
    }

    @Override
    public WebAppImpl withNewWindowsPlan(String appServicePlanName, PricingTier pricingTier) {
        return super.withNewAppServicePlan(appServicePlanName, OperatingSystem.WINDOWS, pricingTier);
    }

    @Override
    public WebAppImpl withNewWindowsPlan(Creatable<AppServicePlan> appServicePlanCreatable) {
        return super.withNewAppServicePlan(appServicePlanCreatable);
    }

    @Override
    public WebAppImpl withNewLinuxPlan(PricingTier pricingTier) {
        return super.withNewAppServicePlan(OperatingSystem.LINUX, pricingTier);
    }

    @Override
    public WebAppImpl withNewLinuxPlan(String appServicePlanName, PricingTier pricingTier) {
        return super.withNewAppServicePlan(appServicePlanName, OperatingSystem.LINUX, pricingTier);
    }

    @Override
    public WebAppImpl withNewLinuxPlan(Creatable<AppServicePlan> appServicePlanCreatable) {
        return super.withNewAppServicePlan(appServicePlanCreatable);
    }

    @Override
    public WebAppImpl withRuntimeStack(WebAppRuntimeStack runtimeStack) {
        runtimeStackOnWindowsOSToUpdate = runtimeStack;
        return this;
    }

    @Override
    public Mono<Void> warDeployAsync(File warFile) {
        return warDeployAsync(warFile, null);
    }

    @Override
    public void warDeploy(File warFile) {
        warDeployAsync(warFile).block();
    }

    @Override
    public Mono<Void> warDeployAsync(InputStream warFile, long length) {
        return warDeployAsync(warFile, length, null);
    }

    @Override
    public void warDeploy(InputStream warFile, long length) {
        warDeployAsync(warFile, length).block();
    }

    @Override
    public Mono<Void> warDeployAsync(File warFile, String appName) {
        try {
            return kuduClient.warDeployAsync(warFile, appName);
        } catch (IOException e) {
            return Mono.error(e);
        }
    }

    @Override
    public void warDeploy(File warFile, String appName) {
        warDeployAsync(warFile, appName).block();
    }

    @Override
    public void warDeploy(InputStream warFile, long length, String appName) {
        warDeployAsync(warFile, length, appName).block();
    }

    @Override
    public Mono<Void> warDeployAsync(InputStream warFile, long length, String appName) {
        return kuduClient.warDeployAsync(warFile, length, appName);
    }

    @Override
    public Mono<Void> zipDeployAsync(File zipFile) {
        try {
            return kuduClient.zipDeployAsync(zipFile);
        } catch (IOException e) {
            return Mono.error(e);
        }
    }

    @Override
    public void zipDeploy(File zipFile) {
        zipDeployAsync(zipFile).block();
    }

    @Override
    public Mono<Void> zipDeployAsync(InputStream zipFile, long length) {
        return kuduClient.zipDeployAsync(zipFile, length)
            .then(WebAppImpl.this.stopAsync())
            .then(WebAppImpl.this.startAsync());
    }

    @Override
    public void zipDeploy(InputStream zipFile, long length) {
        zipDeployAsync(zipFile, length).block();
    }

    @Override
    Mono<Indexable> submitMetadata() {
        Mono<Indexable> observable = super.submitMetadata();
        if (runtimeStackOnWindowsOSToUpdate != null) {
            observable = observable
                // list metadata
                .then(listMetadata())
                // merge with change, then update
                .switchIfEmpty(Mono.just(new StringDictionaryInner()))
                .flatMap(stringDictionaryInner -> {
                    if (stringDictionaryInner.properties() == null) {
                        stringDictionaryInner.withProperties(new HashMap<String, String>());
                    }
                    stringDictionaryInner.properties().put("CURRENT_STACK", runtimeStackOnWindowsOSToUpdate.runtime());
                    return updateMetadata(stringDictionaryInner);
                })
                // clean up
                .then(Mono.fromCallable(() -> {
                    runtimeStackOnWindowsOSToUpdate = null;
                    return WebAppImpl.this;
                }));
        }
        return observable;
    }

    Mono<StringDictionaryInner> listMetadata() {
        return this.manager().serviceClient().getWebApps().listMetadataAsync(resourceGroupName(), name());
    }

    Mono<StringDictionaryInner> updateMetadata(StringDictionaryInner inner) {
        return this.manager().serviceClient().getWebApps().updateMetadataAsync(resourceGroupName(), name(), inner);
    }

    @Override
    public void deploy(DeployType type, File file) {
        deployAsync(type, file).block();
    }

    @Override
    public Mono<Void> deployAsync(DeployType type, File file) {
        return deployAsync(type, file, new DeployOptions());
    }

    @Override
    public void deploy(DeployType type, File file, DeployOptions deployOptions) {
        deployAsync(type, file, deployOptions).block();
    }

    @Override
    public Mono<Void> deployAsync(DeployType type, File file, DeployOptions deployOptions) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(file);
        if (deployOptions == null) {
            deployOptions = new DeployOptions();
        }
        try {
            return kuduClient.deployAsync(type, file, deployOptions.path(), deployOptions.restartSite(),
                deployOptions.cleanDeployment());
        } catch (IOException e) {
            return Mono.error(e);
        }
    }

    @Override
    public void deploy(DeployType type, InputStream file, long length) {
        deployAsync(type, file, length).block();
    }

    @Override
    public Mono<Void> deployAsync(DeployType type, InputStream file, long length) {
        return deployAsync(type, file, length, new DeployOptions());
    }

    @Override
    public void deploy(DeployType type, InputStream file, long length, DeployOptions deployOptions) {
        deployAsync(type, file, length, deployOptions).block();
    }

    @Override
    public Mono<Void> deployAsync(DeployType type, InputStream file, long length, DeployOptions deployOptions) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(file);
        if (deployOptions == null) {
            deployOptions = new DeployOptions();
        }
        return kuduClient.deployAsync(type, file, length, deployOptions.path(), deployOptions.restartSite(),
            deployOptions.cleanDeployment());
    }

    @Override
    public KuduDeploymentResult pushDeploy(DeployType type, File file, DeployOptions deployOptions) {
        return pushDeployAsync(type, file, deployOptions).block();
    }

    @Override
    public Mono<KuduDeploymentResult> pushDeployAsync(DeployType type, File file, DeployOptions deployOptions) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(file);
        if (deployOptions == null) {
            deployOptions = new DeployOptions();
        }
        try {
            return kuduClient.pushDeployAsync(type, file, deployOptions.path(), deployOptions.restartSite(),
                deployOptions.cleanDeployment(), deployOptions.trackDeployment());
        } catch (IOException e) {
            return Mono.error(e);
        }
    }

    @Override
    public CsmDeploymentStatus getDeploymentStatus(String deploymentId) {
        return getDeploymentStatusAsync(deploymentId).block();
    }

    @Override
    public Mono<CsmDeploymentStatus> getDeploymentStatusAsync(String deploymentId) {
        // "GET" LRO is not supported in azure-core
        SerializerAdapter serializerAdapter = SerializerFactory.createDefaultManagementSerializerAdapter();
        return this.manager()
            .serviceClient()
            .getWebApps()
            .getProductionSiteDeploymentStatusWithResponseAsync(this.resourceGroupName(), this.name(), deploymentId)
            .flatMap(fluxResponse -> {
                HttpResponse response = new HttpFluxBBResponse(fluxResponse);
                return response.getBodyAsString().flatMap(bodyString -> {
                    CsmDeploymentStatus status;
                    try {
                        status = serializerAdapter.deserialize(bodyString, CsmDeploymentStatus.class,
                            SerializerEncoding.JSON);
                    } catch (IOException e) {
                        return Mono.error(new ManagementException("Deserialize failed for response body.", response));
                    }
                    return Mono.justOrEmpty(status);
                }).doFinally(ignored -> response.close());
            });
    }
}
