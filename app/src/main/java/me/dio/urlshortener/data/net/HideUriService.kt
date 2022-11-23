package me.dio.urlshortener.data.net

import me.dio.urlshortener.data.model.UrlResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HideUriService {
    @FormUrlEncoded
    @POST("api/v1/shorten")
    suspend fun shorten(@Field("url") url: String): UrlResponse
}