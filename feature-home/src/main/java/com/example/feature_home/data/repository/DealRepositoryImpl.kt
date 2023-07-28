package com.example.feature_home.data.repository

import com.example.feature_home.data.local.dao.DealDao
import com.example.feature_home.data.mapper.toDomainModel
import com.example.feature_home.data.mapper.toEntityModel
import com.example.feature_home.data.remote.api.DealApi
import com.example.feature_home.domain.model.Deal
import com.example.feature_home.domain.repository.DealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DealRepositoryImpl @Inject constructor(
    private val dealApi: DealApi,
    private val dealDao: DealDao,
) : DealRepository {
    override fun getDeals(): Flow<List<Deal>> {
        return dealDao
            .getDeals()
            .map { dealsCached ->
                dealsCached.map { it.toDomainModel() }
            }
            .onEach { deals ->
                if (deals.isEmpty()) {
                    refreshDeals()
                }
            }
    }

    override suspend fun refreshDeals() {
        dealApi
            .getDeals()
            .map {
                it.toDomainModel().toEntityModel()
            }
            .also {
                dealDao.saveDeals(it)
            }
    }
}