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

class listvendoradapter (private var listvendor:List<listvendor>):
    RecyclerView.Adapter<listvendoradapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.listgambarvendor)
        val nama: TextView =itemview.findViewById(R.id.judullistvendor)
        val deskripsi: TextView =itemview.findViewById(R.id.deskripsilistvendor)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listvendoradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutlistvendor,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return listvendor.size
    }

    override fun onBindViewHolder(holder: listvendoradapter.ViewHolder, position: Int) {
        Picasso.get().load(listvendor[position].image).into(holder.itemimage)
        holder.nama.text=listvendor[position].nama
        holder.deskripsi.text=listvendor[position].deskripsi
        holder.itemView.setOnClickListener {
            listvendor[position].onItemClickListener?.invoke()
        }
        Log.d("bener2","agency sudah ok")

    }


}