package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.diyetistan.diyetistanapp.R
import ss.com.bannerslider.banners.Banner
import ss.com.bannerslider.banners.RemoteBanner
import ss.com.bannerslider.views.BannerSlider
import java.util.*


class ProfileFragment : Fragment() {

    private var bannerSlider1: BannerSlider? = null
    private var bannerSlider2: BannerSlider? = null

    companion object {
        val TAG: String = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_profile)
        val view = inflater?.inflate(R.layout.fragment_profile, container, false)
        view!!.findViewById<TextView>(R.id.dispTxt)?.text = (activity as MainActivity).savedDispTxt
        bannerSlider1 = view.findViewById(R.id.banner_slider1)
        bannerSlider2 = view.findViewById(R.id.banner_slider2)
        setupBannerSlider()
        return view
    }

    private fun setupBannerSlider() {

        addBanners()

        bannerSlider1!!.setOnBannerClickListener { position -> Toast.makeText(context, "Banner with position " + position.toString() + " clicked!", Toast.LENGTH_SHORT).show() }
    }

    private fun addBanners() {
        val remoteBanners1 = ArrayList<Banner>()
        val remoteBanners2 = ArrayList<Banner>()
        //Add banners using image urls
        remoteBanners1.add(RemoteBanner(
                "https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg"
        ))
        remoteBanners1.add(RemoteBanner(
                "https://assets.materialup.com/uploads/4b88d2c1-9f95-4c51-867b-bf977b0caa8c/preview.gif"
        ))
        remoteBanners1.add(RemoteBanner(
                "https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png"
        ))
        remoteBanners1.add(RemoteBanner(
                "https://assets.materialup.com/uploads/05e9b7d9-ade2-4aed-9cb4-9e24e5a3530d/preview.jpg"
        ))
        bannerSlider1!!.setBanners(remoteBanners1)

        remoteBanners2.add(RemoteBanner(
                "https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg"
        ))
        remoteBanners2.add(RemoteBanner(
                "https://assets.materialup.com/uploads/4b88d2c1-9f95-4c51-867b-bf977b0caa8c/preview.gif"
        ))
        remoteBanners2.add(RemoteBanner(
                "https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png"
        ))
        remoteBanners2.add(RemoteBanner(
                "https://assets.materialup.com/uploads/05e9b7d9-ade2-4aed-9cb4-9e24e5a3530d/preview.jpg"
        ))
        bannerSlider2!!.setBanners(remoteBanners2)

    }

}