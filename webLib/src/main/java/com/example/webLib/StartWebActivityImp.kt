package com.example.webLib

import android.content.Context
import android.content.Intent
import com.example.common.StartWebActivity
import com.example.webLib.ui.WebActivity
import com.google.auto.service.AutoService


@AutoService(StartWebActivity::class)
class StartWebActivityImp : StartWebActivity {
    override fun startWebActivity(context: Context, url: String, title: String) {
        context.startActivity( Intent(context, WebActivity::class.java).apply {
            putExtra("url",url)
            putExtra("title",title)
        })


    }

}