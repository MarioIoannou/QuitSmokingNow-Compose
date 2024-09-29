package com.marioioannou.quitsmokingnow.domain.use_cases.CigaretteCounterUseCases

import com.marioioannou.quitsmokingnow.domain.entities.Cigarette
import com.marioioannou.quitsmokingnow.domain.repositories.CigaretteRepository

class AddCigaretteUseCase (private val repository: CigaretteRepository) {
    suspend operator fun invoke() {
        val entry = Cigarette(System.currentTimeMillis())
        repository.addCigarette(entry)
    }
}