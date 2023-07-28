package com.example.feature_home.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DealResponse (
    @SerialName("internalName")
    val internalName: String = "",

    @SerialName("title")
    val title: String = "",

    @SerialName("metacriticLink")
    val metacriticLink: String = "",

    @SerialName("dealID")
    val dealID: String = "",

    @SerialName("storeID")
    val storeID: String = "",

    @SerialName("gameID")
    val gameID: String = "",

    @SerialName("salePrice")
    val salePrice: String = "",

    @SerialName("normalPrice")
    val normalPrice: String = "",

    @SerialName("isOnSale")
    val isOnSale: String = "",

    @SerialName("savings")
    val savings: String = "",

    @SerialName("metacriticScore")
    val metacriticScore: String = "",

    @SerialName("steamRatingText")
    val steamRatingText: String = "",

    @SerialName("steamRatingPercent")
    val steamRatingPercent: String = "",

    @SerialName("steamRatingCount")
    val steamRatingCount: String = "",

    @SerialName("steamAppID")
    val steamAppID: String = "",

    @SerialName("releaseDate")
    val releaseDate: Long = 0,

    @SerialName("lastChange")
    val lastChange: Long = 0,

    @SerialName("dealRating")
    val dealRating: String = "",

    @SerialName("thumb")
    val thumb: String = "",
)