package com.choi.part3_ch06.model

data class Horiziontal(
    val title: String,
    val items: List<ListItem>,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.HORIZONTAL
}
