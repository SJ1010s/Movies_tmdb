package com.home.movieskinopoisk.model_kinopoisk.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @field:SerializedName("id") val id: Int = 368539,
    @field:SerializedName("title") val title: String = "Гамильтон",
    @field:SerializedName("year") val year: Int = 2015,
    @field:SerializedName("poster") val poster: String = "//images.kinopoisk.cloud/posters/1003587.jpg",
    @field:SerializedName("actors") val actors: List<String> = listOf(
        "Лин-Мануэль Миранда",
        "Лесли Одом мл.",
        "Давид Диггс",
        "Филлипа Су",
        "Рене Голдсберри",
        "Окьерете Онаодован",
        "Энтони Рамос",
        "Джонатан Грофф",
        "Кристофер Нил Джексон",
        "Жасмин Сепас Джонс"),
    @field:SerializedName("rating_kinopoisk") val rating_kinopoisk: String = "9.261",
): Parcelable