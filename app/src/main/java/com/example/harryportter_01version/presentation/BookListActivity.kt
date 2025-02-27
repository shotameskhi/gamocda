package com.example.harryportter_01version.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harryportter_01version.R
import com.example.harryportter_01version.data.BookRepository
import com.example.harryportter_01version.data.BooksList
import com.example.harryportter_01version.databinding.ActivityBookListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookListActivity : AppCompatActivity() {
    private val viewModel by viewModels<BookViewModel>()
    private val binding by lazy { ActivityBookListBinding.inflate(layoutInflater) }

    private val booksAdapter = BookAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
        setCollectors()
        backButtonClick()
    }

    private fun initRecycler() {
        binding.recyclerView.apply{
            adapter = booksAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setCollectors() {
        lifecycleScope.launch {
            viewModel.hpBooks.collect { booksList ->
                booksAdapter.updateBooksList(booksList)

            }
        }
    }
    private fun backButtonClick (){
        binding.backButton.setOnClickListener{
            finish()
        }
    }


}


