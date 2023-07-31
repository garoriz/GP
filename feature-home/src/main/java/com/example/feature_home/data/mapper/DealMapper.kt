package com.example.feature_home.data.mapper

import com.example.feature_home.data.local.model.DealCached
import com.example.feature_home.data.remote.model.DealResponse
import com.example.feature_home.domain.model.Deal

fun DealCached.toDomainModel() = Deal(
    dealID = dealID,
    title = title,
    thumb = thumb,
    salePrice = "salePrice",
    normalPrice = "normalPrice"
)

fun DealResponse.toDomainModel() = Deal(
    dealID = dealID,
    title = title,
    thumb = thumb,
    salePrice = salePrice,
    normalPrice = normalPrice
)

fun Deal.toEntityModel() = DealCached(
    dealID = dealID,
    title = title,
    thumb = thumb,
    //salePrice = salePrice,
    //normalPrice = normalPrice
)