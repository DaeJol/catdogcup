package com.daejol.data.repository

import DataState
import com.daejol.data.api.CatImagesApi
import com.daejol.domain.repository.CatImagesRepository
import entity.ImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatImagesRepositoryImpl @Inject constructor(
    private val catImagesApi: CatImagesApi
) : CatImagesRepository {
    override fun getCatRandomImages(imageCount: Int): Flow<DataState<List<ImageEntity>>> = flow {
        try {
            val catImages =
                catImagesApi.getCatImages().body()?.map { it.toEntity() }?.toList()
            emit(DataState.Success(data = catImages))
        } catch (e: Exception) {
            emit(DataState.Fail(data = null, exception = e))
        }
    }

}