package com.nicolas.sanchezpost1u8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicolas.sanchezpost1u8.databinding.ItemProductBinding

class ProductAdapter : ListAdapter<ProductItem, ProductAdapter.ViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductItem) {
            binding.tvName.text = item.name
            binding.tvPrice.text = "$${item.price}"
            binding.tvStock.text = "Stock: ${item.stock}"
        }
    }
}
