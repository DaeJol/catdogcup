package com.daejol.data.dogdata.api

import com.daejol.data.dogdata.dto.DogBreedsDto
import com.daejol.data.dogdata.dto.DogBreedDto
import retrofit2.http.GET

public interface DogBreedsApi {
    // https://api.thecatapi.com/v1/images/search?limit=10
    @GET("breeds")
    suspend fun getDogBreeds(): retrofit2.Response<List<DogBreedsDto>?>

    @GET("breeds/{id}")
    suspend fun getDogBreed(id: String): retrofit2.Response<DogBreedsDto?>
}
