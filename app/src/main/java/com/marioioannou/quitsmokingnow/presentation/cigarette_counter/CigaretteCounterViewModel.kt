package com.marioioannou.quitsmokingnow.presentation.cigarette_counter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CigaretteCounterViewModel:ViewModel() {

    var cigaretteCounterState by mutableStateOf(CigaretteCounterUiState())

    fun increaseCount(){
        val count = cigaretteCounterState.cigaretteCount + 1
        cigaretteCounterState = cigaretteCounterState.copy(cigaretteCount = count)
    }
}