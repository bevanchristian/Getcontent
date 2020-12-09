package com.example.getcontent.api

import com.google.gson.annotations.SerializedName

open class searchresponse<T>{
    @SerializedName("total")
    var total: String? = null
    @SerializedName("total_pages")
    var total_pages: String? = null
    @SerializedName("results")
    var results:T? = null

}