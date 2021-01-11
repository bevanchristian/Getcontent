package com.example.getcontent.recycleadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getcontent.R
import com.example.getcontent.dicoveryrecycle
import com.squareup.picasso.Picasso

class banneradapter (private var image:List<String>):
    RecyclerView.Adapter<banneradapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.img_banner)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)
        val hh=itemview.context

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): banneradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutbanner,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: banneradapter.ViewHolder, position: Int) {
        //Picasso.get().load(image[position]).into(holder.itemimage)
        Glide.with(holder.hh).load(image[position]).into(holder.itemimage)

        Log.d("bener2","image[position]")

    }


}