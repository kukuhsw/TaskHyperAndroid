package com.hellu.taskhyperandroid.domain.model

import com.google.gson.annotations.SerializedName

data class BuiltBy(

        @field:SerializedName("href")
        var href: String? = null,

        @field:SerializedName("avatar")
        val avatar: String? = null,

        @field:SerializedName("username")
        val username: String? = null

)
