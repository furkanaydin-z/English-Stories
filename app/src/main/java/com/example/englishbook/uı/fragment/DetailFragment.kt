package com.example.englishbook.uı.fragment

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.englishbook.R
import com.example.englishbook.databinding.FragmentDetailBinding
import com.example.englishbook.uı.translator.WordTranslator


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val translator = WordTranslator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val book = bundle.books
        binding.kitaplar = book

        binding.imageViewDetail.setImageResource(
            resources.getIdentifier(book.image_name, "drawable", requireContext().packageName)
        )

        // textViewDetail'ın movementMethod'ı ayarlanmalı
        binding.textViewDetail.movementMethod = LinkMovementMethod.getInstance()

        // Metni parçalayarak tıklanabilir hale getir
        setSpannableText(binding.textViewDetail, book.ozel_metin ?: "")

        return binding.root
    }

    private fun setSpannableText(textView: TextView, text: String) {
        val spannableStringBuilder = SpannableStringBuilder()
        val words = text.split(" ")

        words.forEachIndexed { index, word ->
            val start = spannableStringBuilder.length
            spannableStringBuilder.append(word)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    val translation = translator.translate(word)
                    Toast.makeText(context, translation, Toast.LENGTH_SHORT).show()
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false // Altını çizmek istemiyorsanız
                    ds.color = textView.currentTextColor // Metin rengini koruyun
                }
            }

            spannableStringBuilder.setSpan(
                clickableSpan,
                start,
                spannableStringBuilder.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            if (index != words.size - 1) {
                spannableStringBuilder.append(" ")
            }
        }

        textView.text = spannableStringBuilder
    }
}