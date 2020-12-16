package com.example.getcontent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.Vendor
import com.example.getcontent.recycleadapter.listvendor
import com.example.getcontent.recycleadapter.listvendoradapter
import kotlinx.android.synthetic.main.activity_list_vendor.*
import kotlinx.android.synthetic.main.fragment_home2.view.*

class list_vendor : AppCompatActivity() {
    private var vendor= mutableListOf<listvendor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vendor)
        rv_listvendor.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        posttolist()
        rv_listvendor.adapter=listvendoradapter(vendor)
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
                    this.image=gmbb
                    this.id=idvendor.toString()
                         this.deskripsi=des

                    this.onItemClickListener={

                        //ini isi activity intent
                        // Toast.makeText(this@home2.requireContext(),nmvendor, Toast.LENGTH_SHORT).show()
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