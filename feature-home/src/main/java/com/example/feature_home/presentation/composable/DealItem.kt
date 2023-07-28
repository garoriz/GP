package com.example.feature_home.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.core.design.Typography
import com.example.core.R
import com.example.feature_home.presentation.model.DealDisplayable

@Composable
fun DealItem(
    deal: DealDisplayable,
    modifier: Modifier = Modifier,
    onDealClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.dimen_16),
            )
            .clickable { onDealClick() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.dimen_8),
            ),
        ) {
            Text(
                text = deal.title,
                style = Typography.bodyMedium,
            )
        }
    }
}