package com.home.movieskinopoisk.model_tmdb.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.home.movieskinopoisk.IDataModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    @field:SerializedName("items") override val movies: List<Movie>
):Parcelable, IDataModel