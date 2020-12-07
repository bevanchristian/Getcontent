package com.example.getcontent.recycleadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcontent.R
import com.squareup.picasso.Picasso

class designadapter (private var image:List<String>,private var nama:List<String>):
    RecyclerView.Adapter<designadapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.gambardesign)
        val nama: TextView =itemview.findViewById(R.id.namadesign)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): designadapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutdesign,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: designadapter.ViewHolder, position: Int) {
        Picasso.get().load(image[position]).into(holder.itemimage)
        holder.nama.text=nama[position]
        Log.d("bener2","agency sudah ok")

    }


}