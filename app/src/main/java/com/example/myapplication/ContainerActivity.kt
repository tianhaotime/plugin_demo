package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.pluginlib.PluginActivity

class ContainerActivity : FragmentActivity() {
    private var pluginActivity: PluginActivity? = null
    var mergeResources: Resources? = null

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        mergeResources = PluginRes(PluginLoader.instance.res)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("aking", "onCreate--")
        val className: String? = intent.getStringExtra("ccc")
        if (className != null) {
            pluginActivity =
                PluginLoader.instance.loadClass(className)?.newInstance() as PluginActivity
            pluginActivity?.activity = this
        }

        Log.d("aking", "mergeResources--")
        super.onCreate(savedInstanceState)

        pluginActivity?.onCreate()

    }

    override fun onStart() {
        super.onStart()
        pluginActivity?.onStart()
    }

    override fun onResume() {
        super.onResume()
        pluginActivity?.onResume()
    }

    override fun onPause() {
        super.onPause()
        pluginActivity?.onPause()
    }

    override fun onStop() {
        super.onStop()
        pluginActivity?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        pluginActivity?.onDestroy()

    }

    override fun getResources(): Resources {
        // 返回插件资源
        return mergeResources ?: super.getResources()
    }

//    override fun getTheme(): Resources.Theme {
//        // 返回插件主题
//        return if (PluginLoader.instance.mTheme != null)
//            PluginLoader.instance.mTheme!!
//        else super.getTheme()
//    }

    override fun getAssets(): AssetManager {
        return if (PluginLoader.instance.assets != null)
            PluginLoader.instance.assets!!
        else super.getAssets()
    }
}