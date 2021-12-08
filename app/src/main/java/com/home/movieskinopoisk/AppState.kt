package com.home.movieskinopoisk

//import com.home.movieskinopoisk.model.data.DataModel

sealed class AppState {

    data class Success(val data: IDataModel) : AppState()
    data class Error(val errorS: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
