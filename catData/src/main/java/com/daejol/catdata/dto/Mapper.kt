package com.daejol.catdata.dto

import entity.BreedInfoEntity
import entity.BreedTypeEntity
import entity.ImageEntity

object Mapper {
    fun CatBreedDto.toDomain(): BreedTypeEntity {
        return BreedTypeEntity(
            id = this.id,
            name = this.name,
            weight = this.weight,
            height = this.height,
            lifeSpan = this.lifeSpan,
            breedsFor = this.breedsFor,
            breedGroup = this.breedGroup
        )
    }

    fun CatBreedsDto.toDomain(): BreedInfoEntity {
        return BreedInfoEntity(
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

    fun CatImageDto.toDomain(): ImageEntity {
        return ImageEntity(
            id = this.id,
            url = this.url,
            width = this.width,
            height = this.height,
            breeds = this.breeds?.map {
                it.toDomain()
            }
        )
    }
}