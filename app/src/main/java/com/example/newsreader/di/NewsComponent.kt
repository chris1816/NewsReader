package com.example.newsreader.di

import com.example.newsreader.NewsRepository
import dagger.Component

@Component(modules = [NewsModule::class])
interface NewsComponent {

    fun injectRetrofit(newsRepository: NewsRepository)
}