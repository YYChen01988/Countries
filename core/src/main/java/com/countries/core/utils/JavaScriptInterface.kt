package com.countries.core.utils

import android.webkit.JavascriptInterface

class JavaScriptInterface {

    @JavascriptInterface
    fun onUrlChange(url: String) {
        println("onUrlChange=$url")
    }
}
