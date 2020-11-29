package com.example.getcontent.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface unsplashservice {
    @GET("photos/random")
    fun getphoto(
        @Query("client_id") client_id:String,
        @Query("count") count: Int

    ): Call<List<BaseResponse<gambar>>>
}