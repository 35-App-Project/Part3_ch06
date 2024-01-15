package com.choi.part3_ch06.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.choi.part3_ch06.BR
import com.choi.part3_ch06.model.ListItem

// 공통화 처리 된 ViewHolder -> 각각의 ViewHolder 는 공통화 처리 된 ViewHolder 를 상속 받는다
abstract class BindingViewHolder<VB : ViewDataBinding>(
    private val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    protected var item: ListItem? = null

    open fun bind(item : ListItem) {
        this.item=item
        // BR 이 뭐지?
        binding.setVariable(BR.item, this.item)
    }

}