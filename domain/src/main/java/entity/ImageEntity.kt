package entity

import com.google.gson.annotations.SerializedName

data class ImageEntity(
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Double?,
    @SerializedName("height")
    val height: Double?,
    @SerializedName("breeds")
    val breeds: List<BreedEntity>?
)