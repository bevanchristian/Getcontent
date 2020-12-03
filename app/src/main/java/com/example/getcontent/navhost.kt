package com.example.getcontent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_navhost.*
import kotlinx.android.synthetic.main.fragment_viewpager.*

class NavHost : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, NavHost::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navhost)
        var navController=findNavController(R.id.fragment)
        bottomnavi.setupWithNavController(navController)
        bottomnavi.setOnNavigationItemSelectedListener { item ->
            when (item.title) {
                "discovery"-> viewpager2.currentItem=0
                "Home" -> viewpager2.currentItem = 1
                "Account"-> viewpager2.currentItem = 2

            }
            false
        }



    }
}