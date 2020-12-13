package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_us.*

import android.app.Activity
import android.net.Uri
//import android.support.v4.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast


class AboutUs : AppCompatActivity() {


    private lateinit var var_btn_tes : Button //diprivate biar var_btn_tes cuma berlaku di sini ga di .kt lain, lateinit soalnya mau dideklarasi nanti
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        var_btn_tes = findViewById(R.id.btn_tes) //by aziz
        var_btn_tes.setOnClickListener{
            val var_otw_acc2 = Intent(this@AboutUs, detailservice::class.java)
            startActivity(var_otw_acc2)
        } //by aziz


        var var_btn_wa = findViewById<Button>(R.id.whatsapp)
        var_btn_wa?.setOnClickListener {
//            val editText = findViewById(R.id.shareText)
//            val text = editText.text.toString()
            val kalimat = "Halo selamat pagi!"
            startShareText(kalimat)
            Toast.makeText(applicationContext, kalimat, Toast.LENGTH_SHORT).show()
//            if (editText != null) {
//                val text = editText.text.toString()
//                if (!text.isEmpty()) {
//                    startShareText(text)
//                } else {
//                    Toast.makeText(applicationContext, R.string.enter_text, Toast.LENGTH_SHORT).show()
//                }
//            }
        }

    }


    private fun startShareText(text: String?) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, text)
        sendIntent.type = "text/plain"
        startActivity(sendIntent)

        val no_hp = 6281254903470
//        val kalimat2 = "Halo selamat pagi :))"

        // Set package only if you do not want to show all the options by which you can share the text.
        // Setting package bypass the system picker and directly share the data on WhatsApp.
        // TODO uncomment code to show whatsapp directly
        sendIntent.setPackage("http://api.whatsapp.com/send?phone=$no_hp&text=$text");
//         sendIntent.setPackage("com.whatsapp");

        startActivity(sendIntent)
    }


    fun whatsappbutton(view: View?) {
        val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")
        intent?.let { startActivity(it) }
    }

    //by aziz #########

    //#################

}