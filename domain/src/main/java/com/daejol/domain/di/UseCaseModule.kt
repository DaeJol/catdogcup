package com.daejol.domain.di

import com.daejol.domain.repository.CatImagesRepository
import com.daejol.domain.repository.DogImagesRepository
import com.daejol.domain.repository.VotesRepository
import com.daejol.domain.usecase.CheckAuthUseCase
import com.daejol.domain.usecase.GetImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.daejol.domain.usecase.GetRankingUseCase
import com.daejol.domain.usecase.WinWorldCupUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetImageUseCase(
        catImagesRepository: CatImagesRepository,
        dogImagesRepository: DogImagesRepository
    ): GetImageUseCase {
        return GetImageUseCase(catImagesRepository, dogImagesRepository)
    }

    @Singleton
    @Provides
    fun provideGetRankingUseCase(
        votesRepository: VotesRepository
    ): GetRankingUseCase = GetRankingUseCase(votesRepository)

    @Singleton
    @Provides
    fun provideCheckAuthUseCase(
        votesRepository: VotesRepository
    ): CheckAuthUseCase = CheckAuthUseCase(votesRepository)

    @Singleton
    @Provides
    fun provideWinWorldCupUseCase(
        votesRepository: VotesRepository
    ): WinWorldCupUseCase = WinWorldCupUseCase(votesRepository)
}
