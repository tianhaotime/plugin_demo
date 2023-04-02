package com.example.myapplication

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.File
import kotlin.properties.Delegates
/**
 *
 * 代理的方式使用
 * */
class PluginLoader private constructor() {
      var mTheme: Resources.Theme? = null
      var assets: AssetManager? = null
    var dexClassLoader by Delegates.notNull<DexClassLoader>()
    lateinit var pluginFilePath: String
    lateinit var res: Resources

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            PluginLoader()
        }
    }

    /*
  * 加载插件
  * */
    fun loadPlugin(context: Context) {
        Log.d("aking", "loadPlugin ----  ")
        //从assets中加载一个文件
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

        //dexPath 是需要加载的 dex / apk / jar 文件路径
        //optimizedDirectory 是 dex 优化后存放的位置，在 ART 上，会执行 oat 对 dex 进行优化，生成机器码，这里就是存放优化后的 odex 文件的位置
        //librarySearchPath 是 native 依赖的位置
        //parent 就是父类加载器，默认会先从 parent 加载对应的类
        dexClassLoader = DexClassLoader(
            pluginFilePath,
            optimizedDirectory,
            librarySearchPath,
            this::class.java.classLoader
        )
    }

    fun getInjectResources(context: Context) {
//        val pm = context.packageManager
//        val packageMInfo: PackageInfo? = pm.getPackageArchiveInfo(
//            PluginLoader.instance.pluginFilePath,
//            PackageManager.GET_ACTIVITIES
//                    or PackageManager.GET_META_DATA
//                    or PackageManager.GET_SERVICES
//                    or PackageManager.GET_PROVIDERS
//                    or PackageManager.GET_SIGNATURES
//        )
//
//        packageMInfo?.applicationInfo?.sourceDir = PluginLoader.instance.pluginFilePath
//        packageMInfo?.applicationInfo?.publicSourceDir = PluginLoader.instance.pluginFilePath
//        res  = pm.getResourcesForApplication(packageMInfo?.applicationInfo!!)


        val apkPath = PluginLoader.instance.pluginFilePath
        val assetManager = AssetManager::class.java.newInstance()
//        var ass = context.assets
        val addAssetPathMethod = AssetManager::class.java.getDeclaredMethod(
            "addAssetPath",
            String::class.java
        )
        assets =assetManager
        addAssetPathMethod.invoke(assetManager, apkPath)
        val resources = Resources(
            assetManager,
            context?.resources?.displayMetrics,
            context?.resources?.configuration
        )
        res = resources
//        mTheme = resources.newTheme();
//        mTheme?.setTo(context?.theme);
//        mTheme?.applyStyle(androidx.constraintlayout.widget.R.style.Theme_AppCompat_DayNight_DarkActionBar,true)
    }

    fun loadClass(className: String): Class<*>? {
        //classLoader注入  其实就是用插件的ClassLoader
        return dexClassLoader.loadClass(className)
    }


    private fun startIt() {
        //classLoader注入
        val pf = dexClassLoader.loadClass("com.example.plugin.PluginFac")
        pf.getMethod("startIt").invoke(pf.newInstance())
    }

    private fun startActivity() {
        Log.d("aking", "启动插件Main ---- ${javaClass.classLoader}")
        val pf = dexClassLoader.loadClass("com.example.plugin.PluginFac")
        pf.getMethod("startActivity", Context::class.java).invoke(pf.newInstance(), this)
    }
}