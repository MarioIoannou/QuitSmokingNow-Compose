package com.marioioannou.quitsmokingnow.di

import android.content.Context
import androidx.room.Room
import com.marioioannou.quitsmokingnow.data.database.CigarettesDatabase
import com.marioioannou.quitsmokingnow.data.database.Dao
import com.marioioannou.quitsmokingnow.data.repositories.CigaretteRepositoryImpl
import com.marioioannou.quitsmokingnow.domain.repositories.CigaretteRepository
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.AddCigaretteUseCase
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.GetDailyResultsUseCase
import com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases.RemoveCigaretteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CigarettesDatabase {
        return Room.databaseBuilder(
            context,
            CigarettesDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideCigaretteDao(db: CigarettesDatabase): Dao = db.dao

    @Provides
    fun provideRepository(dao: Dao): CigaretteRepository = CigaretteRepositoryImpl(dao)

    @Provides
    fun provideAddCigaretteUseCase(repository: CigaretteRepository) = AddCigaretteUseCase(repository)

    @Provides
    fun provideRemoveCigaretteUseCase(repository: CigaretteRepository) = RemoveCigaretteUseCase(repository)

    @Provides
    fun provideGetDailyResultsUseCase(repository: CigaretteRepository) = GetDailyResultsUseCase(repository)
}