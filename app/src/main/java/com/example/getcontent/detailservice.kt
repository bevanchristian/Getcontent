package com.example.getcontent

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.canScrollHorizontally
import androidx.recyclerview.widget.GridLayoutManager
import com.example.getcontent.api.gambar
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.Paket
import com.example.getcontent.recycleadapter.projectserviceadapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation
import kotlinx.android.synthetic.main.activity_detail_vendor.*
import kotlinx.android.synthetic.main.activity_detailservice.*


class detailservice : AppCompatActivity() {

    private var project23= mutableListOf<com.example.getcontent.recycleadapter.detailprojek>()

    private lateinit var var_btn_pick : Button
    private lateinit var var_btn_chat : Button
    private lateinit var to_grupwa_service:String
    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailservice)
        cekinet()
       // val transformation2: Transformation = MaskTransformation(context, R.drawable.rounded_convers_transformation)
        rv_proj.layoutManager= GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false)
        //pindahan data dari detail vendor
        val idpaket = intent.extras!!.getInt("idpaket")
        val namavendor=intent.extras!!.getString("namavendor")
        val idvendor=intent.extras!!.getString("idvendor")

        //inisialisasi database
        val db= AppDatabase.getInstance(this) // inisialisasi data dao nya
        if (db != null) {
            namapaket.text=db.dataDao().namadetailservice(idpaket.toString())
            namavendorservice.text=namavendor
            deskripsipaket.text=db.dataDao().deskripsidetailservice(idpaket.toString())
            hargapaket.text=db.dataDao().hargadetailservice(idpaket.toString())


            val fotovendor = db?.dataDao()?.fotodetailservice(idpaket.toString()) //dapetin foto profil
            val p: Array<String> = fotovendor.split("/").toTypedArray()
            val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
            Picasso.get().load(imageLink).into(fotopaket)//dimasukan*/
        }


        var nama= db?.dataDao()!!.fotoprojectservice(idvendor.toString(),idpaket.toString()).size
        //ngisi project service
        for (x in 0 until nama){
            if (db != null) {
                var s=db.dataDao().fotoprojectservice(idvendor.toString(),idpaket.toString())?.get(x)
                val p: Array<String> = s.split("/").toTypedArray()
                val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                var nama=db.dataDao().namaprojectservice(idvendor.toString(),idpaket.toString())?.get(x)
                var desk=db.dataDao().deskripsiprojek(nama)

                val projekdetail= com.example.getcontent.recycleadapter.detailprojek().apply {
                    this.namaprojekadapter=nama
                    this.deskripsiprojekadapter=desk.toString()
                    this.fotoprojekadapter=imageLink.toString()
                    this.onItemClickListener={

                        //ini pindah mbawa id paket dan nama vendor
                        Toast.makeText(this@detailservice,nama.toString(), Toast.LENGTH_SHORT).show()
                        var pindah=Intent(this@detailservice,detailprojek::class.java)
                        pindah.putExtra("namaprojek",nama)
                        pindah.putExtra("deskripsiprojek",desk)
                        pindah.putExtra("gambar",imageLink.toString())
                        startActivity(pindah)

                    }
                }
                addtolistproject(projekdetail)
            }




        }
        //atach layout e
         rv_proj.adapter=projectserviceadapter(project23)
        to_grupwa_service = db?.dataDao().grupwadetailservice(idvendor.toString())
//        to_grupwa_service = db?.dataDao().grupwadetailvendor(data.toString())

        var_btn_pick = findViewById(R.id.btn_pick) //by aziz
        var_btn_pick.setOnClickListener{
            //openWhatsApp()
            var pindah=Intent(this@detailservice,payment::class.java)
            pindah.putExtra("namapaket",namapaket.text)
            pindah.putExtra("deskripsipaket",deskripsipaket.text.toString())
            pindah.putExtra("hargapaket",hargapaket.text)
            pindah.putExtra("namavendorservice",namavendorservice.text)
            startActivity(pindah)
        }

        var_btn_chat = findViewById(R.id.btn_chat)
        var_btn_chat.setOnClickListener {
            openWhatsApp()
        }

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
                var pindah= Intent(this@detailservice,login::class.java)
                startActivity(pindah)
                finish()

            }
        }
    }
    private fun addtolistproject(projek:com.example.getcontent.recycleadapter.detailprojek){
        project23.add(projek)

    }


    fun openWhatsApp() {
        try {
            val text = "Halo $namavendorservice.text! Saya ingin dibuatkan konten" // Replace with your message.
            val toNumber = "6281254903470" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
//            intent.data = Uri.parse("https://chat.whatsapp.com/E3UkyJOC9mGES1ZHamuPCv")
            intent.data = Uri.parse(to_grupwa_service)
            startActivity(intent)

//            val uri = Uri.parse("https://chat.whatsapp.com/uniqueId")
//            val i = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(Intent.createChooser(i, ""))

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
}

//bikin fixed image
//public class ScrollingActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detailservice);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id==R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//}