package cf.android666.wanandroid.utils

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

/**
 * Created by jixiaoyong on 2018/2/7.
 */
object SuperUtil{

    fun toast(context: Context, msg: String) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    fun loadUrl(webView: WebView, url: String) {

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view!!.loadUrl(url)
                return true
            }
        }

        webView.settings.javaScriptEnabled = true

        webView.loadUrl(url)
    }

    fun <T> startActivity(context: Context,clazz:Class<T>,url: String){

        var intent = Intent(context,clazz)

        intent.putExtra("url", url)

        context.startActivity(intent)
    }
}