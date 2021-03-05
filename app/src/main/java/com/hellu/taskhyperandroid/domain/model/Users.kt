package com.hellu.taskhyperandroid.domain.model

import com.google.gson.annotations.SerializedName

data class Users(
        @field:SerializedName("author")
        var author: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("avatar")
        val avatar: String? = null,

        @SerializedName("url")
        val url: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("language")
        val language: String? = null,

        @field:SerializedName("languageColor")
        val languageColor: String? = null,

        @field:SerializedName("stars")
        val stars: String? = null,

        @field:SerializedName("forks")
        val forks: String? = null,

        @field:SerializedName("currentPeriodStars")
        val currentPeriodStars: String? = null,

        @field:SerializedName("builtBy")
        val builtBy: String? = null,
)
