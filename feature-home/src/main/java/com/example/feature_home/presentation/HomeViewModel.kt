package com.example.feature_home.presentation

import androidx.lifecycle.SavedStateHandle
import com.example.core.BaseViewModel
import com.example.feature_home.domain.usecase.GetDealsUseCase
import com.example.feature_home.domain.usecase.RefreshDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.feature_home.presentation.HomeUiState.PartialState
import com.example.feature_home.presentation.HomeUiState.PartialState.Fetched
import com.example.feature_home.presentation.HomeUiState.PartialState.Loading
import com.example.feature_home.presentation.HomeUiState.PartialState.Error
import com.example.feature_home.presentation.mapper.toPresentationModel
import com.example.feature_home.presentation.HomeIntent.RefreshDeals
import com.example.feature_home.presentation.HomeIntent.GetDeals
import com.example.feature_home.presentation.HomeIntent.DealClicked
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDealsUseCase: GetDealsUseCase,
    private val refreshDealsUseCase: RefreshDealsUseCase,
    savedStateHandle: SavedStateHandle,
    homeInitialState: HomeUiState,
) : BaseViewModel<HomeUiState, PartialState, HomeEvent, HomeIntent>(
    savedStateHandle,
    homeInitialState,
) {
    init {
        observeContinuousChanges(getDeals())
    }

    override fun mapIntents(intent: HomeIntent): Flow<PartialState> = when (intent) {
        is GetDeals -> getDeals()
        is RefreshDeals -> refreshDeals()
        is DealClicked -> dealClicked()
    }

    override fun reduceUiState(
        previousState: HomeUiState,
        partialState: PartialState
    ): HomeUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false,
        )

        is Fetched -> previousState.copy(
            isLoading = false,
            deals = partialState.list,
            isError = false,
        )

        is Error -> previousState.copy(
            isLoading = false,
            isError = true,
        )
    }

    private fun getDeals(): Flow<PartialState> =
        getDealsUseCase()
            .map { result ->
                result.fold(
                    onSuccess = { dealList ->
                        Fetched(dealList.map { it.toPresentationModel() })
                    },
                    onFailure = {
                        Error(it)
                    },
                )
            }
            .onStart {
                emit(Loading)
            }

    private fun refreshDeals(): Flow<PartialState> = flow {
        refreshDealsUseCase()
            .onFailure {
                emit(Error(it))
            }
    }

    private fun dealClicked(): Flow<PartialState> {

        return emptyFlow()
    }
}