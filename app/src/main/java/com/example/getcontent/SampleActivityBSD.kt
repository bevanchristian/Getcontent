/*package com.sample
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getcontent.R
import kotlinx.android.synthetic.main.main.*

class SampleActivity :AppCompatActivity(),OptionsBottomSheetFragment.ItemClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        tv_click_me?.setOnClickListener {
            supportFragmentManager.let {
                OptionsBottomSheetFragment.newInstance(Bundle()).apply {
                    show(it, tag)
                }
            }
        }
    }

    override fun onItemClick(param:String) {
        when(param){
            "share"->{
                //Handle data
            }
            "Download"->{
                //Handle data
            }
            else->{
                //Handle data
            }
        }
    }

}*/