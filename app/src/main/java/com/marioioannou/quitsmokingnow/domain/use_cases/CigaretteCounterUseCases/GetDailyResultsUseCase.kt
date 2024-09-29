package com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases

import com.marioioannou.quitsmokingnow.domain.repositories.CigaretteRepository
import java.time.LocalDate

class GetDailyResultsUseCase(private val repository: CigaretteRepository) {
    suspend operator fun invoke(date: LocalDate): Int {
        return repository.getCigaretteCountForDate(date)
    }
}