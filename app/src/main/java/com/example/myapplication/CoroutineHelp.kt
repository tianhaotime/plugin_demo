package com.example.myapplication

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//协程异常捕获


fun CoroutineScope.launch(onError: (Throwable) -> Unit, block: () -> Unit) {
    val handler = CoroutineExceptionHandler { _, exception: Throwable ->
        onError(exception)
    }

    launch(handler){
        block()
    }
}