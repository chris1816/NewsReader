package com.example.newsreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsListFragment = NewsListFragment.getNewInstance()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, newsListFragment, null).commit()
    }

}
