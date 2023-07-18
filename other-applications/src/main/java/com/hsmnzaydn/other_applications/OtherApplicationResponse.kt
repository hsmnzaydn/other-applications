package com.hsmnzaydn.other_applications


import com.google.gson.annotations.SerializedName

internal data class OtherApplicationResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("error")
    val error: String
)