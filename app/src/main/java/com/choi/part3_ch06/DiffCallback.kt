package com.choi.part3_ch06

import androidx.recyclerview.widget.DiffUtil
import com.choi.part3_ch06.model.ListItem

// ListAdapter 를 위한 DiffCallBack
class DiffCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.viewType==newItem.viewType && oldItem.getKey() == newItem.getKey()
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem==newItem
    }
}