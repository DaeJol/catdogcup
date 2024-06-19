package com.daejol.presentation.worldcup

import TopSectionWidget
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.daejol.presentation.common.ui.BottomButton

enum class WorldCupType {
    CAT, DOG, COMBINED
}

class WorldCupPreviewParameterProvider : PreviewParameterProvider<WorldCupType> {
    override val values = sequenceOf(
        WorldCupType.CAT,
        WorldCupType.DOG,
        WorldCupType.COMBINED,
    )
}

@Preview
@Composable
fun WorldCupScreen(
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: WorldCupType
) {
    val t = WorldCupType.DOG

    return Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.Center,
        ) {
            TopSectionWidget(t)
        }
        Box(
            modifier = Modifier.weight(1F),
//            contentAlignment = Alignment.TopStart,
        ) {
            MiddleSectionWidget(t)
        }
        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.BottomCenter,
        ) {
            BottomButton({})
        }
    }
}