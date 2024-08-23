package com.daejol.data.ranking.dto

import com.daejol.domain.entity.VotesEntity
import com.google.gson.annotations.SerializedName

data class VotesDto(
    val id: String,
    @SerializedName("image_id") val imageId: String,
    @SerializedName("sub_id") val subId: String,
    @SerializedName("created_at") val createdAt: String,
    val value: Int,
    @SerializedName("country_code") val countryCode: String,
    val image: ImageDto
) {
    fun toDomain() =
        VotesEntity(id, imageId, subId, createdAt, value, countryCode, image.toDomain())
}
