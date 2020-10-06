package me.nemiron.hyperion.logs

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.pedrovgs.lynx.LynxActivity
import com.github.pedrovgs.lynx.LynxConfig
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class LogsModule : PluginModule() {

    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
        val rootView = layoutInflater.inflate(R.layout.hl_item_plugin_view, parent, false)
        rootView.findViewById<ConstraintLayout>(R.id.layout).setOnClickListener {
            val lynxConfig = LynxConfig().apply {
                maxNumberOfTracesToShow = 3000
            }
            // TODO : add white background to Activity
            val intent = LynxActivity.getIntent(context, lynxConfig).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
        return rootView
    }
}
