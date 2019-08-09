package com.example.newsreader.di

import com.example.newsreader.data.NewsRepository
import dagger.Component

@Component(modules = [NewsModule::class])
interface NewsComponent {

    fun injectRetrofit(newsRepository: NewsRepository)
}