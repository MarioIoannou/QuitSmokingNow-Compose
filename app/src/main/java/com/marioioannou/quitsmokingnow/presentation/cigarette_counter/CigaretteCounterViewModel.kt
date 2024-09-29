package com.marioioannou.quitsmokingnow.presentation.cigarette_counter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.AddCigaretteUseCase
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.GetDailyResultsUseCase
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.RemoveCigaretteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CigaretteCounterViewModel @Inject constructor(
    private val addCigaretteUseCase: AddCigaretteUseCase,
    private val removeCigaretteUseCase: RemoveCigaretteUseCase,
    private val getDailyResultsUseCase: GetDailyResultsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    init {
        loadDailyResults(LocalDate.now())
    }

    fun addCigarette() {
        viewModelScope.launch {
            addCigaretteUseCase()
            loadDailyResults(LocalDate.now())
        }
    }

    fun removeCigarette() {
        viewModelScope.launch {
            removeCigaretteUseCase()
            loadDailyResults(LocalDate.now())
        }
    }

    fun loadDailyResults(date: LocalDate) {
        viewModelScope.launch {
            val result = getDailyResultsUseCase(date)
            _count.value = result
        }
    }
}
//    var cigaretteCounterState by mutableStateOf(CigaretteCounterUiState())
//
//    fun increaseCount(){
//        val count = cigaretteCounterState.cigaretteCount + 1
//        cigaretteCounterState = cigaretteCounterState.copy(cigaretteCount = count)
//    }
//}