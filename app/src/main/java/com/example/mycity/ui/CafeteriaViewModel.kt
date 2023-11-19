package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CafeteriasDataProvider
import com.example.mycity.model.CComercial
import com.example.mycity.model.Cafeteria
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CafeteriaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CafeteriaUiState(
            cafeteriaList = CafeteriasDataProvider.getCafeteriaData(),
            currentCafeteria = CafeteriasDataProvider.getCafeteriaData().getOrElse(0){
                CafeteriasDataProvider.defaultCafeteria
            }
        )
    )
    val uiState: StateFlow<CafeteriaUiState> = _uiState

    fun updateCurrentCafeteria(selectedCafeteria: Cafeteria){
        _uiState.update {
            it.copy(currentCafeteria = selectedCafeteria)
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

data class CafeteriaUiState(
    val cafeteriaList: List<Cafeteria> = emptyList(),
    val currentCafeteria: Cafeteria = CafeteriasDataProvider.defaultCafeteria,
    val isShowingListPage: Boolean = true
)
