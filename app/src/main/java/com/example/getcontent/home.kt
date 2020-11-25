package com.example.getcontent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, home::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

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
    }

    private fun logout() {
        startActivity(login.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut();
    }
}