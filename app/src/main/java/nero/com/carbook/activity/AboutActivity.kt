package nero.com.carbook.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import nero.com.carbook.R
import nero.com.carbook.extensions.setupToolbar

class AboutActivity : BaseActivity() {

    private val ABOUT_URL = "http://www.livroandroid.com.br/sobre.htm"
    private var webview: WebView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

//      Toolbar
        setupToolbar(R.id.toolbar).setDisplayHomeAsUpEnabled(true)

//      Views
        webview = findViewById(R.id.web_view)
        progressBar = findViewById(R.id.progress_bar)

//      Page loader
        setWebViewClient(webview)
        webview?.loadUrl(ABOUT_URL)
    }

    private fun setWebViewClient(webview: WebView?) {
        webview?.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
//              Start progressBar
                progressBar?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
//              Stop progressBar
                progressBar?.visibility = View.INVISIBLE
            }
        }
    }
}
