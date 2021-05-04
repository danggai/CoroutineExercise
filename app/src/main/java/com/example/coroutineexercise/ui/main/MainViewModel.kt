package com.example.coroutineexercise.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    init {
        launchAll()
    }

    private fun launchAll() = runBlocking {
        Log.e("All", "Start")
        launchA()
        Log.e("A", "Done")
        launchB()
        Log.e("B", "Done")
        launchC()
        Log.e("C", "Done")
    }

    suspend fun launchA() {
        Log.e("A", "Start")
        delay(500L)
        Log.e("A", "Completing")
    }

    suspend fun launchB() {
        Log.e("B", "Start")
        delay(500L)
        Log.e("B", "Completing")
    }

    suspend fun launchC() {
        Log.e("C", "Start")
        delay(500L)
        Log.e("C", "Completing")
    }
}