package me.dio.lifecycle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import me.dio.lifecycle.data.CounterRepositoryImpl
import me.dio.lifecycle.presentation.counter.MainViewModel
import me.dio.lifecycle.presentation.counter.SecondViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(repository = CounterRepositoryImpl()) as T
        }
        if (modelClass == SecondViewModel::class.java) {
            return SecondViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel instance for $modelClass")
    }
}