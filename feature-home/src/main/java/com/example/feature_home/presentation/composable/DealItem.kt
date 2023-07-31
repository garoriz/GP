package com.example.feature_home.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.core.R
import com.example.core.design.Typography
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
                vertical = dimensionResource(id = R.dimen.dimen_8),
                horizontal = dimensionResource(id = R.dimen.dimen_16)
            )
            .clickable { onDealClick() }
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_16)))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = deal.thumb,
            contentDescription = stringResource(id = com.example.feature_home.R.string.thumb_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.dimen_8))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_8)))
                .weight(1f),
        )
        Column(
            modifier = Modifier
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.dimen_8),
            ),
        ) {
            Text(
                text = deal.title,
                style = Typography.titleLarge,
            )
            Row {
                Prices(deal.salePrice, deal.normalPrice)
            }
        }
    }
}

@Composable
fun Prices(salePrice: String, normalPrice: String) {
    Row() {
        Text(
            text = salePrice,
            //style = Typography.titleLarge,
        )
        Text(
            text = normalPrice,
            //style = Typography.titleLarge,
        )
    }
}
