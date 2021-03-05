package com.hellu.taskhyperandroid.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellu.taskhyperandroid.ui.MainViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

    private var mainViewModel: MainViewModel? = null

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            if(mainViewModel == null) mainViewModel = MainViewModel(application)
            return mainViewModel as T
        }
        throw IllegalAccessException("Unknown View Model Class : ${modelClass.name}")
    }

    companion object{
        var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application):ViewModelFactory{
            if (INSTANCE == null){
                INSTANCE = ViewModelFactory(application)
            }
            return INSTANCE!!
        }
    }

}