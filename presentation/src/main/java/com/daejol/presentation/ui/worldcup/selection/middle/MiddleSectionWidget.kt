package com.daejol.presentation.ui.worldcup.selection.middle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.daejol.domain.usecase.AnimalType
import com.daejol.presentation.ui.worldcup.WorldCupViewModel
import com.daejol.presentation.ui.worldcup.selection.WorldCupPreviewParameterProvider

@Composable
fun MiddleSectionWidget(
    viewModel: WorldCupViewModel,
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: AnimalType
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 36.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        MiddleDropDownSelectionWidget(
            content = "몇 강까지 진행할까요?",
            state = viewModel.worldCupLevel,
            menus = listOf(
                DropdownItems(text = "16강", onClick = {
                    viewModel.setLevel("16강")
                    viewModel.updateGameLevel(16)
                }),
                DropdownItems(text = "32강", onClick = {
                    viewModel.setLevel("32강")
                    viewModel.updateGameLevel(32)
                }),
                DropdownItems(text = "64강", onClick = {
                    viewModel.setLevel("64강")
                    viewModel.updateGameLevel(64)
                }),
                DropdownItems(text = "128강", onClick = {
                    viewModel.setLevel("128강")
                    viewModel.updateGameLevel(128)
                }),
            ),
        )

        MiddleDropDownSelectionWidget(
            content = "이미지는 어떻게 고를까요?",
            state = viewModel.imageType,
            menus = listOf(
                DropdownItems(text = "무작위", onClick = { viewModel.setImageSelection("무작위") }),
                DropdownItems(text = "북마크", onClick = { viewModel.setImageSelection("북마크") }),
                DropdownItems(text = "인기 순위", onClick = { viewModel.setImageSelection("인기 순위") }),
            ),
        )

        MiddleToggleSelectionWidget(
            content = "결과를 내 북마크에\n저장할까요?",
            state = viewModel.bookmark,
            onSwitch = { viewModel.saveBookmark(it) }
        )

        MiddleToggleSelectionWidget(
            content = "결과를 다른 사람들과도\n공유하시겠어요?",
            state = viewModel.share,
            onSwitch = { viewModel.allowShare(it) }
        )
    }
}

