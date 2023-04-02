package com.example.plugin

import android.util.Log
import com.example.pluginlib.PluginActivity

class ChaJianActivity1 : PluginActivity() {

    override fun onCreate() {
        Log.d("aking","ChaJianActivity1")
        super.onCreate()
        setContentView(R.layout.chajian_layout)
    }
}