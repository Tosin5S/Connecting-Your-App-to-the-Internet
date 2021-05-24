package com.x5s.connecting_your_app_to_the_internet.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.x5s.connecting_your_app_to_the_internet.api.Result
import com.x5s.connecting_your_app_to_the_internet.databinding.ItemRvBinding

class MainAdapter(
        private val results: List<Result>, private val listener: (Result) -> Unit
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(results[position])
    }

    inner class MainViewHolder(private val binding: ItemRvBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(result: Result){
            binding.title.text = result.resultName
            binding.imageIv.load(result.resultImage)
            binding.root.setOnClickListener{
                listener.invoke(result)
            }
        }
    }


    override fun getItemCount(): Int {
        return results.size
    }
}