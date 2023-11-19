package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CComercialesDataProvider
import com.example.mycity.model.CComercial
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CComercialViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        CComercialUiState(
            cComercialList = CComercialesDataProvider.getCComercialesData(),
            currentCComercial = CComercialesDataProvider.getCComercialesData().getOrElse(0){
                CComercialesDataProvider.defaultCComercial
            }
        )
    )
    val uiState: StateFlow<CComercialUiState> = _uiState

    fun updateCurrentCComercial(selectedCComercial: CComercial){
        _uiState.update {
            it.copy(currentCComercial = selectedCComercial)
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

data class CComercialUiState(
    val cComercialList: List<CComercial> = emptyList(),
    val currentCComercial: CComercial = CComercialesDataProvider.defaultCComercial,
    val isShowingListPage: Boolean = true
)