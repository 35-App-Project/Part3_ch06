package com.choi.part3_ch06.viewholder

import com.choi.part3_ch06.ListAdapter
import com.choi.part3_ch06.databinding.ItemViewpagerBinding
import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.model.ViewPager

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){

    private val adapter=ListAdapter()

    init {
        binding.viewpager.adapter=adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }

}