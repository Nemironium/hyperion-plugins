package me.nemiron.hyperion.chucker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.chuckerteam.chucker.api.Chucker
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class ChuckerModule : PluginModule() {

    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
        val rootView = layoutInflater.inflate(R.layout.hch_item_plugin_view, parent, false)
        rootView.findViewById<ConstraintLayout>(R.id.layout).setOnClickListener {

            val intent = Chucker.getLaunchIntent(context).apply {

                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
        return rootView
    }
}
