package com.example.getcontent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.getcontent.api.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.discoverylayout.view.*
import kotlinx.android.synthetic.main.fragment_account2.*
import kotlinx.android.synthetic.main.fragment_account2.view.*
import kotlinx.android.synthetic.main.fragment_discovery.*
import kotlinx.android.synthetic.main.fragment_discovery.view.*
import okhttp3.internal.notifyAll
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
        /*aa.itemsswipetorefresh.setOnRefreshListener {
            gmb.clear()
            posttolist()
            aa.rv_recycle.adapter=dicoveryrecycle(gmb)
            aa.itemsswipetorefresh.isRefreshing=false
            //aa.refreshDrawableState()

        }
        posttolist()*/
        aa.rv_recycle.adapter=dicoveryrecycle(gmb)
        aa.rv_recycle.setHasFixedSize(true)

        //searchview//
        search()
        return aa
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
        aa.itemsswipetorefresh.setOnRefreshListener {
            gmb.clear()
            posttolist()
            aa.itemsswipetorefresh.isRefreshing=false
            aa.rv_recycle.adapter=dicoveryrecycle(gmb)
//            aa.refreshDrawableState(true)

        }



    }
    private fun search(){
        aa.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                Api.service<searchunsplash>()
                    .getsearch( "nRGGB7bhCOSbaJeSkhYSDix-cWju7XsP7zTjt1XTFG0",query.toString())
                    .enqueue(object : Callback<searchresponse<List<urlsearch<gambar>>>> {
                        override fun onResponse(
                            call: Call<searchresponse<List<urlsearch<gambar>>>>,
                            response: Response<searchresponse<List<urlsearch<gambar>>>>
                        ) {
                            var hitung=10
                            for (x in 0 until hitung!!){
                                var link = response.body()?.results?.get(x)?.urls?.small
                                var coba = response.raw()
                                addtolist(link.toString())
                                Log.d("bener", link.toString())
                            }




                        }

                        override fun onFailure(call: Call<searchresponse<List<urlsearch<gambar>>>>, t: Throwable) {
                            Log.d("eror", t.message.toString())

                        }

                    })

                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
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
                    var hitung=response.body()?.size
                   for (x in 0 until hitung!!){
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