package com.example.retrofitwords.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwords.R
import com.example.retrofitwords.model.Book

class BookAdapter: RecyclerView.Adapter<BookViewHolder>() {

    private val books = mutableListOf<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_book_item, null)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.titleBookView.text = books[position].title ?: ""
        holder.authorBookView.text = books[position].author ?: ""
    }

    fun refreshBooks(newBook: List<Book>) {
        books.addAll(newBook)
        notifyDataSetChanged()
    }
}