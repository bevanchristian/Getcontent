package com.example.getcontent

//import jp.wasabeef.picasso.transformations.CropCircleTransformation

import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.Paket
import com.example.getcontent.recycleadapter.paketvendoradapter
import com.example.getcontent.recycleadapter.portofoliovendoradapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import kotlinx.android.synthetic.main.activity_detail_vendor.*


//zoom image
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ImageView;

//import android.view.MotionEvent;
//import android.view.ScaleGestureDetector;


class detail_vendor : AppCompatActivity() {
    private lateinit var id:String
    private var paket= mutableListOf<Paket>()
    private var porto= mutableListOf<String>()

//    zoom image
//    private var scaleGestureDetector: ScaleGestureDetector? = null
//    private var mScaleFactor = 1.0f
//    private var imageView: ImageView? = null

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
       // Picasso.get().load(imageLink).into(fotoprofil)//dimasukan
       Picasso.get().load(imageLink).transform(CircleTransform()).into(fotoprofil)//dimasukan

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

        chat.setOnClickListener {
            Toast.makeText(this@detail_vendor,"jancok", Toast.LENGTH_SHORT).show()
        }

//        zoom image
//        imageView = findViewById(R.id.imageView)
//        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())

    }

//    zoom image
//    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
//        scaleGestureDetector!!.onTouchEvent(motionEvent)
//        return true
//    }
//
//    private inner class ScaleListener : SimpleOnScaleGestureListener() {
//        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
//            mScaleFactor *= scaleGestureDetector.scaleFactor
//            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f))
//            imageView!!.scaleX = mScaleFactor
//            imageView!!.scaleY = mScaleFactor
//            return true
//        }
//    }

    override fun onResume() {
        super.onResume()

    }
    class CircleTransform : Transformation {
        override fun transform(source: Bitmap): Bitmap {
            val size = Math.min(source.width, source.height)
            val x = (source.width - size) / 2
            val y = (source.height - size) / 2
            val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
            if (squaredBitmap != source) {
                source.recycle()
            }
            val bitmap = Bitmap.createBitmap(size, size, source.config)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            val shader = BitmapShader(
                squaredBitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )
            paint.setShader(shader)
            paint.setAntiAlias(true)
            val r = size / 2f
            canvas.drawCircle(r, r, r, paint)
            squaredBitmap.recycle()
            return bitmap
        }

        override fun key(): String {
            return "circle"
        }
    }


    override fun onStart() {
        super.onStart()

    }
    private fun addtolistpaket(image:Paket){
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
                    var id=db.dataDao().idpaketdetailvendor(data.toString()).get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]

                    val vendor2= Paket().apply {
                        this.gambar=imageLink
                        this.id=id.toString()
                        this.onItemClickListener={

                            //ini pindah mbawa id paket dan nama vendor
                            Toast.makeText(this@detail_vendor,id.toString(), Toast.LENGTH_SHORT).show()
                            var pindah=Intent(this@detail_vendor,detailservice::class.java)
                            pindah.putExtra("idpaket",id)
                            pindah.putExtra("namavendor",vendor.text.toString())
                            pindah.putExtra("idvendor",data.toString())
                            startActivity(pindah)

                        }
                    }
                    addtolistpaket(vendor2)
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