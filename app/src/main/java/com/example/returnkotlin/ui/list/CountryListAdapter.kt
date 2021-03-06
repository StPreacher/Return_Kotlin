package com.example.returnkotlin.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.R
import com.example.returnkotlin.databinding.CountryItemBinding
import com.example.returnkotlin.model.Country
import com.example.returnkotlin.ui.viewholder.CountryItemViewHolder

class CountryListAdapter(private var items : List<Country>) :
    RecyclerView.Adapter<CountryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : CountryItemBinding = DataBindingUtil.inflate(inflater, R.layout.country_item,parent,false)
        return CountryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

}