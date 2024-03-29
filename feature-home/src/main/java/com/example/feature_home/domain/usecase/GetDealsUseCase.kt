package com.example.feature_home.domain.usecase

import com.example.feature_home.domain.model.Deal
import com.example.feature_home.domain.repository.DealRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

fun interface GetDealsUseCase : () -> Flow<Result<List<Deal>>>

fun getDeals(
    dealRepository: DealRepository,
): Flow<Result<List<Deal>>> = dealRepository
    .getDeals()
    .map {
        Result.success(it)
    }
    .retryWhen { cause, _ ->
        if (cause is IOException) {
            emit(Result.failure(cause))

            delay(RETRY_TIME_IN_MILLIS)
            true
        } else {
            false
        }
    }
    .catch { // for other than IOException but it will stop collecting Flow
        emit(Result.failure(it)) // also catch does re-throw CancellationException
    }