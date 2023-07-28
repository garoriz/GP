package com.example.core.navigation

sealed class NavigationDestination(
    val route: String,
) {
    object Home : NavigationDestination("homeDestination")
    object Back : NavigationDestination("navigationBack")
}