package com.example.getcontent

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_account.*

class account : AppCompatActivity() {

lateinit var name:String
    lateinit var email2:String
    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, account::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            // Name, email address, and profile photo Url
            name = user.displayName.toString()
            email2 = user.email.toString()
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }

        initprofil()

    }

    fun initprofil(){
        nama.text= Editable.Factory.getInstance().newEditable(name)
        email.text=Editable.Factory.getInstance().newEditable(email2)
        //fotoprofil.setImageResource(Uri.parse(photo))
    }

    override fun onStart() {
        super.onStart()

    }
}