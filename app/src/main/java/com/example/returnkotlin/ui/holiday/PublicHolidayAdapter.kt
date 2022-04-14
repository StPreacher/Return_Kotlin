package com.example.returnkotlin.ui.holiday

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.R
import com.example.returnkotlin.databinding.PublicHolidayItemBinding
import com.example.returnkotlin.model.PublicHoliday
import com.example.returnkotlin.ui.viewholder.PublicViewHolder
import com.example.returnkotlin.util.extensions.listen

class PublicHolidayAdapter(private var items: List<PublicHoliday>) :
    RecyclerView.Adapter<PublicViewHolder>() {

    var itemClick : ((PublicHoliday) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: PublicHolidayItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.public_holiday_item, parent, false)
        return PublicViewHolder(binding).listen {pos, type ->
            val item = items[pos]
        }
    }

    override fun onBindViewHolder(holder: PublicViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}