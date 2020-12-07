package com.example.getcontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getcontent.database.AppDatabase
import com.example.getcontent.recycleadapter.banneradapter
import com.example.getcontent.recycleadapter.designadapter
import com.example.getcontent.recycleadapter.vendoradapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home2.view.*


class home2 : Fragment() {
lateinit var aa:View
    private var banner= mutableListOf<String>()
    private var gambarvendor= mutableListOf<String>()
    private var namavendor= mutableListOf<String>()
    private var gambardesign= mutableListOf<String>()
    private var namadesign= mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        aa= inflater.inflate(R.layout.fragment_home2, container, false)
        /*layout manager banner,agency*/
        aa.rv_agency.layoutManager=LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        aa.rv_banner.layoutManager=LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        aa.rv_design.layoutManager=LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        /* di tarik dari sql dan api*/
        posttolist()
        /*dipasang*/
        aa.rv_banner.adapter=banneradapter(banner)
        aa.rv_agency.adapter=vendoradapter(gambarvendor,namavendor)
        aa.rv_design.adapter=designadapter(gambardesign,namadesign)
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

       /* var li= mutableListOf<ImageView>(aa.img_ven1,aa.img_ven2,aa.img_ven3)
        for(x in li){
            x.setOnClickListener {
                var pindah= Intent(this.requireActivity(),detail_vendor::class.java)
                startActivity(pindah)
            }
        }*/
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






    private fun addtolist(image:String){
        banner.add(image)
    }

    private fun addtolistvendor(gmbvendor:String,nmvendor:String){
        gambarvendor.add(gmbvendor)
        namavendor.add(nmvendor)
    }
    private fun addtolistdesign(gmbdesign:String,nmdesign:String){
        gambardesign.add(gmbdesign)
        namadesign.add(nmdesign)
    }

    private fun posttolist(){
        val db=AppDatabase.getInstance(this.requireContext())
        val ukuranbanner = db?.dataDao()?.promo?.size
        val ukuranvendor=db?.dataDao()?.namavendor?.size
        val ukurandesign=db?.dataDao()?.namadesign?.size
        if (ukuranbanner != null) {

            /*banner*/
            for (x in 0 until ukuranbanner){
                if (db != null) {
                    var s=db.dataDao().promo.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    addtolist(imageLink)
                }
            }
            /*vendor*/
            for(x in 0 until ukuranvendor!!){
                if (db != null) {
                    var s=db.dataDao().fotovendor.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    var nmvendor:String=db.dataDao().namavendor.get(x)
                    addtolistvendor(imageLink,nmvendor)
                }
            }
            /*design*/
            for(x in 0 until ukurandesign!!){
                if (db != null) {
                    var s=db.dataDao().fotodesign.get(x)
                    val p: Array<String> = s.split("/").toTypedArray()
                    val imageLink = "https://drive.google.com/uc?export=download&id=" + p[5]
                    var nmdesign:String=db.dataDao().namadesign.get(x)
                    addtolistdesign(imageLink,nmdesign)
                }
            }

        }
    }
}