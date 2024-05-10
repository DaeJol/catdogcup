package di

import com.daejol.domain.repository.CatImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import usecase.GetImageUsecase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Singleton
    @Provides
    fun provideGetImageUsecase(catImagesRepository: CatImagesRepository): GetImageUsecase {
        return GetImageUsecase(catImagesRepository)
    }
}