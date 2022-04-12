package com.example.returnkotlin.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.R
import com.example.returnkotlin.databinding.CountryItemBinding
import com.example.returnkotlin.model.Country

class CountryListAdapter(private var items : List<Country>) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : CountryItemBinding = DataBindingUtil.inflate(inflater, R.layout.country_item,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    inner class ViewHolder(private val mBinding: CountryItemBinding) :RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item : Country) {
            mBinding.model = item
        }
    }
}