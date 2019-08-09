package com.example.newsreader.data.model

import com.google.gson.annotations.SerializedName

class Source {

    @field:SerializedName("id")
    var id: String? = null

    @field:SerializedName("name")
    var name: String? = null
}