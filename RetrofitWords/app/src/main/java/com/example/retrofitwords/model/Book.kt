package com.example.retrofitwords.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Book(
    @Json(name = "title") val title: String?,
    @Json(name = "author") val author: String?
)
