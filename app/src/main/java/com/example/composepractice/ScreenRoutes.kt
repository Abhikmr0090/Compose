package com.example.composepractice

const val ON_BOARDING_ROUTE = "on_boarding"
const val LOGIN_OR_REGISTER = "login_or_register"
const val LOGIN             = "login"
const val HOME_SCREEN       = "home_screen"
const val START_NAV         = "start"
const val HOME_NAV          = "home_nav"

sealed class ScreenRoutes(val route: String) {
    object OnBoardingRoute     : ScreenRoutes(ON_BOARDING_ROUTE)
    object LoginOrRegister     : ScreenRoutes(LOGIN_OR_REGISTER)
    object LoginRoute          : ScreenRoutes(LOGIN)
    object HomeRoute           : ScreenRoutes(HOME_SCREEN)
}