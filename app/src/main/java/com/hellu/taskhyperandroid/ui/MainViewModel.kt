package com.hellu.taskhyperandroid.ui

import android.app.Application
import androidx.lifecycle.*
import com.hellu.taskhyperandroid.data.remote.ApiResponse
import com.hellu.taskhyperandroid.domain.model.Users
import com.hellu.taskhyperandroid.domain.repository.UserRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository(application)
    private val _userData = MutableLiveData<ApiResponse<List<Users>>>()

    fun getMeal(): LiveData<ApiResponse<List<Users>>> {
        return if (_userData.value == null) return Transformations.map(userRepository.getUser()){
            _userData.value = it
            it
        }
        else _userData
    }

}