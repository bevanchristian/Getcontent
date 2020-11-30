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
import kotlinx.android.synthetic.main.fragment_account2.*
import kotlinx.android.synthetic.main.fragment_account2.view.*
import kotlin.properties.Delegates


class account2 : Fragment() {

    lateinit var bb:View

    lateinit var name: String
    lateinit var email2: String
    var emailVerified by Delegates.notNull<Boolean>()
    val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bb =  inflater.inflate(R.layout.fragment_account2, container, false)
        if (user!= null){
            user?.let {
                // Name, email address, and profile photo Url
                name = user.displayName.toString()
                email2 = user.email.toString()
                var photoUrl = user.photoUrl
                if (user.photoUrl!=null){
                    Picasso.get().load(user.photoUrl.toString()).into(bb.fotoprofil2)
                }





            }

        }else{
            nama.text=Editable.Factory.getInstance().newEditable("")

            email.text = Editable.Factory.getInstance().newEditable("")
        }


        initprofil()
        return bb

    }


    fun initprofil() {
        bb.nama.text = Editable.Factory.getInstance().newEditable(name)
        bb.email.text = Editable.Factory.getInstance().newEditable(email2)
        if (user != null) {
            bb.hp.text= Editable.Factory.getInstance().newEditable(user.isEmailVerified.toString())
        }
        //fotoprofil.setImageResource(Uri.parse(photo))
    }

    override fun onResume() {
        super.onResume()
        bb.logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            var a=Intent(this.requireActivity(),login::class.java)
            startActivity(a)

        }
        if (nama.text.isNotEmpty()){
            bb.update.setOnClickListener {
                var coba= UserProfileChangeRequest.Builder().setDisplayName(nama.text.toString()).build()


                if (user != null) {
                    user.updateProfile(coba).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this.requireActivity(),
                                "Sukses mengganti Username",
                                Toast.LENGTH_LONG
                            ).show()
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