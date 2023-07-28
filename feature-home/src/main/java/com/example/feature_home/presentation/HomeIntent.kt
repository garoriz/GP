package com.example.feature_home.presentation

sealed class HomeIntent {
    object GetDeals : HomeIntent()

    object RefreshDeals : HomeIntent()

    data class DealClicked(val dealID: String) : HomeIntent()
}