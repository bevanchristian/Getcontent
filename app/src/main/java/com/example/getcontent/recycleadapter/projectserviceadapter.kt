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

class projectserviceadapter (private var image:List<String>,private var nama:List<String>):
    RecyclerView.Adapter<projectserviceadapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.gambarproject)
        val nama: TextView =itemview.findViewById(R.id.namaproject)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): projectserviceadapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutprojectservice,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: projectserviceadapter.ViewHolder, position: Int) {
        Picasso.get().load(image[position]).into(holder.itemimage)
        holder.nama.text=nama[position]
        Log.d("bener2","agency sudah ok")

    }


}