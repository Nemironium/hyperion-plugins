package me.nemiron.hyperion.logs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class LogsModule : PluginModule() {

    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
        val rootView = layoutInflater.inflate(R.layout.hl_item_plugin_view, parent, false)
        rootView.findViewById<ConstraintLayout>(R.id.layout).setOnClickListener {

        }
        return rootView
    }
}
