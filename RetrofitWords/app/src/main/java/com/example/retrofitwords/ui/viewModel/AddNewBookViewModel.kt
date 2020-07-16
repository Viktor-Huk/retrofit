package com.example.retrofitwords.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwords.model.Book
import com.example.retrofitwords.network.NetworkService
import kotlinx.coroutines.launch

class AddNewBookViewModel: ViewModel() {

    fun addNewBook(book: Book) {
        viewModelScope.launch {
            NetworkService.addNewBook(book)
        }
    }
}
