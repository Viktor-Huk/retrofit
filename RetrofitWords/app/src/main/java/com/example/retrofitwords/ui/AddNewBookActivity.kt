package com.example.retrofitwords.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.retrofitwords.R
import com.example.retrofitwords.model.Book
import com.example.retrofitwords.ui.viewModel.AddNewBookViewModel

class AddNewBookActivity : AppCompatActivity() {

    private val addNewBookViewModel by viewModels<AddNewBookViewModel>()

    private lateinit var titleText: TextView
    private lateinit var authorText: TextView
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_book)

        titleText = findViewById(R.id.titleNewBook)
        authorText = findViewById(R.id.authorNewBook)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener { addNewBook() }
    }

    private fun addNewBook() {

        val newBook = Book(
            titleText.text.toString(),
            authorText.text.toString()
        )

        addNewBookViewModel.addNewBook(newBook)
        finish()
    }
}