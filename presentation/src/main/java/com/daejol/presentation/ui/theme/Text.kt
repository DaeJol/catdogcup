package com.daejol.presentation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
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
@Deprecated("Text를 이용해서 RichText를 만드는 방식에서 Layout을 이용해서 만들겠습니다.")
@Composable
fun CustomRichText(
    texts: List<RichText>,
    defaultTextSize: Float = 14F,
    defaultTextColor: Color = Black100,
    defaultFontFamily: FontFamily = Pretendard,
    defaultFontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Left,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    return Text(
        buildAnnotatedString {
            texts.forEach {
                //
                val spanStyle = SpanStyle(
                    color = it.textStyle.fontColor ?: defaultTextColor,
                    fontWeight = it.textStyle.fontWeight ?: defaultFontWeight,
                    fontSize = it.textStyle.fontSize?.sp ?: defaultTextSize.sp,
                    fontFamily = it.textStyle.fontFamily ?: defaultFontFamily,
                    background = Orange100,

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

@Composable
fun CustomRichText(
    defaultTextSize: Float = 14F,
    defaultTextColor: Color = Black100,
    defaultFontFamily: FontFamily = Pretendard,
    defaultFontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Left,
    content: @Composable () -> Unit
) {
    print("[keykat $content")


    return Layout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Track the y co-ord we have placed children up to
            var xPosition = 0
            var yPosition = 0

            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
//                xPosition += placeable.width
                yPosition += placeable.height
            }
        }
    }


//
//    return Column {
//        Row {
//            Text("saksksakaskk")
//            Text("fkdsjfdskfkdjsfskdjsdkfjk")
//        }
//        Text("sdfdsfas")
//        Text("sdfdsafsdafdsafdsas")
//    }
//
//    return Text(
//        buildAnnotatedString {
//            texts.forEach {
//                //
//                val spanStyle = SpanStyle(
//                    color = it.textStyle.fontColor ?: defaultTextColor,
//                    fontWeight = it.textStyle.fontWeight ?: defaultFontWeight,
//                    fontSize = it.textStyle.fontSize?.sp ?: defaultTextSize.sp,
//                    fontFamily = it.textStyle.fontFamily ?: defaultFontFamily,
//                    background = Orange100,
//
//                    )
//
//                withStyle(style = spanStyle) {
//                    append(it.text)
//                }
//
//                if (it.endOfLine) {
//                    append("\n")
//                }
//            }
//        },
//        textAlign = textAlign
//    )
}


/** CustomRichText에 담을 자식 클래스입니다.
 * @param text 단순히 텍스트를 담아주세요.
 * @param textStyle 스타일을 넣어주세요. []CustomTextStyle] 클래스를 사용해주세요.
 * @param endOfLine 다음 줄로 줄바꿈하고 싶을 때 true를 해주세요.
 */
open class RichText(
    val text: String = "",
    val textStyle: CustomTextStyle = CustomTextStyle(),
    val endOfLine: Boolean = false,
    val decoration: @Composable (() -> Unit)? = null,
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