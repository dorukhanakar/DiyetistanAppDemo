package com.diyetistan.diyetistanapp.SliderActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.enums.WebLinksEnum
import kotlinx.android.synthetic.main.activity_yemek_slider2.*

class YemekSlider2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_slider2)
        val link = intent.getStringExtra(WebLinksEnum.YemekSlider1.toString())
        yemekslider2_webview!!.loadUrl(link)
        val webSettings = yemekslider2_webview?.settings
        webSettings?.javaScriptEnabled = true
    }
}
