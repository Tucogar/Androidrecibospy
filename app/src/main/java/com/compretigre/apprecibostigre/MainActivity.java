package com.compretigre.apprecibostigre;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      this.myWebView = (WebView) this.findViewById(R.id.webview);

       WebView myWebView = (WebView) findViewById(R.id.webview);
       myWebView.loadUrl("http://tucogarcia-001-site1.itempurl.com/recibospy/default");
       //myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyBrowser());
        myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {

                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        WebSettings webSettings = myWebView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webSettings.setAllowFileAccess(true);
       webSettings.setAllowContentAccess(true);

    }
    @Override
    public void onBackPressed() {

        // Check if there's history
        if (this.myWebView.canGoBack())
            this.myWebView.goBack();
        else
            super.onBackPressed();

    }


    private class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {

           //if (urlNewString1.equals("pdf")){
            //String fraseOpenwebinar = urlNewString;
            //int textLength = fraseOpenwebinar.length();
            //if (textLength="71") {
             //   String filtro = fraseOpenwebinar.substring(68, 3);
            //}

            view.loadUrl(urlNewString);


               return true;

            //}
           //else{
            //   view.loadUrl(urlNewString);
            //   return true;
           //}





        }

        //@Override
        //public void onPageFinished(WebView view, String url) {

        //}
    }

    private class MyWebViewClient extends WebViewClient {

        private long loadTime; // Web page loading time

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("http://www.compretigre.com/recibospy/cliente/menu")) {
                // This is my web site, so do not override; let my WebView load
                // the page
                return false;
            }


            // Otherwise, the link is not for a page on my site, so launch
            // another Activity that handles URLs
           // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
           // startActivity(intent);
            return false;

        }
    }


    // Use When the user clicks a link from a web page in your WebView

   // public boolean shouldOverrideUrlLoading(WebView view, String url) {

   //     if (url.startsWith("tel:")) {
    //        initiateCall(url);
    //        return true;
    //    }
    //    if (url.startsWith("mailto:")) {
    //        sendEmail(url.substring(7));
     //       return true;
     //   }
    //    return false;
   // }
}