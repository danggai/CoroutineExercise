package com.example.coroutineexercise.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    var lvToastMsg: MutableLiveData<String> = MutableLiveData("")

    init {
        viewModelScope.launch {
            init()
        }
    }

    private suspend fun init() = coroutineScope {
        Log.e("init", "Start")

        val deferredOne = async {
            launchAll("ViewModel Init1")
            true
        }
        val deferredTwo = async {
            launchAll("ViewModel Init2")
            launchAll("ViewModel Init3")
            true
        }

        if (deferredOne.await() && deferredTwo.await()) Log.e("init", "Done")
        else Log.e("init", "Failed")
    }

    }

    private suspend fun launchAll(tag: String) =
            withContext(viewModelScope.coroutineContext) {
                Log.e(tag, "Start")
                launchA()
                launchB()
                launchC()
                lvToastMsg.value = "coroutine \"" + tag + "\" Done"
                Log.e(tag, "Done")
            }
    private suspend fun launchA() {
        Log.e("A", "Start")
        delay(500L)
        Log.e("A", "Complete")
    }

    private suspend fun launchB() {
        Log.e("B", "Start")
        delay(500L)
        Log.e("B", "Complete")
    }

    private suspend fun launchC() {
        Log.e("C", "Start")
        delay(500L)
        Log.e("C", "Complete")
    }
}