package com.daejol.presentation.ui.worldcup.selection

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.daejol.domain.usecase.WorldCupType
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.utils.BottomButton
import com.daejol.presentation.ui.worldcup.WorldCupViewModel
import com.daejol.presentation.ui.worldcup.selection.middle.MiddleSectionWidget
import com.daejol.presentation.ui.worldcup.selection.top.TopSectionWidget

class WorldCupPreviewParameterProvider : PreviewParameterProvider<WorldCupType> {
    override val values = sequenceOf(
        WorldCupType.CAT,
        WorldCupType.DOG,
        WorldCupType.COMBINED,
    )
}

@Composable
fun WorldCupScreen(
    viewModel: WorldCupViewModel,
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: String,
    navController: NavController? = null
) {
    val t = enumValueOf<WorldCupType>(type)
    viewModel.setType(t)

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
            val context = LocalContext.current
            BottomButton(
                onClick = {
                    viewModel.getAnimalList(
                        context = context,
                        onFinish = {
                            viewModel.initializeGame()
                            navController?.navigate(
                                route = Screen.WorldCupPlay.route
                            )
                        }
                    )
                }
            )
        }
        Box {

        }
    }
}

@Preview
@Composable
fun Preview() {
    WorldCupScreen(viewModel = viewModel(), WorldCupType.CAT.name)
}
