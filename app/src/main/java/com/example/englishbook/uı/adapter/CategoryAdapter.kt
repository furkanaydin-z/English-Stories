package com.example.englishbook.uı.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.englishbook.data.entity.Kitaplar
import com.example.englishbook.databinding.CardTasarimBinding

class CategoryAdapter(var bContext:Context,var booksList: List<Kitaplar>, var onItemClick: (Kitaplar) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(bContext),parent,false)
        return CardTasarimHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val book = booksList.get(position)
        val b = holder.tasarim
        b.cardImageView.setImageResource(
            bContext.resources.getIdentifier(book.image_name,"drawable",bContext.packageName))
        b.cardTextView.text = book.book_name
        b.textLevel.text = book.book_level.toString()


        holder.itemView.setOnClickListener {
            onItemClick.invoke(book)
        }

    }
    override fun getItemCount(): Int {
        return booksList.size
    }
}