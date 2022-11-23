package me.dio.urlshortener.data

import kotlinx.coroutines.delay
import me.dio.urlshortener.domain.ShortenedUrl
import me.dio.urlshortener.domain.UrlsRepository

class UrlsRepositoryImpl : UrlsRepository {
    override suspend fun getAll(): List<ShortenedUrl> {
        delay(1_000)
        return listOf(
            ShortenedUrl("https://www.dio.me/", "https://hideuri.com/yQJA11"),
            ShortenedUrl("https://github.com/digitalinnovationone", "https://hideuri.com/2y657Z"),
            ShortenedUrl(
                "https://br.linkedin.com/school/digitalinnovation-one/",
                "https://hideuri.com/mGZ08N"
            ),
            ShortenedUrl(
                "https://www.instagram.com/dio_makethechange/",
                "https://hideuri.com/Dd4g3X"
            ),
            ShortenedUrl("https://twitter.com/dio_me_", "https://hideuri.com/nOZ62Y"),
            ShortenedUrl(
                "https://pt-br.facebook.com/diomakethechange/",
                "https://hideuri.com/v0ZyX1"
            ),
        )
    }
}