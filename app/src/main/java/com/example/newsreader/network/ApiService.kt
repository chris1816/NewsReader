package com.example.newsreader.network

import com.example.newsreader.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v2/top-headlines?country=us&category=business&apiKey=API_KEY")
    fun requestNews(): Call<Response>
}