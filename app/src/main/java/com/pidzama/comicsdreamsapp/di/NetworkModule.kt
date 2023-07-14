package com.pidzama.comicsdreamsapp.di

import androidx.paging.ExperimentalPagingApi
import com.pidzama.comicsdreamsapp.data.local.ComicsDreamsDatabase
import com.pidzama.comicsdreamsapp.data.remote.ComicsDreamsApi
import com.pidzama.comicsdreamsapp.data.repository.RemoteDataSourceImpl
import com.pidzama.comicsdreamsapp.domain.repository.RemoteDataSource
import com.pidzama.comicsdreamsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideComicsDreamsApi(retrofit: Retrofit): ComicsDreamsApi {
        return retrofit.create(ComicsDreamsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        comicsDreamsApi: ComicsDreamsApi,
        comicsDreamsDatabase: ComicsDreamsDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            comicsDreamsApi = comicsDreamsApi,
            comicsDreamsDatabase = comicsDreamsDatabase
        )
    }
}