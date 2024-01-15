package com.choi.part3_ch06.model

interface ListItem : java.io.Serializable {
    val viewType : ViewType

    fun getKey() = hashCode()
}


// List 에 들어갈 항목을 위한 파일
enum class ViewType {
    // 부모 타입(공간)
    VIEW_PAGER,
    HORIZONTAL,
    FULL_AD,

    // 자식 타입
    SELL_ITEM,
    IMAGE,
    SALE,
    COUPON,

    EMPTY,
}