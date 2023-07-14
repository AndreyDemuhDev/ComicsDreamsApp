package com.pidzama.comicsdreamsapp.data.remote

import com.pidzama.comicsdreamsapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsDreamsApi {

    @GET("/comics.api/heroes")
    suspend fun getAllHeroes(@Query("page") page: Int = 1): ApiResponse

    @GET("/comics.api/heroes/search")
    suspend fun searchHeroes(@Query("name") name: String): ApiResponse
}