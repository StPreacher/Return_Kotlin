package com.example.returnkotlin.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.databinding.CountryItemBinding
import com.example.returnkotlin.model.Country

class CountryListAdapter(private var items : List<Country>) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    inner class ViewHolder(private val mBinding: CountryItemBinding) :RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item : Country) {
            with(mBinding){
                mBinding.model = item
            }
        }
    }
}