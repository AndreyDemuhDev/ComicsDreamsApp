package com.pidzama.comicsdreamsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pidzama.comicsdreamsapp.domain.model.HeroRemoteServer

@Dao
interface HeroRemoteServerDao {

    @Query("SELECT * FROM hero_remote_server_table WHERE id=:id")
    suspend fun getRemoteKey(id: Int): HeroRemoteServer?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteServer: List<HeroRemoteServer>)

    @Query("DELETE FROM hero_remote_server_table")
    suspend fun deleteAllRemoteKeys()
}