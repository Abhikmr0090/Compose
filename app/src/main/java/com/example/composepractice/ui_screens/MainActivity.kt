package com.example.composepractice.ui_screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice.Navigation
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.viewmodels.LoginViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel : LoginViewModel by viewModels()

        setContent {
            ComposePracticeTheme {
                Navigation(loginViewModel)
                //  OnBoarding()
                // LoginNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@ExperimentalPagerApi
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
      //  Navigation()
    }
}