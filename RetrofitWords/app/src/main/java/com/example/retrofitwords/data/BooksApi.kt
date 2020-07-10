package com.example.retrofitwords.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val ENDPOINT = "http://172.20.10.3:3000"
private const val BOOKS = "/books"

interface BooksApi {

    @GET(BOOKS)
    suspend fun getListOfBooks(): ApiData
}

object BooksApiImpl {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(ENDPOINT)
        .build()

    private val booksService = retrofit.create(BooksApi::class.java)

    suspend fun getListOfBooks(): List<Book> {

        Log.i("tag", "${booksService.getListOfBooks()}")

        return withContext(Dispatchers.IO) {
            booksService.getListOfBooks()
                .books
                .map {
                    Book(it.title)
                }
        }
    }
}