package com.example.shazam.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shazam.data.api.ApiService
import com.example.shazam.data.model.TopChart

class TopChartDataSource(private val apiService: ApiService) : PagingSource<Int, TopChart>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopChart> {
        try {
            val currentPage = params.key ?: 0
            val response = apiService.getTopChart(offset = currentPage * 50)
            val responseData = mutableListOf<TopChart>()
            val data = response.body() ?: arrayListOf()
            responseData.addAll(data)

            val prevKey = if (currentPage == 0) null else currentPage - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TopChart>): Int? {
        return state.anchorPosition
    }
}