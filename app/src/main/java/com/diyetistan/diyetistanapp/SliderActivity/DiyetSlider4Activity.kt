package com.diyetistan.diyetistanapp.SliderActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.enums.WebLinksEnum
import kotlinx.android.synthetic.main.activity_diyet_slider4.*

class DiyetSlider4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diyet_slider4)
        val link = intent.getStringExtra(WebLinksEnum.DiyetSlider3.toString())
        diyetslider4_webview!!.loadUrl(link)
        val webSettings = diyetslider4_webview?.settings
        webSettings?.javaScriptEnabled = true
    }
}
