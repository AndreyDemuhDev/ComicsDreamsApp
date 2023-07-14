package com.pidzama.comicsdreamsapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.pidzama.comicsdreamsapp.domain.model.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero_table ORDER BY id")
    fun gelAllHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM hero_table WHERE id=:id")
    fun getCurrentHero(id: Int): Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<Hero>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()
}