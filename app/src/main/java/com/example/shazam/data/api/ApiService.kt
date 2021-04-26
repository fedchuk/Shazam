package com.example.shazam.data.api

import com.example.shazam.data.model.TopChart
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(ApiConstants.HEADER_RAPID_API_KEY, ApiConstants.HEADER_RAPID_API_HOST)
    @GET(ApiConstants.Routes.CHART_CITY)
    suspend fun getTopChart(
        @Query("city_id") cityId: Int = 703448,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 50
    ): Response<List<TopChart>>
}