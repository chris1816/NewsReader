package com.example.newsreader

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.model.Article
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
        newsViewModel?.getNews()
        initRV()
    }

    private fun initRV() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rv_newslist.layoutManager = linearLayoutManager
        val adapter = NewsAdapter()
        rv_newslist.adapter = adapter
/*        val itemDecoration = DividerItemDecoration(activity, linearLayoutManager.orientation)
        rv_newslist.addItemDecoration(itemDecoration)*/
        newsViewModel?.newsList?.observe(viewLifecycleOwner, object : Observer<List<Article>>{
            override fun onChanged(news: List<Article>?) {
                Log.i("qwe", "3: " + news?.size.toString())
                adapter.setNews(news)
            }
        })
    }
}