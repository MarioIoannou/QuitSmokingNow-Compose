package com.marioioannou.quitsmokingnow.domain.repositories

import com.marioioannou.quitsmokingnow.domain.entities.Cigarette
import java.time.LocalDate

interface CigaretteRepository {
    
        suspend fun addCigarette(entry: Cigarette)
        suspend fun removeLastCigarette()
        suspend fun getCigaretteCountForDate(date: LocalDate): Int
        suspend fun getAllEntries(): List<Cigarette>
    
}