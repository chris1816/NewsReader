package com.example.newsreader.network

import com.example.newsreader.data.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v2/top-headlines?country=us&category=business&apiKey=b90ca89707b64117b1376d98bed1477a")
    fun requestNews(): Call<Response>
}