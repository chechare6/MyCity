package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.utils.MyCityContentType

enum class MyCityScreens(@StringRes val title: Int) {
    Activities (title = R.string.activities),
    Recommendations (title = R.string.recommendations),
    Details (title = R.string.details)
}

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass
) {
    val viewModel: MyCityViewModel = viewModel()

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreens.valueOf(
        backStackEntry?.destination?.route?:MyCityScreens.Activities.name
    )
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> MyCityContentType.ListOnly
        WindowWidthSizeClass.Expanded -> MyCityContentType.ListAndDetails
        else -> MyCityContentType.ListOnly
    }
    
    Scaffold (
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen.title,
                canGoBack = navController.previousBackStackEntry != null,
                navigateNext = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiStateActivities by viewModel.uiActivitiesState.collectAsState()
        val uiStateRecommendation by viewModel.uiRecommendationState.collectAsState()

        if(contentType == MyCityContentType.ListAndDetails){
            MyCityListAndDetail(uiStateActivities, uiStateRecommendation, viewModel, innerPadding, modifier = Modifier.fillMaxWidth())
        } else {
            NavHost(
                navController = navController,
                startDestination = MyCityScreens.Activities.name
            ) {
                composable(route = MyCityScreens.Activities.name) {
                    ActivitiesScreen(
                        activities = uiStateActivities.activitiesList,
                        onClick = {
                            viewModel.updateCurrentActivity(it)
                            viewModel.updateRecommendationList(it.titleResourceId)
                            navController.navigate(MyCityScreens.Recommendations.name)
                        },
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                        contentPadding = innerPadding
                        )
                }

                composable(route = MyCityScreens.Recommendations.name) {
                    RecommendationScreen(
                        recommendations = uiStateRecommendation.recommendationsList,
                        onClick = {
                                  viewModel.updateCurrentRecommendation(it)
                            navController.navigate(MyCityScreens.Details.name)
                        },
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                        contentPadding = innerPadding
                    )
                }
                composable(MyCityScreens.Details.name) {
                    DetailsScreen(
                        selectedRecommendation = uiStateRecommendation.currentRecommendation,
                        onBackPressed = {
                                        navController.navigate(MyCityScreens.Recommendations.name)
                        },
                        contentPadding = innerPadding
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    @StringRes currentScreen: Int,
    canGoBack: Boolean,
    navigateNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen),
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if(canGoBack) {
                IconButton(onClick = navigateNext) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Composable
fun MyCityListAndDetail(
    activitiesUiState: ActivitiesUiState,
    recommendationUiState: RecommendationUiState,
    viewModel: MyCityViewModel,
    innerPadding: PaddingValues,
    modifier: Modifier
) {
    Row {
        Column (
            modifier = Modifier.fillMaxWidth(0.25f)
        ) {
            ActivitiesScreen(
                activities = activitiesUiState.activitiesList,
                onClick = {
                    viewModel.updateCurrentActivity(it)
                    viewModel.updateRecommendationList(it.titleResourceId)
                },
                modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                contentPadding = innerPadding
            )
        }
        Column (
            modifier = Modifier.fillMaxWidth(.35f)
        ) {
            RecommendationScreen(
                recommendations = recommendationUiState.recommendationsList,
                onClick = {
                    viewModel.updateCurrentRecommendation(it)
                },
                modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                contentPadding = innerPadding
            )
        }
        Column {
            DetailsScreen(
                selectedRecommendation = recommendationUiState.currentRecommendation,
                contentPadding = innerPadding,
                onBackPressed = { }
            )
        }
    }
}


