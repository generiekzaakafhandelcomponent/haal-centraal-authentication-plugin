package com.ritense.valtimoplugins.haalcentraalauthenticationplugin.autoconfigure

import com.ritense.plugin.service.PluginService
import com.ritense.valtimoplugins.haalcentraalauthenticationplugin.client.ClientFactoryHelper
import com.ritense.valtimoplugins.haalcentraalauthenticationplugin.client.SamlTokenClient
import com.ritense.valtimoplugins.haalcentraalauthenticationplugin.plugin.HaalCentraalAuthenticationPluginFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

@AutoConfiguration
class HaalCentraalAuthenticationPluginAutoconfiguration {
    @Bean
    fun haalCentraalAuthenticationPluginFactory(
        pluginService: PluginService,
        samlTokenClient: SamlTokenClient,
        clientFactoryHelper: ClientFactoryHelper,
    ): HaalCentraalAuthenticationPluginFactory =
        HaalCentraalAuthenticationPluginFactory(pluginService, samlTokenClient, clientFactoryHelper)

    @Bean
    fun clientFactoryHelper(): ClientFactoryHelper = ClientFactoryHelper()

    @Bean
    fun samlTokenWebClient(clientFactoryHelper: ClientFactoryHelper): SamlTokenClient =
        SamlTokenClient(
            clientFactoryHelper,
        )
}
