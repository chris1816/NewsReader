package com.example.newsreader.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsreader.R
import com.example.newsreader.data.model.Article
import kotlinx.android.synthetic.main.layout_newslist_fragment.*

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
        return inflater.inflate(R.layout.layout_newslist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
    }

    private fun initRV() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rv_newslist.layoutManager = linearLayoutManager
        val adapter = NewsAdapter(activity as NewsAdapter.NewsClickListener)
        rv_newslist.adapter = adapter
        newsViewModel?.newsList?.observe(viewLifecycleOwner, object : Observer<List<Article>>{
            override fun onChanged(news: List<Article>?) {
                adapter.setNews(news)
            }
        })
    }
}