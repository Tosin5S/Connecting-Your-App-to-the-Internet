package com.x5s.connecting_your_app_to_the_internet.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.x5s.connecting_your_app_to_the_internet.api.Api
import com.x5s.connecting_your_app_to_the_internet.api.DrinkDetail
import com.x5s.connecting_your_app_to_the_internet.api.Repository
import com.x5s.connecting_your_app_to_the_internet.databinding.FragmentDetailBinding
import com.x5s.connecting_your_app_to_the_internet.fragments.main.MainFragment.Companion.ID_ARGS

class DetailFragment: Fragment() {

    private var binding : FragmentDetailBinding? = null
    private val drinksDetail = mutableListOf<DrinkDetail>()

    private val viewModel: DetailFragmentViewModel by lazy{
        ViewModelProvider(
                this,
                DetailViewModelFactory(Repository(Api.apiService))
        ).get(DetailFragmentViewModel::class.java)
    }

    override fun onCreateView(
            inflate: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        //viewModel.getDrinksDetail()
        var id = ""
        arguments?.let{
            id = it.getString(ID_ARGS).toString()
        }
        viewModel.getDrinksDetail(id)
        viewModel.drinkDetailLiveData.observe(viewLifecycleOwner, Observer{
           drinksDetail.addAll(it)
        })

        binding?.instructionTv?.text = drinksDetail[0].instruction
        binding?.thumbIv?.load(drinksDetail[0].drinkThumb)
        activity?.title = drinksDetail[0].drinkName
    }
}