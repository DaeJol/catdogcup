package com.daejol.catdata.dto

import com.google.gson.annotations.SerializedName

data class DogImageDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Double?,
    @SerializedName("height")
    val height: Double?,
    @SerializedName("breeds")
    val breeds: List<DogBreedsDto>?
)