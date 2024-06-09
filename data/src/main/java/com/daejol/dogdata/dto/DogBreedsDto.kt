package com.daejol.catdata.dto

import com.google.gson.annotations.SerializedName

data class DogBreedsDto(
    // TODO: 이렇게 SerializedName으로 json column명을 정의하고
    // TODO: 변수명은 camelCase를 사용하는 것이 좋을까?
    // TODO: 아니면 변수명도 통일하면 좋을까?

    // TODO: 서버 개발자와 일할 수 있으면 특정 field는 not null을 선언할 수 있겠지만
    // TODO: 외부 API를 사용하는 경우 수정 요청을 할 수 없기 때문에
    // TODO: 모든 column에 null 처리를 하는 것이 맞다고 생각한다.
    @SerializedName("adaptability")
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
    val weight: DogWeight?,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String?
)

data class DogWeight(
    @SerializedName("imperial")
    val imperial: String?,
    @SerializedName("metric")
    val metric: String?
)