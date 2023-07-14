package com.pidzama.comicsdreamsapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pidzama.comicsdreamsapp.util.Constants.HERO_REMOTE_SERVER_DATABASE_TABLE_NAME

@Entity(tableName = HERO_REMOTE_SERVER_DATABASE_TABLE_NAME)
data class HeroRemoteServer(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)