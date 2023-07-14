package com.pidzama.comicsdreamsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pidzama.comicsdreamsapp.data.local.dao.HeroDao
import com.pidzama.comicsdreamsapp.data.local.dao.HeroRemoteServerDao
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.domain.model.HeroRemoteServer
import com.pidzama.comicsdreamsapp.util.DatabaseTypeConverter

@Database(entities = [Hero::class, HeroRemoteServer::class], version = 1)
@TypeConverters(DatabaseTypeConverter::class)
abstract class ComicsDreamsDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteServerDao(): HeroRemoteServerDao
}