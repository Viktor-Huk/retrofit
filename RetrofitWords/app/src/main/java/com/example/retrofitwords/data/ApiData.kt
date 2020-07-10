package com.example.retrofitwords.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "books") val books: List<Book>
)

@JsonClass(generateAdapter = true)
data class Book(
    @Json(name = "title") val title: String?
)