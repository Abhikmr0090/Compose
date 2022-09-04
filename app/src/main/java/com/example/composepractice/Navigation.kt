package com.example.composepractice

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.ui_screens.BottomNavigationScreen
import com.example.composepractice.ui_screens.Login
import com.example.composepractice.ui_screens.OnBoarding
import com.example.composepractice.viewmodels.LoginViewModel
import com.google.accompanist.pager.ExperimentalPagerApi



@ExperimentalPagerApi
@Composable
fun Navigation(loginViewModel: LoginViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.OnBoardingRoute.route,
    ) {

        composable(route = ScreenRoutes.OnBoardingRoute.route) {
            OnBoarding(navController = navController)
        }

        composable(route = ScreenRoutes.LoginOrRegister.route) {
            LoginNavigation(navController = navController)
        }

        composable(route = ScreenRoutes.LoginRoute.route) {
            Login(navController = navController,loginViewModel)
        }

        composable(route = ScreenRoutes.HomeRoute.route) {
             BottomNavigationScreen()
        }

    }

}