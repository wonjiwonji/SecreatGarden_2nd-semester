package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class shop extends AppCompatActivity {

    ImageButton shop_back;
    View.OnClickListener cl;
    Intent i;

    private WebView webView;
    private String url = "https://www.sbg.or.kr/shop/product_main.html?part1_code=1";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        shop_back = (ImageButton) findViewById(R.id.shop_back);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        //화면 비율
        // wide viewport를 사용하도록 설정
        webView.getSettings().setUseWideViewPort(true);
        //컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        webView.getSettings().setLoadWithOverviewMode(true);
        //zoom 허용
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.shop_back:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                }
            }
        };
        shop_back.setOnClickListener(cl);
    }

    private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }


}

