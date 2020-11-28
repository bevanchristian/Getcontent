package com.example.getcontent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class dicoveryrecycle (private var image:List<Int>):
    RecyclerView.Adapter<dicoveryrecycle.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.discovergambar)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dicoveryrecycle.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.discoverylayout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return image.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemimage.setImageResource(image[position])
    }

}