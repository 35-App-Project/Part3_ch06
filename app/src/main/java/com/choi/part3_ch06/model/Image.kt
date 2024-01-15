package com.choi.part3_ch06.model

data class Image(
    val imageUrl: String,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.IMAGE
}
