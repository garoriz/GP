package com.example.feature_home.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DealCached(
    @PrimaryKey
    val dealID: String,

    @ColumnInfo(name = "title")
    val title: String,
)
