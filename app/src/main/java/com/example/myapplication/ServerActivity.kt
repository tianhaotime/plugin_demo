package com.example.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ServerActivity : AppCompatActivity() {
    lateinit var mstub: IMyAidlInterface.Stub
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)



    }

    //创建一个stub
    fun stub() {
        mstub = object : IMyAidlInterface.Stub() {
            override fun getBook(book: Book?) {
                println("server do${mstub.toString()}")
            }

        }
    }
}