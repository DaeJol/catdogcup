package com.daejol.data.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import entity.BreedEntity
import entity.ImageEntity

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
) {
    fun toEntity(): ImageEntity {
        val breedsList = this.breeds.map {
            Gson().fromJson(Gson().toJson(it), BreedEntity::class.java)
        }.toList()

        return ImageEntity(
            id = this.id,
            url = this.url,
            width = this.width,
            height = this.height,
            breeds = breedsList
        )
    }
}