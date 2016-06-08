package com.artofjeam.famb;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Browser extends Activity {

    WebView webView;
    EditText url;
    TextView title;
    ImageView btnBack, btnForward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        webView = (WebView) findViewById(R.id.webView);
        url = (EditText) findViewById(R.id.url);
        title = (TextView) findViewById(R.id.title);
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnForward = (ImageView) findViewById(R.id.btnForward);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        // указываем страницу загрузки
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("http://google.com");
        url.setText(webView.getUrl());
        title.setText(webView.getTitle());
        changeBack();
        changeForward();
    }



    public void goToURL(View view){
        webView.loadUrl("http://" + url.getText().toString());
        title.setText(webView.getTitle());
        changeBack();
        changeForward();
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
            url.setText(webView.getUrl());
            title.setText(webView.getTitle());
            changeBack();
            changeForward();
        } else {
            super.onBackPressed();
            finish();
            this.overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
        }
    }
    public void changeBack(){
        if (webView.canGoBack()) {
            btnBack.setImageResource(R.drawable.back);
        }
        else {
            btnBack.setImageResource(R.drawable.back_off);
        }
    }
    public void changeForward(){
        if (webView.canGoForward()) {
            btnForward.setImageResource(R.drawable.forward);
        }
        else {
            btnForward.setImageResource(R.drawable.forward_off);
        }
    }

    public void goBack(View view){
        if(webView.canGoBack()) {
            webView.goBack();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    changeBack();
                    changeForward();
                    url.setText(webView.getUrl());
                    title.setText(webView.getTitle());
                }
            }, 1 * 1000);
        }
    }

    public void goForword(View view) {
        if (webView.canGoForward()) {
            webView.goForward();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    changeBack();
                    changeForward();
                    url.setText(webView.getUrl());
                    title.setText(webView.getTitle());
                }
            }, 1 * 1000);
        }

    }

    public void close(View view) {
        finish();
        this.overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String str) {
            view.loadUrl(str);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    changeBack();
                    changeForward();
                    url.setText(webView.getUrl());
                    title.setText(webView.getTitle());
                }
            }, 1 * 1000);
            return true;
        }
    }


    @Override
    public void onDestroy(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.
        this.overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
        super.onDestroy();
    }

}

