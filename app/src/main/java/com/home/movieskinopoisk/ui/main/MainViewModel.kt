package com.home.movieskinopoisk.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.movieskinopoisk.AppState
import com.home.movieskinopoisk.model_tmdb.Repository
import com.home.movieskinopoisk.model_tmdb.RepositoryImpl
import com.home.movieskinopoisk.model_tmdb.data.RemoteDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl(RemoteDataSource())
) : ViewModel() {

    private val disposables = CompositeDisposable()

    fun getLiveData() = liveDataToObserver
    fun getFilmFromRemoteSource() {
        liveDataToObserver.value = AppState.Loading(null)
        disposables.addAll(repositoryImpl.getFilmData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { success -> liveDataToObserver.value = AppState.Success(data = success) },
                { error ->
                    liveDataToObserver.value = AppState.Error(error)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}