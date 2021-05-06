package com.example.coroutineexercise.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    var lvToastEvent: MutableLiveData<String> = MutableLiveData("")

    init {
        launchAllWhenViewModelInit()
    }

    private fun launchAllWhenViewModelInit() {
        launchAll(Dispatchers.Main, "when ViewModel Init")
    }
    }

    private fun launchAll(dispatcher: CoroutineDispatcher, tag: String) {
        CoroutineScope(dispatcher).launch {
            Log.e(tag, "Start")
            launchA()
            Log.e("A", "Done")
            launchB()
            Log.e("B", "Done")
            launchC()
            Log.e("C", "Done")
            withContext(Dispatchers.Main) {
                Log.e(tag, "Done")
                lvToastEvent.value = "coroutine " + tag + " Done"
            }
        }.start()
    }

    private suspend fun launchA() {
        Log.e("A", "Start")
        delay(500L)
        Log.e("A", "Completing")
    }

    private suspend fun launchB() {
        Log.e("B", "Start")
        delay(500L)
        Log.e("B", "Completing")
    }

    private suspend fun launchC() {
        Log.e("C", "Start")
        delay(500L)
        Log.e("C", "Completing")
    }
}