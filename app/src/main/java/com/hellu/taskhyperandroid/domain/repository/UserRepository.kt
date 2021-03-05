package com.hellu.taskhyperandroid.domain.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellu.taskhyperandroid.data.remote.ApiResponse
import com.hellu.taskhyperandroid.data.remote.RemoteDataSource
import com.hellu.taskhyperandroid.domain.model.UserResponse
import com.hellu.taskhyperandroid.domain.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(application: Application) {
    fun getUser(): LiveData<ApiResponse<List<Users>>> {
        val data = MutableLiveData<ApiResponse<List<Users>>>()

        data.value = ApiResponse.Loading
        RemoteDataSource().callApi().getAllUsers().enqueue(object: Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    response.body()?.users?.let {
                        data.value = ApiResponse.Success(it)
                    }
                }else{
                    data.value = ApiResponse.Error(response.message())
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                data.value = ApiResponse.Error(t.message.toString())
            }

        })
        return data
    }

}