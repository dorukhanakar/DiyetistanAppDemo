package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diyetistan.diyetistanapp.R


class BmrFragment : Fragment() {

    companion object {
        val TAG: String = BmrFragment::class.java.simpleName
        fun newInstance() = BmrFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_bmr)
        val view = inflater?.inflate(R.layout.fragment_bmr, container, false)
        return view
    }

}