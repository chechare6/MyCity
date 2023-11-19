package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.ParqueDataProvider
import com.example.mycity.model.Parque
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ParqueViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ParqueUiState(
            parqueList = ParqueDataProvider.getParqueData(),
            currentParque = ParqueDataProvider.getParqueData().getOrElse(0){
                ParqueDataProvider.defaultParque
            }
        )
    )
    val uiState: StateFlow<ParqueUiState> = _uiState

    fun updateCurrentParque(selectedParque: Parque) {
        _uiState.update {
            it.copy(currentParque = selectedParque)
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

data class ParqueUiState(
    val parqueList: List<Parque> = emptyList(),
    val currentParque: Parque = ParqueDataProvider.defaultParque,
    val isShowingListPage: Boolean = true
)