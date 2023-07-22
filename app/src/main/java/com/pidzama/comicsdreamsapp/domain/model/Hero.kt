package com.pidzama.comicsdreamsapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pidzama.comicsdreamsapp.util.Constants.HERO_DATABASE_TABLE_NAME
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = HERO_DATABASE_TABLE_NAME)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val alias: String,
    val realName: String,
    val image: String,
    val biography: String,
    val position: String,
    val height: Double,
    val power: Int,
    val rating: Double,
    val allies: List<String>,
    val enemies: List<String>,
    val publisher: String,
)
