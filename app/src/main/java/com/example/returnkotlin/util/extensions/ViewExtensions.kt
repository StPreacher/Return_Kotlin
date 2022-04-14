package com.example.returnkotlin.util.extensions

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.returnkotlin.model.PublicHoliday

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun TextView.changeWith(value: String?) {
    this.text = value
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}
