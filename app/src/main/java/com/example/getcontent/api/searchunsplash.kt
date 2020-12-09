package com.example.getcontent.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface searchunsplash {
    @GET("/search/photos")
    fun getsearch(
        @Query("client_id") client_id:String,
        @Query("query") query: String

    ): Call<searchresponse<List<urlsearch<gambar>>>>
}