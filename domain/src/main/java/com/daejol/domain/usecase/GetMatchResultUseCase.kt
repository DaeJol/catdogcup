package com.daejol.domain.usecase

import com.daejol.domain.entity.BreedInfoEntity
import com.daejol.domain.repository.CatBreedsRepository
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

data class MbtiCat(
    val id: String,
    val imageUrl: String,
    val mbti: String
)

class GetMatchResultUseCase @Inject constructor(
    private val catBreedsRepository: CatBreedsRepository
) {
    val mbtiList = listOf(
        MbtiCat(
            id = "bslo",
            imageUrl = "https://cdn2.thecatapi.com/images/7isAO4Cav.jpg",
            mbti = "ECAR"
        ),
        MbtiCat(
            id = "norw",
            imageUrl = "https://cdn2.thecatapi.com/images/06dgGmEOV.jpg",
            mbti = "ECAL"
        ),
        MbtiCat(
            id = "abys",
            imageUrl = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            mbti = "ECDR"
        ),
        MbtiCat(
            id = "kuri",
            imageUrl = "https://cdn2.thecatapi.com/images/NZpO4pU56M.jpg",
            mbti = "ECDL"
        ),
        MbtiCat(
            id = "birm",
            imageUrl = "https://cdn2.thecatapi.com/images/HOrX5gwLS.jpg",
            mbti = "ESAR"
        ),
        MbtiCat(
            id = "dons",
            imageUrl = "https://cdn2.thecatapi.com/images/3KG57GfMW.jpg",
            mbti = "ESAL"
        ),
        MbtiCat(
            id = "hima",
            imageUrl = "https://cdn2.thecatapi.com/images/CDhOtM-Ig.jpg",
            mbti = "ESDR"
        ),
        MbtiCat(
            id = "drex",
            imageUrl = "https://cdn2.thecatapi.com/images/4RzEwvyzz.png",
            mbti = "ESDL"
        ),
        MbtiCat(
            id = "mcoo",
            imageUrl = "https://cdn2.thecatapi.com/images/OOD3VXAQn.jpg",
            mbti = "ICAR"
        ),
        MbtiCat(
            id = "bali",
            imageUrl = "https://cdn2.thecatapi.com/images/13MkvUreZ.jpg",
            mbti = "ICAL"
        ),
        MbtiCat(
            id = "cymr",
            imageUrl = "https://cdn2.thecatapi.com/images/3dbtapCWM.jpg",
            mbti = "ICDR"
        ),
        MbtiCat(
            id = "munc",
            imageUrl = "https://cdn2.thecatapi.com/images/j5cVSqLer.jpg",
            mbti = "ICDL"
        ),
        MbtiCat(
            id = "pers",
            imageUrl = "https://cdn2.thecatapi.com/images/-Zfz5z2jK.jpg",
            mbti = "ISAR"
        ),
        MbtiCat(
            id = "khao",
            imageUrl = "https://cdn2.thecatapi.com/images/165ok6ESN.jpg",
            mbti = "ISAL"
        ),
        MbtiCat(
            id = "nebe",
            imageUrl = "https://cdn2.thecatapi.com/images/OGTWqNNOt.jpg",
            mbti = "ISDR"
        ),
        MbtiCat(
            id = "nebe",
            imageUrl = "https://cdn2.thecatapi.com/images/OGTWqNNOt.jpg",
            mbti = "ISDL"
        ),
    )
    
    suspend fun getBreedsDetail(
        mbti: String
    ): Flow<BreedInfoEntity?> {
        val mbtiCat =  mbtiList.find {
            it.mbti == mbti
        }

        if (mbtiCat == null) {
            return flow { }
        }

        println("[keykat] ${mbti} ${mbtiCat}")

        return catBreedsRepository.getCatBreed(id = mbtiCat.id).map {
            return@map it.on(
                onError = {
                    throw Exception()
                },
                onSuccess = { breedTypeEntity ->
                    breedTypeEntity?.copy(imageUrl = mbtiCat.imageUrl)
                }
            )
        }
    }
}