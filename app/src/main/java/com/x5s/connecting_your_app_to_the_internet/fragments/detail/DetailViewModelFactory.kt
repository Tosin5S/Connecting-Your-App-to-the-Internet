package com.x5s.connecting_your_app_to_the_internet.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFragmentViewModel::class.java)){
            return DetailFragmentViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKOWN CLASS")
        }
    }
}