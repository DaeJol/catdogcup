package com.daejol.catdata.api

import com.daejol.catdata.dto.CatImageDto
import okhttp3.Response
import retrofit2.http.GET

public interface CatImagesApi {
    // https://api.thecatapi.com/v1/images/search?limit=10
    @GET("images/search")
    suspend fun getCatImages(): retrofit2.Response<List<CatImageDto>?>
}