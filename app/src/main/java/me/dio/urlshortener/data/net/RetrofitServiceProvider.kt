package me.dio.urlshortener.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitServiceProvider {
    inline fun <reified T> create(): T {
        return Retrofit.Builder()
            .baseUrl("https://hideuri.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}