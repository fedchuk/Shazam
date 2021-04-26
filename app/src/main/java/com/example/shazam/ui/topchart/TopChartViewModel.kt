package com.example.shazam.ui.topchart

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.shazam.data.api.ApiService
import com.example.shazam.data.repository.TopChartDataSource
import com.example.shazam.di.ErrorHandler
import com.example.shazam.navigation.Navigator
import com.example.shazam.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopChartViewModel
@Inject constructor(
    private val navigator: Navigator,
    private val apiService: ApiService,
    errorHandler: ErrorHandler
) : BaseViewModel(errorHandler) {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        TopChartDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}