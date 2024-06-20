package com.daejol.presentation.worldcup.middle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.daejol.presentation.ui.theme.Grey10
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Orange80
import com.daejol.presentation.ui.theme.TrackGrey
import com.daejol.presentation.ui.theme.White100

@Composable
fun MiddleToggleSelectionWidget(
    content: String,
    state: State<Boolean>,
    onSwitch: (value: Boolean) -> Unit
) {
    return Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = content, modifier = Modifier.weight(2F), textAlign = TextAlign.Start)
        Surface(
            modifier = Modifier
                .weight(1F),
            onClick = {

            }
        ) {
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Switch(checked = state.value,
                    colors = SwitchDefaults.colors().copy(
                        checkedThumbColor = White100,
                        checkedTrackColor = Orange80,
                        uncheckedThumbColor = White100,
                        uncheckedTrackColor = TrackGrey,
                        uncheckedBorderColor = TrackGrey
                    ),
                    thumbContent = { },
                    onCheckedChange = {
                        onSwitch.invoke(it)
                    })
            }
        }
    }
}