package com.daejol.catdata.dto

import com.google.gson.annotations.SerializedName

data class CatBreedDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("weight")
    val weight: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("life_span")
    val lifeSpan: String?,
    @SerializedName("bred_for")
    val breedsFor: String?,
    @SerializedName("breed_group")
    val breedGroup: String?
)
