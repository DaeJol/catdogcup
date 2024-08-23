package com.daejol.data.ranking.dto

import com.daejol.domain.entity.ImageEntity

data class ImageDto(
    val id: String,
    val url: String
) {
    fun toDomain() = ImageEntity(id = id, url = url)
}
