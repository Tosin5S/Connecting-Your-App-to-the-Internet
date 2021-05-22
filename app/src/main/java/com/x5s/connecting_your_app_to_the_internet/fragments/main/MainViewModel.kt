package com.x5s.connecting_your_app_to_the_internet.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.x5s.connecting_your_app_to_the_internet.api.Drink
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class MainViewModel(private val repository: Repository):ViewModel() {
    private val TAG = MainViewModel::class.java.simpleName
    private val _drinksLiveData = MutableLiveData<List<Drink>>()
     val drinksLiveData:LiveData<List<Drink>>
     get() = _drinksLiveData

    init {
        getDrinks()
    }

    private fun getDrinks() {
        viewModelScope.launch {
            try {
                _drinksLiveData.value = repository.getDrink("Alcoholic").drinks
                Log.d(TAG, "${_drinksLiveData.value}")
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }
}