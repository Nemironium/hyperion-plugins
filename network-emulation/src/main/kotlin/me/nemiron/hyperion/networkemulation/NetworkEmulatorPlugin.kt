package me.nemiron.hyperion.networkemulation

import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

@AutoService(Plugin::class)
internal class NetworkEmulatorPlugin : Plugin() {
    override fun minimumRequiredApi() = 21

    override fun createPluginModule(): PluginModule {
        return NetworkEmulatorPluginModule()
    }
}