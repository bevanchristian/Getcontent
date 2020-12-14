package com.example.getcontent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_payment.*

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        paketpayment.text= intent.extras!!.getString("namapaket")
        deskrpsipayment.text=intent.extras!!.getString("deskripsipaket")
        hargapayment.text=intent.extras!!.getString("hargapaket")

        bayar.setOnClickListener{
            openWhatsApp()
        }

    }
    fun openWhatsApp() {
        try {
            val text = "Halo Kak! saya ingin membayar" // Replace with your message.
            val toNumber =
                "628113340369" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
            startActivity(intent)

//            val uri = Uri.parse("https://chat.whatsapp.com/uniqueId")
//            val i = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(Intent.createChooser(i, ""))

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
