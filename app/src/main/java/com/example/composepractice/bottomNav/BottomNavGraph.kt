package com.example.composepractice.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composepractice.*
import com.example.composepractice.ui_screens.MoreScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.HomeItem.route,
        route = HOME_NAV
    ) {
        composable(route = BottomNavItems.HomeItem.route) {
            HomeScreen()
        }

        composable(route = BottomNavItems.SearchItem.route) {
            SearchScreen()
        }

        composable(route = BottomNavItems.ChatItem.route) {
            ChatScreen()
        }

        composable(route = BottomNavItems.Profile.route) {
            ProfileScreen(navController)
        }

        composable(route = BottomNavItems.More.route) {
            MoreScreen(navController)
        }

        composable(route = BottomNavItems.EditProfile.route) {
            EditProfileScreen(navController)
        }


    }
}

//@Composable
//fun BottomNavGraph(navController: NavHostController) {
//
//    NavHost(navController = navController, startDestination = BottomNavItems.HomeItem.route) {
//        composable(route = BottomNavItems.HomeItem.route) {
//            HomeScreen()
//        }
//
//        composable(route = BottomNavItems.SearchItem.route) {
//            SearchScreen()
//        }
//
//        composable(route = BottomNavItems.ChatItem.route) {
//            ChatScreen()
//        }
//
//        composable(route = BottomNavItems.Profile.route) {
//
//        }
//
//        composable(route = BottomNavItems.More.route) {
//
//        }
//
//    }
//}