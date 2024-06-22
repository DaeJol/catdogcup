package com.daejol.presentation.worldcup

import com.daejol.presentation.worldcup.top.TopSectionWidget
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daejol.presentation.common.ui.BottomButton
import com.daejol.presentation.worldcup.middle.MiddleSectionWidget

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
    viewModel: WorldCupViewModel = viewModel(),
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: WorldCupType
) {
    val t = WorldCupType.DOG

    return Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 36.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentAlignment = Alignment.Center,
        ) {
            TopSectionWidget(t)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4F),
        ) {
            MiddleSectionWidget(viewModel, t)
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
        ) {
            BottomButton({})
        }
    }
}