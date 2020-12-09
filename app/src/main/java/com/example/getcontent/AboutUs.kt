package com.example.getcontent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUs : AppCompatActivity() {


    private lateinit var var_btn_tes : Button //diprivate biar var_btn_tes cuma berlaku di sini ga di .kt lain, lateinit soalnya mau dideklarasi nanti
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        var_btn_tes = findViewById(R.id.btn_tes) //by aziz
        var_btn_tes.setOnClickListener{
            val var_otw_acc2 = Intent(this@AboutUs, account2::class.java)
            startActivity(var_otw_acc2)
        } //by aziz

    }

    //by aziz #########

    //#################

}