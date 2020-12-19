package com.example.getcontent

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailprojek.*

class detailprojek : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailprojek)


        val nama = intent.extras!!.getString("namaprojek")
        val desk=intent.extras!!.getString("deskripsiprojek")
        val gambar=intent.extras!!.getString("gambar")

        namaprojekdetail.text=nama
        Picasso.get().load(gambar).into(fotoprojek)
        deskripsiprojek.text=desk


        fab.setOnClickListener {
            onBackPressed()
        }




    }
}