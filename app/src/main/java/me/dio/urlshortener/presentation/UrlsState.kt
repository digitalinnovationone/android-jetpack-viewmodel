package me.dio.urlshortener.presentation

import me.dio.urlshortener.domain.ShortenedUrl

sealed interface UrlsState {
    val urls: List<ShortenedUrl>
        get() = listOf()
    val isProgressVisible: Boolean
        get() = false
    val errorMessage: String?
        get() = null
    val isErrorMessageVisible: Boolean
        get() = errorMessage != null

    data class Success(override val urls: List<ShortenedUrl>) : UrlsState

    object Loading : UrlsState {
        override val isProgressVisible = true
    }

    data class Failed(override val errorMessage: String) : UrlsState

    object Empty : UrlsState {
        override val errorMessage = "Nenhuma URL encontrada"
    }
}