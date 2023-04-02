package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class BlankViewModel(private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default) :
    ViewModel() {

    init {
        viewModelScope.launch {

        }
    }

    //耗时操作
    suspend fun loadNews() {
        withContext(defaultDispatcher) {

        }


        coroutineScope{}
    }
}