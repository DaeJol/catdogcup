package com.daejol.data.dto

import entity.BreedEntity

object Mapper {
    fun CatBreedsDto.toDomain(): BreedEntity {
        return BreedEntity(
            altNames = this.altNames,
            cfaUrl = this.cfaUrl,
            description = this.description,
            id = this.id,
            name = this.name,
            origin = this.origin,
            vcahospitalsUrl = this.vcahospitalsUrl,
            vetstreetUrl = this.vetstreetUrl,
            vocalisation = this.vocalisation,
            wikipediaUrl = this.wikipediaUrl
        )
    }


}