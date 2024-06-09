package di

import com.daejol.catdata.api.CatBreedsApi
import common.ApiConst
import com.daejol.catdata.api.CatImagesApi
import com.daejol.catdata.api.DogImagesApi
import com.daejol.catdata.dto.CatBreedsDto
import com.daejol.dogdata.api.DogBreedsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
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

    class CatRetrofitInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val params = mapOf<String, String>("api-key" to ApiConst.CAT_API_KEY)

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

    class DogRetrofitInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val params = mapOf<String, String>("api-key" to ApiConst.DOG_API_KEY)

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
}

