package com.example.newsreader

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.newsreader.model.Article
import javax.inject.Inject

class NewsViewModel @Inject constructor (
    private val newsRepository: NewsRepository
): ViewModel() {

    private val newsList: LiveData<List<Article>> = Transformations.switchMap(newsRepository.news) {
        newsRepository.loadNews()
    }

    fun getNewsList() {
        newsRepository.getNewsList()
    }

}