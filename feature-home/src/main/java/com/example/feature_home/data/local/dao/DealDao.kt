package com.example.feature_home.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.feature_home.data.local.model.DealCached
import kotlinx.coroutines.flow.Flow

@Dao
interface DealDao {
    @Query("SELECT * FROM DealCached")
    fun getDeals(): Flow<List<DealCached>>

    @Upsert
    suspend fun saveDeals(deals: List<DealCached>)

}