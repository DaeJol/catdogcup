package com.daejol.presentation.ui.worldcup.selection.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.daejol.domain.usecase.WorldCupType
import com.daejol.presentation.ui.worldcup.WorldCupViewModel
import com.daejol.presentation.ui.worldcup.selection.WorldCupPreviewParameterProvider

@Preview
@Composable
fun TopSectionWidget(
    viewModel: WorldCupViewModel
) {
    return Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier
            .weight(2f)
            .padding(24.dp, 0.dp, 0.dp, 0.dp)
        ) {
            TopSectionTitleWidget(viewModel)
        }
        Box(modifier = Modifier.weight(1f)) {
            TopSectionCatImageWidget(type = viewModel.worldCupType.value)
        }
    }
}
