package com.x5s.connecting_your_app_to_the_internet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(
        private val results: List<Property>
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(property: Property){
            val nameTv = view.findViewById<TextView>(R.id.name)
            val statusTv = view.findViewById<TextView>(R.id.status)
            val speciesTv = view.findViewById<TextView>(R.id.species)
            val imageIv = view.findViewById<ImageView>(R.id.image)

            nameTv.text = property.name
            statusTv.text = property.status
            speciesTv.text = property.species

            Glide.with(view.context).load(property.image).centerCrop().into(imageIv)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(results[position])
    }



    override fun getItemCount(): Int {
        return results.size
    }
}