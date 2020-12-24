package com.example.getcontent

//import MainActivity2
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_us.*

import android.app.Activity
import android.content.ActivityNotFoundException
import android.net.Uri
//import android.support.v4.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast


class AboutUs : AppCompatActivity() {


    private lateinit var var_btn_tes : Button //diprivate biar var_btn_tes cuma berlaku di sini ga di .kt lain, lateinit soalnya mau dideklarasi nanti
    private lateinit var var_btn_instagram : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        /*var_btn_tes = findViewById(R.id.btn_tes) //by aziz
        var_btn_tes.setOnClickListener{
            val var_otw_acc2 = Intent(this@AboutUs, MainActivity2::class.java)
            startActivity(var_otw_acc2)
        } */


    //    var var_btn_wa = findViewById<Button>(R.id.whatsapp)


        var_btn_instagram = findViewById(R.id.instagram)
        var_btn_instagram.setOnClickListener {
            val uri: Uri = Uri.parse("http://instagram.com/_u/getcontent.id")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/getcontent.id")
                    )
                )
            }
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