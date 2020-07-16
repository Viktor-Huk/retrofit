package com.example.retrofitwords.ui.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.retrofitwords.model.Book
import com.example.retrofitwords.network.NetworkService
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books


    init {
        viewModelScope.launch {
            _books.value = NetworkService.getListOfBooks()
        }
    }

    fun getAllBooks(): LiveData<List<Book>> {

        viewModelScope.launch {
            _books.value = NetworkService.getListOfBooks()
        }

        return books
    }
}