package com.example.composepractice

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ConnectUpBG
import com.example.composepractice.ui.theme.N200
import com.example.composepractice.ui.theme.N400
import com.example.composepractice.ui.theme.N600
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun SearchScreen() {
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(.95f)
                .align(alignment = Alignment.CenterHorizontally),
            value = search,
            onValueChange = { search = it },
            placeholder = {
                Text(
                    text = "Search",
                    color = N400,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = N200,
                unfocusedIndicatorColor = N200,
                backgroundColor = Color.Transparent
            ),
        )

        SetTab()
    }
}

@ExperimentalPagerApi
@Composable
fun ViewPager(pagerState: PagerState) {
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Red), count = 3
    ) { pos ->
        //  PagerScreens()
    }
}

@ExperimentalPagerApi
@Composable
fun TabView(pagerState: PagerState, list: List<String>) {
    val index = remember {
        mutableStateOf(0)
    }

    TabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .width(0.dp)
                    .height(0.dp),
            )
        }) {
        list.forEachIndexed { index, name ->
            TabItem(tabName = name, tabIndex = index, pagerState = pagerState)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabItem(
    tabName: String,
    tabIndex: Int,
    pagerState: PagerState
) {
    Log.d("TAG", "TabItem: $tabName")
    Tab(
        selected = pagerState.currentPage == tabIndex,
        onClick = { /*TODO*/ },
        text = {
            Text(
                text = tabName,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                color = Color.White
            )
        })
}


@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Composable
fun SetTab() {

    var isSelected = remember {
        mutableStateOf(false)
    }

    val tabItems = listOf(
        "Newest",
        "Online",
        "Verified"
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = ConnectUpBG,
                height = 4.dp
            )
        },
        divider = {
            TabRowDefaults.Divider(
                thickness = -1.dp
            )
        }
    ) {
        tabItems.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        title,
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontSize = 16.sp,
                        style = if (pagerState.currentPage == index) {
                            TextStyle(fontWeight = FontWeight.Bold)
                        } else {
                            TextStyle(fontWeight = FontWeight.Normal)
                        }
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
    HorizontalPager(
        count = tabItems.size, state = pagerState, modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) { page ->
        LazyColumn(Modifier.fillMaxWidth()) {
            items(15) {
                ShowUsers()
            }
        }
    }
}

@Composable
fun ShowUsers() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
                .weight(.5f)
                .background(color = Color.LightGray)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.ic_person_search),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter)
            ) {
                User()
            }

        }

        Spacer(modifier = Modifier.width(2.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
                .weight(.5f)
                .background(color = Color.LightGray)
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.ic_person_search),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter)
            ) {
                User()
            }
        }
    }

    Spacer(modifier = Modifier.height(2.dp))
}

@Composable
fun User() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp),
        text = "Pushpendra Kumar Pal hsd asdhasdsahkjd sakdjh sadjh ",
        textAlign = TextAlign.Center,
        color = N600,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        text = "SDE-1",
        textAlign = TextAlign.Center,
        color = N600,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    )
}

@Preview
@Composable
fun ShowUser() {
    ShowUsers()
}

