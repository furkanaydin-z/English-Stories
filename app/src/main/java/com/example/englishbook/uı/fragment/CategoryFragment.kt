package com.example.englishbook.uı.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.englishbook.R
import com.example.englishbook.databinding.FragmentCategoryBinding
import com.example.englishbook.uı.adapter.CategoryAdapter
import com.example.englishbook.uı.viewModel.BookViewModel

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel:BookViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_category,container,false)
        binding.categoryFragment = this

        viewModel.kitaplarListesi.observe(viewLifecycleOwner){
            val bookAdapter = CategoryAdapter(requireContext(),it) {clickedBook ->
                val action = CategoryFragmentDirections.categoryToDetail(clickedBook)
                findNavController().navigate(action)
            }
            binding.categoryAdapter = bookAdapter

        }



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : BookViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun ara(aramaKelimesi:String){
        Log.e("arama",aramaKelimesi)
    }
}