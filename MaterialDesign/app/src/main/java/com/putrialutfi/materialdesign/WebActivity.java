package com.putrialutfi.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView web;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progress = new ProgressDialog(WebActivity.this);
        progress.setMessage("Page is loading ...");
        progress.show();

        web = findViewById(R.id.webView);

        web.loadUrl("https://quranque-app.firebaseapp.com");
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.dismiss();
                getSupportActionBar().setTitle(web.getTitle());
            }
        });

        WebSettings mWebSettings = web.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportZoom(false);
        mWebSettings.setDomStorageEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
