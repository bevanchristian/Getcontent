package com.example.getcontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.listvendoradapter
import kotlinx.android.synthetic.main.activity_list_vendor.*
import kotlinx.android.synthetic.main.fragment_home2.view.*

class list_vendor : AppCompatActivity() {
    lateinit var gambar:MutableList<String>
    lateinit var nama:MutableList<String>
    lateinit var deksripsi:MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vendor)
        rv_listvendor.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        posttolist()
        rv_listvendor.adapter=listvendoradapter(gambar,nama,deksripsi)
    }


    fun add(gmb:String,nm:String,desk:String){
        gambar.add(gmb)
        nama.add(nm)
        deksripsi.add(desk)
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
                    add(imageLink,name!!,des!!)
            }
        }





    }
}