package com.anis.lesson7_8_cv_builder.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(
    itemView!!
) {
    var currentPosition = 0
    open fun onBind(position: Int) {
        currentPosition = position
    }
}