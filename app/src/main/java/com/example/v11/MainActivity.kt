package com.example.v11

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webViewVar = findViewById<WebView>(R.id.wView)
        webViewSetUp(webViewVar)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetUp(webViewVar: WebView){
        webViewVar.webViewClient = WebViewClient()

        webViewVar.apply {
            settings.javaScriptEnabled = true
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1)
                   settings.safeBrowsingEnabled = true
//            add url
            loadUrl("https://github.com/gs1719")
        }

    }





//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        val webView = findViewById<WebView>(R.id.wView)
//        when {
//            webView.canGoBack() -> webView.goBack()
//            else -> showAppClosingDialog()
//        }
//    }

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val webView = findViewById<WebView>(R.id.wView)
            when {
                webView.canGoBack() -> webView.goBack()
                else -> showAppClosingDialog()
            }
        }
    }
    private fun showAppClosingDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Warning")
            .setMessage("Do you really want to close the app?")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No", null)
            .show()
    }

}