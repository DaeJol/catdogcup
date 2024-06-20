package com.daejol.presentation.worldcup.middle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.worldcup.WorldCupViewModel

@Composable
fun MiddleDropDownSelectionWidget(
    content: String,
    viewModel: WorldCupViewModel = viewModel(),
    menus: List<DropdownItems>
) {
    var expanded by remember { mutableStateOf(false) }

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
                expanded = true
            }
        ) {
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = viewModel.worldCupLevel.value)
                Icon(
                    Icons.Rounded.ArrowDropDown,
                    contentDescription = "몇 강까지 진행할까요?",
                    tint = Orange100,
                )
            }
            DropdownMenu(
                expanded = expanded,
                /// DropDownMenu를 닫으라는 명령(Dismiss Request)이 떨어졌을 때의 동작
                onDismissRequest = {
                    expanded = false
                },
                offset = DpOffset(0.dp, 0.dp)
            ) {
                menus.forEach {
                    DropdownMenuItem(text = { Text(it.text) }, onClick = {
                        expanded = false
                        it.onClick.invoke()
                    })
                }
            }
        }
    }
}

class DropdownItems(
    var text: String,
    var onClick: () -> Unit
)