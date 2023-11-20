package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R
import com.example.mycity.data.ActivitiesDataProvider
import com.example.mycity.data.CComercialesDataProvider
import com.example.mycity.model.Activities
import com.example.mycity.model.CComercial
import com.example.mycity.model.Cafeteria
import com.example.mycity.model.Parque
import com.example.mycity.model.Restaurante
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.utils.MyCityContentType


@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
) {
    val viewModel: MyCityViewModel = viewModel()
    val activityUiState by viewModel.uiActivitiesState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Expanded -> MyCityContentType.ListAndDetails
        else -> MyCityContentType.ListOnly
    }
    Scaffold (
        topBar = {
            MyCityAppBar(windowSize = windowSize)
        }
    ) { innerPadding ->
        ActivityList(
            activity = activityUiState.activitiesList,
            onClick = {
                viewModel.updateCurrentActivity(it)
                viewModel.navigateToCComercialPage()
            },
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
            contentPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.mycity),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ActivityListItem(
    activity: Activities,
    onItemClick: (Activities) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(activity) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            ActivityListImageItem(
                activity = activity,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column (
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(activity.titleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CComercialListItem(
    cComercial: CComercial,
    onItemClick: (CComercial) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(cComercial) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            CComercialListImageItem(
                cComercial = cComercial,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height)))
            Column (
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(cComercial.titleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}


@Composable
fun ActivityListImageItem(activity: Activities, modifier: Modifier) {
    Box(
        modifier = modifier
    ){
        Image(painter = painterResource(activity.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun CComercialListImageItem(cComercial: CComercial, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(painter = painterResource(cComercial.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun ParqueListImageItem(parque: Parque, modifier: Modifier) {
    Box(modifier = modifier) {
        Image(painter = painterResource(parque.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun CafeteriaListImageItem(cafeteria: Cafeteria, modifier: Modifier) {
    Box(modifier = modifier) {
        Image(painter = painterResource(cafeteria.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun RestauranteListItem(restaurante: Restaurante, modifier: Modifier) {
    Box(modifier = modifier) {
        Image(painter = painterResource(restaurante.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun ActivityList(
    activity: List<Activities>,
    onClick: (Activities) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
)   {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ) {
        items(activity, key = { activity -> activity.id }) {activity ->
            ActivityListItem    (
                activity = activity,
                onItemClick = onClick
            )
        }
    }
}


@Composable
private fun CComercialList(
    cComercial: List<CComercial>,
    onClick: (CComercial) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ) {
        items(cComercial, key = { cComercial -> cComercial.id }) {cComercial ->
            CComercialListItem(
                cComercial = cComercial,
                onItemClick = onClick
            )
        }
    }
}

@Preview
@Composable
fun ActivitiesListPreview() {
    MyCityTheme {
        Surface {
            ActivityList(
                activity = ActivitiesDataProvider.getActivityData(),
                onClick = {} )
        }
    }
}

@Preview
@Composable
fun CComercialListPreview() {
    MyCityTheme {
        Surface {
            CComercialList(
                cComercial = CComercialesDataProvider.getCComercialesData(),
                onClick = {} )
        }
    }
}


