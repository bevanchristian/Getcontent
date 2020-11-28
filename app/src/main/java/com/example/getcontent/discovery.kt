package com.example.getcontent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_discovery.view.*

class discovery : Fragment() {

    lateinit var aa:View
    var gmb= mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        aa= inflater.inflate(R.layout.fragment_discovery, container, false)
        aa.rv_recycle.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        aa.rv_recycle.addItemDecoration(GridItemDecoration(10, 2))
        aa.rv_recycle.adapter=dicoveryrecycle(gmb)
        posttolist()

        return aa
    }



    private fun addtolist(image:Int){

        gmb.add(image)
    }

    private fun posttolist(){
        for(i in 1..24){

            addtolist(R.drawable.googleg_standard_color_18)
            addtolist(R.drawable.ic_launcher_background)
            addtolist(R.drawable.googleg_disabled_color_18)

            addtolist(R.drawable.common_google_signin_btn_icon_dark)
        }
    }

}