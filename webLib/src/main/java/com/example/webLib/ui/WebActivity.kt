package com.example.webLib.ui

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.BuildService
import com.example.webLib.R
import java.util.*
import kotlin.properties.Delegates

class WebActivity : AppCompatActivity() {

    var webView by Delegates.notNull<WebView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)


        val url = intent?.getStringExtra("url")
            ?: "https://blog.csdn.net/qq_22090073/article/details/108223341"
        webView.loadUrl(url)


        val iterator: Iterator<BuildService> = ServiceLoader.load(
            BuildService::class.java
        ).iterator()
        if (iterator.hasNext()) {
            Toast.makeText(this, "版本号 = " + iterator.next().versionCode(), Toast.LENGTH_LONG).show()
        }

        webView.addJavascriptInterface(this,"name");
    }

    @JavascriptInterface
    fun aaa(): String {
        return "aaa"
    }
}