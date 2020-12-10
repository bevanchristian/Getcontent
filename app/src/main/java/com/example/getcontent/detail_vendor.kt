package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_vendor.*


class detail_vendor : AppCompatActivity() {
    private lateinit var id:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vendor)



    }

    override fun onResume() {

        super.onResume()
        val data = intent.extras!!.getInt("idvendorrr")
        vendor.text=data.toString()
        var gambar = mutableListOf<ImageView>(gold,silver,photoshoot,videoshoot)
        for(x in gambar){
            x.setOnClickListener {
                var pindah=Intent(this,detailservice::class.java)
                startActivity(pindah)
            }
        }
    }


}