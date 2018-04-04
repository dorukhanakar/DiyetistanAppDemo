package com.diyetistan.diyetistanapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.SliderActivity.*
import ss.com.bannerslider.banners.Banner
import ss.com.bannerslider.banners.RemoteBanner
import ss.com.bannerslider.views.BannerSlider
import java.util.*


class ProfileFragment : Fragment() {

    private var bannerSlider1: BannerSlider? = null
    private var bannerSlider2: BannerSlider? = null
    var intent: Intent? = null

    companion object {
        val TAG: String = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_profile)
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view!!.findViewById<TextView>(R.id.dispTxt)?.text = (activity as MainActivity).savedDispTxt
        bannerSlider1 = view.findViewById(R.id.banner_slider1)
        bannerSlider2 = view.findViewById(R.id.banner_slider2)
        setupBannerSlider()
        return view
    }

    private fun setupBannerSlider() {

        addBanners()

        bannerSlider1!!.setOnBannerClickListener { position ->

            if (position.toString() == "0") {
                val intent = Intent(activity, YemekSlider1Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "1") {
                val intent = Intent(activity, YemekSlider2Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "2") {
                val intent = Intent(activity, YemekSlider3Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "3") {
                val intent = Intent(activity, YemekSlider4Activity::class.java)
                startActivity(intent)
            }
        }

        bannerSlider2!!.setOnBannerClickListener { position ->

            if (position.toString() == "0") {
                val intent = Intent(activity, DiyetSlider1Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "1") {
                val intent = Intent(activity, DiyetSlider2Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "2") {
                val intent = Intent(activity, DiyetSlider3Activity::class.java)
                startActivity(intent)
            }
            if (position.toString() == "3") {
                val intent = Intent(activity, DiyetSlider4Activity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun addBanners() {
        val remoteBanners1 = ArrayList<Banner>()
        val remoteBanners2 = ArrayList<Banner>()
        //Add banners using image urls
        remoteBanners1.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/yem1.png"
        ))
        remoteBanners1.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/yem2.jpg"
        ))
        remoteBanners1.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/yem3.jpg"
        ))
        remoteBanners1.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/yem4.jpg"
        ))
        bannerSlider1!!.setBanners(remoteBanners1)

        remoteBanners2.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/elma_slider.jpg"
        ))
        remoteBanners2.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/diyabet_slider.jpg"
        ))
        remoteBanners2.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/gaps_slider.jpg"
        ))
        remoteBanners2.add(RemoteBanner(
                "http://www.adok-isg.com/wp-content/uploads/2018/05/ramazan_slider.jpg"
        ))
        bannerSlider2!!.setBanners(remoteBanners2)

    }

}