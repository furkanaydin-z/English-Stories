package com.example.englishbook.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.englishbook.data.datasource.BookDataSource
import com.example.englishbook.data.entity.Kitaplar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BookRepository() {
     private val bds = BookDataSource(Firebase.firestore.collection("default"))

     fun booksList(): MutableLiveData<List<Kitaplar>> = bds.booksList()

}