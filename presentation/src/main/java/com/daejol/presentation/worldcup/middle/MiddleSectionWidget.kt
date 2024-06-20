package com.daejol.presentation.worldcup.middle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daejol.presentation.worldcup.WorldCupPreviewParameterProvider
import com.daejol.presentation.worldcup.WorldCupType
import com.daejol.presentation.worldcup.WorldCupViewModel

@Preview
@Composable
fun MiddleSectionWidget(
    viewModel: WorldCupViewModel = viewModel(),
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: WorldCupType
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
                DropdownItems(text = "16강", onClick = { viewModel.setLevel("16강") }),
                DropdownItems(text = "32강", onClick = { viewModel.setLevel("32강") }),
                DropdownItems(text = "64강", onClick = { viewModel.setLevel("64강") }),
                DropdownItems(text = "128강", onClick = { viewModel.setLevel("128강") }),
                DropdownItems(text = "256강", onClick = { viewModel.setLevel("256강") }),
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

