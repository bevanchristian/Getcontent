package com.example.getcontent

import CustomBottomSheetDialogFragment
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.getcontent.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.layout_persistent_bottom_sheet.*

//utk bottom sheet
//import kotlinx.android.synthetic.main.activity_detail_vendor.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@MainActivity2, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(this@MainActivity2, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@MainActivity2, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@MainActivity2, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@MainActivity2, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this@MainActivity2, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                }
            }
        })

//        utk bottom sheet, ini dicommand
        btnBottomSheetPersistent.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            else
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        btnBottomSheetModal.setOnClickListener {
            CustomBottomSheetDialogFragment().apply {
                show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
            }
        }
//        sampe sini

    }
}