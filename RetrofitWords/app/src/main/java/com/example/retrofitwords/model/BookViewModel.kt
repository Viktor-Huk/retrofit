package com.example.retrofitwords.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwords.data.Book
import com.example.retrofitwords.data.BooksApiImpl
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Book>>()
    val items: LiveData<List<Book>> get() = _items

    init {

        viewModelScope.launch {
            _items.value = BooksApiImpl.getListOfBooks()
        }
    }
}