package com.choi.part3_ch06.model

data class SellItem(
    val imagerUrl : String,
    val name: String,
    val price : Long,
    val badge : String?=null,
    val rating : Float?=null,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.SELL_ITEM

}
