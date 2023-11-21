package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.ActivitiesDataProvider
import com.example.mycity.data.RecommendationDataProvider
import com.example.mycity.model.Activities
import com.example.mycity.model.Recommendation
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

    private val _recommendationState = MutableStateFlow(
        RecommendationUiState(
            recommendationsList = RecommendationDataProvider.getRecommendationData(uiActivitiesState.value.currentActivities.titleResourceId),
            currentRecommendation = RecommendationDataProvider.getRecommendationData(uiActivitiesState.value.currentActivities.titleResourceId).getOrElse(0) {
                RecommendationDataProvider.defaultRecommendation
            }
        )
    )
    val uiRecommendationState: StateFlow<RecommendationUiState> = _recommendationState

    fun updateCurrentActivity(selectedActivities: Activities){
        _activitiesState.update {
            it.copy(currentActivities = selectedActivities)
        }
    }

    fun updateCurrentRecommendation(selectedRecommendation: Recommendation) {
        _recommendationState.update {
            it.copy(currentRecommendation = selectedRecommendation)
        }
    }

    fun updateRecommendationList(activity: Int) {
        _recommendationState.update {
            it.copy(recommendationsList = RecommendationDataProvider.getRecommendationData(activity))
        }
    }

}

data class ActivitiesUiState(
    val activitiesList: List<Activities> = emptyList(),
    val currentActivities: Activities = ActivitiesDataProvider.defaultActivity
)

data class RecommendationUiState(
    val recommendationsList: List<Recommendation> = emptyList(),
    val currentRecommendation: Recommendation = RecommendationDataProvider.defaultRecommendation
)
