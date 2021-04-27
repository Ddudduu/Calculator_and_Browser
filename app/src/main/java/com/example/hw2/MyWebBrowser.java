package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.webkit.WebChromeClient;

public class MyWebBrowser extends AppCompatActivity {
    EditText editText_url;
    WebView mWebView;
    String Pageurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_browser);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);

        editText_url = (EditText) findViewById(R.id.url);
        editText_url.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KeyEvent.KEYCODE_ENTER)){
                    mWebView.loadUrl("http://"+editText_url.getText().toString());
                    return true;
                }
                return false;
            }
        });

        Intent intent = getIntent();
        String intent_url=intent.getStringExtra(Intent.EXTRA_TEXT);

         if(intent_url!=null){
             mWebView.loadUrl(intent_url);
         }
    }

    public void onClick(View v){
        Intent intent =new Intent(this,MyCalculator.class);
        startActivity(intent);
    }

    public void previous_page(View v){
        mWebView.goBack();
    }

    public void next_page(View v){
        mWebView.goForward();
    }

    public class WebViewClient extends android.webkit.WebViewClient{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            Pageurl=view.getUrl();
            editText_url.setText(Pageurl);

        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view,url);
            Pageurl=view.getUrl();
            editText_url.setText(Pageurl);
        }
    }
}

