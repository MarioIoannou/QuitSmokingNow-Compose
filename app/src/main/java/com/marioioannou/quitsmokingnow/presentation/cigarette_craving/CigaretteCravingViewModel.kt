package com.marioioannou.quitsmokingnow.presentation.cigarette_craving

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants.formatTime

class CigaretteCravingViewModel : ViewModel() {

    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData(Constants.TIME_COUNTDOWN.formatTime())
    val time: LiveData<String> = _time

    private val _progress = MutableLiveData(1.00F)
    val progress: LiveData<Float> = _progress

    private val _isPlaying = MutableLiveData(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    // hold data for celebrate view as boolean
    private val _celebrate = CigaretteCravingEventUi<Boolean>()

    val celebrate: LiveData<Boolean> get() = _celebrate

    fun handleCountDownTimer() {
        if (isPlaying.value == true) {
            pauseTimer()
            _celebrate.postValue(false)
        } else {
            startTimer()
        }
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        handleTimerValues(false, Constants.TIME_COUNTDOWN.formatTime(), 1.0F, false)
    }

    private fun startTimer() {

        _isPlaying.value = true
        countDownTimer = object : CountDownTimer(Constants.TIME_COUNTDOWN, 1000) {

            override fun onTick(millisRemaining: Long) {
                val progressValue = millisRemaining.toFloat() / Constants.TIME_COUNTDOWN
                handleTimerValues(true, millisRemaining.formatTime(), progressValue, false)
                _celebrate.postValue(false)
            }

            override fun onFinish() {
                pauseTimer()
                _celebrate.postValue(true)
            }
        }.start()
    }

    private fun handleTimerValues(isPlaying: Boolean, text: String, progress: Float, celebrate: Boolean) {
        _isPlaying.value = isPlaying
        _time.value = text
        _progress.value = progress
        _celebrate.postValue(celebrate)
    }

    // Hello this is a comment
    // Hello this is a comment
}