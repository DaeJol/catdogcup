package com.daejol.data.di

import com.daejol.data.ApiConst
import com.daejol.data.catdata.api.CatBreedsApi
import com.daejol.data.catdata.api.CatImagesApi
import com.daejol.data.dogdata.api.DogBreedsApi
import com.daejol.data.dogdata.api.DogImagesApi
import com.daejol.data.ranking.api.CatVotesApi
import com.daejol.data.ranking.api.DogVotesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CatType

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DogType

    // @Provides: 외부 라이브러리에서 사용되는 room, retrofit 같은
    // 라이브러리의 의존성 삽입

    @Singleton
    @CatType
    @Provides
    fun provideCatOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(CatRetrofitInterceptor())
    }

    @Singleton
    @DogType
    @Provides
    fun provideDogOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(DogRetrofitInterceptor())
    }

    @Singleton
    @CatType
    @Provides
    fun provideCatRetrofit(
        @CatType okHttpClient: OkHttpClient.Builder,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConst.CAT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    @Singleton
    @DogType
    @Provides
    fun provideDogRetrofit(
        @DogType okHttpClient: OkHttpClient.Builder,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConst.DOG_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideCatImagesApi(@CatType retrofit: Retrofit): CatImagesApi {
        return retrofit.create(CatImagesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCatBreedsApi(@CatType retrofit: Retrofit): CatBreedsApi {
        return retrofit.create(CatBreedsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDogImagesApi(@DogType retrofit: Retrofit): DogImagesApi {
        return retrofit.create(DogImagesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDogBreedsApi(@DogType retrofit: Retrofit): DogBreedsApi {
        return retrofit.create(DogBreedsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCatVotesApi(@CatType retrofit: Retrofit): CatVotesApi {
        return retrofit.create(CatVotesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDogVotesApi(@DogType retrofit: Retrofit): DogVotesApi {
        return retrofit.create(DogVotesApi::class.java)
    }
}
