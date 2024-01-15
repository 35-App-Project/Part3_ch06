package com.choi.part3_ch06.model

// 맞는 View Type 이 없을 때 Empty 에 맞는 ViewHolder를 뿌려 줄 것이다
class Empty : ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY

}