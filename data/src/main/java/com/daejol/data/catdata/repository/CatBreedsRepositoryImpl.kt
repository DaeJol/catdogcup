package com.daejol.data.catdata.repository

import com.daejol.domain.DataState
import com.daejol.data.catdata.api.CatBreedsApi
import com.daejol.data.catdata.dto.CatMapper.toDomain
import com.daejol.domain.repository.CatBreedsRepository
import com.daejol.domain.entity.BreedInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatBreedsRepositoryImpl @Inject constructor(
    private val catBreedsApi: CatBreedsApi
): CatBreedsRepository {
    override suspend fun getCatBreeds(): Flow<DataState<List<BreedInfoEntity>>> = flow {
        try {
            val dogBreeds =
                catBreedsApi.getCatBreeds().body()?.map { it.toDomain() }?.toList()
            emit(DataState.Success(data = dogBreeds))
        } catch (e: Exception) {
            emit(DataState.Fail(data = null, exception = e))
        }
    }

    override suspend fun getCatBreed(id: String): Flow<DataState<BreedInfoEntity>> = flow {
        try {
            val catBreedInfo =
                catBreedsApi.getCatBreed(id = id).body()
            emit(DataState.Success(data = catBreedInfo?.toDomain()))
        } catch (e: Exception) {
            emit(DataState.Fail(data = null, exception = e))
        }
    }

}