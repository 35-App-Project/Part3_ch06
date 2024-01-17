package com.choi.part3_ch06.model

import com.google.gson.annotations.SerializedName

// API 로 부터 받아 오는 DTO 들
data class NetworkResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data : PageListResponse,
)

data class PageListResponse(
    @SerializedName("list") val list: List<ListItem>,
    @SerializedName("page") val page: PageInfoResponse
)

// Paging 관련 Response
data class PageInfoResponse(
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("nextPage") val nextPage: Int?,
    @SerializedName("totalPage") val totalPage: Int,
    @SerializedName("totalItems") val totalItems:Int,

)
