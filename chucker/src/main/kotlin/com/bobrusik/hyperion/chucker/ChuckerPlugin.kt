package com.bobrusik.hyperion.chucker

import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

@AutoService(Plugin::class)
internal class ChuckerPlugin : Plugin() {
    override fun minimumRequiredApi() = 21

    override fun createPluginModule(): PluginModule {
        return ChuckerModule()
    }
}