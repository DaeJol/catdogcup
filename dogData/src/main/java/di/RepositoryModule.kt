package di

import com.daejol.catdata.repository.DogImagesRepositoryImpl
import com.daejol.domain.repository.CatImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    // @Binds: 생성자를 가지지 않는 인터페이스 의존성 삽입의 경우
    @Singleton
    @Binds
    abstract fun bindsCatImagesRepository(
        catImagesRepositoryImpl: DogImagesRepositoryImpl
    ): CatImagesRepository
}