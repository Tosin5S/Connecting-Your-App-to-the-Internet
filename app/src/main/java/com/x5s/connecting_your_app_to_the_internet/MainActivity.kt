package com.x5s.connecting_your_app_to_the_internet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.x5s.connecting_your_app_to_the_internet.api.Api
import com.x5s.connecting_your_app_to_the_internet.api.Result
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import com.x5s.connecting_your_app_to_the_internet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var results = mutableListOf<Result>()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService)))
                .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(results)

        binding?.rickAndMortyRv?.layoutManager =
                LinearLayoutManager(parent)
        binding?.rickAndMortyRv?.visibility = View.VISIBLE
        binding?.rickAndMortyRv?.adapter = adapter
    }

    companion object {
        val ID_ARGS = MainActivity::class.java.simpleName + "results"
    }

}