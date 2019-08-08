package com.example.newsreader

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsreader.model.Article

class NewsViewModel : ViewModel() {

    val newsRepository by lazy {
        NewsRepository()
    }

/*    private val _newsList: LiveData<List<Article>> = Transformations.switchMap(newsRepository.news) {
        Log.i("qwe", "1: " + it.size.toString())
        newsRepository.loadNews()
    }*/
    private val _newsList: LiveData<List<Article>> = getNews()
    val newsList: LiveData<List<Article>>
        get() = _newsList

    fun getNews(): LiveData<List<Article>> {
        Log.i("qwe", "-1: ")
        return newsRepository.getNewsList()
    }

}