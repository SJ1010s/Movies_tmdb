package com.home.movieskinopoisk.model_tmdb


import com.home.movieskinopoisk.model_tmdb.data.DataModel
import com.home.movieskinopoisk.model_tmdb.data.RemoteDataSource
import io.reactivex.rxjava3.core.Single

class RepositoryImpl(private val remoteDataSource: RemoteDataSource): Repository {

    override fun getFilmData(): Single<DataModel> {
        return remoteDataSource.getFilmData()
    }
}