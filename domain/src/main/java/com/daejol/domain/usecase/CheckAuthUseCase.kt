package com.daejol.domain.usecase

import com.daejol.domain.repository.VotesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CheckAuthUseCase @Inject constructor(
    private val votesRepository: VotesRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke() = withContext(defaultDispatcher) {
        votesRepository.checkIfUserIsSignedIn()
    }
}
