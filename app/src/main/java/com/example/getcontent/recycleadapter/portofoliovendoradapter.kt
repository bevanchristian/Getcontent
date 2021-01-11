package com.example.getcontent.recycleadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getcontent.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation

class portofoliovendoradapter (private var image:List<String>):
    RecyclerView.Adapter<portofoliovendoradapter.ViewHolder>(){

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.vendor_post1)
        val hh=itemview.context

        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): portofoliovendoradapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.portofoliodetailvendor,parent,false)
        return ViewHolder(v)

    }


    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: portofoliovendoradapter.ViewHolder, position: Int) {
//        val transformation2: Transformation = MaskTransformation(holder.hh, R.drawable.rounded_convers_transformation)
//        Picasso.get().load(image[position]).transform(transformation2).into(holder.itemimage)
       // Picasso.get().load(image[position]).into(holder.itemimage)
        Glide.with(holder.hh).load(image[position]).into(holder.itemimage)


        Log.d("bener2","agency sudah ok")

    }


}