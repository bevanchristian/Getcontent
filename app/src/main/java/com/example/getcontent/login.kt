package com.example.getcontent

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_home2.*


class login : AppCompatActivity() {

    val RC_SIGN_IN: Int = 1
    lateinit var signInClient: GoogleSignInClient
    lateinit var signInOptions: GoogleSignInOptions
    private lateinit var auth: FirebaseAuth


    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        cekinet()


        // inisialisasi
        FirebaseApp.initializeApp(this);

        try {
            // dapetin authentikasinya
            auth = FirebaseAuth.getInstance()

            initializeUI()

            setupGoogleLogin()
        }  catch (e: Exception) {
            auth = FirebaseAuth.getInstance()
            initializeUI()
            setupGoogleLogin()
        }


    }
    fun cekinet(){

        if ( connectivity != null)
        {
            info = connectivity!!.activeNetworkInfo

            if (info != null)
            {
                if (info!!.state == NetworkInfo.State.CONNECTED)
                {
                    //Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_LONG).show()
                var pindah=Intent(this@login,internetconnect::class.java)
                startActivity(pindah)
                finish()
            }
        }
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }


    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            startActivity(NavHost.getLaunchIntent(this))
            finish()

        }






    }

    private fun initializeUI() {
        google_button.setOnClickListener {
            login()
        }
    }

    private fun login() {
        // untuk manggil pop sign in
        val loginIntent: Intent = signInClient.signInIntent

        startActivityForResult(loginIntent, RC_SIGN_IN)// menuju ke on activity result


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //authentication account is retrieved and sent to Firebase to complete the authentication process.
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    googleFirebaseAuth(account)
                }
            } catch (e: ApiException) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun googleFirebaseAuth(acct: GoogleSignInAccount) {

        // jadi sudah login dan sudah dapet autentikasi lanjut untuk dapetin credential
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {

                startActivity(NavHost.getLaunchIntent(this))
            } else {
                Toast.makeText(
                    this,
                    "Google sign in failed google firebase auth:(",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun setupGoogleLogin() {
        signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(this, signInOptions)
    }

}