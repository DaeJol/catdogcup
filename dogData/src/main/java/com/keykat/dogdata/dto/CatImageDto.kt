package com.daejol.catdata.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import entity.BreedEntity
import entity.ImageEntity

data class CatImageDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Double?,
    @SerializedName("height")
    val height: Double?,
    @SerializedName("breeds")
    val breeds: List<CatBreedsDto>?
)