package com.daejol.data.dto

import com.google.gson.annotations.SerializedName

data class CatImageDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Double,
    @SerializedName("height")
    val height: Double,
    @SerializedName("breeds")
    val breeds: List<CatBreedsDto>
)