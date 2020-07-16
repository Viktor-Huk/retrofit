package com.example.retrofitwords.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwords.R
import com.example.retrofitwords.ui.adapter.BookAdapter
import com.example.retrofitwords.ui.viewModel.BookViewModel

class MainActivity : AppCompatActivity() {

    private val bookViewModel by viewModels<BookViewModel>()
    private val bookAdapter = BookAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addNewBookButton)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = bookAdapter

        bookViewModel.books.observe(this, Observer { listOfBooks ->
            listOfBooks ?: return@Observer
            bookAdapter.refreshBooks(listOfBooks)
        })

        addButton.setOnClickListener { addNewCar() }
    }

    private fun addNewCar() {
        val intent = Intent(this, AddNewBookActivity::class.java)
        startActivity(intent)
    }
}