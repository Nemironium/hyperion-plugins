package me.nemiron.hyperion.deviceinformation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

internal class DeviceInformationModule : PluginModule() {

    private val device by lazy { DeviceParser(context).invoke() }

    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
        val rootView = layoutInflater.inflate(R.layout.hdi_item_plugin_view, parent, false)
        initViews(rootView)
        return rootView
    }

    private fun initViews(rootView: View) = with(rootView) {
        findViewById<TextView>(R.id.manufacturer).text = device.manufacturer
        findViewById<TextView>(R.id.model).text = device.model
        findViewById<TextView>(R.id.resolution).text = device.resolution
        findViewById<TextView>(R.id.density).text = device.density
        findViewById<TextView>(R.id.android).text = device.androidVersion
        findViewById<TextView>(R.id.api).text = device.apiVersion
    }
}
