package com.example.returnkotlin.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.databinding.CountryItemBinding
import com.example.returnkotlin.model.Country

class CountryItemViewHolder(private val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item : Country) {
        binding.model = item
    }
}