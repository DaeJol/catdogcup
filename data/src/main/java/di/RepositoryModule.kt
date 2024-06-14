package di

import com.daejol.catdata.repository.CatBreedsRepositoryImpl
import com.daejol.catdata.repository.CatImagesRepositoryImpl
import com.daejol.catdata.repository.DogImagesRepositoryImpl
import com.daejol.dogdata.repository.DogBreedsRepositoryImpl
import com.daejol.domain.repository.CatBreedsRepository
import com.daejol.domain.repository.CatImagesRepository
import com.daejol.domain.repository.DogBreedsRepository
import com.daejol.domain.repository.DogImagesRepository
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
        catImagesRepositoryImpl: CatImagesRepositoryImpl
    ): CatImagesRepository

    @Singleton
    @Binds
    abstract fun bindsCatBreedsRepository(
        catBreedsRepositoryImpl: CatBreedsRepositoryImpl
    ): CatBreedsRepository


    // @Binds: 생성자를 가지지 않는 인터페이스 의존성 삽입의 경우
    @Singleton
    @Binds
    abstract fun bindsDogImagesRepository(
        catImagesRepositoryImpl: DogImagesRepositoryImpl
    ): DogImagesRepository

    @Singleton
    @Binds
    abstract fun bindsDogBreedsRepository(
        dogBreedsRepositoryImpl: DogBreedsRepositoryImpl
    ): DogBreedsRepository
}