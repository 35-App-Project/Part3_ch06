package com.choi.part3_ch06

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.remote.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

// Hilt 를 사용 하여 Factory 를 구현 하지 않아도 된다
@HiltViewModel
class MainViewModel  @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _pagingData = MutableStateFlow<PagingData<ListItem>?>(null)
    val pagingData : StateFlow<PagingData<ListItem>?> = _pagingData

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch {
            mainRepository.loadList()
                .cachedIn(this)
                .collectLatest { list ->
                    _pagingData.value=list
                }
        }
    }
}