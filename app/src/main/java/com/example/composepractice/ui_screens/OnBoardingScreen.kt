package com.example.composepractice.ui_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composepractice.OnBoardingPageData
import com.example.composepractice.R
import com.example.composepractice.ScreenRoutes
import com.example.composepractice.onBoardingScreens
import com.example.composepractice.ui.theme.ButtonColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoarding(navController: NavController ?= null) {
    val pagerState = rememberPagerState()
    val isSkipVisible = remember { mutableStateOf(false) }

    isSkipVisible.value = pagerState.currentPage < 2

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HorizontalPager(
            modifier = Modifier
                .weight(5f)
                .wrapContentHeight()
                .wrapContentHeight(), count = 3, state = pagerState
        ) { pos ->
            OnBoardingScreens(screens = onBoardingScreens[pos])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .wrapContentHeight(),
            pagerState = pagerState,
            activeColor = ButtonColor
        )

        //     Spacer(modifier = Modifier.height(22.dp))

        if (navController != null) {
            NextButton(
                navController = navController,
                modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterHorizontally),
                pagerState = pagerState
            )
        }

        if (isSkipVisible.value) {
            SkipButton(pagerState = pagerState)
        }


    }
}

@ExperimentalPagerApi
@Composable
fun SkipButton(pagerState: PagerState) {
    val coroutine = rememberCoroutineScope()

    TextButton(onClick = {
        coroutine.launch {
            pagerState.animateScrollToPage(2)
        }
    }) {
        Text(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            text = "Skip",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontFamily = FontFamily(
                Font(R.font.montserrat_semibold)
            )
        )
    }
}

@ExperimentalPagerApi
@Composable
fun NextButton(navController: NavController, modifier: Modifier, pagerState: PagerState) {
    val coroutine = rememberCoroutineScope()
    val btnText = remember { mutableStateOf("Next") }

    if (pagerState.currentPage == 2) {
        btnText.value = OnBoardingButton.GetStarted.name
    } else {
        btnText.value = OnBoardingButton.Next.name
    }

    Button(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(.8f),
        shape = RoundedCornerShape(15.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 2.dp
        ),
        onClick = {
            coroutine.launch {
                when (btnText.value) {
                    OnBoardingButton.GetStarted.name -> {
                        navController.navigate(ScreenRoutes.LoginOrRegister.route)
                    }

                    OnBoardingButton.Next.name -> {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ButtonColor,
        )
    ) {
        Text(text = btnText.value,fontFamily = FontFamily(
            Font(R.font.montserrat_bold)
        )
        )
    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardingScreens(screens: OnBoardingPageData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = screens.image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            modifier = Modifier.wrapContentHeight(),
            text = screens.mainContent,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth(.75f)
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally),
            text = screens.content,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@ExperimentalPagerApi
@Composable
fun DesignPreview() {
      OnBoarding()
}

enum class OnBoardingButton {
    Next,
    GetStarted
}
