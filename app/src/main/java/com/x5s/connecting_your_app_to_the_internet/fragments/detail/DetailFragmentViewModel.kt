package com.x5s.connecting_your_app_to_the_internet.fragments.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x5s.connecting_your_app_to_the_internet.api.Result
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import com.x5s.connecting_your_app_to_the_internet.api.ResultDetail
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailFragmentViewModel(private val repository: Repository): ViewModel(){

    private val _resultDetailLiveData = MutableLiveData<List<ResultDetail>>()

    val resultDetailLiveData: LiveData<List<ResultDetail>>
    get() = _resultDetailLiveData

    private val TAG = DetailFragmentViewModel::class.java.simpleName

    fun getResult(id:String){
        try {
            viewModelScope.launch {
                _resultDetailLiveData.value = repository.getResultDetails(id).results
            }
        }catch (e:Exception){
            Log.e(TAG,e.message.toString())
        }
    }
}