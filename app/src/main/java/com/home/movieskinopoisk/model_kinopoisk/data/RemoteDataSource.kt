package com.home.movieskinopoisk.model_kinopoisk.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.home.movieskinopoisk.baseURL
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor






class RemoteDataSource {

    val interceptor = HttpLoggingInterceptor()

    val gson = GsonBuilder().create()

    private val filmsApi = Retrofit.Builder()
        .baseUrl(baseURL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create(gson)
        )
        .build()
        .create(FilmMainScreenAPI::class.java)

    fun getFilmData(): Single<DataModel> {
        return filmsApi.getFilms().subscribeOn(Schedulers.io())
    }
}