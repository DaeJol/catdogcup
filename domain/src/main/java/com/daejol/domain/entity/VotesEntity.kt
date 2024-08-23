package com.daejol.domain.entity

data class VotesEntity(
    val id: String,
    val imageId: String,
    val subId: String,
    val createdAt: String,
    val value: Int,
    val countryCode: String,
    val image: ImageEntity
)
