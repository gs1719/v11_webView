# v11_webView
Web View with back pressed functionality

Learned WebV8ew i.e. showing the website under your application



<details><summary>CODE</summary>
<p>

## some code for reference

### for webview

```kotlin
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
```

### for back button

```kotlin
//in onCreate add this line 
override fun onCreate(savedInstanceState: Bundle?) {
  //.........................
  //...........................
    onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
}
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
```
</p>
</details>

here is video showing same

<img src="https://user-images.githubusercontent.com/52217208/218350580-6d4e2cbd-2164-4c74-ab13-f95ae6e5eb9e.mp4" width=25% height=25%>

