package com.example.newsreader

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsreader.model.Article
import com.example.newsreader.model.Response
import com.example.newsreader.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val retrofit: Retrofit
) {

    val news = MutableLiveData<List<Article>>()

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun getNewsList() {
        val call = apiService.requestNews()
        call.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                response.body()?.articles?.let {
                    news.value = it
                }
            }

        })

    }

    fun loadNews(): LiveData<List<Article>> {
        return news
    }
}