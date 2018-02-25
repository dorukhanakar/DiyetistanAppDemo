package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diyetistan.diyetistanapp.R


class HomeFragment : Fragment() {

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_home)
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        return view
    }

}