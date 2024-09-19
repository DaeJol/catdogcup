package com.daejol.domain.usecase

import com.daejol.domain.entity.BreedInfoEntity
import com.daejol.domain.repository.CatBreedsRepository
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

class GetMatchResultUseCase @Inject constructor(
    private val catBreedsRepository: CatBreedsRepository
) {
    val matchResultImages = mutableMapOf(
        "bslo" to "https://cdn2.thecatapi.com/images/7isAO4Cav.jpg",
        "norw" to "https://cdn2.thecatapi.com/images/06dgGmEOV.jpg",
        "abys" to "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
        "kuri" to "https://cdn2.thecatapi.com/images/NZpO4pU56M.jpg",
        "birm" to "https://cdn2.thecatapi.com/images/HOrX5gwLS.jpg",
        "dons" to "https://cdn2.thecatapi.com/images/3KG57GfMW.jpg",
        "hima" to "https://cdn2.thecatapi.com/images/CDhOtM-Ig.jpg",
        "drex" to "https://cdn2.thecatapi.com/images/4RzEwvyzz.png",
        "mcoo" to "https://cdn2.thecatapi.com/images/OOD3VXAQn.jpg",
        "bali" to "https://cdn2.thecatapi.com/images/13MkvUreZ.jpg",
        "cymr" to "https://cdn2.thecatapi.com/images/3dbtapCWM.jpg",
        "munc" to "https://cdn2.thecatapi.com/images/j5cVSqLer.jpg",
        "pers" to "https://cdn2.thecatapi.com/images/-Zfz5z2jK.jpg",
        "khao" to "https://cdn2.thecatapi.com/images/165ok6ESN.jpg",
        "nebe" to "https://cdn2.thecatapi.com/images/OGTWqNNOt.jpg"
    )
    
    suspend fun getBreedsDetail(
        id: String
    ): Flow<BreedInfoEntity?> {
        return catBreedsRepository.getCatBreed(id = id).map {
            return@map it.on(
                onError = {
                    throw Exception()
                },
                onSuccess = { breedTypeEntity ->
                    breedTypeEntity?.copy(
                        imageUrl = matchResultImages[id]
                    )
                }
            )
        }
    }
}