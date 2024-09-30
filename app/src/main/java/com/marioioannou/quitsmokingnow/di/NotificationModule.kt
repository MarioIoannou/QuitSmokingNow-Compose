package com.marioioannou.quitsmokingnow.di

import android.content.Context
import com.marioioannou.quitsmokingnow.data.notification.NotificationServiceImpl
import com.marioioannou.quitsmokingnow.domain.notification.NotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationService(@ApplicationContext context: Context): NotificationService {
        return NotificationServiceImpl(context)
    }
}