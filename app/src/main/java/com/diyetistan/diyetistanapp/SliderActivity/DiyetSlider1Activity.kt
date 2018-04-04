package com.diyetistan.diyetistanapp.SliderActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diyetistan.diyetistanapp.R
import kotlinx.android.synthetic.main.activity_diyet_slider1.*

class DiyetSlider1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diyet_slider1)
        diyetslider1_webview!!.loadUrl("http://diyetistan.byethost22.com/diyet-programlari/elma-diyeti/")
    }
}
