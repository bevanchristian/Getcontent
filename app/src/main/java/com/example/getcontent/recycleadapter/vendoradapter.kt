package com.example.getcontent.recycleadapter

import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcontent.R
import com.example.getcontent.dicoveryrecycle
import com.squareup.picasso.Picasso
import java.lang.Exception

class vendoradapter (private var vendor:List<Vendor>):
    RecyclerView.Adapter<vendoradapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.gambarvendor)
        val nama:TextView=itemview.findViewById(R.id.namavendor)
        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vendoradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.agencyvendor,parent,false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return vendor.size
    }

    override fun onBindViewHolder(holder: vendoradapter.ViewHolder, position: Int) {
try {
    Picasso.get().load(vendor[position].image).into(holder.itemimage)
    holder.nama.text=vendor[position].nama
    holder.itemView.setOnClickListener {
        vendor[position].onItemClickListener?.invoke()
    }

    Log.d("bener2","agency sudah ok")
} catch (e:Exception){

}


    }


}