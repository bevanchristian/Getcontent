package com.example.getcontent

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_account2.view.*

class dicoveryrecycle (private var image:List<String>):
    RecyclerView.Adapter<dicoveryrecycle.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.discovergambar)
            // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dicoveryrecycle.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.discoverylayout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return image.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(image[position]).placeholder(R.drawable.bg_placeholder).into(holder.itemimage)
        Log.d("bener2","image[position]")
        //holder.tulisan.text=image.toString()

    }

}