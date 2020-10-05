package me.nemiron.hyperion.networkemulation

import android.content.Context
import androidx.core.content.edit

class QualityConfig(context: Context) {

    companion object {
        private const val PREFS_NAME = "network-emulator"
        private const val NETWORK_ENABLED = "NETWORK_ENABLED"
        private const val LATENCY_MS = "LATENCY_MS"
        private const val ERROR_PERCENTAGE = "ERROR_PERCENTAGE"
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var networkEnabled: Boolean
        get() = prefs.getBoolean(NETWORK_ENABLED, true)
        set(value) = prefs.edit { putBoolean(NETWORK_ENABLED, value) }

    var latencyMs: Int
        get() = prefs.getInt(LATENCY_MS, 0)
        set(value) = prefs.edit { putInt(LATENCY_MS, value) }

    var errorPercentage: Int
        get() = prefs.getInt(ERROR_PERCENTAGE, 0)
        set(value) = prefs.edit { putInt(ERROR_PERCENTAGE, value) }
}