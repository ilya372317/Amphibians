package com.example.amphibians.ui.viewModel

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.repository.AmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibianUiState
    object Loading : AmphibianUiState
    object Error : AmphibianUiState
}

class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {
    var uiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)

    init {
        getAmphibians()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository)
            }
        }
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            uiState = try {
                AmphibianUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibianUiState.Error
            }
        }
    }
}