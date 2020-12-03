package com.example.getcontent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.getcontent.database.AppDatabase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home2.view.*


class home2 : Fragment() {
lateinit var aa:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         aa= inflater.inflate(R.layout.fragment_home2, container, false)
        initializeUI()

        return aa


    }

    private fun initializeUI() {
        aa.sign_out_button.setOnClickListener {
            logout()
        }

        aa.account.setOnClickListener {
            account()
        }
    }
    private fun account(){

        findNavController().navigate(R.id.action_home22_to_account22)
       // var a= Intent(this,com.example.getcontent.account::class.java)
        //startActivity(a)
    }

    private fun logout() {
        startActivity(login.getLaunchIntent(this.requireActivity()))
        FirebaseAuth.getInstance().signOut();
    }


    override fun onResume() {


        super.onResume()
        var li= mutableListOf<ImageView>(aa.img_ven1,aa.img_ven2,aa.img_ven3,aa.img_ven4,aa.img_ven5)

        for(x in li){
            x.setOnClickListener {
                var pindah= Intent(this.requireActivity(),detail_vendor::class.java)
                startActivity(pindah)
            }
        }
        val db=AppDatabase.getInstance(this.requireContext())
        if (db != null) {
            aa.tv_promotrend.text= db.dataDao().all.toString()
            db.close()
        }


    }
}