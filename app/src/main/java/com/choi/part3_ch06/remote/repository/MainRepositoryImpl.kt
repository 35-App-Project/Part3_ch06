package com.choi.part3_ch06.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.remote.MainPagingSource
import com.choi.part3_ch06.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService : MainService
): MainRepository {
    override fun loadList() = Pager(
        config= PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
        ),
        pagingSourceFactory = {
            MainPagingSource(mainService)
        }
    ).flow
}