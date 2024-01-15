package com.choi.part3_ch06.viewholder

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import com.choi.part3_ch06.ListAdapter
import com.choi.part3_ch06.databinding.ItemHorizontalBinding
import com.choi.part3_ch06.model.Horiziontal
import com.choi.part3_ch06.model.ListItem

class HorizontalViewHolder(private val binding: ItemHorizontalBinding) :
    BindingViewHolder<ItemHorizontalBinding>(binding) {

        private val adapter= ListAdapter()

        init {
            binding.listView.adapter=adapter
        }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horiziontal
        binding.titleTextView.text=item.title
        adapter.submitList(item.items)
    }
}