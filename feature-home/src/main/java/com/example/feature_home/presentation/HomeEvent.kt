package com.example.feature_home.presentation

sealed class HomeEvent {
    data class OpenWebBrowserWithDetails(val uri: String) : HomeEvent()
}