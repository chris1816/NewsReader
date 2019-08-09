package com.example.newsreader.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsreader.R
import com.example.newsreader.data.model.Article
import kotlinx.android.synthetic.main.layout_news_adapter.view.*

class NewsAdapter(var newsClickListener: NewsClickListener?): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

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

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            newsClickListener?.onClick(newsList?.get(adapterPosition)?.url)
        }

        init {
            itemView.setOnClickListener(this)
        }

        val author = itemView.tv_author
        val title = itemView.tv_title
        val description = itemView.tv_description
        val image = itemView.im_news

        fun bindView(article: Article) {

            if (article.author.isNullOrEmpty()) {
                author.text = itemView.context.getString(R.string.unknown)
            } else {
                val authorName = "Author: ${article.author}"
                author.text = authorName
            }

            title.text = article.title

            if (article.description.isNullOrEmpty()) {
                description.text = itemView.context.getString(R.string.no_description)
            } else description.text = article.description

            Glide.with(itemView.context)
                .load(article.urlToImage)
                .placeholder(android.R.drawable.gallery_thumb)
                .into(image)

            //debug glide
/*            Glide.with(itemView.context).load(article.urlToImage)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.i("damn", "e: ${article.title}: $e")
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                }).into(itemView.im_news)*/
        }
    }

    interface NewsClickListener {
        fun onClick(imageUrl: String?)
    }
}