package com.choi.part3_ch06.remote.repository

import androidx.paging.PagingData
import com.choi.part3_ch06.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>

}