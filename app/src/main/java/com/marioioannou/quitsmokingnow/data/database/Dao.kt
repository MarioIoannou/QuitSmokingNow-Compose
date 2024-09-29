package com.marioioannou.quitsmokingnow.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    suspend fun insertCigarette(cigarette: CigaretteEntity)

    @Delete
    suspend fun delete(entry: CigaretteEntity)

    @Query("SELECT * FROM cigarettes_table ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLastEntry(): CigaretteEntity?

    @Query("SELECT * FROM cigarettes_table")
    suspend fun getAllCigarettes(): List<CigaretteEntity>

    @Query("SELECT * FROM cigarettes_table WHERE date(timestamp / 1000, 'unixepoch') = :date")
    suspend fun getCigarettesByDate(date: String): List<CigaretteEntity>

}