package com.example.getcontent

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.Vendor
import com.example.getcontent.recycleadapter.listvendor
import com.example.getcontent.recycleadapter.listvendoradapter
import kotlinx.android.synthetic.main.activity_list_vendor.*
import kotlinx.android.synthetic.main.fragment_home2.view.*

class list_vendor : AppCompatActivity() {
    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null
    private var vendor= mutableListOf<listvendor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vendor)
        cekinet()
        rv_listvendor.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        posttolist()
        rv_listvendor.adapter=listvendoradapter(vendor)
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
                var pindah= Intent(this@list_vendor,login::class.java)
                startActivity(pindah)
                finish()

            }
        }
    }

    private fun add(listvendor: listvendor){
        this.vendor.add(listvendor)
    }


    fun posttolist(){

        var db=AppDatabase.getInstance(this)
        var ukuran= db?.dataDao()?.namavendor?.size

        if (ukuran != null) {
            for (x in 0 until ukuran.toInt()){


                    var name= db?.dataDao()?.namavendor?.get(x)
                    var des= db?.dataDao()?.deskripsivendor?.get(x)
                    var gmbb= db?.dataDao()!!.fotovendor!!.get(x)
                    val p: Array<String> = gmbb?.split("/")?.toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                     var idvendor=db.dataDao().idvendor.get(x)
                    val vendor2= listvendor().apply {
                    this.nama=name
                    this.image=imageLink
                    this.id=idvendor.toString()
                         this.deskripsi=des

                    this.onItemClickListener={

                        //ini isi activity intentname
                        Toast.makeText(this@list_vendor,name, Toast.LENGTH_SHORT).show()
                        var pindah= Intent(this@list_vendor,detail_vendor::class.java)
                        pindah.putExtra("idvendorrr",idvendor)
                        startActivity(pindah)

                    }
                }
                    add(vendor2)

            }
        }





    }
}