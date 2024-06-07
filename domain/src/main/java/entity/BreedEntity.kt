package entity

import com.google.gson.annotations.SerializedName

// TODO: 어떤 속성을 어떻게 쓸 지에 따라 translator를 어떻게 만들 지 결정하자.
// TODO: ex) intelligence랑 description, vetstreet_url에 있는 정보를 활용해서
// TODO: 우리가 사용자에게 보여 줄 멘트를 translator로 전달한다거나 등등
// TODO: 또한 필요 없는 속성은 제거하자.
data class BreedEntity(
    @SerializedName("alt_names")
    val altNames: String?,
    @SerializedName("cfa_url")
    val cfaUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("vcahospitals_url")
    val vcahospitalsUrl: String?,
    @SerializedName("vetstreet_url")
    val vetstreetUrl: String?,
    @SerializedName("vocalisation")
    val vocalisation: Int?,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String?
)