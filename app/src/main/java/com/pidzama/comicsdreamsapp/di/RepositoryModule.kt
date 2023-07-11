package com.pidzama.comicsdreamsapp.di

import android.content.Context
import com.pidzama.comicsdreamsapp.data.repository.DataStoreOptionsImpl
import com.pidzama.comicsdreamsapp.data.repository.Repository
import com.pidzama.comicsdreamsapp.domain.repository.DataStoreOptions
import com.pidzama.comicsdreamsapp.domain.use_cases.UseCases
import com.pidzama.comicsdreamsapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.pidzama.comicsdreamsapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOptions(
        @ApplicationContext context: Context
    ): DataStoreOptions {
        return DataStoreOptionsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository)
        )
    }
}