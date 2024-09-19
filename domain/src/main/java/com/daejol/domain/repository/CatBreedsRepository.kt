package com.daejol.domain.repository

import com.daejol.domain.DataState
import com.daejol.domain.entity.BreedInfoEntity
import com.daejol.domain.entity.BreedTypeEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CatBreedsRepository {
    suspend fun getCatBreeds(): Flow<DataState<List<BreedInfoEntity>>>

    @GET("breeds/{id}")
    suspend fun getCatBreed(id: String): Flow<DataState<BreedInfoEntity>>
}