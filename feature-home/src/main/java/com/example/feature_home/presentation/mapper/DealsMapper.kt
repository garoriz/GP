package com.example.feature_home.presentation.mapper

import com.example.feature_home.domain.model.Deal
import com.example.feature_home.presentation.model.DealDisplayable

fun Deal.toPresentationModel() = DealDisplayable(
    dealID = dealID,
    title = title
)