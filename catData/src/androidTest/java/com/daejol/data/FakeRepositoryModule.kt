package com.daejol.data

import com.daejol.data.repository.CatImagesRepositoryImpl
import com.daejol.domain.repository.CatImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import di.RepositoryModule
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class FakeRepositoryModule {
    // @Binds: 생성자를 가지지 않는 인터페이스 의존성 삽입의 경우
    @Singleton
    @Binds
    abstract fun bindsCatImagesRepository(
        catImagesRepositoryImpl: CatImagesRepositoryImpl
    ): CatImagesRepository
}