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

    private val _cComercialState = MutableStateFlow(
        CComercialUiState(
            cComercialList = CComercialesDataProvider.getCComercialesData(),
            currentCComercial = CComercialesDataProvider.getCComercialesData().getOrElse(0) {
                ParqueDataProvider.defaultParque
            }
        )
    )

    fun updateCurrentCComercial(selectedCComercial: CComercial){
        _cComercialState.update {
            it.copy(currentCComercial = selectedCComercial)
        }
    }

    private val _parqueState = MutableStateFlow(
        ParqueUiState(
            parqueList = ParqueDataProvider.getParqueData(),
            currentParque = ParqueDataProvider.getParqueData().getOrElse(0) {
                ParqueDataProvider.defaultParque
            }
        )
    )

    fun updateCurrentParque(selectedParque: Parque){
        _parqueState.update {
            it.copy(currentParque = selectedParque)
        }
    }

    private val _cafeteriaState = MutableStateFlow(
        CafeteriaUiState(
            cafeteriaList = CafeteriasDataProvider.getCafeteriaData(),
            currentCafeteria = CafeteriasDataProvider.getCafeteriaData().getOrElse(0) {
                CafeteriasDataProvider.defaultCafeteria
            }
        )
    )

    fun updateCurrentCafeteria(selectedCafeteria: Cafeteria) {
        _cafeteriaState.update {
            it.copy(currentCafeteria = selectedCafeteria)
        }
    }

    private val _restauranteState = MutableStateFlow(
        RestauranteUiState(
            restauranteList = RestauranteDataProvider.getRestauranteData(),
            currentRestaurante = RestauranteDataProvider.getRestauranteData().getOrElse(0) {
                RestauranteDataProvider.defaultRestaurante
            }
        )
    )

    fun updateCurrentRestaurante(selectedRestaurante: Restaurante) {
        _restauranteState.update {
            it.copy(currentRestaurante = selectedRestaurante)
        }
    }

}

data class ActivitiesUiState(
    val activitiesList: List<Activities> = emptyList(),
    val currentActivities: Activities = ActivitiesDataProvider.defaultActivity,
    val isShowingActivities: Boolean = true
)

data class CComercialUiState(
    val cComercialList: List<CComercial> = emptyList(),
    val currentCComercial: Any = CComercialesDataProvider.defaultCComercial,
    val isShowingListPage: Boolean = true
)

data class ParqueUiState(
    val parqueList: List<Parque> = emptyList(),
    val currentParque: Parque = ParqueDataProvider.defaultParque,
    val isShowingListPage: Boolean = true
)

data class CafeteriaUiState(
    val cafeteriaList: List<Cafeteria> = emptyList(),
    val currentCafeteria: Cafeteria = CafeteriasDataProvider.defaultCafeteria,
    val isShowingListPage: Boolean = true
)

data class RestauranteUiState(
    val restauranteList: List<Restaurante> = emptyList(),
    val currentRestaurante: Restaurante = RestauranteDataProvider.defaultRestaurante,
    val isShowingListPage: Boolean = true
)
