package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diyetistan.diyetistanapp.R


class BlogFragment : Fragment() {

    companion object {
        val TAG: String = BlogFragment::class.java.simpleName
        fun newInstance() = BlogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_blog)
        val view = inflater?.inflate(R.layout.fragment_blog, container, false)
        return view
    }

}