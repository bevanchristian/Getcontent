package com.example.getcontent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.getcontent.database.AppDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailservice.*


class detailservice : AppCompatActivity() {

    private lateinit var var_btn_pick : Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailservice)
        //pindahan data dari detail vendor
        val idpaket = intent.extras!!.getInt("idpaket")
        val namavendor=intent.extras!!.getString("namavendor")

        //inisialisasi database
        val db= AppDatabase.getInstance(this) // inisialisasi data dao nya
        if (db != null) {
            namapaket.text=db.dataDao().namadetailservice(idpaket.toString())
            namavendorservice.text=namavendor
            deskripsipaket.text=db.dataDao().deskripsidetailservice(idpaket.toString())
            hargapaket.text=db.dataDao().hargadetailservice(idpaket.toString())


            val fotovendor = db?.dataDao()?.fotodetailservice(idpaket.toString()) //dapetin foto profil
            val p: Array<String> = fotovendor?.split("/")!!.toTypedArray()
            val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
            Picasso.get().load(imageLink).into(fotopaket)//dimasukan*/
        }

        var_btn_pick = findViewById(R.id.btn_pick) //by aziz
        var_btn_pick.setOnClickListener{
            openWhatsApp()
        }
        
    }

    fun openWhatsApp() {
        try {
            val text = "Halo Kak! Saya ingin dibuatkan konten" // Replace with your message.
            val toNumber =
                "6281254903470" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
            intent.data = Uri.parse("https://chat.whatsapp.com/E3UkyJOC9mGES1ZHamuPCv&text=$text")
            startActivity(intent)

//            val uri = Uri.parse("https://chat.whatsapp.com/uniqueId")
//            val i = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(Intent.createChooser(i, ""))

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
}