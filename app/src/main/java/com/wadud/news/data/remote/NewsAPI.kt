package com.wadud.news.data.remote

import com.wadud.news.data.remote.dto.NewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getTopHeadLines(@Query("country") country: String, @Query("apiKey") apiKey: String): NewsDto

}