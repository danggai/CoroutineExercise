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
            launchAll("when ViewModel Init1")
        }
        viewModelScope.launch {
            launchAll("when ViewModel Init2")
            launchAll("when ViewModel Init3")
        }
    }

    private fun launchAllWhenViewModelInit() {
        launchAll(Dispatchers.Main, "when ViewModel Init")
    }
    }

    private suspend fun launchAll(tag: String) {
        viewModelScope.async {
            Log.e(tag, "Start")
            launchA()
            launchB()
            launchC()
            lvToastMsg.value = "coroutine " + tag + " Done"
            Log.e(tag, "Done")
        }.await()
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