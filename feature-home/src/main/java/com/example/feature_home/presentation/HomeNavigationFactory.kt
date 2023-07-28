package com.example.feature_home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.NavigationDestination.Home
import com.example.core.navigation.NavigationFactory
import com.example.feature_home.presentation.composable.HomeRoute
import javax.inject.Inject

class HomeNavigationFactory @Inject constructor() : NavigationFactory {
    override fun create(builder: NavGraphBuilder) {
        builder.composable(Home.route) {
            HomeRoute()
        }
    }
}