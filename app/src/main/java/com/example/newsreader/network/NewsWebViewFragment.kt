package com.example.newsreader.network

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_news_webview_fragment.view.*
import android.webkit.WebView

class NewsWebViewFragment: Fragment() {

    companion object {
        const val URL = "url"

        fun newInstance(url: String): NewsWebViewFragment {
            val bundle = Bundle()
            bundle.putString(URL, url)
            val fragment = NewsWebViewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.example.newsreader.R.layout.layout_news_webview_fragment, container, false)

        val imageUrl = arguments?.getString(URL)
        val webview = view.wv_news
        webview.webViewClient = NewsBrowser()
        webview.settings.javaScriptEnabled = true
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.settings.mediaPlaybackRequiresUserGesture = false
        webview.loadUrl(imageUrl)
        return view
    }

    class NewsBrowser: WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}