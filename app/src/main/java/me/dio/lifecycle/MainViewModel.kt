package me.dio.lifecycle

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter = 0
        private set

    fun increment() {
        counter++
    }
}