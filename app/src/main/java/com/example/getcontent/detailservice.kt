package com.example.getcontent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class detailservice : AppCompatActivity() {

    private lateinit var var_btn_pick : Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailservice)

        var_btn_pick = findViewById(R.id.btn_pick) //by aziz
        var_btn_pick.setOnClickListener{
            openWhatsApp()
        }
        
    }

    fun openWhatsApp() {
        try {
            val text = "This is a test" // Replace with your message.
            val toNumber =
                "6281254903470" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
}