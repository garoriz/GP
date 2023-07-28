package com.example.gp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feature_home.data.local.dao.DealDao
import com.example.feature_home.data.local.model.DealCached

private const val DATABASE_VERSION = 1

@Database(
    entities = [DealCached::class],
    version = DATABASE_VERSION,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dealDao(): DealDao
}