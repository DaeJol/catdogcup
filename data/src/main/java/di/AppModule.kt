package di

import com.daejol.data.api.ApiConst
import com.daejol.data.api.CatImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // @Provides: 외부 라이브러리에서 사용되는 room, retrofit 같은
    // 라이브러리의 의존성 삽입
    @Singleton
    @Provides
    fun provideOkHttpInterceptor(): Interceptor {
        return RetrofitInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(RetrofitInterceptor())
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConst.CAT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideCatImagesApi(retrofit: Retrofit): CatImagesApi {
        return retrofit.create(CatImagesApi::class.java)
    }
}

class RetrofitInterceptor : Interceptor {
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
