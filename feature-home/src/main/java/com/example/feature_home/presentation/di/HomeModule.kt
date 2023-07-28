package com.example.feature_home.presentation.di

import com.example.core.navigation.NavigationFactory
import com.example.feature_home.presentation.HomeNavigationFactory
import com.example.feature_home.presentation.HomeUiState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object HomeViewModelModule {
    @Provides
    fun provideInitialHomeUiState(): HomeUiState = HomeUiState()
}

@Module
@InstallIn(SingletonComponent::class)
internal interface HomeSingletonModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindHomeNavigationFactory(factory: HomeNavigationFactory): NavigationFactory
}