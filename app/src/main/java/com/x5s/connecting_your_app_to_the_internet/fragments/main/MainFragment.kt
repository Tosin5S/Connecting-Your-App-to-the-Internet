package com.x5s.connecting_your_app_to_the_internet.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.x5s.connecting_your_app_to_the_internet.R
import com.x5s.connecting_your_app_to_the_internet.api.Api
import com.x5s.connecting_your_app_to_the_internet.api.Drink
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import com.x5s.connecting_your_app_to_the_internet.databinding.FragmentMainBinding

class MainFragment:Fragment() {

    private var binding: FragmentMainBinding? = null
    private var drinks = mutableListOf<Drink>()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService)))
                .get(MainViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ):View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.drinksLiveData.observe(viewLifecycleOwner, Observer {
            drinks.addAll(it)
        })
        val adapter = MainAdapter(drinks){
            requireView().findNavController().navigate(
                    R.id.action_mainFragment_to_detailFragment,
            bundleOf(ID_ARGS to it.drinkId)
            )
        }
        binding?.cocktailRv?.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.cocktailRv?.visibility = View.VISIBLE
        binding?.cocktailRv?.adapter = adapter

    }

        companion object {
           val ID_ARGS = MainFragment::class.java.simpleName + "Drink-id"
    }

}