package com.example.newsreader

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsreader.model.Article
import com.example.newsreader.model.Response
import com.example.newsreader.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class NewsRepository {

    @Inject
    lateinit var retrofit: Retrofit

    val news = MutableLiveData<List<Article>>()
/*    val news: LiveData<List<Article>>
        get() = _news*/

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
                Log.i("qwe", "error: ")
                error.printStackTrace()
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.i("qwe", "status: " + response.body()?.status)
                Log.i("qwe", "total result: " + response.body()?.totalResults)
                Log.i("qwe", "article: " + response.body()?.articles?.size)
                response.body()?.articles?.let {
                    Log.i("qwe", "0: " + it.size.toString())
                    news.value = it
                }
            }

        })
        return news
    }

    fun loadNews(): LiveData<List<Article>> {
        Log.i("qwe", "2: ")
        return news
    }
}