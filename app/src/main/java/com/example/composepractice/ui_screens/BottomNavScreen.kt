package com.example.composepractice

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

                    Icon(
                        modifier = Modifier
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_base_notification_filled),
                        tint = Color.Black,
                        contentDescription = null
                    )
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