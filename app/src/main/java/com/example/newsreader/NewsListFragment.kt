package com.example.newsreader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class NewsListFragment : Fragment() {

    companion object {
        fun getNewInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }

    val newsViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(NewsViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.layout_newslist_fragment, container, false)
        if (newsViewModel == null) {
            newsViewModel?.getNewsList()
        }
        return view
    }
}