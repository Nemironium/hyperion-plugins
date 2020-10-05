package me.nemiron.hyperion.networkemulation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

internal class NetworkEmulatorPluginModule : PluginModule() {

    private val config by lazy { QualityConfig(this.context) }
    private lateinit var rootView: View
    private val internetEnabled by lazy { rootView.findViewById<Switch>(R.id.internetEnabled) }
    private val latencySeek by lazy { rootView.findViewById<SeekBar>(R.id.latencySeek) }
    private val latencyRate by lazy { rootView.findViewById<TextView>(R.id.latencyRate) }
    private val errorSeek by lazy { rootView.findViewById<SeekBar>(R.id.errorSeek) }
    private val errorRate by lazy { rootView.findViewById<TextView>(R.id.errorRate) }

    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
        rootView = layoutInflater.inflate(R.layout.hne_item_plugin_view, parent, false)
        initViews()
        return rootView
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        latencyRate.text = config.latencyMs.toSeconds()
        latencyRate.setActiveColor(config.latencyMs > 0)
        errorRate.text = "${config.errorPercentage}%"
        errorRate.setActiveColor(config.errorPercentage > 0)

        with(internetEnabled) {
            isChecked = config.networkEnabled
            setOnCheckedChangeListener { _, isChecked ->
                config.networkEnabled = isChecked
                setElementsActive(isChecked)
            }
        }

        with(latencySeek) {
            val latencyRates = this.context.resources.getIntArray(R.array.hne_latency_rate_ms)
            max = latencyRates.size - 1
            progress = latencyRates.indexOf(config.latencyMs)
            doAfterProgressChanged { progress ->
                val latencyMs = latencyRates[progress]
                config.latencyMs = latencyMs
                latencyRate.text = latencyMs.toSeconds()
                latencyRate.setActiveColor(latencyMs > 0)
            }
        }

        with(errorSeek) {
            val errorPercents = this.context.resources.getIntArray(R.array.hne_error_rate_percentage)
            max = errorPercents.size - 1
            progress = errorPercents.indexOf(config.errorPercentage)
            doAfterProgressChanged { progress ->
                val errorPercent = errorPercents[progress]
                config.errorPercentage = errorPercent
                errorRate.text = "$errorPercent%"
                errorRate.setActiveColor(errorPercent > 0)
            }
        }
    }

    private fun setElementsActive(isActive: Boolean) {
        listOf<View>(latencyRate, errorRate, latencySeek, errorSeek)
            .forEach { it.isEnabled = isActive }
    }
}
