package com.example.retrofitwords.network

import com.example.retrofitwords.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    private const val HOST = "http://172.20.10.2:3000"

    private val client = OkHttpClient
        .Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(BooksApi::class.java)

    suspend fun getListOfBooks(): List<Book> {
        return withContext(Dispatchers.IO) {
            retrofit.getListOfBooks()
        }
    }

    suspend fun addNewBook(book: Book) {
        withContext(Dispatchers.IO) {
            retrofit.addNewBook(book)
        }
    }
}