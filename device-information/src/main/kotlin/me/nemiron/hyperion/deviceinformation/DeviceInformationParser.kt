package me.nemiron.hyperion.deviceinformation

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import com.jaredrummler.android.device.DeviceName

internal data class Device(
    val manufacturer: String,
    val model: String,
    val resolution: String,
    val density: String,
    val androidVersion: String,
    val apiVersion: String
)

internal class DeviceParser(context: Context) {

    init {
        DeviceName.init(context)
    }

    private val metrics = context.resources.displayMetrics
    private val densityBucket: String =
        when (metrics.densityDpi) {
        in 0..DisplayMetrics.DENSITY_LOW -> "ldpi"
        in DisplayMetrics.DENSITY_LOW..DisplayMetrics.DENSITY_MEDIUM -> "mdpi"
        DisplayMetrics.DENSITY_TV -> "tvdpi"
        in DisplayMetrics.DENSITY_MEDIUM..DisplayMetrics.DENSITY_HIGH -> "hdpi"
        in DisplayMetrics.DENSITY_HIGH..DisplayMetrics.DENSITY_XHIGH -> "xhdpi"
        in DisplayMetrics.DENSITY_XHIGH..DisplayMetrics.DENSITY_XXHIGH -> "xxhdpi"
        in DisplayMetrics.DENSITY_XXHIGH..DisplayMetrics.DENSITY_XXXHIGH -> "xxxhdpi"
        else -> "unknown"
    }

    operator fun invoke() = Device(
        manufacturer = Build.MANUFACTURER,
        model = DeviceName.getDeviceName(),
        resolution = "${metrics.widthPixels} x ${metrics.heightPixels}",
        density = "${metrics.densityDpi} dpi ($densityBucket)",
        androidVersion = "${Build.VERSION.CODENAME} (${Build.VERSION.RELEASE})",
        apiVersion = "${Build.VERSION.SDK_INT}",
    )
}