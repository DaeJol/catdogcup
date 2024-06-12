package com.daejol.presentation.personalMatchScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.daejol.presentation.theme.CatdogcupTheme
import com.daejol.presentation.theme.Orange80

class PersonalScreen {
    @Composable
    fun PersonalWidget() {
        val configuration = LocalConfiguration.current

        val sh = configuration.screenHeightDp.dp

        return CatdogcupTheme(
            statusBarColor = Orange80
        ) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sh / 3 * 2),
                color = Orange80
            ) {

            }

        }
    }
}