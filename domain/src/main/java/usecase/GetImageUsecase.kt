package usecase

import com.daejol.domain.repository.CatImagesRepository
import entity.ImageEntity
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetImageUsecase @Inject constructor(
    private val catImagesRepository: CatImagesRepository
) {
    suspend fun getRandomCatImages(randomImageCount: Int): Flow<List<ImageEntity>?>? {
        try {
            val flow = catImagesRepository.getCatRandomImages(randomImageCount).map {
                return@map it.on(
                    // TODO: Entity 자체를 넘겨주는 것이 좋을까? 아니면 정말 필요한 것만 한 번 더 정제해서
                    // TODO: 주는 것이 나을까?
                    onSuccess = { list ->
                        list
                    },
                    // TODO: onError일 때 어떤 데이터를 던져주는 것이 좋을까?
                    onError = {
                        throw Exception()
                    }
                )
            }

            return flow
        } catch (e: Exception) {
            return null
        }
    }
}