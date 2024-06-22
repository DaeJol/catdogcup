package com.daejol.presentation.common.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.daejol.presentation.ui.theme.CustomTextStyle
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Pretendard
import com.daejol.presentation.ui.theme.White100

@Composable
fun BottomButton(onClick: () -> Unit) {
    return Button(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RectangleShape,
        colors = ButtonColors(Orange100, Orange100, Orange100, Orange100),
        onClick = { onClick.invoke() },
    ) {
        Column {
            Text(
                text = "월드컵 시작하기",
                modifier = Modifier.padding(12.dp),
                style = CustomTextStyle(
                    fontSize = 24F,
                    fontColor = White100,
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.SemiBold,
                ).style
            )
        }
    }
}
