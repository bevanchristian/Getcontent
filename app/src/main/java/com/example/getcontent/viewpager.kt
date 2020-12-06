package com.example.getcontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.fragment_viewpager.*


class viewpager : Fragment() {
    lateinit var viewPagerAdapter: viewpageradapter

    var listNames: List<String> = listOf("")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPagerAdapter = viewpageradapter(childFragmentManager, this.lifecycle)
        


            viewPagerAdapter.addFragment(discovery())
            viewPagerAdapter.addFragment(home2())
            viewPagerAdapter.addFragment(account2())






        viewpager2.adapter = viewPagerAdapter
        viewpager2.currentItem = 1









    }




}