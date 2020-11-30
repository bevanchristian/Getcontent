package com.example.getcontent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.getcontent.api.Api
import com.example.getcontent.api.BaseResponse
import com.example.getcontent.api.gambar
import com.example.getcontent.api.unsplashservice
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.discoverylayout.view.*
import kotlinx.android.synthetic.main.fragment_account2.*
import kotlinx.android.synthetic.main.fragment_account2.view.*
import kotlinx.android.synthetic.main.fragment_discovery.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class discovery : Fragment() {

    lateinit var aa:View
    var gmb= mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        aa= inflater.inflate(R.layout.fragment_discovery, container, false)
        aa.rv_recycle.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        aa.rv_recycle.addItemDecoration(GridItemDecoration(10, 2))
        posttolist()
        aa.rv_recycle.adapter=dicoveryrecycle(gmb)
        aa.rv_recycle.setHasFixedSize(true)


        return aa
    }

    override fun onStart() {
        super.onStart()

    }



    private fun addtolist(image:String){

        gmb.add(image)
    }

    private fun posttolist(){

        Api.service<unsplashservice>()
            .getphoto( "nRGGB7bhCOSbaJeSkhYSDix-cWju7XsP7zTjt1XTFG0",24)
            .enqueue(object : Callback<List<BaseResponse<gambar>>> {
                override fun onResponse(
                    call: Call<List<BaseResponse<gambar>>>,
                    response: Response<List<BaseResponse<gambar>>>
                ) {

                   for (x in 1..22){
                       var link = response.body()?.get(x)?.urls?.small
                       var coba = response.raw()
                       addtolist(link.toString())
                       Log.d("bener", link.toString())
                   }




                }

                override fun onFailure(call: Call<List<BaseResponse<gambar>>>, t: Throwable) {
                    Log.d("eror", t.message.toString())

                }

            })

    }

}