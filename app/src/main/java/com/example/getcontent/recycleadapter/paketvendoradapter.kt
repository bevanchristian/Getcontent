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

class paketvendoradapter (private var Paket:List<Paket>):
    RecyclerView.Adapter<paketvendoradapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.paket)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): paketvendoradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.paketdetailvendorlayout,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return Paket.size
    }

    override fun onBindViewHolder(holder: paketvendoradapter.ViewHolder, position: Int) {
        Picasso.get().load(Paket[position].gambar).into(holder.itemimage)
        holder.itemView.setOnClickListener {
            Paket[position].onItemClickListener?.invoke()
        }
        Log.d("bener2","agency sudah ok")

    }


}