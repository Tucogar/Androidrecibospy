package com.compretigre.apprecibostigre;

import android.webkit.WebView;

public class MyWebViewClient {

    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        return false;
    }
}
