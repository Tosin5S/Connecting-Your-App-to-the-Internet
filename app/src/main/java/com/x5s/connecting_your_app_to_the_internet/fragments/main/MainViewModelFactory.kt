package com.x5s.connecting_your_app_to_the_internet.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }else{
            throw  IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}