package com.daejol.domain.entity

import com.google.gson.annotations.SerializedName

data class ImageEntity(
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Double? = null,
    @SerializedName("height")
    val height: Double? = null,
    @SerializedName("breeds")
    val breeds: List<BreedInfoEntity>? = null
)
