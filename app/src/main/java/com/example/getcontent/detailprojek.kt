package com.example.getcontent

import android.app.Service
import android.content.Intent
import android.content.res.ColorStateList
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailprojek.*
import kotlinx.android.synthetic.main.activity_internetconnect.*

class detailprojek : AppCompatActivity() {
    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailprojek)
        cekinet()

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

    override fun onResume() {
        super.onResume()
        cekinet()
    }
    fun cekinet(){
        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        if ( connectivity != null)
        {
            info = connectivity!!.activeNetworkInfo

            if (info != null)
            {
                if (info!!.state == NetworkInfo.State.CONNECTED)
                {
                   // Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()

                }
            }
            else
            {
                Toast.makeText(context, "Cek internet anda", Toast.LENGTH_LONG).show()
                var pindah= Intent(this@detailprojek,login::class.java)
                startActivity(pindah)
                finish()

            }
        }
    }
}