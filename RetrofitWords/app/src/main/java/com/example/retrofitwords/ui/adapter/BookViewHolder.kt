package com.example.retrofitwords.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwords.R

class BookViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val titleBookView = view.findViewById<TextView>(R.id.title_book)
    val authorBookView = view.findViewById<TextView>(R.id.author_book)
}