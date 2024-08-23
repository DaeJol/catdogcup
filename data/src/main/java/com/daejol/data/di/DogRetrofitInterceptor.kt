package com.daejol.data.di

import com.daejol.data.ApiConst
import okhttp3.Interceptor
import okhttp3.Response

class DogRetrofitInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val params = mapOf("api_key" to ApiConst.DOG_API_KEY)

        val uriBuilder = request.url.newBuilder()
        params.forEach { (key, value) ->
            uriBuilder.addQueryParameter(key, value)
        }

        println("[keykat] $uriBuilder")

        return chain.proceed(
            request.newBuilder()
                .url(uriBuilder.build())
                .method(request.method, request.body)
                .build()
        )
    }
}
