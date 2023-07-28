package com.example.feature_home.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.design.Typography
import com.example.core.utils.collectWithLifecycle
import com.example.feature_home.R
import com.example.feature_home.presentation.HomeEvent
import com.example.feature_home.presentation.HomeEvent.OpenWebBrowserWithDetails
import com.example.feature_home.presentation.HomeIntent
import com.example.feature_home.presentation.HomeUiState
import com.example.feature_home.presentation.HomeViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HandleEvents(viewModel.event)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        onIntent = viewModel::acceptIntent,
    )
}

@Composable
internal fun HomeScreen(
    uiState: HomeUiState,
    onIntent: (HomeIntent) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Column(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.home_bg),
                    contentScale = ContentScale.FillBounds
                )
        }
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = Typography.titleLarge,
            modifier = Modifier.padding(
                start = dimensionResource(id = com.example.core.R.dimen.dimen_8),
                top = dimensionResource(id = com.example.core.R.dimen.dimen_32),
                end = dimensionResource(id = com.example.core.R.dimen.dimen_8),
                bottom = dimensionResource(id = com.example.core.R.dimen.dimen_0)
            )
        )

        Text(
            text = stringResource(id = R.string.home_desc),
            style = Typography.titleMedium,
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = com.example.core.R.dimen.dimen_8),
                vertical = dimensionResource(id = com.example.core.R.dimen.dimen_8),
            )
        )

        if (uiState.deals.isNotEmpty()) {
            DealsAvailableContent(
                snackbarHostState = snackbarHostState,
                uiState = uiState,
                onDealClick = { onIntent(HomeIntent.DealClicked(it)) },
            )
        } else {
            DealsNotAvailableContent(
                uiState = uiState,
            )
        }
    }
}

@Composable
private fun DealsAvailableContent(
    snackbarHostState: SnackbarHostState,
    uiState: HomeUiState,
    onDealClick: (String) -> Unit,
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.deals_error_refreshing)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage,
            )
        }
    }

    DealsListContent(
        dealList = uiState.deals,
        onDealClick = onDealClick,
    )
}

@Composable
private fun DealsNotAvailableContent(uiState: HomeUiState) {
    when {
        uiState.isLoading -> DealsLoadingPlaceholder()
        uiState.isError -> DealsErrorContent()
    }
}

@Composable
private fun HandleEvents(events: Flow<HomeEvent>) {
    val uriHandler = LocalUriHandler.current

    events.collectWithLifecycle {
        when (it) {
            is OpenWebBrowserWithDetails -> {
                uriHandler.openUri(it.uri)
            }
        }
    }
}