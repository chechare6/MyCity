package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.ActivitiesDataProvider
import com.example.mycity.data.CComercialesDataProvider
import com.example.mycity.data.CafeteriasDataProvider
import com.example.mycity.data.ParqueDataProvider
import com.example.mycity.data.RestauranteDataProvider
import com.example.mycity.model.Activities
import com.example.mycity.model.CComercial
import com.example.mycity.model.Cafeteria
import com.example.mycity.model.Parque
import com.example.mycity.model.Restaurante
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel () {
    private val _activitiesState = MutableStateFlow(
        ActivitiesUiState(
            activitiesList = ActivitiesDataProvider.getActivityData(),
            currentActivities = ActivitiesDataProvider.getActivityData().getOrElse(0) {
                ActivitiesDataProvider.defaultActivity
            }
        )
    )
    val uiActivitiesState: StateFlow<ActivitiesUiState> = _activitiesState



    fun updateCurrentActivity(selectedActivities: Activities){
        _activitiesState.update {
            it.copy(currentActivities = selectedActivities)
        }
    }



}

data class ActivitiesUiState(
    val activitiesList: List<Activities> = emptyList(),
    val currentActivities: Activities = ActivitiesDataProvider.defaultActivity
)

data class RecommendationUiState(
    val recommendationsList: List<Recommendations> = emptyList(),
    val currentRecommendation: Recommendation = RecommedationDataProvider.defaultRecommendation
)
