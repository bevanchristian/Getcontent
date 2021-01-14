package com.example.getcontent.recycleadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getcontent.R
import com.squareup.picasso.Picasso

class listvendoradapter (private var listvendor:List<listvendor>):
    RecyclerView.Adapter<listvendoradapter.ViewHolder>(){


    // (2) v jadi itemview dimana v adalah layoutmu
    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.listgambarvendor)
        val nama: TextView =itemview.findViewById(R.id.judullistvendor)
        val deskripsi: TextView =itemview.findViewById(R.id.deskripsilistvendor)
        val hh=itemview.context
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }

    // untuk insiasi layout e(1)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listvendoradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutlistvendor,parent,false)
        return ViewHolder(v)
    }

    // ngitung ada berapa baris supaya hasil querymy supaya bisa dibuat sesuai dengan jumlahnya(3)
    override fun getItemCount(): Int {
        return listvendor.size
    }

    //(4)
    override fun onBindViewHolder(holder: listvendoradapter.ViewHolder, position: Int) {
        //Picasso.get().load(listvendor[position].image).into(holder.itemimage)
        Glide.with(holder.hh).load(listvendor[position].image).into(holder.itemimage)
        holder.nama.text=listvendor[position].nama
        holder.deskripsi.text=listvendor[position].deskripsi
        holder.itemView.setOnClickListener {
            listvendor[position].onItemClickListener?.invoke()
        }
        listvendor[position].image?.let { Log.d("bener2", it) }

    }


}