package com.example.feature_home.presentation

import android.os.Parcelable
import com.example.feature_home.presentation.model.DealDisplayable
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class HomeUiState(
    val isLoading: Boolean = false,
    val deals: List<DealDisplayable> = emptyList(),
    val isError: Boolean = false,
) : Parcelable {
    sealed class PartialState {
        object Loading : PartialState()

        data class Fetched(val list: List<DealDisplayable>) : PartialState()

        data class Error(val throwable: Throwable) : PartialState()
    }
}