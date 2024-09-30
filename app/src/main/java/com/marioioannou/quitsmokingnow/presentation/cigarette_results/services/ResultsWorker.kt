package com.marioioannou.quitsmokingnow.presentation.cigarette_results.services

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.marioioannou.quitsmokingnow.domain.notification.NotificationService
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.GetDailyResultsUseCase
import java.time.LocalDate

class ResultsWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val getDailyResultsUseCase: GetDailyResultsUseCase,
    private val notificationService: NotificationService
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val date = LocalDate.now().minusDays(1)
        val count = getDailyResultsUseCase(date)

        notificationService.showDailyResultsNotification(count)

        return Result.success()
    }
}