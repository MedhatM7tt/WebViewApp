package com.example.sm.webviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity{


    WebView simpleWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleWebView = (WebView) findViewById(R.id.simpleWebView);
        loadPage();
    }


    //This is an implementation of WebChromeClient for use in handling Javascript dialogs,
    // favicons, titles, and the progress. This will replace the current handler.
    //------------------------------------------------------------------------------//
    //JavaScript is disabled in a WebView by default. You can enable it through the WebSettings attached to your
    // WebView.You can retrieve WebSettings with getSettings(), then enable JavaScript with setJavaScriptEnabled().
    //-------------------------------------------------------------------------------//
    //WebSettings provides access to a variety of other settings that you might find useful.
    // For example, if you're developing a web application that's designed specifically for the WebView in your Android app,


    public void loadPage(){
        simpleWebView.setWebViewClient(new MyWebViewClient());

        // ------------URL U Want to change with the website you need --------- ///
        String url = "https://www.ourcoffeesa.com/";

        simpleWebView.getSettings().setJavaScriptEnabled(true);
        simpleWebView.loadUrl(url);
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /// ------------ method for control the back button action ------------ ///
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (simpleWebView.canGoBack()) {
                        simpleWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
