package com.choi.part3_ch06.model

data class Coupon(
    val imageUrl: String,
    val name: String,
    val coupon : String,

) : ListItem {
    override val viewType: ViewType
        get() = ViewType.COUPON
}
