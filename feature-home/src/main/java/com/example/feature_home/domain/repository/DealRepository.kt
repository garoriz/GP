package com.example.feature_home.domain.repository

import com.example.feature_home.domain.model.Deal
import kotlinx.coroutines.flow.Flow

interface DealRepository {
    fun getDeals(): Flow<List<Deal>>

    suspend fun refreshDeals()
}