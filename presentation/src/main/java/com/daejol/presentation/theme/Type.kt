package com.daejol.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R


import com.daejol.presentation.R

val oaGothic = FontFamily(
    Font(R.font.oa_gothic_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.oa_gothic_extra_bold, FontWeight.ExtraBold, FontStyle.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = oaGothic,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    // "카테고리" 이렇게 적혀있는 타이틀에 사용하는 폰트
    headlineLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = oaGothic,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


