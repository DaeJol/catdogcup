package com.daejol.data.ranking.dto

import com.daejol.domain.entity.ImageEntity
import com.google.gson.annotations.SerializedName

data class VotesRequest(
    @SerializedName("image_id") val imageId: String,
    @SerializedName("sub_id") val subId: String,
    val value: Int = 0
)

fun ImageEntity.toData() = VotesRequest(
    imageId = id ?: "",
    subId = breeds?.firstOrNull().toString()
)
