package com.example.plugin

import android.content.Context
import android.util.Log

class PluginFac {
    fun startIt() {
        Log.d("aking", "我是插件方法")
    }

    fun startActivity(context: Context) {
        Log.d("aking", "启动插件Main  ${javaClass.classLoader}")
//        Intent(context, MainActivity::class.java).apply {
//            context.startActivity(this)
//        }
    }
}