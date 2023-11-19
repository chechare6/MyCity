package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.RestauranteDataProvider
import com.example.mycity.model.Restaurante
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RestauranteViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RestauranteUiState(
            restauranteList = RestauranteDataProvider.getRestauranteData(),
            currentRestaurante = RestauranteDataProvider.getRestauranteData().getOrElse(0){
                RestauranteDataProvider.defaultRestaurante
            }
        )
    )
    val uiState: StateFlow<RestauranteUiState> = _uiState

    fun updateCurrentRestaurante(selectedRestaurante: Restaurante) {
        _uiState.update {
            it.copy(currentRestaurante = selectedRestaurante)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

data class RestauranteUiState(
    val restauranteList: List<Restaurante> = emptyList(),
    val currentRestaurante: Restaurante = RestauranteDataProvider.defaultRestaurante,
    val isShowingListPage: Boolean = true
)