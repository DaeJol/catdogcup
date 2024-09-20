package com.daejol.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daejol.domain.usecase.CheckAuth
import com.daejol.domain.usecase.GetRankingUseCase
import com.daejol.presentation.ui.theme.CatdogcupTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var checkAuth: CheckAuth
    @Inject
    lateinit var getRankingUseCase: GetRankingUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v: View?, _: WindowInsetsCompat? ->
            ViewCompat.onApplyWindowInsets(
                v!!, WindowInsetsCompat.CONSUMED
            )
        }

        setContent {
            CatdogcupTheme(
                statusBarColor = Color.Transparent
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainApp()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            checkAuth.checkIfUserIsSignedIn()
            getRankingUseCase.getPopularCatsAndDogs()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatdogcupTheme {
        MainApp()
    }
}
