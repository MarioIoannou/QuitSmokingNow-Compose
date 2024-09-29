package com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases

import com.marioioannou.quitsmokingnow.domain.repositories.CigaretteRepository

class RemoveCigaretteUseCase(private val repository: CigaretteRepository) {
    suspend operator fun invoke() {
        repository.removeLastCigarette()
    }
}