package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.util.ArrayMap
import dalvik.system.DexClassLoader
import java.io.File
import java.lang.ref.WeakReference
import kotlin.properties.Delegates

class HookUtils {
    fun hook(context: Context) {
        val currentClassLoader: ClassLoader = javaClass.classLoader
        val loadedApkClass = currentClassLoader.loadClass("android.app.LoadedApk")
        val atClass = currentClassLoader.loadClass("android.app.ActivityThread")
        var atField = atClass.getDeclaredField("sCurrentActivityThread")
        atField.isAccessible = true
        //获取ActivityThread对象
        val at = atField.get(null)
        //获取mPackages属性
        val pkField = atClass.getDeclaredField("mPackages")
        pkField.isAccessible = true
        val mPackages: ArrayMap<String, WeakReference<*>> =
            pkField.get(at) as ArrayMap<String, WeakReference<*>>
        val loadApkWeakReference = mPackages[context.packageName]  as WeakReference
        //给loadApk替换我们的classLoader
        var mClassLoader = loadedApkClass.getDeclaredField("mClassLoader")
        mClassLoader.isAccessible = true
        getMyClassLoader(context);
        mClassLoader.set(loadApkWeakReference.get(),dexClassLoader)
        val intent = Intent()
        intent.setClassName(context, "com.example.plugin.ChaJian2Activity")
        context.startActivity(intent)

    }

    var dexClassLoader by Delegates.notNull<DexClassLoader>()
    lateinit var pluginFilePath: String
    fun getMyClassLoader(context: Context){
        var inputStream = context.assets.open("plugin-debug.apk")
        //复制到file目录下
        File(
            context.filesDir.absolutePath,
            "plugin-debug.apk"
        ).writeBytes(inputStream.readBytes())
        pluginFilePath =
            File(context.filesDir.absolutePath, "plugin-debug.apk").absolutePath
        val optimizedDirectory = context.filesDir.absolutePath
        val librarySearchPath = File(context.filesDir, "pluginlib").absolutePath
        dexClassLoader = DexClassLoader(
            pluginFilePath,
            optimizedDirectory,
            librarySearchPath,
            this::class.java.classLoader
        )
    }
}