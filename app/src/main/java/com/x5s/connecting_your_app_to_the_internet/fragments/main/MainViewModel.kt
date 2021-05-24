package com.x5s.connecting_your_app_to_the_internet.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.x5s.connecting_your_app_to_the_internet.api.Result
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class MainViewModel(private val repository: Repository):ViewModel() {
    private val TAG = MainViewModel::class.java.simpleName
    private val _resultLiveData = MutableLiveData<List<Result>>()
     val resultLiveData:LiveData<List<Result>>
     get() = _resultLiveData

    init {
        getResult()
    }

    private fun getResult() {
        viewModelScope.launch {
            try {
                _resultLiveData.value = repository.getResults("results").results
                Log.d(TAG, "${_resultLiveData.value}")
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }
}