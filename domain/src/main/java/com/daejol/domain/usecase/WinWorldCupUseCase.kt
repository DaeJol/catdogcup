package com.daejol.domain.usecase

import com.daejol.domain.AnimalType
import com.daejol.domain.entity.ImageEntity
import com.daejol.domain.repository.VotesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WinWorldCupUseCase @Inject constructor(
    private val votesRepository: VotesRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(
        animalType: AnimalType,
        imageEntity: ImageEntity
    ) = withContext(defaultDispatcher) {
        votesRepository.increaseNumberOfWins(animalType, imageEntity)
    }
}
