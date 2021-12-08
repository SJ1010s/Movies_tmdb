package com.home.movieskinopoisk.model_kinopoisk.data

import com.home.movieskinopoisk.token
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface FilmMainScreenAPI {
    @GET("movies/all/page/1/$token")
    fun getFilms(): Single<DataModel>
}