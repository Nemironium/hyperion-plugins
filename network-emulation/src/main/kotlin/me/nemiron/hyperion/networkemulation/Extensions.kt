package me.nemiron.hyperion.networkemulation

import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat


internal fun Int.toSeconds(): String = when {
    this == 0 -> "0s"
    this % 1000 == 0 -> "${this / 1000.0}s"
    else -> "${this.toFloat() / 1000.0}s"
}

internal inline fun SeekBar.doAfterProgressChanged(
    crossinline action: (progress: Int) -> Unit
) {
    this.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) =
            action(progress)

        override fun onStartTrackingTouch(seekBar: SeekBar?) { }

        override fun onStopTrackingTouch(seekBar: SeekBar?) { }
    })
}


internal fun TextView.setActiveColor(isActive: Boolean) {
    if (isActive)
        this.setTextColor(ContextCompat.getColor(context, R.color.hype_blue))
    else
        this.setTextColor(ContextCompat.getColor(context, R.color.hype_plugin_text))
}
