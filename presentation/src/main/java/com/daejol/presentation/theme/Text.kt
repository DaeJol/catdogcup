package com.daejol.presentation.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R

/**한 줄의 텍스트에 여러 스타일을 적용하고 싶을 때 사용합니다.
 *
 *    CustomRichText(
 *       listOf(
 *          RichText(text = "h", style = CustomStyle()),
 *          RichText(text = "ello")
 *          RichText(text = " world!", endOfLine = true)
 *       )
 *    )
 *
 * @param texts 텍스트와 텍스트 스타일을 담아줍니다. []RichText] 클래스를 사용해주고 list로 묶어주세요.
 **/
@Composable
fun CustomRichText(
    texts: List<RichText>,
    defaultTextSize: Float = 14F,
    defaultTextColor: Color = Black100,
    defaultFontFamily: FontFamily = Pretendard,
    defaultFontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Left
) {
//    val align = when (alignment) {
//        Alignment.Center -> androidx.compose.ui.Alignment.Vertical
//    }

    return  Text(
        buildAnnotatedString {
            texts.forEach {
                //
                val spanStyle = SpanStyle(
                    color = it.textStyle.fontColor ?: defaultTextColor,
                    fontWeight = it.textStyle.fontWeight ?: defaultFontWeight,
                    fontSize = it.textStyle.fontSize?.sp ?: defaultTextSize.sp,
                    fontFamily = it.textStyle.fontFamily ?: defaultFontFamily,
                )

                withStyle(style = spanStyle) {
                    append(it.text)
                }

                if (it.endOfLine) {
                    append("\n")
                }
            }
        },
        textAlign = textAlign
    )
}

/** CustomRichText에 담을 자식 클래스입니다.
 * @param text 단순히 텍스트를 담아주세요.
 * @param textStyle 스타일을 넣어주세요. []CustomTextStyle] 클래스를 사용해주세요.
 * @param endOfLine 다음 줄로 줄바꿈하고 싶을 때 true를 해주세요.
 */
open class RichText(
    val text: String = "",
    val textStyle: CustomTextStyle = CustomTextStyle(),
    val endOfLine: Boolean = false
)

val Pretendard = FontFamily(
    fonts = listOf(
        Font(R.font.pretendard_light, weight = FontWeight.Light),
        Font(R.font.pretendard_medium, weight = FontWeight.Medium),
        Font(R.font.pretendard_black, weight = FontWeight.Black),
        Font(R.font.pretendard_bold, weight = FontWeight.Bold),
        Font(R.font.pretendard_extrabold, weight = FontWeight.ExtraBold),
        Font(R.font.pretendard_extralight, weight = FontWeight.ExtraLight),
        Font(R.font.pretendard_semibold, weight = FontWeight.SemiBold),
        Font(R.font.pretendard_regular, weight = FontWeight.Normal),
        Font(R.font.pretendard_thin, weight = FontWeight.Thin)
    )
)

val MoveSans = FontFamily(
    fonts = listOf(
        Font(R.font.movesans_light),
        Font(R.font.movesans_medium),
        Font(R.font.movesans_bold),
    )
)

val Gimpo = FontFamily(
    fonts = listOf(
        Font(R.font.gimpo_1, weight = FontWeight.Light),
        Font(R.font.gimpo_2, weight = FontWeight.Normal)
    )
)

class CustomTextStyle(
    val fontSize: Float? = null,
    val fontColor: Color? = null,
    val fontWeight: FontWeight? = null,
    var fontFamily: FontFamily? = null
) {
    var style = TextStyle()

    init {
        style = TextStyle(
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize?.sp ?: run { 14F.sp },
            color = fontColor ?: run { Black100 },
        )
    }
}