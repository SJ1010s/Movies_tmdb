package com.home.movieskinopoisk.model_tmdb

import com.home.movieskinopoisk.model_tmdb.data.DataModel
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getFilmData(): Single<DataModel>
}