package com.example.getcontent.recycleadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.getcontent.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation
import kotlinx.android.synthetic.main.activity_detail_vendor.*


//projek==projek23
class projectserviceadapter (private var projek:List<detailprojek>):
    RecyclerView.Adapter<projectserviceadapter.ViewHolder>(){
    //karena sudah tau design nya yamg mana maka di findviewby id(2)
    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val itemimage: ImageView =itemview.findViewById(R.id.gambarproject)
        val nama: TextView =itemview.findViewById(R.id.namaproject)
        val hh=itemview.context



        // var tulisan:TextView=itemview.findViewById(R.id.cek)

    }

    //inflate / suapaya recycle view tau dia design layout nya yang mana (1)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): projectserviceadapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layoutprojectservice,parent,false)
        return ViewHolder(v)
    }

    //supaya tau ada berapa jumlah querynya jadi bisa mbuat 10 design(3)
    override fun getItemCount(): Int {
        return projek.size
    }

    // ini tempat nginglate designmu(4)
    override fun onBindViewHolder(holder: projectserviceadapter.ViewHolder, position: Int) {
       // val transformation2: Transformation = MaskTransformation(holder.hh, R.drawable.rounded_convers_transformation)
        //Picasso.get().load(projek[position].fotoprojekadapter).transform(transformation2).into(holder.itemimage)
        Glide.with(holder.hh).load(projek[position].fotoprojekadapter).into(holder.itemimage)
        holder.nama.text=projek[position].namaprojekadapter


        holder.itemView.setOnClickListener {
            projek[position].onItemClickListener?.invoke()
        }
        Log.d("bener2","agency sudah ok")

    }


}