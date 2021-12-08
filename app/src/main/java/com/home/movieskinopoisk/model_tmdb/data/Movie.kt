package com.home.movieskinopoisk.model_tmdb.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.home.movieskinopoisk.IMovie
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @field:SerializedName("id") override val id: Int = 19995,
    @field:SerializedName("title") override val title: String = "Аватар",
    @field:SerializedName("release_date") override val year: String = "2009-12-10",
    @field:SerializedName("poster_path") override val poster: String = "/uaRusyPlXRD4w3XPbfDDbO4jXST.jpg",
    @field:SerializedName("vote_average") override val rating_kinopoisk: String = "9.261",
    @field:SerializedName("overview") override val description: String = "Описание",
): Parcelable, IMovie