package com.pidzama.comicsdreamsapp.di

import android.content.Context
import androidx.room.Room
import com.pidzama.comicsdreamsapp.data.local.HeroesDatabase
import com.pidzama.comicsdreamsapp.util.Constants.NAME_HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        klass = HeroesDatabase::class.java,
        name = NAME_HERO_DATABASE
    ).build()
}