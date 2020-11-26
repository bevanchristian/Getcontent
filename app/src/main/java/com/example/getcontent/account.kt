package com.example.getcontent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_account.*
import kotlin.properties.Delegates

class account : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, account::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    lateinit var name: String
    lateinit var email2: String
    var emailVerified by Delegates.notNull<Boolean>()
    val user = FirebaseAuth.getInstance().currentUser



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)


        user?.let {
            // Name, email address, and profile photo Url
            name = user.displayName.toString()
            email2 = user.email.toString()
            var photoUrl = user.photoUrl
            Picasso.get().load(user.photoUrl.toString()).into(fotoprofil)




        }
        initprofil()

    }
    fun initprofil() {
        nama.text = Editable.Factory.getInstance().newEditable(name)
        email.text = Editable.Factory.getInstance().newEditable(email2)
        if (user != null) {
            hp.text=Editable.Factory.getInstance().newEditable(user.isEmailVerified.toString())
        }
        //fotoprofil.setImageResource(Uri.parse(photo))
    }

    override fun onResume() {
        super.onResume()
        updateuser.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            startActivity(login.getLaunchIntent(this))
        }


    }


    override fun onStart() {
        super.onStart()


    }
}





