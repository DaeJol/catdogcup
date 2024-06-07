package com.keykat.dogdata.api

import com.daejol.catdata.dto.DogBreedsDto
import com.daejol.catdata.dto.DogImageDto
import com.keykat.dogdata.dto.DogBreedDto
import retrofit2.http.GET

public interface DogBreedsApi {
    // https://api.thecatapi.com/v1/images/search?limit=10
    @GET("breeds")
    suspend fun getDogBreeds(): retrofit2.Response<List<DogBreedsDto>?>

    @GET("breeds/{id}")
    suspend fun getDogBreed(id: String): retrofit2.Response<DogBreedDto?>
}