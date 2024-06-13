package com.daejol.presentation.personalMatchScreen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class PersonalActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalScreen().PersonalWidget()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PersonalScreen().PersonalWidget()
    }
}