package com.daejol.data.catdata.api

import com.daejol.data.catdata.dto.CatBreedDto
import com.daejol.data.catdata.dto.CatBreedsDto
import retrofit2.http.GET

public interface CatBreedsApi {
    // https://api.thecatapi.com/v1/images/search?limit=10
    @GET("breeds")
    suspend fun getCatBreeds(): retrofit2.Response<List<CatBreedsDto>?>

    @GET("breeds/{id}")
    suspend fun getCatBreed(id: String): retrofit2.Response<CatBreedsDto?>
}