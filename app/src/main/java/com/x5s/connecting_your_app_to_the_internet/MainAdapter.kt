package com.x5s.connecting_your_app_to_the_internet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

 internal class MainAdapter(private val context: Context,private val results: List<Result?>?): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    internal inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            val nameTv:TextView = itemView.findViewById(R.id.name)
            val statusTv:TextView = itemView.findViewById(R.id.status)
            val speciesTv:TextView = itemView.findViewById(R.id.species)
            val imageIv:ImageView = itemView.findViewById(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_rv, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val result = results?.get(position)
        if(result != null) {
            Glide.with(context).load(result.image).into(holder.imageIv)
        }
        if (result != null){
            holder.nameTv.text = result.name
        }
        if (result != null){
            holder.statusTv.text = result.status
        }
        if (result != null){
            holder.speciesTv.text = result.species
        }
    }

    override fun getItemCount(): Int {
        if (results != null) {
            return results.size
        }
        return 0
    }
}