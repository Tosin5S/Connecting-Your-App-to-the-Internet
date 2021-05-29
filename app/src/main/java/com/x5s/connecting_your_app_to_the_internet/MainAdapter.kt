package com.x5s.connecting_your_app_to_the_internet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private val context: Context,private val results: List<Result?>?): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view){

            val nameTv:TextView = view.findViewById(R.id.name)
            val statusTv:TextView = view.findViewById(R.id.status)
            val speciesTv:TextView = view.findViewById(R.id.species)
            val imageIv:ImageView = view.findViewById(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val result = results?.get(position)
        if(results != null) {
            Glide.with(context).load(result?.image).into(holder.imageIv)
        }
        if (results != null){
            holder.nameTv.text = result?.name
        }
        if (results != null){
            holder.statusTv.text = result?.status
        }
        if (results != null){
            holder.speciesTv.text = result?.species
        }
    }

    override fun getItemCount(): Int {
        if (results != null) {
            return results.size
        }
        return 0
    }
}