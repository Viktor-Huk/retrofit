package com.example.retrofitwords.network

import com.example.retrofitwords.model.Book
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val ENDPOINT = "/books"

interface BooksApi {

    @GET(ENDPOINT)
    suspend fun getListOfBooks(): List<Book>

    @POST(ENDPOINT)
    suspend fun addNewBook (
        @Body book: Book
    )
}
