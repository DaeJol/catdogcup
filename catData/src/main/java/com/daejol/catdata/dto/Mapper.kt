package com.daejol.catdata.dto

import entity.BreedInfoEntity
import entity.ImageEntity

object Mapper {
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