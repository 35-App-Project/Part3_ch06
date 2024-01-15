package com.choi.part3_ch06.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.choi.part3_ch06.databinding.ItemEmptyBinding
import com.choi.part3_ch06.model.ViewType

// Adapter 의 Create ViewHolder 에서 호출 -> ViewType 에 맞는 holder 를 넘겨 주기 위함
// 3개의 Adapter 가 있어 Generator 를 따로 빼서 제작  => 하나로 관리
object ViewHolderGenerator {

    class ItemViewHolder(binding : ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    // 실질 적인 구현체
    fun get(
        parent: ViewGroup,
        viewType: Int
    ) : BindingViewHolder<*> {
        return when(viewType) {
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalViewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal -> FullAddViewHolder(parent.toBinding())

            ViewType.SELL_ITEM.ordinal->SellItemViewHolder(parent.toBinding())
            ViewType.COUPON.ordinal-> CouponViewHolder(parent.toBinding())
            ViewType.IMAGE.ordinal -> ImageViewHolder(parent.toBinding())
            ViewType.SALE.ordinal -> SaleViewHolder(parent.toBinding())

            else -> ItemViewHolder(parent.toBinding())
        }
    }

   // Extension Function
    private inline fun <reified  V: ViewBinding> ViewGroup.toBinding() : V {
        return V::class.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null,LayoutInflater.from(context),this,false) as V
    }
}