package com.daejol.data.api

import com.daejol.data.dto.CatImageDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

public interface CatImagesApi {
    // https://api.thecatapi.com/v1/images/search?limit=10
    @GET("images/search")
    fun getCatImages(): Flow<DataState<List<CatImageDto>>>
}