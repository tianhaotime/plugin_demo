package com.example.myapplication

import android.content.res.Resources

class PluginRes(val injectResources: Resources)  : Resources(
    injectResources.assets,
    injectResources.displayMetrics,
    injectResources.configuration
)