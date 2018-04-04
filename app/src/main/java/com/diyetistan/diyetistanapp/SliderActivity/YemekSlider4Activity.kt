package com.diyetistan.diyetistanapp.SliderActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diyetistan.diyetistanapp.R
import kotlinx.android.synthetic.main.activity_yemek_slider4.*

class YemekSlider4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_slider4)
        yemekslider4_webview!!.loadUrl("http://diyetistan.byethost22.com/yemek-tarifleri/etli-kuru-fasulye/")
    }
}
