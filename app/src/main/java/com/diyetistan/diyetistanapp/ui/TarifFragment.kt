package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.diyetistan.diyetistanapp.R


class TarifFragment : Fragment() {

    var mWebView: WebView? = null

    companion object {
        val TAG: String = TarifFragment::class.java.simpleName
        fun newInstance() = TarifFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_tarif)
        val view = inflater.inflate(R.layout.fragment_tarif, container, false)
        mWebView = view.findViewById<View>(R.id.tarif_webview) as WebView
        mWebView?.loadUrl("http://diyetistan.byethost22.com/yemek-tarifleri/")


        val webSettings = mWebView?.settings
        webSettings?.javaScriptEnabled = true


        mWebView?.webViewClient = WebViewClient()
        return view
    }

}