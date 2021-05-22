package com.x5s.connecting_your_app_to_the_internet.fragments.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x5s.connecting_your_app_to_the_internet.api.DrinkDetail
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailFragmentViewModel(private val repository: Repository): ViewModel(){

    private val _drinksDetailLiveData = MutableLiveData<List<DrinkDetail>>()

    val drinkDetailLiveData: LiveData<List<DrinkDetail>>
    get() = _drinksDetailLiveData

    private val TAG = DetailFragmentViewModel::class.java.simpleName

    fun getDrinksDetail(id:String){
        try {
            viewModelScope.launch {
                _drinksDetailLiveData.value = repository.getDrinkDetails(id).drinks
            }
        }catch (e:Exception){
            Log.e(TAG,e.message.toString())
        }
    }
}