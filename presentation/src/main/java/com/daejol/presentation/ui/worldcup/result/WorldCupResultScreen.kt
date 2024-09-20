package com.daejol.presentation.ui.worldcup.result

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.daejol.presentation.model.Graph
import com.daejol.presentation.ui.theme.CustomRichText
import com.daejol.presentation.ui.theme.Gimpo
import com.daejol.presentation.ui.theme.MoveSans
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.RichTextAlign
import com.daejol.presentation.ui.theme.White100
import com.daejol.presentation.ui.worldcup.WorldCupViewModel

@Composable
fun WorldCupResultScreen(
    viewModel: WorldCupViewModel,
    navController: NavController? = null
) {
    val imageWidth = LocalConfiguration.current.screenWidthDp.dp / 5 * 4 - 10.dp
    val imageHeight = LocalConfiguration.current.screenWidthDp.dp / 5 * 4 - 20.dp

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CustomRichText(
            textAlign = RichTextAlign.Center,
            defaultFontFamily = Gimpo,
            defaultTextSize = 24f
        ) {
            RichText(text = "나의 최애는?")
        }
        Spacer(modifier = Modifier.height(24.dp))
        AsyncImage(
            model = viewModel.getWinnerImage(),
            contentDescription = "",
            modifier = Modifier
                .width(imageWidth)
                .height(imageHeight)
                .padding(5.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                ),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomRichText(
            textAlign = RichTextAlign.Center,
            defaultFontFamily = MoveSans,
            defaultFontWeight = FontWeight.Bold,
            defaultTextSize = 20f
        ) {
            RichText(text = viewModel.getWinnerName() ?: "")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // TODO: RichText로 쓰면 줄 바꿈이 안됨
//        CustomRichText(
//            textAlign = RichTextAlign.Center,
//            defaultFontFamily = MoveSans,
//            defaultFontWeight = FontWeight.Bold,
//            defaultTextSize = 12f,
//        ) {
//            RichText(text = viewModel.getWinnerDescription() ?: "")
//        }
        Text(
            text = viewModel.getWinnerDescription() ?: "",
            fontFamily = MoveSans,
            fontSize = 12.sp,
            modifier = Modifier
                .width(imageWidth),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ShareButton(LocalContext.current)
            Spacer(modifier = Modifier.width(24.dp))
            BookMarkButton()
            Spacer(modifier = Modifier.width(24.dp))
            DownloadButton(viewModel = viewModel)
        }

        Spacer(modifier = Modifier.height(24.dp))
        PlayAnotherWorldCupButton(imageWidth, navController)
    }
}

// TODO: 공유하기 기능에 어떤 데이터를 넣어서 줄까?
//  image? 텍스트? 링크? intent로 딥링크 기능을 넣을까??
@Composable
fun ShareButton(context: Context) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, "공유하기")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    // share
    IconButton(
        onClick = {
            startActivity(context, shareIntent, null)
        },
        modifier = Modifier
            .background(Orange100, CircleShape)
            .width(36.dp)
            .height(36.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Share,
            contentDescription = "",
            tint = White100,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}

// TODO: 북마크 기능은 firebase 혹은 내부 DB 작업이 완료된 후에 사용할 것
@Composable
fun BookMarkButton() {
    // share
    IconButton(
        onClick = { },
        modifier = Modifier
            .background(Orange100, CircleShape)
            .width(36.dp)
            .height(36.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Bookmark,
            contentDescription = "",
            tint = White100,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}

@Composable
fun DownloadButton(viewModel: WorldCupViewModel) {
    val context = LocalContext.current
    // share
    IconButton(
        onClick = {
            viewModel.downloadWinnerImage(context, onComplete = {
                Toast.makeText(context, "다운로드가 완료되었습니다.", Toast.LENGTH_SHORT).show()
            })
        },
        modifier = Modifier
            .background(Orange100, CircleShape)
            .width(36.dp)
            .height(36.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Download,
            contentDescription = "",
            tint = White100,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}

@Composable
fun PlayAnotherWorldCupButton(imageWidth: Dp, navController: NavController?) {
    // 다른 월드컵 하러 가기
    Button(
        onClick = {
            navController?.navigate(Graph.Home.route) {
                popUpTo(0)
            }
        },
        modifier = Modifier
            .width(imageWidth),
        shape = RoundedCornerShape(
            corner = CornerSize(50.dp)
        )

    ) {
        Text(
            text = "다른 월드컵 하러 가기",
            fontSize = 16.sp
        )
    }
}
