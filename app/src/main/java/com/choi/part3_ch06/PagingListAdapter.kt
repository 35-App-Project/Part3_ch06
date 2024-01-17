package com.choi.part3_ch06

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.viewholder.BindingViewHolder
import com.choi.part3_ch06.viewholder.ViewHolderGenerator

class PagingListAdapter : PagingDataAdapter<ListItem,BindingViewHolder<*>>(DiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        val item=getItem(position)
        return item?.viewType?.ordinal ?: -1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent,viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item=getItem(position)
        if (item!=null) {
            holder.bind(item)
        }
    }

}