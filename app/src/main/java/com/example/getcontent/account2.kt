package com.example.getcontent

import android.app.Activity
import android.content.Intent
import android.graphics.*
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import kotlinx.android.synthetic.main.fragment_account2.*
import kotlinx.android.synthetic.main.fragment_account2.view.*
import java.io.File
//import sun.invoke.util.VerifyAccess.getPackageName
import kotlin.properties.Delegates


class account2 : Fragment() {
    private var tes:Unit?=null
    lateinit var bb:View
    private  var profil: Uri? =null

    lateinit var name: String
    lateinit var email2: String
    var emailVerified by Delegates.notNull<Boolean>()
    val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }
    class CircleTransform : Transformation {
        override fun transform(source: Bitmap): Bitmap {
            val size = Math.min(source.width, source.height)
            val x = (source.width - size) / 2
            val y = (source.height - size) / 2
            val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
            if (squaredBitmap != source) {
                source.recycle()
            }
            val bitmap = Bitmap.createBitmap(size, size, source.config)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            val shader = BitmapShader(
                squaredBitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )
            paint.setShader(shader)
            paint.setAntiAlias(true)
            val r = size / 2f
            canvas.drawCircle(r, r, r, paint)
            squaredBitmap.recycle()
            return bitmap
        }

        override fun key(): String {
            return "circle"
        }
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
                    Picasso.get().load(user.photoUrl.toString()).transform(CircleTransform()).into(bb.fotoprofil2)
                    //Picasso.get().load(bitmap).transform(CircleTransform()).into(bb.fotoprofil2)

                    Log.d("foto",user.photoUrl.toString())
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
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(a)

        }
        if (nama.text.isNotEmpty()){

            //bb.pickphoto.setOnClickListener {
              //  val intent = Intent(Intent.ACTION_PICK)
               // intent.type = "image/*"
              //  startActivityForResult(intent, 100)


         //   }





            bb.update.setOnClickListener {
                var coba= UserProfileChangeRequest.Builder().setDisplayName(nama.text.toString()).build()

                //var gambar= UserProfileChangeRequest.Builder().set(nama.text.toString()).build()


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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 100){

         /*   if (data!=null){
                profil= data.data
               // val bitmap = MediaStore.Images.Media.getBitmap(context?.getContentResolver(), profil)
                Log.d("profil",profil.toString())
                var gambar=UserProfileChangeRequest.Builder().setPhotoUri(profil).build()

                /* val resolver = context?.contentResolver
                 val readOnlyMode = "r"
                 resolver.openFileDescriptor(Uri.parse(profil.toString()), readOnlyMode).use { pfd ->
                     // Perform operations on "pfd".
                 }*/
                fotoprofil2.setImageURI(profil)
                user?.updateProfile(gambar)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(
                            this.requireActivity(),
                            "Sukses mengganti Gambar",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this.requireActivity(),
                            "gagal ganti gambar",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                //fotoprofil2.setImageURI(profil)
            }*/

            //fotoprofil2.setImageURI(profil)
        }
    }




}