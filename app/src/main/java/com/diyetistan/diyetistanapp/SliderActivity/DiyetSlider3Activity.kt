package com.diyetistan.diyetistanapp.SliderActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.enums.WebLinksEnum
import kotlinx.android.synthetic.main.activity_diyet_slider3.*

class DiyetSlider3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diyet_slider3)
        val link = intent.getStringExtra(WebLinksEnum.DiyetSlider2.toString())
        diyetslider3_webview!!.loadUrl(link)
        val webSettings = diyetslider3_webview?.settings
        webSettings?.javaScriptEnabled = true
    }
}
