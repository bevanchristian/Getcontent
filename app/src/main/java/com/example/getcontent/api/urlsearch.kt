package com.example.getcontent.api

import com.google.gson.annotations.SerializedName

open class urlsearch<T>{
    @SerializedName("urls")
    var urls:T? = null

}