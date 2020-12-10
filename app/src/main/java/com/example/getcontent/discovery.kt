package com.example.getcontent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.getcontent.api.*
import kotlinx.android.synthetic.main.discoverylayout.*
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
        /*aa.itemsswipetorefresh.setOnRefreshListener {
            gmb.clear()
            posttolist()
            aa.rv_recycle.adapter=dicoveryrecycle(gmb)
            aa.itemsswipetorefresh.isRefreshing=false
            //aa.refreshDrawableState()

        }*/

        //searchview//


        return aa
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        posttolist()
        //https://stackoverflow.com/questions/34104870/notifydatasetchanged-doesnt-refresh-recyclerview
        /* aa.searchView.setOnClickListener {
             aa.searchView.onFocusChangeListener = OnFocusChangeListener { view, hasFocus ->
                 if (hasFocus) {
                     val imm =
                         requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                     imm.showSoftInput(view, 0)
                 }
             }

         }*/
        search()

        aa.rv_recycle.adapter=dicoveryrecycle(gmb)
        aa.rv_recycle.setHasFixedSize(true)

        aa.itemsswipetorefresh.setOnRefreshListener {

            posttolist()

//            aa.refreshDrawableState(true)
            //aa.rv_recycle.a(dicoveryrecycle(gmb),true)

           aa.itemsswipetorefresh.isRefreshing=false

        }



        aa.searchView.setOnClickListener {
            aa.searchView.onFocusChangeListener = OnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    val imm =
                        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(view, 0)
                }
            }
            search()
        }




    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()






    }
    private fun search(){
        aa.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                Api.service<searchunsplash>()
                    .getsearch( "nRGGB7bhCOSbaJeSkhYSDix-cWju7XsP7zTjt1XTFG0",query.toString(),"30")
                    .enqueue(object : Callback<searchresponse<List<urlsearch<gambar>>>> {
                        override fun onResponse(
                            call: Call<searchresponse<List<urlsearch<gambar>>>>,
                            response: Response<searchresponse<List<urlsearch<gambar>>>>
                        ) {
                            var hitung=response.body()?.results?.size
                            for (x in 0 until hitung!!){
                                var link = response.body()?.results?.get(x)?.urls?.small
                                var coba = response.raw()
                                addtolist(link.toString())
                                Log.d("bener", link.toString())
                            }
                            aa.rv_recycle.adapter=dicoveryrecycle(gmb)
                            aa.rv_recycle.scrollToPosition(0)




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
            .getphoto( "nRGGB7bhCOSbaJeSkhYSDix-cWju7XsP7zTjt1XTFG0",29)
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
                    aa.rv_recycle.adapter=dicoveryrecycle(gmb)
                    aa.rv_recycle.scrollToPosition(0)





                }

                override fun onFailure(call: Call<List<BaseResponse<gambar>>>, t: Throwable) {
                    Log.d("eror", t.message.toString())

                }

            })

    }

}