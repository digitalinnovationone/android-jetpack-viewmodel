package me.dio.urlshortener.domain

interface UrlsRepository {
    suspend fun getAll(): List<ShortenedUrl>
}