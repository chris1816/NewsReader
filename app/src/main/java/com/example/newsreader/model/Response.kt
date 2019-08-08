package com.example.newsreader.model

import com.google.gson.annotations.SerializedName

class Response {

    @field: SerializedName("status")
    var status: String? = null

    @field: SerializedName("totalResults")
    var totalResults: Int? = null

    @field: SerializedName("news")
    var articles: List<Article>? = null
}