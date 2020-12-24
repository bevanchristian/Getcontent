package com.example.getcontent

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_internetconnect.*


class internetconnect : AppCompatActivity() {

    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internetconnect)

        cekinet.setOnClickListener {
        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        if ( connectivity != null)
        {
            info = connectivity!!.activeNetworkInfo

            if (info != null)
            {
                if (info!!.state == NetworkInfo.State.CONNECTED)
                {
                    Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                    var pindah= Intent(this@internetconnect,login::class.java)
                    startActivity(pindah)
                    finish()
                }
            }
            else
            {
                Toast.makeText(context, "Cek internet anda", Toast.LENGTH_LONG).show()

            }
        }
        }
    }

    override fun onRestart() {
        super.onRestart()
        cekinet.setOnClickListener {
            connectivity =
                context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivity != null) {
                info = connectivity!!.activeNetworkInfo

                if (info != null) {
                    if (info!!.state == NetworkInfo.State.CONNECTED) {
                        Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                        var pindah = Intent(this@internetconnect, login::class.java)
                        startActivity(pindah)
                        finish()
                    }
                } else {
                    Toast.makeText(context, "Cek internet anda", Toast.LENGTH_LONG).show()

                }
            }

        }
    }
}