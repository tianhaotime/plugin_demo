package com.example.myapplication

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

data class Dog(@JvmField val name: String) {

}

data class Child @JvmOverloads constructor(
    var age: Int,
    var name: String = ""
) {
    var nick: String? = null
        get() {
            return field + ""
        }
        set(value) {
            field + ""
        }


    fun ggg(block: (Int) -> Int) {
        block.invoke(8)

        GlobalScope.launch {
            async { }.await()
        }
    }

    @Synchronized
    fun jjj() {
        ggg { i ->
            return@ggg i
        }
        synchronized(this) {

        }
    }

    fun <T> jkl(t: T) {
        var a: String? = null
        print(a!!.length)

        var b : String?
    }

}

