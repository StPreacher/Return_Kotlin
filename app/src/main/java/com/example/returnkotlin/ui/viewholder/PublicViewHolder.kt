package com.example.returnkotlin.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.databinding.PublicHolidayItemBinding
import com.example.returnkotlin.model.PublicHoliday

class PublicViewHolder(private val binding: PublicHolidayItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item : PublicHoliday) {
        binding.model = item
    }
}