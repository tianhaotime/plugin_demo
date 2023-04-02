package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button = findViewById(R.id.button)


        button.setOnClickListener {

            lifecycleScope.launch{
//                withContext(Dispatchers.Main){
//                    PluginLoader.instance.loadPlugin(this@MainActivity2)
//                    PluginLoader.instance.getInjectResources(this@MainActivity2)
//                }
//                Intent(this@MainActivity2, ContainerActivity::class.java).apply {
//                    this.putExtra("ccc","com.example.plugin.ChaJianActivity1")
//                    startActivity(this)
//                }

                HookUtils().hook(this@MainActivity2)
            }


        }


    }


}