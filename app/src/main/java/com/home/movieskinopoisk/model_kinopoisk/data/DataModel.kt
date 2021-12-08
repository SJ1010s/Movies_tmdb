package com.home.movieskinopoisk.model_kinopoisk.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    @field:SerializedName("movies") val movies: List<Movie>
):Parcelable