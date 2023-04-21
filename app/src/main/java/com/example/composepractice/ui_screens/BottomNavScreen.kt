package com.example.composepractice.ui_screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.MontserratBold
import com.example.composepractice.R
import com.example.composepractice.bottomNav.BottomNavGraph
import com.example.composepractice.bottomNav.BottomNavItems
import com.example.composepractice.bottomNav.bottomItem
import com.example.composepractice.ui.theme.ConnectUpBG
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(52.dp),
                backgroundColor = ConnectUpBG,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        modifier = Modifier.padding(start = 12.dp),
                        painter = painterResource(id = R.drawable.connectup_white_bg),
                        tint = Color.Black,
                        contentDescription = null
                    )

                    Box(
                        modifier = Modifier
                            .width(29.dp)
                            .height(29.dp)
                    ) {


                        ConstraintLayout {
                            val (bellIcon, count,notification_count) = createRefs()
                            Icon(
                                modifier = Modifier
                                    .size(200.dp)
                                    .constrainAs(bellIcon) {
                                        end.linkTo(parent.end)
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                    },
                                painter = painterResource(id = R.drawable.ic_base_notification_filled),
                                tint = Color.Black,
                                contentDescription = null
                            )

                            Canvas(
                                modifier = Modifier
                                    .width(12.dp)
                                    .height(12.dp)
                                    .constrainAs(count) {
                                        bottom.linkTo(bellIcon.bottom)
                                        end.linkTo(bellIcon.end)
                                    },
                                onDraw = {
                                    drawCircle(color = Color.Red, radius = 22f)
                                }
                            )

                            Text(
                                modifier = Modifier.constrainAs(notification_count){
                                     bottom.linkTo(count.bottom)
                                    top.linkTo(count.top)
                                    end.linkTo(count.end)
                                    start.linkTo(count.start)
                                },
                                text = "99+",
                                fontSize = 6.sp,
                                fontFamily = MontserratBold(),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        bottomItem.forEach { screen ->
            BottomItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.BottomItem(
    screen: BottomNavItems,
    currentDestination: NavDestination?,
    navController: NavHostController
) {


    BottomNavigationItem(
        label = {
            Text(
                text = screen.name,
                fontFamily = FontFamily(Font(R.font.montserrat_regular))
            )
        },
        icon = {
            screen.icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null
                )
            }
        },

        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navController.navigate(screen.route) {
                popUpTo(BottomNavItems.HomeItem.route)
                launchSingleTop = true
                //  navController.popBackStack()
            }
        },
    )
}

@Preview
@ExperimentalPagerApi
@Composable
fun HomePreview() {
    BottomNavigationScreen()
}