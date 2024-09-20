package com.daejol.presentation.model

import coil.request.ImageRequest
import com.daejol.domain.entity.ImageEntity

data class ImageModel(
    val imageEntity: ImageEntity,
    val imageRequest: ImageRequest,
)
