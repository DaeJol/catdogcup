package com.daejol.data.ranking.api

import com.daejol.data.ranking.dto.VotesDto
import com.daejol.data.ranking.dto.VotesRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DogVotesApi {
    @GET("votes")
    suspend fun getVotes(
        @Query("attach_image") attachImage: Int? = null,
        @Query("sub_id") subId: String? = null,
        @Query("page") page: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("order") order: String? = null
    ): Response<List<VotesDto>>

    @POST("votes")
    suspend fun updateVotes(
        @Body votesRequest: VotesRequest
    )
}
