package com.keykat.dogdata.dto

import com.google.gson.annotations.SerializedName

// "id": 2,
// "name": "Afghan Hound",
// "weight": " 50 to 60 pounds",
// "height": "25 to 27 inches at the shoulder",
// "life_span": "10 to 13 years",
// "bred_for": "Coursing and hunting",
// "breed_group": "Hound"
data class DogBreedDto(
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
