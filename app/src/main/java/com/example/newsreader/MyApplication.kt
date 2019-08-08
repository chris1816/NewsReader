package com.example.newsreader

import android.app.Application
import com.example.newsreader.di.DaggerNewsComponent
import com.example.newsreader.di.NewsComponent

class MyApplication : Application() {

    companion object {
        fun getDaggerComponent(): NewsComponent {
            return DaggerNewsComponent
                .builder()
                .build()
        }
    }
}