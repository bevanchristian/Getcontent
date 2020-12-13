package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.paketvendoradapter
import com.example.getcontent.recycleadapter.portofoliovendoradapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_vendor.*
import kotlinx.android.synthetic.main.fragment_home2.view.*


class detail_vendor : AppCompatActivity() {
    private lateinit var id:String
    private var paket= mutableListOf<String>()
    private var porto= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vendor)
        rv_paket.layoutManager= GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false)
        rv_post.layoutManager= GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false)
        // punya id sekarang tinggal aku insert ke function
        val data = intent.extras!!.getInt("idvendorrr")
        val db= AppDatabase.getInstance(this) // inisialisasi data dao nya

        val fotovendor = db?.dataDao()?.fotodetailvendor(data.toString()) //dapetin foto profil
        val p: Array<String> = fotovendor?.split("/")!!.toTypedArray()
        val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
        Picasso.get().load(imageLink).into(fotoprofil)//dimasukan

        val bannervendor = db?.dataDao()?.bannerdetailvendor(data.toString()) //dapetin foto banner
        val c: Array<String> = bannervendor?.split("/")!!.toTypedArray()
        val imageLink2 = "https://drive.google.com/uc?export=download&id=" + c[5]
        Picasso.get().load(imageLink2).into(bannerdetailvendor)//dimasukan


        // sekarang nama
        val nama=db?.dataDao().namadetailvendor(data.toString())
        vendor.text=nama
        // deskripsi
        val deskripsi=db?.dataDao().deskripsidetailvendor(data.toString())
        deskripsi2.text=deskripsi

        //nomer hp
        val hp=db?.dataDao().nomordetailvendor(data.toString())
        postpaket(data,db)
        rv_paket.adapter=paketvendoradapter(paket)
        rv_post.adapter=portofoliovendoradapter(porto)



    }

    override fun onResume() {
        super.onResume()

    }


    override fun onStart() {
        super.onStart()

    }
    private fun addtolistpaket(image:String){
        paket.add(image)
    }
    private fun addtolistporto(image:String){
        porto.add(image)
    }

    fun postpaket(data:Int,db:AppDatabase){
        val ukuranpaket= db.dataDao().paketdetailvendor(data.toString()).size
        val ukuranporto= db.dataDao().portofoliodetailvendor(data.toString()).size

            /*paket vendor*/
            for (x in 0 until ukuranpaket){
                if (db != null) {
                    var s=db.dataDao().paketdetailvendor(data.toString()).get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    addtolistpaket(imageLink)
                }
            }

        /*portofolio vendor*/
        for (x in 0 until ukuranporto){
            if (db != null) {
                var s=db.dataDao().portofoliodetailvendor(data.toString()).get(x)
                val p: Array<String> = s.split("/").toTypedArray()
                val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                addtolistporto(imageLink)
            }
        }



    }


}