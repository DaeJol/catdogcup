package com.daejol.domain.repository

import DataState
import entity.BreedInfoEntity
import entity.BreedTypeEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface DogBreedsRepository {
    suspend fun getDogBreeds(): Flow<DataState<List<BreedInfoEntity>>>

    @GET("breeds/{id}")
    suspend fun getDogBreed(id: String): Flow<DataState<BreedTypeEntity>>
}