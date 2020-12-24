package com.example.getcontent

//package com.kharismarizqii.belajarintent

import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.*
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation
import kotlinx.android.synthetic.main.fragment_home2.view.*


// CODE BY AZIZ, LINK HOMEPAGE TO ACCOUNT2 EXPERIMENT
//class home2 : AppCompatActivity(), View.OnclickListener, View.OnClickListener {
//
//}

class home2 : Fragment() {
lateinit var aa:View
    private var banner= mutableListOf<String>()

    private var vendor= mutableListOf<Vendor>()


    private var projek= mutableListOf<project>()
   // var gakngotak=GakNgotak()

   // val radius = 30
    //val margin = 5
    //val transformation: Transformation = RoundedCornersTransformation(radius, margin)
    //private var namadesign= mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        aa= inflater.inflate(R.layout.fragment_home2, container, false)

        val transformation2: Transformation = MaskTransformation(context, R.drawable.rounded_convers_transformation)
        var about_us="https://drive.google.com/file/d/1esLH7PDu_fBjuGXbs3j64iYt4quCo4Vc/view?usp=sharing"
        val p: Array<String> = about_us.split("/").toTypedArray()
        val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
        Picasso.get().load(imageLink.toString()).transform(transformation2).into(aa.tv_aboutus)
        var how_it="https://drive.google.com/file/d/1bNNGv_GWqBTkL5Y2h0h6oLUNP7sGtVxT/view?usp=sharing"
        val x: Array<String> = how_it.split("/").toTypedArray()
        val gambar_howit = "https://drive.google.com/uc?export=download&id=" + x[5]


        Picasso.get().load(gambar_howit.toString()).transform(transformation2).into(aa.tv_howit)


        /*layout manager banner,agency*/
        aa.rv_agency.layoutManager=LinearLayoutManager(
            this.requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        aa.rv_banner.layoutManager=LinearLayoutManager(
            this.requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        aa.rv_design.layoutManager=LinearLayoutManager(
            this.requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        /* di tarik dari sql dan api*/

        return aa


    }
    /*class RoundedCornersTransform  : Transformation {
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
            paint.shader = shader
            paint.isAntiAlias = true
            val r = size / 8f
            canvas.drawRoundRect(
                RectF(0f, 0f ,source.width.toFloat(), source.height.toFloat()),
                r,
                r,
                paint
            )




            squaredBitmap.recycle()
            return bitmap
        }

        override fun key(): String {
            return "rounded_corners"
        }
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        posttolist()
        /*dipasang*/
        aa.rv_banner.adapter=banneradapter(banner)

        aa.rv_agency.adapter=vendoradapter(vendor)



        aa.rv_design.adapter=designadapter(projek)
        initializeUI()
    }

    private fun initializeUI() {
//        aa.sign_out_button.setOnClickListener {
//            logout()
//        }
//
//        aa.account.setOnClickListener {
//            account()
//        }

        aa.tv_aboutus.setOnClickListener{
            val var_btn_aboutus = Intent(this.requireContext(), AboutUs::class.java)
            startActivity(var_btn_aboutus)
        }

        aa.tv_howit.setOnClickListener {
            val var_btn_howit = Intent(this.requireContext(), Howitwork::class.java)
            startActivity(var_btn_howit)
        }
        aa.viewvendor.setOnClickListener {
            val var_btn_list = Intent(this.requireContext(), list_vendor::class.java)
            startActivity(var_btn_list)
        }

       /* var li= mutableListOf<ImageView>(aa.img_ven1,aa.img_ven2,aa.img_ven3)
        for(x in li){
            x.setOnClickListener {
                var pindah= Intent(this.requireActivity(),detail_vendor::class.java)
                startActivity(pindah)
            }
        }*/
    }
    private fun account(){

        findNavController().navigate(R.id.action_home22_to_account22)
       // var a= Intent(this,com.example.getcontent.account::class.java)
        //startActivity(a)
    }

    private fun logout() {
        startActivity(login.getLaunchIntent(this.requireActivity()))
        FirebaseAuth.getInstance().signOut();
    }






    private fun addtolist(image: String){
        banner.add(image)
    }

    private fun addtolistvendor(vendor: Vendor){
        this.vendor.add(vendor)
    }
    private fun addtolistdesign(project: project){
        this.projek.add(project)
    }

    private fun posttolist(){
        val db=AppDatabase.getInstance(this.requireContext())
        val ukuranbanner = db?.dataDao()?.promo?.size
        val ukuranvendor=db?.dataDao()?.namavendor?.size
        val ukurandesign=db?.dataDao()?.namadesign?.size
        if (ukuranbanner != null) {

            /*banner*/
            for (x in 0 until ukuranbanner){
                if (db != null) {
                    var s=db.dataDao().promo.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    addtolist(imageLink)
                }
            }
            /*vendor*/
            for(x in 0 until ukuranvendor!!){
                if (db != null) {

                    var s=db.dataDao().fotovendor.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id="+ p[5]
                    var nmvendor:String=db.dataDao().namavendor.get(x)
                    var idvendor=db.dataDao().idvendor.get(x)
                    //var pair=Pair(nmvendor,id)  //masukin nama dan id
                    val vendor2= Vendor().apply {
                        this.nama=nmvendor
                        this.image=imageLink
                        this.id=idvendor.toString()

                        this.onItemClickListener={

                            //ini isi activity intent
                           // Toast.makeText(this@home2.requireContext(),nmvendor, Toast.LENGTH_SHORT).show()
                            var pindah=Intent(
                                this@home2.requireContext(),
                                detail_vendor::class.java
                            )
                            pindah.putExtra("idvendorrr", idvendor)
                            startActivity(pindah)

                        }
                    }
                    addtolistvendor(vendor2)
                }
            }
            /*design*/
            for(x in 0 until ukurandesign!!){
                if (db != null) {
                    var s=db.dataDao().fotodesign.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    var nmdesign:String=db.dataDao().namadesign.get(x)
                    var idpaketvendor=db.dataDao().idpaketvendordesign.get(x).toString()
                    var idvendordesign=db.dataDao().idvendordesign.get(x).toString()
                    var namavendor=db.dataDao().namavendordesign(idvendordesign)
                    val design= project().apply {
                        this.idproject=idpaketvendor
                        this.namaproject=nmdesign
                        this.imageproject=imageLink
                        this.onItemClickListener={

                            //ini isi activity intent
                            Toast.makeText(
                                this@home2.requireContext(),
                                idpaketvendor.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                            var pindah=Intent(
                                this@home2.requireContext(),
                                detailservice::class.java
                            )
                            pindah.putExtra("idpaket", idpaketvendor.toInt())
                            pindah.putExtra("namavendor", namavendor)
                            pindah.putExtra("idvendor", idvendordesign)
                            startActivity(pindah)


                        }
                    }
                    addtolistdesign(design)
                }
            }

        }
    }
}


