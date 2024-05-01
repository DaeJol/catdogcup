package entity

import com.google.gson.annotations.SerializedName

// TODO: 어떤 속성을 어떻게 쓸 지에 따라 translator를 어떻게 만들 지 결정하자.
// TODO: ex) intelligence랑 description, vetstreet_url에 있는 정보를 활용해서
// TODO: 우리가 사용자에게 보여 줄 멘트를 translator로 전달한다거나 등등
// TODO: 또한 필요 없는 속성은 제거하자.
data class BreedEntity(
    val adaptability: Int?,
    @SerializedName("affection_level")
    val affectionLevel: Int?,
    @SerializedName("alt_names")
    val altNames: String?,
    @SerializedName("cfa_url")
    val cfaUrl: String?,
    @SerializedName("child_friendly")
    val childFriendly: Int?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("country_codes")
    val countryCodes: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("dog_friendly")
    val dogFriendly: Int?,
    @SerializedName("energy_level")
    val energyLevel: Int?,
    @SerializedName("experimental")
    val experimental: Int?,
    @SerializedName("grooming")
    val grooming: Int?,
    @SerializedName("hairless")
    val hairless: Int?,
    @SerializedName("health_issues")
    val healthIssues: Int?,
    @SerializedName("hypoallergenic")
    val hypoallergenic: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("indoor")
    val indoor: Int?,
    @SerializedName("intelligence")
    val intelligence: Int?,
    @SerializedName("lap")
    val lap: Int?,
    @SerializedName("life_span")
    val lifeSpan: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("natural")
    val natural: Int?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("rare")
    val rare: Int?,
    @SerializedName("reference_image_id")
    val referenceImageId: String?,
    @SerializedName("rex")
    val rex: Int?,
    @SerializedName("shedding_level")
    val sheddingLevel: Int?,
    @SerializedName("short_legs")
    val shortLegs: Int?,
    @SerializedName("social_needs")
    val socialNeeds: Int?,
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int?,
    @SerializedName("suppressed_tail")
    val suppressedTail: Int?,
    @SerializedName("temperament")
    val temperament: String?,
    @SerializedName("vcahospitals_url")
    val vcahospitalsUrl: String?,
    @SerializedName("vetstreet_url")
    val vetstreetUrl: String?,
    @SerializedName("vocalisation")
    val vocalisation: Int?,
    @SerializedName("weight")
    val weight: Weight?,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String?
)

data class Weight(
    @SerializedName("imperial")
    val imperial: String?,
    @SerializedName("metric")
    val metric: String?
)