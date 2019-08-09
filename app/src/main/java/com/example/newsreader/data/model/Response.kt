package com.example.newsreader.data.model

import com.google.gson.annotations.SerializedName

class Response {

    @field: SerializedName("status")
    var status: String? = null

    @field: SerializedName("totalResults")
    var totalResults: Int? = null

    @field: SerializedName("articles")
    var articles: List<Article>? = null
}