package com.marioioannou.quitsmokingnow.data.repositories

import com.marioioannou.quitsmokingnow.data.database.CigaretteEntity
import com.marioioannou.quitsmokingnow.data.database.Dao
import com.marioioannou.quitsmokingnow.domain.entities.Cigarette
import com.marioioannou.quitsmokingnow.domain.repositories.CigaretteRepository
import java.time.LocalDate

class CigaretteRepositoryImpl (private val dao: Dao) : CigaretteRepository {
    override suspend fun addCigarette(entry: Cigarette) {
        val entity = CigaretteEntity(timestamp = entry.timestamp)
        dao.insertCigarette(entity)
    }

    override suspend fun removeLastCigarette() {
        val lastEntry = dao.getLastEntry()
        if (lastEntry != null) {
            dao.delete(lastEntry)
        }
    }

    override suspend fun getCigaretteCountForDate(date: LocalDate): Int {
        val dateString = date.toString()
        val entries = dao.getCigarettesByDate(dateString)
        return entries.size
    }

    override suspend fun getAllEntries(): List<Cigarette> {
        return dao.getAllCigarettes().map { Cigarette(it.timestamp) }
    }
}