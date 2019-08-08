package com.example.newsreader

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor (
    private val newsRepository: NewsRepository
): ViewModel() {

    fun getNewsList() {

    }

}