package com.example.composepractice.ui_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.TabItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun NotificationScreen() {
    val pagerState = rememberPagerState()

    Column {
        HorizontalPager(count = 6, state = pagerState) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = {
                    TabRowDefaults.Indicator(
                        height = 2.dp
                    )
                }) {

            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun Preview() {
    NotificationScreen()
}