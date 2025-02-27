package com.example.harryportter_01version.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harryportter_01version.data.BookData
import com.example.harryportter_01version.data.BookRepository
import com.example.harryportter_01version.data.BooksList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel: ViewModel(){
    private val booksRepository = BookRepository()
    private var _hpBooks = MutableStateFlow<List<BookData>>(emptyList())
    val hpBooks: StateFlow<List<BookData>> = _hpBooks

    init {
        getBooks()
    }

    fun getBooks()= viewModelScope.launch {
        val  books = booksRepository.getBooksList()
        if (books != null) {
            _hpBooks.emit(books)
        } else {
            Log.d("HarryPotterViewModel", "hasn't found Book")
        }


    }

}