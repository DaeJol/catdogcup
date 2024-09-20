package com.daejol.domain.repository

import com.daejol.domain.DataState
import com.daejol.domain.entity.BreedInfoEntity
import com.daejol.domain.entity.BreedTypeEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface DogBreedsRepository {
    suspend fun getDogBreeds(): Flow<DataState<List<BreedInfoEntity>>>

    @GET("breeds/{id}")
    suspend fun getDogBreed(id: String): Flow<DataState<BreedInfoEntity>>
}