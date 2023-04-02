package com.example.plugin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class ChaJian2Activity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(application)
        tv.text = "插件2"
        setContentView(tv)
    }
}