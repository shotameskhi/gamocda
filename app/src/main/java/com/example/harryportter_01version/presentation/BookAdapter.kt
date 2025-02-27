package com.example.harryportter_01version.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harryportter_01version.data.BookData
import com.example.harryportter_01version.databinding.ItemBookBinding

class BookAdapter: RecyclerView.Adapter<BookAdapter.HarryPotterViewHolder>() {

        private var books: List<BookData> = emptyList()


        var onItemClick: (currentBook: BookData) -> Unit = {}

        fun updateBooksList(newBooksList: List<BookData>) {
            val bookCallBack = BookCallBack(books, newBooksList)
            val diffResult = DiffUtil.calculateDiff(bookCallBack)
            books = newBooksList
            diffResult.dispatchUpdatesTo(this)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryPotterViewHolder {
            return HarryPotterViewHolder(
                ItemBookBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        override fun onBindViewHolder(holder: HarryPotterViewHolder, position: Int) {
            holder.bind(books[position])
        }

        override fun getItemCount(): Int = books.size
        class BookCallBack(
            private val oldList: List<BookData>,
            private val newList: List<BookData>
        ) : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldList.size
            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oList = oldList[oldItemPosition]
                val nList = newList[newItemPosition]
                return oList.id == nList.id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oList = oldList[oldItemPosition]
                val nList = newList[newItemPosition]
                return oList == nList
            }

        }
        inner class HarryPotterViewHolder(private val binding: ItemBookBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(bookData: BookData) = with(binding) {
                val book = bookData.attributes
                Glide.with(imageView)
                    .load(book?.coverUrl)
                    .into(imageView)

                textWiki.text = book?.title


                binding.root.setOnClickListener {
                    onItemClick.invoke(bookData)
                }

            }
        }

    }


