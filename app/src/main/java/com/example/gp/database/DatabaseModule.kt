package com.example.gp.database

import android.content.Context
import androidx.room.Room
import com.example.feature_home.data.local.dao.DealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val APP_DATABASE_NAME = "app_database_name"

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            APP_DATABASE_NAME,
        ).build()
    }

    @Singleton
    @Provides
    fun provideDealDao(database: AppDatabase): DealDao {
        return database.dealDao()
    }
}