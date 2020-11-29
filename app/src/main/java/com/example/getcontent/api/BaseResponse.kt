package com.example.getcontent.api

import com.google.gson.annotations.SerializedName
import java.util.*

open class BaseResponse<T>{
    @SerializedName("id")
    var id: String? = null
    @SerializedName("created_at")
    var created_at: String? = null
    @SerializedName("updated_at")
    var updated_at: String? = null
    @SerializedName("promoted_at")
    var promoted_at: String? = null
    @SerializedName("width")
    var width: String? = null
    @SerializedName("urls")
    var urls:T? = null

}