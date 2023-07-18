package com.hsmnzaydn.other_applications


import com.google.gson.annotations.SerializedName

internal data class Data(
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("tutorialType")
    val tutorialType: String
)