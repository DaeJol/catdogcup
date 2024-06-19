package com.daejol.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R
import com.daejol.presentation.common.data.px
import com.daejol.presentation.common.data.sp
import com.daejol.presentation.ui.theme.RichTextScope.isEndOfLine
import com.daejol.presentation.ui.theme.RichTextScope.richTextContent

/** CustomRichText에 담을 자식 클래스입니다.
 * @param text 단순히 텍스트를 담아주세요.
 * @param textStyle 스타일을 넣어주세요. []CustomTextStyle] 클래스를 사용해주세요.
 * @param endOfLine 다음 줄로 줄바꿈하고 싶을 때 true를 해주세요.
 */
@Deprecated("CustomRichText v1용으로 사용하던 클래스.")
open class RichText(
    val text: String = "",
    val textStyle: CustomTextStyle = CustomTextStyle(),
    val endOfLine: Boolean = false,
)

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
    content: @Composable (ColumnScope.() -> Unit)
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

class RichTextDecoration(
    val background: Color = Color.Transparent,
    val padding: Padding = Padding(),
    val borderRadius: BorderRadius = BorderRadius()
)

class BorderRadius(
    val topLeft: Float = 0f,
    val topRight: Float = 0f,
    val bottomLeft: Float = 0f,
    val bottomRight: Float = 0f
)

class Padding(
    val left: Float = 0f,
    val top: Float = 0f,
    val right: Float = 0f,
    val bottom: Float = 0f
)

object RichTextScope {
    private val items = mutableListOf<RichTextInstance>()

    @Composable
    fun RichText(
        text: String,
        textStyle: CustomTextStyle = CustomTextStyle(),
        endOfLine: Boolean = false,
        lineHeight: Dp = 0.dp,
        decoration: RichTextDecoration = RichTextDecoration()
    ) {
        val richText = RichTextInstance(
            text = text,
            textStyle = textStyle,
            endOfLine = endOfLine,
            lineHeight = lineHeight,
            decoration = decoration
        )

        items.add(richText)
    }

    private class RichTextInstance(
        val text: String = "",
        val textStyle: CustomTextStyle = CustomTextStyle(),
        val endOfLine: Boolean = false,
        val lineHeight: Dp = 0.dp,
        val decoration: RichTextDecoration = RichTextDecoration()
    )


    fun richTextContent(): @Composable () -> Unit {
        return {
            items.forEach {
                val text = it.text + if (it.endOfLine) "\n" else ""

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        // clip 다음에 background를 선언해줘야 색상이 선언된 후 clip이 적용됨
                        .clip(
                            RoundedCornerShape(
                                it.decoration.borderRadius.topLeft,
                                it.decoration.borderRadius.topRight,
                                it.decoration.borderRadius.bottomLeft,
                                it.decoration.borderRadius.bottomRight
                            )
                        )
                        .background(color = it.decoration.background)
                        .padding(
                            it.decoration.padding.left.dp,
                            it.decoration.padding.top.dp,
                            it.decoration.padding.right.dp,
                            it.decoration.padding.bottom.dp,
                        )
                ) {
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = text,
                        style = it.textStyle.style,
                        lineHeight = it.lineHeight.sp(),
                    )
                }
            }
        }
    }

    fun isEndOfLine(index: Int): Boolean {
        val item = items[index]
        return item.endOfLine
    }
}

@Composable
fun CustomRichText(
    defaultTextSize: Float = 14F,
    defaultTextColor: Color = Black100,
    defaultFontFamily: FontFamily = Pretendard,
    defaultFontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Left,
    content: @Composable RichTextScope.() -> Unit
) {
    RichTextScope.content()
    val richContent = richTextContent()


    return Layout(
        modifier = Modifier.wrapContentSize(),
        content = richContent,
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var xPosition = 0
            var yPosition = 0

            placeables.forEachIndexed { index, placeable ->
                placeable.placeRelative(x = xPosition, y = yPosition)

                if (isEndOfLine(index)) {
                    xPosition = 0
                    yPosition += placeable.height
                } else {
                    xPosition += placeable.width
                }
            }
        }
    }
}

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