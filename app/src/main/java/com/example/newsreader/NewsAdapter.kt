package com.example.newsreader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_news_adapter.view.*

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList: List<Article>? = null

    fun setNews(news: List<Article>?) {
        newsList = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_news_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return newsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        newsList?.let{
            holder.bindView(it[position])
        }
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author = itemView.tv_author
        val title = itemView.tv_title
        val description = itemView.tv_description
        val image = itemView.im_news

        fun bindView(article: Article) {
            if(!article.author.isNullOrEmpty()) {
                author.visibility = View.VISIBLE
                val authorName = "Author: ${article.author}"
                author.text = authorName
            }
            if (!article.title.isNullOrEmpty()) {
                title.visibility = View.VISIBLE
                title.text = article.title
            }
            if (!article.description.isNullOrEmpty()) {
                description.visibility = View.VISIBLE
                description.text = article.description
            }
            if (!article.urlToImage.isNullOrEmpty()) {

                Picasso.with(itemView.context)
                    .load(article.urlToImage)
                    .into(image)
            }
        }
    }
}