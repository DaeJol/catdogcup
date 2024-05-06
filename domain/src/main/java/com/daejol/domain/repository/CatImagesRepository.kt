package com.daejol.domain.repository

import DataState
import entity.ImageEntity
import kotlinx.coroutines.flow.Flow

interface CatImagesRepository {
    fun getCatRandomImages(imageCount: Int): Flow<DataState<List<ImageEntity>>>
}