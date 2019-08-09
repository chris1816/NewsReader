package com.example.newsreader.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsreader.MyApplication
import com.example.newsreader.data.model.Article
import com.example.newsreader.data.model.Response
import com.example.newsreader.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class NewsRepository {

    @Inject
    lateinit var retrofit: Retrofit

    val news = MutableLiveData<List<Article>>()

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    init {
        MyApplication.getDaggerComponent().injectRetrofit(this)
    }

    fun getNewsList(): LiveData<List<Article>> {
        val call = apiService.requestNews()
        call.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, error: Throwable) {
                error.printStackTrace()
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                response.body()?.articles?.let {
                    news.value = it
                }
            }

        })
        return news
    }
}