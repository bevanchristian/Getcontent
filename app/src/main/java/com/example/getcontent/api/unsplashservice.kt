package com.example.getcontent.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface unsplashservice {
    @GET("random")
    fun getShipmentSummary(
        @Query("client_id") client_id: String,
        @Query("count") count: Int
    ): Call<BaseResponse>
}