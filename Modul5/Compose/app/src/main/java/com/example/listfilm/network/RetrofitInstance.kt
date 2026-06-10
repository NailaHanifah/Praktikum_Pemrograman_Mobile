package com.example.listfilm.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitInstance {
    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()

    val api: TmdbApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(TmdbApiService::class.java)
    }
}

