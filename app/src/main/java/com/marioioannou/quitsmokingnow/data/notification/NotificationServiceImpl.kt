package com.marioioannou.quitsmokingnow.data.notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.marioioannou.quitsmokingnow.R
import com.marioioannou.quitsmokingnow.data.utils.ConstantsDataLayer
import com.marioioannou.quitsmokingnow.domain.notification.NotificationService

class NotificationServiceImpl (
    private val context: Context
) : NotificationService {

    override fun showDailyResultsNotification(count: Int) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context, ConstantsDataLayer.CHANNEL_ID)
            .setSmallIcon(R.drawable.quit_smoking_logo_notif)
            .setContentTitle("Daily Results Ready")
            .setContentText("You smoked $count cigarettes yesterday.")
            .setAutoCancel(true)
            .build()

        notificationManager.notify(ConstantsDataLayer.NOTIFICATION_ID, notification)
    }
}
