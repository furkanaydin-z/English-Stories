package com.example.englishbook.uı.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishbook.data.entity.Kitaplar
import com.example.englishbook.data.repo.BookRepository

class BookViewModel (): ViewModel() {
    private val brepo = BookRepository()

    var kitaplarListesi = MutableLiveData<List<Kitaplar>>()

    init {
        booksList()
    }

    fun booksList() {
        kitaplarListesi = brepo.booksList()

    }
}