package com.home.movieskinopoisk.model_tmdb.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmMainScreenAPI {
    @GET("3/list/10")
    fun getFilms(
        @Query("api_key") token: String,
        @Query("language") language: String
    ): Single<DataModel>
}