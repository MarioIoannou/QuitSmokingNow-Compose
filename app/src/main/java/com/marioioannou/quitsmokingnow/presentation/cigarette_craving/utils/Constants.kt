package com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils

import java.util.concurrent.TimeUnit

object Constants {

    //const val TIME_COUNTDOWN: Long = 240000L
    const val TIME_COUNTDOWN: Long = 10000L

    private const val TIME_FORMAT = "%02d:%02d"

    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

}