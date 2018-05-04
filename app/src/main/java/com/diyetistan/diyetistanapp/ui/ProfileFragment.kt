package com.diyetistan.diyetistanapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.SliderActivity.*
import com.diyetistan.diyetistanapp.enums.WebLinksEnum
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ss.com.bannerslider.banners.Banner
import ss.com.bannerslider.banners.RemoteBanner
import ss.com.bannerslider.views.BannerSlider

/*
Yemek Slider'ları -> 12-13-14-15
Diyet Sliderları -> 0-1-2-3
Yemek Banner'ları -> 8-9-10-11
Profile Banner'ları ->4-5-6-7
 */


class ProfileFragment : Fragment(), ValueEventListener {

    private val database by lazy { FirebaseDatabase.getInstance() }
    private val databaseReference by lazy { database.reference.child("WebLinks") }
    private val linkList by lazy { ArrayList<String>() }

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

        databaseReference.addValueEventListener(this)

        return view
    }

    private fun setupBannerSlider() {

        addBanners()

        bannerSlider1!!.setOnBannerClickListener { position ->

            if (position.toString() == "0") {
                val intent = Intent(activity, YemekSlider1Activity::class.java)
                intent.putExtra(WebLinksEnum.YemekSlider0.toString(), linkList[12])
                startActivity(intent)
            }
            if (position.toString() == "1") {
                val intent = Intent(activity, YemekSlider2Activity::class.java)
                intent.putExtra(WebLinksEnum.YemekSlider1.toString(), linkList[13])
                startActivity(intent)
            }
            if (position.toString() == "2") {
                val intent = Intent(activity, YemekSlider3Activity::class.java)
                intent.putExtra(WebLinksEnum.YemekSlider2.toString(), linkList[14])
                startActivity(intent)
            }
            if (position.toString() == "3") {
                val intent = Intent(activity, YemekSlider4Activity::class.java)
                intent.putExtra(WebLinksEnum.YemekSlider3.toString(), linkList[15])
                startActivity(intent)
            }
        }

        bannerSlider2!!.setOnBannerClickListener { position ->

            if (position.toString() == "0") {
                val intent = Intent(activity, DiyetSlider1Activity::class.java)
                intent.putExtra(WebLinksEnum.DiyetSlider0.toString(), linkList[0])
                startActivity(intent)
            }
            if (position.toString() == "1") {
                val intent = Intent(activity, DiyetSlider2Activity::class.java)
                intent.putExtra(WebLinksEnum.DiyetSlider1.toString(), linkList[1])
                startActivity(intent)
            }
            if (position.toString() == "2") {
                val intent = Intent(activity, DiyetSlider3Activity::class.java)
                intent.putExtra(WebLinksEnum.DiyetSlider2.toString(), linkList[2])
                startActivity(intent)
            }
            if (position.toString() == "3") {
                val intent = Intent(activity, DiyetSlider4Activity::class.java)
                intent.putExtra(WebLinksEnum.DiyetSlider3.toString(), linkList[3])
                startActivity(intent)
            }
        }
    }

    private fun addBanners() {
        val remoteBanners1 = ArrayList<Banner>()
        val remoteBanners2 = ArrayList<Banner>()
        //Add banners using image urls
        remoteBanners1.add(RemoteBanner(linkList[8]))
        remoteBanners1.add(RemoteBanner(linkList[9]))
        remoteBanners1.add(RemoteBanner(linkList[10]))
        remoteBanners1.add(RemoteBanner(linkList[11]))
        bannerSlider1!!.setBanners(remoteBanners1)

        remoteBanners2.add(RemoteBanner(linkList[4]))
        remoteBanners2.add(RemoteBanner(linkList[5]))
        remoteBanners2.add(RemoteBanner(linkList[6]))
        remoteBanners2.add(RemoteBanner(linkList[7]))
        bannerSlider2!!.setBanners(remoteBanners2)

    }

    override fun onCancelled(databaseError: DatabaseError?) {

        Log.e("Profile Fragment", "WebLinks failed to fetch")
    }

    override fun onDataChange(dataSnapshot: DataSnapshot?) {

        linkList.clear()

        dataSnapshot?.children?.forEach { dataItem ->

            val webLink = dataItem.getValue(String::class.java)
            webLink?.let { linkList.add(it) }
        }

        setupBannerSlider()
    }
}