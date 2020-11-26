package com.example.getcontent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
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
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            startActivity(login.getLaunchIntent(this))
        }
        if (nama.text.isNotEmpty()){
            update.setOnClickListener {
                var coba= UserProfileChangeRequest.Builder().setDisplayName(nama.text.toString()).build()


                if (user != null) {
                    user.updateProfile(coba).addOnCompleteListener {
                        if (it.isSuccessful) {

                            startActivity(home.getLaunchIntent(this))
                        } else {
                            Toast.makeText(
                                this,
                                "gagal ganti displayname",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }else{
            Toast.makeText(this, "maaf isikan dengan huruf", Toast.LENGTH_SHORT).show()
        }







    }


    override fun onStart() {
        super.onStart()


    }
}






