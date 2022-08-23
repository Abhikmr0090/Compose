package com.example.composepractice.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composepractice.ScreenRoutes

sealed class BottomNavItems(
    val name : String,
    val route  : String,
    var icon : ImageVector? = null
){

    object HomeItem : BottomNavItems(
        name = "Home",
        route  = "home",
        icon = Icons.Outlined.Home
    )

    object SearchItem : BottomNavItems(
        name = "Search",
        route  = "search",
        icon = Icons.Outlined.Search
    )

    object ChatItem : BottomNavItems(
        name = "Chat",
        route  = "chat",
        icon = Icons.Outlined.MailOutline
    )

    object Profile : BottomNavItems(
        name = "Profile",
        route  = "profile",
        icon = Icons.Outlined.Person
    )

    object More : BottomNavItems(
        name = "More",
        route  = "more",
        icon = Icons.Outlined.Menu
    )

    object EditProfile : BottomNavItems(
        name = "",
        route = "edit_profile"
    )
}

val bottomItem = listOf(
    BottomNavItems.HomeItem,
    BottomNavItems.SearchItem,
    BottomNavItems.ChatItem,
    BottomNavItems.Profile,
    BottomNavItems.More,
)