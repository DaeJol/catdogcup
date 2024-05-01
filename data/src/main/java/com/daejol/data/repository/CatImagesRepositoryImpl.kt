package com.daejol.data.repository

import com.daejol.data.api.CatImagesApi
import com.daejol.domain.repository.CatImagesRepository
import entity.ImageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatImagesRepositoryImpl @Inject constructor(
    catImagesApi: CatImagesApi
): CatImagesRepository {
    override fun getCatRandomImages(imageCount: Int): Flow<ImageEntity> {
        TODO("Not yet implemented")
    }

}