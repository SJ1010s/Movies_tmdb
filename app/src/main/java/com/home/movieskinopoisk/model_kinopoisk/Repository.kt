package com.home.movieskinopoisk.model_kinopoisk

import com.home.movieskinopoisk.model_kinopoisk.data.DataModel
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getFilmData(): Single<DataModel>
}