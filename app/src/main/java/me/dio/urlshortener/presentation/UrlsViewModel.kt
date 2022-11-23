package me.dio.urlshortener.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import me.dio.urlshortener.core.Event
import me.dio.urlshortener.domain.UrlsRepository

class UrlsViewModel(
    private val repository: UrlsRepository
) : ViewModel() {
    private val _action = MutableLiveData<Event<UrlsAction>>()
    val action: LiveData<Event<UrlsAction>> = _action

    val state: LiveData<UrlsState> = repository.getAll()
        .map { urls ->
            if (urls.isNotEmpty()) UrlsState.Success(urls)
            else UrlsState.Empty
        }
        .onStart {
            emit(UrlsState.Loading)
        }
        .catch { error ->
            UrlsState.Failed(error.message ?: "Error on load urls")
        }
        .asLiveData()


    fun shorten(url: String) {
        viewModelScope.launch {
            _action.value = Event(UrlsAction.Loading)
            val action = runCatching { repository.shorten(url) }
                .fold(onSuccess = {
                  UrlsAction.Done
                },
                onFailure = { error ->
                    UrlsAction.Failed(error.message ?: "Falha ao encurtar URL")
                })
            _action.value = Event(action)
        }
    }
}
