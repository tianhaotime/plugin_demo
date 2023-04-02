package com.example.pluginlib

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity

open class PluginActivity constructor() {

    var activity: FragmentActivity? = null
    open fun onCreate() {
    }

    fun onStart() {
    }

    fun onResume() {
    }

    fun onPause() {
    }

    fun onStop() {
    }

    fun onDestroy() {
    }

    fun setContentView(layoutId: Int) {
        activity?.setContentView(layoutId)
    }

    fun <T : View?> findViewById(@IdRes id: Int): T? {
        return activity?.findViewById<T>(id)
    }
}