package com.example.newsreader.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsreader.R
import com.example.newsreader.network.NewsWebViewFragment

class MainActivity : AppCompatActivity(), NewsAdapter.NewsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            return
        }
        val newsListFragment = NewsListFragment.getNewInstance()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, newsListFragment, null).commit()
    }

    override fun onClick(imageUrl: String?) {
        imageUrl?.let {
            val newsWebViewFragment = NewsWebViewFragment.newInstance(it)
            supportFragmentManager.beginTransaction().replace(R.id.container, newsWebViewFragment, null).addToBackStack(null).commit()
        }
    }

}
