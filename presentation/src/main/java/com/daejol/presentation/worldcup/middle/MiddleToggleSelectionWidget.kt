package com.daejol.presentation.worldcup.middle

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MiddleToggleSelectionWidget(content: String) {
    return Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = content)
    }

}