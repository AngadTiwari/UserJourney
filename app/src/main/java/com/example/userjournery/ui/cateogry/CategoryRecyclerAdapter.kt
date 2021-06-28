package com.example.userjournery.ui.cateogry

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.userjournery.R
import com.example.userjournery.databinding.AdapterCategoryBinding
import com.example.userjournery.model.UserCategory
import java.util.*

class CategoryRecyclerAdapter: RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    private var data: List<UserCategory> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = AdapterCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<UserCategory>) {
        this.data = data
        notifyDataSetChanged()
    }

    class CategoryViewHolder(private val binding: AdapterCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                // TODO: Handle on click, if required
            }
        }

        fun bind(item: UserCategory) = with(itemView) {
            binding.textCategoryName.text = item.name
        }
    }
}