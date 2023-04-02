package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import java.util.TreeMap
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.properties.Delegates

class SeconedActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconed2)

        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)
                println("SeconedActivity2--onCreate")
            }

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                println("SeconedActivity2--onStart")
            }

            override fun onResume(owner: LifecycleOwner) {
                super.onResume(owner)
                println("SeconedActivity2--onResume")
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
                println("SeconedActivity2--onPause")
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                println("SeconedActivity2--onStop")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                println("SeconedActivity2--onDestroy")
            }
        })
        //协程
//        val job = lifecycleScope.launch {
//            load()
//        }

        runBlocking {
//            withContext(Dispatchers.Default){
//                while (true){
//
//                }
//            }

        }


        CoroutineScope(EmptyCoroutineContext.plus(Dispatchers.Main.immediate).plus(CoroutineName("hh"))).launch {  }
    }

    //增加扩展方法
    fun CoroutineScope.safeLaunch(onError: ((Throwable) -> Unit)? = null,
                                  onBlock: () -> Unit) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            onError?.invoke(throwable)
        }

        this.launch(exceptionHandler) {
            onBlock.invoke()
        }
    }
    fun weituo1() {
        class User {
            var name by Delegates.observable("haha") { a, b, c ->
                println("a = $a b = $b c = $c")
            }
        }
        val user = User()
        user.name = "第一次"
        user.name = "第二次"
    }

    suspend fun load(){
        //这个写法什么意思
        val job = coroutineScope{
            println(Thread.currentThread().name+"  11")
            async {  }
            withContext(Dispatchers.Main.immediate) {

            }
            val a = "".let {  }

            safeLaunch({},fun(){})
        }

        val jobG = GlobalScope.launch(job.run { Job() }) {
            delay(1000L)
        }
        jobG.cancel()
        withContext(SupervisorJob() + Dispatchers.Main.immediate){
            println(Thread.currentThread().name+"  22")
        }
        //怎么创建作用域
        withContext(EmptyCoroutineContext+Dispatchers.Default){
            println(Thread.currentThread().name+"  33")
        }

//        Glide.with()

        val async = lifecycleScope.async {
            ""
        }
        async.await()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction().add(MyFragment(), "").commit()
        lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)

        val liveData = MutableLiveData<String>()
        liveData.observe(this, Observer {  })
    }

    fun bianli(map: HashMap<*, *>) {
        for (e in map) {
            println("key = ${e.key} ----${e.value}")
        }
    }

    override fun onStart() {
        super.onStart()
        println("SeconedActivity2--onStart-----")
    }

    override fun onRestart() {
        super.onRestart()
        println("SeconedActivity2--onRestart-----")
    }

    override fun onResume() {
        super.onResume()
        println("SeconedActivity2--onResume--------")
    }
}

class MyFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MyFragment--onCreate--------")


        val liveData = MutableLiveData<String>()
        liveData.observe(this, Observer {  })
        liveData.observe(viewLifecycleOwner, Observer {  })
    }

    override fun onResume() {
        super.onResume()
        println("MyFragment--onResume--------")
    }
}
