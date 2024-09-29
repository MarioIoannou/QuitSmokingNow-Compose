package com.marioioannou.quitsmokingnow.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CigaretteEntity::class],
    version = 1
)
abstract class CigarettesDatabase: RoomDatabase() {
    abstract val dao: Dao
}