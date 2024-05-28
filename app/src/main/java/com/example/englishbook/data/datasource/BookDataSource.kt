package com.example.englishbook.data.datasource

import androidx.lifecycle.MutableLiveData
import com.example.englishbook.data.entity.Kitaplar
import com.google.firebase.firestore.CollectionReference

class BookDataSource (var collectionBooks:CollectionReference) {

     fun booksList(): MutableLiveData<List<Kitaplar>> {
          val kitaplarListesi = MutableLiveData<List<Kitaplar>>()

          collectionBooks.get().addOnCompleteListener {
               val liste = ArrayList<Kitaplar>()
               for (d in it.result){
                    val book = d.toObject(Kitaplar::class.java)
                    book.kitap_id =d.id
                    liste.add(book)
               }
               kitaplarListesi.value = liste
          }
          return kitaplarListesi
     }
}