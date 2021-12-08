package com.home.movieskinopoisk

import com.google.gson.annotations.SerializedName

interface IMovie {
    val id: Int
    val title: String
    val year: String
    val poster: String
    val rating_kinopoisk: String
    val description: String
}