package com.daejol.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatRetrofitClient {
    companion object {
        private val client = OkHttpClient.Builder().addInterceptor(RetrofitInterceptor())

        val instance: Retrofit =
             Retrofit.Builder()
                .baseUrl(ApiConst.CAT_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                 .client(client.build())
                 .build()
    }
}

class RetrofitInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val params = mapOf<String, String>("api-key" to ApiConst.API_KEY)

        val uriBuilder = request.url.newBuilder()
        params.forEach { (key, value) ->
            uriBuilder.addQueryParameter(key, value)
        }

        return chain.proceed(
            request.newBuilder()
                .url(uriBuilder.build())
                .method(request.method, request.body)
                .build()
        )
    }
}