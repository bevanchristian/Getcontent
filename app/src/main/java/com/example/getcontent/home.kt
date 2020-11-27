package com.example.getcontent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //setSupportActionBar(toolbar)

        initializeUI()


    }

    private fun initializeUI() {
        sign_out_button.setOnClickListener {
            logout()
        }

        account.setOnClickListener {
            account()
        }
    }
    private fun account(){
        var a=Intent(this,com.example.getcontent.account::class.java)
        startActivity(a)
    }

    private fun logout() {
        startActivity(login.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut();
    }
}