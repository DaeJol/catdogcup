package com.daejol.catdata.repository

import DataState
import com.daejol.catdata.api.CatBreedsApi
import com.daejol.catdata.dto.CatMapper.toDomain
import com.daejol.domain.repository.CatBreedsRepository
import entity.BreedInfoEntity
import entity.BreedTypeEntity
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

    override suspend fun getCatBreed(id: String): Flow<DataState<BreedTypeEntity>> = flow {
        try {
            val catBreedType =
                catBreedsApi.getCatBreed(id = id).body()
            emit(DataState.Success(data = catBreedType?.toDomain()))
        } catch (e: Exception) {
            emit(DataState.Fail(data = null, exception = e))
        }
    }

}