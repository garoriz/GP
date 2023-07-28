package com.example.feature_home.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.example.core.design.AntiFlashWhite
import com.example.feature_home.presentation.model.DealDisplayable

@Composable
fun DealsListContent(
    dealList: List<DealDisplayable>,
    modifier: Modifier = Modifier,
    onDealClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .clip(RoundedCornerShape(
                topStart = dimensionResource(id = com.example.core.R.dimen.dimen_32),
                topEnd = dimensionResource(id = com.example.core.R.dimen.dimen_32),
                bottomEnd = dimensionResource(id = com.example.core.R.dimen.dimen_0),
                bottomStart = dimensionResource(id = com.example.core.R.dimen.dimen_0)
            ))
            .background(AntiFlashWhite),
    ) {
        itemsIndexed(
            items = dealList,
            key = { _, deal -> deal.dealID },
        ) { _, item ->
            DealItem(
                deal = item,
                onDealClick = { },
            )
        }
    }
}
