package com.home.movieskinopoisk.model_kinopoisk

import com.home.movieskinopoisk.model_kinopoisk.data.DataModel
import com.home.movieskinopoisk.model_kinopoisk.data.RemoteDataSource
import io.reactivex.rxjava3.core.Single

class RepositoryImpl(private val remoteDataSource: RemoteDataSource): Repository {

    override fun getFilmData(): Single<DataModel> {
        return remoteDataSource.getFilmData()
    }
}