package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Howitwork: AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.how_it)
        var_btn_tes = findViewById(R.id.btn_tes) //by aziz
        var_btn_tes.setOnClickListener{
            val var_otw_acc2 = Intent(this@AboutUs, account2::class.java)
            startActivity(var_otw_acc2)
        } //by aziz

    }
}