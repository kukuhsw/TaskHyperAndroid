package com.hellu.taskhyperandroid.data.remote

import com.hellu.taskhyperandroid.domain.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("repositories")
    fun getAllUsers(): Call<UserResponse>
}