package com.example.feature_home.domain.usecase

import com.example.core.utils.resultOf
import com.example.feature_home.domain.repository.DealRepository

fun interface RefreshDealsUseCase : suspend () -> Result<Unit>

suspend fun refreshDeals(
    dealRepository: DealRepository,
): Result<Unit> = resultOf {
    dealRepository.refreshDeals()
}