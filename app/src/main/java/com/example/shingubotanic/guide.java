package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class guide extends MainActivity {
    Toolbar toolbar;
    ImageButton home;
    View.OnClickListener cl;
    Intent i;
    WebView gd;
    MyClient mc;

    class MyClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        home = (ImageButton) findViewById(R.id.home);
        gd = (WebView) findViewById(R.id.guide);
        mc = new MyClient();
        gd.setWebViewClient(mc);
        gd.setWebViewClient(new WebViewClient());

// 페이지 크기를 조정할수있게 허용
        gd.getSettings().setJavaScriptEnabled(true);
// 돋보기 기능을 가능할수있게 하는 기능 허가
        gd.getSettings().setBuiltInZoomControls(true);
        gd.getSettings().setSupportZoom(true);
// 앱의 크기의 맞게 자동 조정해주는 기능 허가
        gd.getSettings().setLoadWithOverviewMode(true);
        gd.getSettings().setUseWideViewPort(true);
        gd.loadUrl("https://www.sbg.or.kr/guide/guide.html");

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.home :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                }
            }
        };
        home.setOnClickListener(cl);





    }
}