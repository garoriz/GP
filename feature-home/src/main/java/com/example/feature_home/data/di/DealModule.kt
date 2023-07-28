package com.example.feature_home.data.di

import com.example.feature_home.data.remote.api.DealApi
import com.example.feature_home.data.repository.DealRepositoryImpl
import com.example.feature_home.domain.repository.DealRepository
import com.example.feature_home.domain.usecase.GetDealsUseCase
import com.example.feature_home.domain.usecase.RefreshDealsUseCase
import com.example.feature_home.domain.usecase.getDeals
import com.example.feature_home.domain.usecase.refreshDeals
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DealModule {
    @Provides
    @Singleton
    fun provideDealApi(
        retrofit: Retrofit,
    ): DealApi {
        return retrofit.create(DealApi::class.java)
    }

    @Provides
    fun provideGetDealsUseCase(
        dealRepository: DealRepository,
    ): GetDealsUseCase {
        return GetDealsUseCase {
            getDeals(dealRepository)
        }
    }

    @Provides
    fun provideRefreshDealsUseCase(
        dealRepository: DealRepository,
    ): RefreshDealsUseCase {
        return RefreshDealsUseCase {
            refreshDeals(dealRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        @Singleton
        fun bindDealRepository(impl: DealRepositoryImpl): DealRepository
    }
}