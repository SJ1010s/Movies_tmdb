package com.home.movieskinopoisk.model_tmdb.data

import com.google.gson.GsonBuilder
import com.home.movieskinopoisk.BASE_URL_TMDB
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RemoteDataSource {

    val gson = GsonBuilder().create()


    private val filmsApi = Retrofit.Builder()
        .baseUrl(BASE_URL_TMDB)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create(gson)
        )
        .build()
        .create(FilmMainScreenAPI::class.java)

    fun getFilmData(): Single<DataModel> {
        return filmsApi.getFilms("a146112095c6f7a99ea6985e2b51dab4", "ru")
            .subscribeOn(Schedulers.io())
    }
}