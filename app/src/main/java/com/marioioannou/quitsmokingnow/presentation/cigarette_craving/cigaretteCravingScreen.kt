package com.marioioannou.quitsmokingnow.presentation.cigarette_craving

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants.formatTime


@Composable
fun CigaretteCravingScreen(){

    val viewModel: CigaretteCravingViewModel = viewModel()
    val time by viewModel.time.observeAsState(Constants.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.00F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)
    val celebrate by viewModel.celebrate.observeAsState(false)

    CravingsTimer(time = time, progress = progress, isPlaying = isPlaying, isLottiePlaying = isPlaying, celebrate = celebrate) {
        viewModel.handleCountDownTimer()
    }

}