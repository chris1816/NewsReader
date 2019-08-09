package com.example.newsreader.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsreader.data.model.Article
import com.example.newsreader.data.NewsRepository

class NewsViewModel : ViewModel() {

    private val newsRepository by lazy {
        NewsRepository()
    }

    private val _newsList: LiveData<List<Article>> = getNews()
    val newsList: LiveData<List<Article>>
        get() = _newsList

    private fun getNews(): LiveData<List<Article>> {
        return newsRepository.getNewsList()
    }

}