package me.dio.urlshortener.domain

data class ShortenedUrl(
    val original: String,
    val url: String,
)