package com.example.feature_home.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DealDisplayable(
    val dealID: String,
    val title: String,
    val thumb: String,
    val salePrice: String,
    val normalPrice: String,
) : Parcelable