package com.hellu.taskhyperandroid.domain.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
        @field:SerializedName("users")
        val users: List<Users>? = null
)
