package com.marioioannou.quitsmokingnow.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "cigarettes_table"
)
data class CigaretteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val timestamp: Long
)
