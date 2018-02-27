package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.diyetistan.diyetistanapp.R


class ProfileFragment : Fragment() {

    companion object {
        val TAG: String = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_profile)
        val view = inflater?.inflate(R.layout.fragment_profile, container, false)
        view!!.findViewById<TextView>(R.id.dispTxt)?.text = (activity as MainActivity).savedDispTxt
        return view
    }

}