package com.mcvector36.report_loto.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.support.v4.app.Fragment
import com.mcvector36.report_loto.R

class PlaceholderFragment : Fragment() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(
                R.layout.fragment_main,
                container,
                false
        )

        webView = root.findViewById(R.id.web_view)

        val webSettings: WebSettings = webView.settings

        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        val sectionNumber =
                arguments?.getInt(ARG_SECTION_NUMBER) ?: 1

        val url = when (sectionNumber) {
            1 -> "https://www.loto.ro/?p=3872"
            2 -> "https://www.loto.ro/?p=3899"
            else -> "https://www.loto.ro/"
        }

        webView.loadUrl(url)

        return root
    }

    override fun onDestroyView() {
        webView.stopLoading()
        webView.webViewClient = null
        webView.webChromeClient = null
        webView.destroy()

        super.onDestroyView()
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(
                            ARG_SECTION_NUMBER,
                            sectionNumber
                    )
                }
            }
        }
    }
}