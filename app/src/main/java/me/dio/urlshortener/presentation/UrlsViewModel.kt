package me.dio.urlshortener.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.dio.urlshortener.domain.UrlsRepository

class UrlsViewModel(
    private val repository: UrlsRepository
) : ViewModel() {
    private val _state = MutableLiveData<UrlsState>()
    val state: LiveData<UrlsState> = _state

    init {
        loadUrls()
    }

    private fun loadUrls() {
        _state.value = UrlsState.Loading

        viewModelScope.launch {
            _state.value = runCatching {
                repository.getAll()
            }.fold(onSuccess = { urls ->
                UrlsState.Success(urls)
            }, onFailure = { error ->
                UrlsState.Failed(error.message ?: "Error on load urls")
            })
        }
    }
}
