package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_account.*
import kotlin.properties.Delegates


class account2 : Fragment() {


    lateinit var name: String
    lateinit var email2: String
    var emailVerified by Delegates.notNull<Boolean>()
    val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user?.let {
            // Name, email address, and profile photo Url
            name = user.displayName.toString()
            email2 = user.email.toString()
            var photoUrl = user.photoUrl
            Picasso.get().load(user.photoUrl.toString()).into(fotoprofil)




        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.activity_account, container, false)


        initprofil()

    }


    fun initprofil() {
        nama.text = Editable.Factory.getInstance().newEditable(name)
        email.text = Editable.Factory.getInstance().newEditable(email2)
        if (user != null) {
            hp.text= Editable.Factory.getInstance().newEditable(user.isEmailVerified.toString())
        }
        //fotoprofil.setImageResource(Uri.parse(photo))
    }

    override fun onResume() {
        super.onResume()
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            var a=Intent(this.requireActivity(),login::class.java)
            startActivity(a)

        }
        if (nama.text.isNotEmpty()){
            update.setOnClickListener {
                var coba= UserProfileChangeRequest.Builder().setDisplayName(nama.text.toString()).build()


                if (user != null) {
                    user.updateProfile(coba).addOnCompleteListener {
                        if (it.isSuccessful) {
                         findNavController().navigate(R.id.action_account22_to_home22)
                        } else {
                            Toast.makeText(
                                this.requireActivity(),
                                "gagal ganti displayname",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }else{
            Toast.makeText(this.requireActivity(), "maaf isikan dengan huruf", Toast.LENGTH_SHORT).show()
        }







    }


    override fun onStart() {
        super.onStart()


    }




}