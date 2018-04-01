package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.diyetistan.diyetistanapp.R


class BmrFragment : Fragment() {

    private var weight: EditText? = null
    private var height: EditText? = null
    private var result: TextView? = null
    private var category: TextView? = null
    private var calculate: Button? = null
    internal var bmi = 0f



    companion object {
        val TAG: String = BmrFragment::class.java.simpleName
        fun newInstance() = BmrFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_bmr)
        val view = inflater?.inflate(R.layout.fragment_bmr, container, false)

        weight = view!!.findViewById(R.id.weight_edit)
        height = view.findViewById(R.id.height_edit)
        result = view.findViewById(R.id.resultbmr_text)
        category = view.findViewById(R.id.categorybmr_text)
        calculate = view.findViewById(R.id.bmr_button)

        calculate!!.setOnClickListener {

            bmi = 0f
            var help = 0f

            val h = Integer.parseInt(height!!.text.toString())

            val w = Integer.parseInt(weight!!.text.toString())

            help = (h * h).toFloat()

            bmi = w / (help / 10000)

            if (bmi < 18.5) {

                category!!.text = "Çok Zayıfsınız "
            } else if (bmi < 25) {
                category!!.text = "Kilonuz Normal "

            } else
                category!!.text = "Çok Kilolusunuz "
            result!!.text = bmi.toString()

        }


        return view
    }

}