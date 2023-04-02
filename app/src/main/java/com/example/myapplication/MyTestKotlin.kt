package com.example.myapplication

import android.content.Context

class MyTestKotlin {
    lateinit var tv:MyTextView

    fun kk(context:Context){
        tv.onTouchEvent(null)
        tv.apply {  }

        val tv1 = MyTextView(context)
        with(tv1) {
            this.text = ""
        }
    }
}