package me.dio.urlshortener.data.datasource

import kotlinx.coroutines.flow.Flow
import me.dio.urlshortener.domain.ShortenedUrl

interface UrlShortenerDataSource {
    interface Local {
        fun getAll(): Flow<List<ShortenedUrl>>
        fun add(shortenedUrl: ShortenedUrl)
    }

    interface Remote : UrlShortenerDataSource {
        suspend fun create(url: String): ShortenedUrl
    }
}